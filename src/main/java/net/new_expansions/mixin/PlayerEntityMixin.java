package net.new_expansions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.SwordItem;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.new_expansions.items.equipment.NewexpSwordItem;
import net.new_expansions.registry.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
    
    @Shadow private int sleepTimer;
    @Shadow @Final private PlayerInventory inventory;
    @Shadow public abstract boolean isSpectator();
    @Shadow public abstract boolean isCreative();
    
    @Shadow public abstract float getAttackCooldownProgress(float baseTime);
    
    @Shadow public abstract void resetLastAttackedTicks();
    
    @Shadow public abstract void spawnSweepAttackParticles();
    
    @Shadow public abstract void addCritParticles(Entity target);
    
    @Shadow public abstract void addEnchantedHitParticles(Entity target);
    
    @Shadow public abstract void increaseStat(Identifier stat, int amount);
    
    @Shadow public abstract void addExhaustion(float exhaustion);
    
    @Inject(method = "createPlayerAttributes", at = @At("RETURN"),cancellable = true)
    private static void createPlayerAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
        cir.setReturnValue(LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.10000000149011612).add(EntityAttributes.GENERIC_ATTACK_SPEED).add(EntityAttributes.GENERIC_LUCK));
    }
    
    /**
     * @author Pro__Dan
     * @reason added enchantments
     */
    @Overwrite
    public float getBlockBreakingSpeed(BlockState block) {
        float f = this.inventory.getBlockBreakingSpeed(block);
        if (f > 1.0F) {
            int i = EnchantmentHelper.getEfficiency(this);
            ItemStack itemStack = this.getMainHandStack();
            if (i > 0 && !itemStack.isEmpty()) {
                f += (float)(i * i + 1);
            }
        }
        if (f > 1.0F && block.isIn(NewexpTags.PERFORMANCE_ENCHANTMENT)) {
            int i = EnchantmentHelper.getEquipmentLevel(NewexpEnchantments.PERFORMANCE, this);
            ItemStack itemStack = this.getMainHandStack();
            if (i > 0 && !itemStack.isEmpty()) {
                f += (float)(i * 15 + 5);
            }
        }
    
        if (StatusEffectUtil.hasHaste(this)) {
            f *= 1.0F + (float)(StatusEffectUtil.getHasteAmplifier(this) + 1) * 0.2F;
        }
    
        if (this.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
            float g = switch (this.getStatusEffect(StatusEffects.MINING_FATIGUE).getAmplifier()) {
                case 0 -> 0.3F;
                case 1 -> 0.09F;
                case 2 -> 0.0027F;
                default -> 8.1E-4F;
            };
            
            f *= g;
        }
    
        if (this.isSubmergedIn(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(this)) {
            f /= 5.0F;
        }
        
        if (!this.isOnGround() && !(this.hasStatusEffect(StatusEffects.SLOW_FALLING))) {
            f /= 5.0F;
        }
    
        return f;
    }
    
    /**
     * @author Pro__Dan
     * @reason Fix sweeping attack, added mod enchantments, added damage multiplier, added hardcore health scaling
     */
    @Overwrite
    public void attack(Entity target) {
        if (target.isAttackable()) {
            if (!target.handleAttack(this)) {
                boolean hardcore = this.getWorld().getLevelProperties().isHardcore();
                float weapon_damage = (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                float enchantment_damage;
                float damage_multiplier = hardcore ? 0.66667F : 1F;
                if(target.getClass() == ServerPlayerEntity.class){
                    damage_multiplier = 1F;
                }
                if (target instanceof LivingEntity) {
                    enchantment_damage = EnchantmentHelper.getAttackDamage(this.getMainHandStack(), ((LivingEntity)target).getGroup());
                } else {
                    enchantment_damage = EnchantmentHelper.getAttackDamage(this.getMainHandStack(), EntityGroup.DEFAULT);
                }
                if (EnchantmentHelper.getEquipmentLevel(NewexpEnchantments.THERMAL_SHOCK, this) > 0) {
                    BlockPos pos = this.getBlockPos();
                    float temperature = this.getWorld().getBiome(pos).value().getTemperature();
                    enchantment_damage += Math.round(MathHelper.abs((temperature -0.6F) * 4) * 100) / 100F ;
                    //System.out.println("enchantment_damage: " + enchantment_damage);
                }
                if (EnchantmentHelper.getEquipmentLevel(NewexpEnchantments.DIFFICULTY_PEAK, this) > 0) {
                    BlockPos pos = this.getBlockPos();
                    float diff = this.getWorld().getDifficulty().getId();
                    float local_diff = this.getWorld().getLocalDifficulty(pos).getLocalDifficulty();
                    float clamped_local_diff = this.getWorld().getLocalDifficulty(pos).getClampedLocalDifficulty();
                    damage_multiplier += hardcore ? 0.25F : (diff - 1) / 20F;
                    enchantment_damage += (MathHelper.clamp(local_diff, 0.0F, 4.0F) - clamped_local_diff);
                    //System.out.println("damage_multiplier: " + damage_multiplier);
                    //System.out.println("enchantment_damage: " + enchantment_damage);
                }
                
                float attack_cooldown = this.getAttackCooldownProgress(0.5F);
                weapon_damage *= 0.2F + attack_cooldown * attack_cooldown * 0.8F;
                enchantment_damage *= attack_cooldown;
                this.resetLastAttackedTicks();
                if (weapon_damage > 0.0F || enchantment_damage > 0.0F) {
                    boolean bl = attack_cooldown > 0.9F;
                    boolean bl2 = false;
                    int i = 0;
                    i += EnchantmentHelper.getKnockback(this);
                    if (this.isSprinting() && bl) {
                        this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, this.getSoundCategory(), 1.0F, 1.0F);
                        ++i;
                        bl2 = true;
                    }
                    
                    boolean bl3 = bl && this.fallDistance > 0.0F && !this.isOnGround() && !this.isClimbing() && !this.isTouchingWater() && !this.hasStatusEffect(StatusEffects.BLINDNESS) && !this.hasVehicle() && target instanceof LivingEntity;
                    bl3 = bl3 && !this.isSprinting();
                    if (bl3) {
                        weapon_damage *= 1.5F;
                    }
    
                    weapon_damage += enchantment_damage;
                    //System.out.println("weapon_damage before: " + weapon_damage);
                    weapon_damage *= damage_multiplier;
                    //System.out.println("weapon_damage: " + weapon_damage);
                    boolean bl4 = false;
                    double d = (double)(this.horizontalSpeed - this.prevHorizontalSpeed);
                    if (bl && !bl3 && !bl2 && this.isOnGround() && d < (double)this.getMovementSpeed()) {
                        ItemStack itemStack = this.getStackInHand(Hand.MAIN_HAND);
                        if (itemStack.getItem() instanceof SwordItem || itemStack.getItem() instanceof NewexpSwordItem) {
                            bl4 = true;
                        }
                    }
                    
                    float j = 0.0F;
                    boolean bl5 = false;
                    int k = EnchantmentHelper.getFireAspect(this);
                    if (target instanceof LivingEntity) {
                        j = ((LivingEntity)target).getHealth();
                        if (k > 0 && !target.isOnFire()) {
                            bl5 = true;
                            target.setOnFireFor(1);
                        }
                    }
                    
                    Vec3d vec3d = target.getVelocity();
                    boolean bl6 = target.damage(this.getDamageSources().playerAttack((PlayerEntity)(Object)this), weapon_damage);
                    if (bl6) {
                        if (i > 0) {
                            if (target instanceof LivingEntity) {
                                ((LivingEntity)target).takeKnockback((double)((float)i * 0.5F), (double) MathHelper.sin(this.getYaw() * 0.017453292F), (double)(-MathHelper.cos(this.getYaw() * 0.017453292F)));
                            } else {
                                target.addVelocity((double)(-MathHelper.sin(this.getYaw() * 0.017453292F) * (float)i * 0.5F), 0.1, (double)(MathHelper.cos(this.getYaw() * 0.017453292F) * (float)i * 0.5F));
                            }
                            
                            this.setVelocity(this.getVelocity().multiply(0.6, 1.0, 0.6));
                            this.setSprinting(false);
                        }
                        
                        if (bl4) {
                            float l = 1.0F + EnchantmentHelper.getSweepingMultiplier(this) * weapon_damage;
                            List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, target.getBoundingBox().expand(1.0, 0.25, 1.0));
                            Iterator var19 = list.iterator();
                            
                            label166:
                            while(true) {
                                LivingEntity livingEntity;
                                do {
                                    do {
                                        do {
                                            do {
                                                if (!var19.hasNext()) {
                                                    this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, this.getSoundCategory(), 1.0F, 1.0F);
                                                    this.spawnSweepAttackParticles();
                                                    break label166;
                                                }
                                                
                                                livingEntity = (LivingEntity)var19.next();
                                            } while(livingEntity == this);
                                        } while(livingEntity == target);
                                    } while(this.isTeammate(livingEntity));
                                } while(livingEntity instanceof ArmorStandEntity && ((ArmorStandEntity)livingEntity).isMarker());
                                
                                if (this.squaredDistanceTo(livingEntity) < 9.0) {
                                    livingEntity.takeKnockback(0.4000000059604645, (double)MathHelper.sin(this.getYaw() * 0.017453292F), (double)(-MathHelper.cos(this.getYaw() * 0.017453292F)));
                                    livingEntity.damage(this.getDamageSources().playerAttack((PlayerEntity)(Object)this), l);
                                    EnchantmentHelper.onTargetDamaged(this, livingEntity);
                                }
                            }
                        }
                        
                        if (target instanceof ServerPlayerEntity && target.velocityModified) {
                            ((ServerPlayerEntity)target).networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(target));
                            target.velocityModified = false;
                            target.setVelocity(vec3d);
                        }
                        
                        if (bl3) {
                            this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, this.getSoundCategory(), 1.0F, 1.0F);
                            this.addCritParticles(target);
                        }
                        
                        if (!bl3 && !bl4) {
                            if (bl) {
                                this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, this.getSoundCategory(), 1.0F, 1.0F);
                            } else {
                                this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, this.getSoundCategory(), 1.0F, 1.0F);
                            }
                        }
                        
                        if (enchantment_damage > 0.0F) {
                            this.addEnchantedHitParticles(target);
                        }
                        
                        this.onAttacking(target);
                        if (target instanceof LivingEntity) {
                            EnchantmentHelper.onUserDamaged((LivingEntity)target, this);
                        }
                        
                        EnchantmentHelper.onTargetDamaged(this, target);
                        ItemStack itemStack2 = this.getMainHandStack();
                        Entity entity = target;
                        if (target instanceof EnderDragonPart) {
                            entity = ((EnderDragonPart)target).owner;
                        }
                        
                        if (!this.getWorld().isClient && !itemStack2.isEmpty() && entity instanceof LivingEntity) {
                            itemStack2.postHit((LivingEntity)entity, (PlayerEntity)(Object)this);
                            if (itemStack2.isEmpty()) {
                                this.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
                            }
                        }
                        
                        if (target instanceof LivingEntity) {
                            float m = j - ((LivingEntity)target).getHealth();
                            this.increaseStat(Stats.DAMAGE_DEALT, Math.round(m * 10.0F));
                            if (k > 0) {
                                target.setOnFireFor(k * 4);
                            }
                            
                            if (this.getWorld() instanceof ServerWorld && m > 2.0F) {
                                int n = (int)((double)m * 0.5);
                                ((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.DAMAGE_INDICATOR, target.getX(), target.getBodyY(0.5), target.getZ(), n, 0.1, 0.0, 0.1, 0.2);
                            }
                        }
                        
                        this.addExhaustion(0.1F);
                    } else {
                        this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, this.getSoundCategory(), 1.0F, 1.0F);
                        if (bl5) {
                            target.extinguish();
                        }
                    }
                }
                
            }
        }
    }
    
    @Unique
    int freeze = 0;
    @Unique
    int timeBeforeFreeze = 24000;
    @Unique
    int timeInCold = 0;
    @Unique
    int timerFreeze = 0;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo info) {
        ItemStack helmetStack = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplateStack = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggingsStack = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bootsStack = this.getEquippedStack(EquipmentSlot.FEET);
        BlockPos pos = this.getBlockPos();
        boolean temperature = this.getWorld().getBiome(pos).value().isCold(pos);
            if(
                    (this.getWorld().getGameRules().getBoolean(NewexpGamerules.DO_FREEZE)) && temperature
                    && (helmetStack.getItem() != NewexpItems.LEATHER_HELMET
                    || chestplateStack.getItem() != NewexpItems.LEATHER_CHESTPLATE
                    || leggingsStack.getItem() != NewexpItems.LEATHER_LEGGINGS
                    || bootsStack.getItem() != NewexpItems.LEATHER_BOOTS)
                    && !this.inPowderSnow && !this.isCreative() && !this.isSpectator()
            ){
                timeInCold++;
                if(timeInCold > timeBeforeFreeze){
                    timerFreeze++;
                    if(timerFreeze % 80 == 0){
                        freeze += (this.getWorld().getGameRules().getInt(NewexpGamerules.FREEZE_SPEED)*2);
                    }
                    this.setFrozenTicks(freeze);
                }
                if(this.isOnFire()){
                    freeze = 0;
                }
            }else if(this.inPowderSnow){
                if(helmetStack.getItem() != NewexpItems.LEATHER_HELMET
                        && chestplateStack.getItem() != NewexpItems.LEATHER_CHESTPLATE
                        && leggingsStack.getItem() != NewexpItems.LEATHER_LEGGINGS
                        && bootsStack.getItem() != NewexpItems.LEATHER_BOOTS){
                    freeze = this.getFrozenTicks();
                }else{
                    this.setFrozenTicks(freeze);
                }
            }
            else
            {
                if(freeze > 0){
                    freeze--;
                    timerFreeze = 0;
                }else if(freeze < 0){
                    freeze = 0;
                }else{
                    if(timeInCold > 0){
                        timeInCold -= 10;
                    }else{
                        timeInCold = 0;
                    }
                }
                if(this.isOnFire()){
                    freeze = 0;
                }
            }
            
            if(this.getWorld().getGameRules().getInt(NewexpGamerules.TIME_BEFORE_FREEZE) != timeBeforeFreeze){
                timeBeforeFreeze = this.getWorld().getGameRules().getInt(NewexpGamerules.TIME_BEFORE_FREEZE);
            }

            if(this.getWorld().getGameRules().getBoolean(NewexpGamerules.DO_NO_SLEEP)){
                this.sleepTimer = 0;
            }
        }
    }