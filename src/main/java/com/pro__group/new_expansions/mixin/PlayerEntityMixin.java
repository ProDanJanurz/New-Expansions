package com.pro__group.new_expansions.mixin;

import com.pro__group.new_expansions.registry.NewexpItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{

    int regenMain = 0;
    int regenOff = 0;
    int regenHelmet = 0;
    int regenChestplate = 0;
    int regenLeggings = 0;
    int regenBoots = 0;
    int freeze = 0;
    int timeBeforeFreeze = 24000;
    int timeInCold = 0;
    int timerFreeze = 0;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo info) {
        ItemStack mainStack = this.getEquippedStack(EquipmentSlot.MAINHAND);
        ItemStack offStack = this.getEquippedStack(EquipmentSlot.OFFHAND);
        ItemStack helmetStack = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplateStack = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggingsStack = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bootsStack = this.getEquippedStack(EquipmentSlot.FEET);
        BlockPos pos = this.getBlockPos();
        float temperature = world.getBiome(pos).getTemperature();
        PlayerEntity player = (PlayerEntity) (Object) this;

            if(
                    temperature <= 0.1F && (helmetStack.getItem() != Items.LEATHER_HELMET
                    || chestplateStack.getItem() != Items.LEATHER_CHESTPLATE
                    || leggingsStack.getItem() != Items.LEATHER_LEGGINGS
                    || bootsStack.getItem() != Items.LEATHER_BOOTS)
                    && this.inPowderSnow == false && !player.isCreative() && !player.isSpectator()
            ){
                timeInCold++;
                if(timeInCold > timeBeforeFreeze){
                    timerFreeze++;
                    if(timerFreeze % 40 == 0){
                        freeze += 2;
                    }
                    this.setFrozenTicks(freeze);
                }
            }else if(this.inPowderSnow){
                if(helmetStack.getItem() != Items.LEATHER_HELMET
                        && chestplateStack.getItem() != Items.LEATHER_CHESTPLATE
                        && leggingsStack.getItem() != Items.LEATHER_LEGGINGS
                        && bootsStack.getItem() != Items.LEATHER_BOOTS){
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
            }

            if (helmetStack.getItem() == NewexpItems.THELMET && !this.isSubmergedIn(FluidTags.WATER)) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 610, 0, false, false, true));
            }

            if ((bootsStack.getItem() == NewexpItems.EBOOTS
                    || bootsStack.getItem() == NewexpItems.GEBOOTS
                    || bootsStack.getItem() == NewexpItems.DEBOOTS
                    || bootsStack.getItem() == NewexpItems.NEBOOTS
            ) && this.isOnGround()) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 410, 0, false, false, true));
            }

            if (bootsStack.getItem() == NewexpItems.EEBOOTS && this.isOnGround()) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 810, 0, false, false, true));
            }

            if ((mainStack.getItem() == NewexpItems.EPICKAXE
                    || mainStack.getItem() == NewexpItems.EAXE
                    || mainStack.getItem() == NewexpItems.ESHOVEL
                    || mainStack.getItem() == NewexpItems.EHOE
                    || mainStack.getItem() == NewexpItems.ESWORD
                    || mainStack.getItem() == NewexpItems.GEPICKAXE
                    || mainStack.getItem() == NewexpItems.GEAXE
                    || mainStack.getItem() == NewexpItems.GESHOVEL
                    || mainStack.getItem() == NewexpItems.GEHOE
                    || mainStack.getItem() == NewexpItems.GESWORD
                    || mainStack.getItem() == NewexpItems.DEPICKAXE
                    || mainStack.getItem() == NewexpItems.DEAXE
                    || mainStack.getItem() == NewexpItems.DESHOVEL
                    || mainStack.getItem() == NewexpItems.DEHOE
                    || mainStack.getItem() == NewexpItems.DESWORD
                    || mainStack.getItem() == NewexpItems.NEPICKAXE
                    || mainStack.getItem() == NewexpItems.NEAXE
                    || mainStack.getItem() == NewexpItems.NESHOVEL
                    || mainStack.getItem() == NewexpItems.NEHOE
                    || mainStack.getItem() == NewexpItems.NESWORD
            ) && mainStack.getDamage() > 0) {
                regenMain += 1 ;
                while(regenMain >= 400){
                    int temp = mainStack.getDamage();
                    temp -= 1;
                    mainStack.setDamage(temp);
                    regenMain -= 400;
                }
            }
            if ((mainStack.getItem() == NewexpItems.EPICKAXE
                    || mainStack.getItem() == NewexpItems.EAXE
                    || mainStack.getItem() == NewexpItems.ESHOVEL
                    || mainStack.getItem() == NewexpItems.EHOE
                    || mainStack.getItem() == NewexpItems.ESWORD
                    || mainStack.getItem() == NewexpItems.GEPICKAXE
                    || mainStack.getItem() == NewexpItems.GEAXE
                    || mainStack.getItem() == NewexpItems.GESHOVEL
                    || mainStack.getItem() == NewexpItems.GEHOE
                    || mainStack.getItem() == NewexpItems.GESWORD
                    || mainStack.getItem() == NewexpItems.DEPICKAXE
                    || mainStack.getItem() == NewexpItems.DEAXE
                    || mainStack.getItem() == NewexpItems.DESHOVEL
                    || mainStack.getItem() == NewexpItems.DEHOE
                    || mainStack.getItem() == NewexpItems.DESWORD
                    || mainStack.getItem() == NewexpItems.NEPICKAXE
                    || mainStack.getItem() == NewexpItems.NEAXE
                    || mainStack.getItem() == NewexpItems.NESHOVEL
                    || mainStack.getItem() == NewexpItems.NEHOE
                    || mainStack.getItem() == NewexpItems.NESWORD
            ) && mainStack.getDamage() > 0) {
                regenOff += 1 ;
                while(regenOff >= 400){
                    int temp = offStack.getDamage();
                    temp -= 1;
                    offStack.setDamage(temp);
                    regenOff -= 400;
                }
            }
            if ((helmetStack.getItem() == NewexpItems.EHELMET
                    || helmetStack.getItem() == NewexpItems.GEHELMET
                    || helmetStack.getItem() == NewexpItems.DEHELMET
                    || helmetStack.getItem() == NewexpItems.NEHELMET
            ) && helmetStack.getDamage() > 0) {
                regenHelmet += 1 ;
                while(regenHelmet >= 400){
                    int temp = helmetStack.getDamage();
                    temp -= 1;
                    helmetStack.setDamage(temp);
                    regenHelmet -= 400;
                }
            }
            if ((chestplateStack.getItem() == NewexpItems.ECHESTPALTE
                    || chestplateStack.getItem() == NewexpItems.GECHESTPALTE
                    || chestplateStack.getItem() == NewexpItems.DECHESTPALTE
                    || chestplateStack.getItem() == NewexpItems.NECHESTPALTE
            ) && chestplateStack.getDamage() > 0) {
                regenChestplate += 1 ;
                    while(regenChestplate >= 400){
                        int temp = chestplateStack.getDamage();
                        temp -= 1;
                        chestplateStack.setDamage(temp);
                        regenChestplate -= 400;
                }
            }
            if ((leggingsStack.getItem() == NewexpItems.ELEGGINGS
                    || leggingsStack.getItem() == NewexpItems.GELEGGINGS
                    || leggingsStack.getItem() == NewexpItems.DELEGGINGS
                    || leggingsStack.getItem() == NewexpItems.NELEGGINGS
            ) && leggingsStack.getDamage() > 0) {
            regenLeggings += 1 ;
            while(regenLeggings >= 400){
                int temp = leggingsStack.getDamage();
                temp -= 1;
                leggingsStack.setDamage(temp);
                regenLeggings -= 400;
                }
            }
            if ((bootsStack.getItem() == NewexpItems.EBOOTS
                    || bootsStack.getItem() == NewexpItems.GEBOOTS
                    || bootsStack.getItem() == NewexpItems.DEBOOTS
                    || bootsStack.getItem() == NewexpItems.NEBOOTS
            ) && bootsStack.getDamage() > 0) {
                regenBoots += 1 ;
                while(regenBoots >= 400){
                    int temp = bootsStack.getDamage();
                    temp -= 1;
                    bootsStack.setDamage(temp);
                    regenBoots -= 400;
                }
            }
            if ((mainStack.getItem() == NewexpItems.EEPICKAXE
                    || mainStack.getItem() == NewexpItems.EEAXE
                    || mainStack.getItem() == NewexpItems.EESHOVEL
                    || mainStack.getItem() == NewexpItems.EEHOE
                    || mainStack.getItem() == NewexpItems.EESWORD
            ) && mainStack.getDamage() > 0) {
                regenMain += 1 ;
                while(regenMain >= 200){
                    int temp = mainStack.getDamage();
                    temp -= 1;
                    mainStack.setDamage(temp);
                    regenMain -= 200;
                }
            }
            if ((offStack.getItem() == NewexpItems.EEPICKAXE
                    || offStack.getItem() == NewexpItems.EEAXE
                    || offStack.getItem() == NewexpItems.EESHOVEL
                    || offStack.getItem() == NewexpItems.EEHOE
                    || offStack.getItem() == NewexpItems.EESWORD
            ) && offStack.getDamage() > 0) {
                regenOff += 1 ;
                while(regenOff >= 200){
                    int temp = offStack.getDamage();
                    temp -= 1;
                    offStack.setDamage(temp);
                    regenOff -= 200;
                }
            }
            if (helmetStack.getItem() == NewexpItems.EEHELMET && helmetStack.getDamage() > 0) {
                regenHelmet += 1 ;
                while(regenHelmet >= 200){
                    int temp = helmetStack.getDamage();
                    temp -= 1;
                    helmetStack.setDamage(temp);
                    regenHelmet -= 200;
                }
            }
            if (chestplateStack.getItem() == NewexpItems.EECHESTPALTE && chestplateStack.getDamage() > 0) {
                regenChestplate += 1 ;
                while(regenChestplate >= 200){
                    int temp = chestplateStack.getDamage();
                    temp -= 1;
                    chestplateStack.setDamage(temp);
                    regenChestplate -= 200;
                }
            }
            if (leggingsStack.getItem() == NewexpItems.EELEGGINGS && leggingsStack.getDamage() > 0) {
                regenLeggings += 1 ;
                while(regenLeggings >= 200){
                    int temp = leggingsStack.getDamage();
                    temp -= 1;
                    leggingsStack.setDamage(temp);
                    regenLeggings -= 200;
                }
            }
            if (bootsStack.getItem() == NewexpItems.EEBOOTS && bootsStack.getDamage() > 0) {
                regenBoots += 1 ;
                while(regenBoots >= 200){
                    int temp = bootsStack.getDamage();
                    temp -= 1;
                    bootsStack.setDamage(temp);
                    regenBoots -= 200;
                }
            }
            if ((mainStack.getItem() == NewexpItems.EGPICKAXE
                    || mainStack.getItem() == NewexpItems.EGAXE
                    || mainStack.getItem() == NewexpItems.EGSHOVEL
                    || mainStack.getItem() == NewexpItems.EGHOE
                    || mainStack.getItem() == NewexpItems.EGSWORD
                    || mainStack.getItem() == NewexpItems.EDPICKAXE
                    || mainStack.getItem() == NewexpItems.EDAXE
                    || mainStack.getItem() == NewexpItems.EDSHOVEL
                    || mainStack.getItem() == NewexpItems.EDHOE
                    || mainStack.getItem() == NewexpItems.EDSWORD
                    || mainStack.getItem() == NewexpItems.ENPICKAXE
                    || mainStack.getItem() == NewexpItems.ENAXE
                    || mainStack.getItem() == NewexpItems.ENSHOVEL
                    || mainStack.getItem() == NewexpItems.ENHOE
                    || mainStack.getItem() == NewexpItems.ENSWORD
            ) && mainStack.getDamage() > 0) {
                regenMain += 1 ;
                while(regenMain >= 800){
                    int temp = mainStack.getDamage();
                    temp -= 1;
                    mainStack.setDamage(temp);
                    regenMain -= 800;
                }
            }
            if ((mainStack.getItem() == NewexpItems.EGPICKAXE
                    || mainStack.getItem() == NewexpItems.EGAXE
                    || mainStack.getItem() == NewexpItems.EGSHOVEL
                    || mainStack.getItem() == NewexpItems.EGHOE
                    || mainStack.getItem() == NewexpItems.EGSWORD
                    || mainStack.getItem() == NewexpItems.EDPICKAXE
                    || mainStack.getItem() == NewexpItems.EDAXE
                    || mainStack.getItem() == NewexpItems.EDSHOVEL
                    || mainStack.getItem() == NewexpItems.EDHOE
                    || mainStack.getItem() == NewexpItems.EDSWORD
                    || mainStack.getItem() == NewexpItems.ENPICKAXE
                    || mainStack.getItem() == NewexpItems.ENAXE
                    || mainStack.getItem() == NewexpItems.ENSHOVEL
                    || mainStack.getItem() == NewexpItems.ENHOE
                    || mainStack.getItem() == NewexpItems.ENSWORD
            ) && offStack.getDamage() > 0) {
                regenOff += 1 ;
                while(regenOff >= 800){
                    int temp = offStack.getDamage();
                    temp -= 1;
                    offStack.setDamage(temp);
                    regenOff -= 800;
                }
            }
            if ((helmetStack.getItem() == NewexpItems.EGHELMET
                    || helmetStack.getItem() == NewexpItems.EDHELMET
                    || helmetStack.getItem() == NewexpItems.ENHELMET
            ) && helmetStack.getDamage() > 0) {
                regenHelmet += 1 ;
                while(regenHelmet >= 800){
                    int temp = helmetStack.getDamage();
                    temp -= 1;
                    helmetStack.setDamage(temp);
                    regenHelmet -= 800;
                }
            }
            if ((chestplateStack.getItem() == NewexpItems.EGCHESTPALTE
                    || chestplateStack.getItem() == NewexpItems.EDCHESTPALTE
                    || chestplateStack.getItem() == NewexpItems.ENCHESTPALTE
            ) && chestplateStack.getDamage() > 0) {
                regenChestplate += 1 ;
                while(regenChestplate >= 800){
                    int temp = chestplateStack.getDamage();
                    temp -= 1;
                    chestplateStack.setDamage(temp);
                    regenChestplate -= 800;
                }
            }
            if ((leggingsStack.getItem() == NewexpItems.EGLEGGINGS
                    || leggingsStack.getItem() == NewexpItems.EDLEGGINGS
                    || leggingsStack.getItem() == NewexpItems.ENLEGGINGS
            ) && leggingsStack.getDamage() > 0) {
                regenLeggings += 1 ;
                while(regenLeggings >= 800){
                    int temp = leggingsStack.getDamage();
                    temp -= 1;
                    leggingsStack.setDamage(temp);
                    regenLeggings -= 800;
                }
            }
            if ((bootsStack.getItem() == NewexpItems.EGBOOTS
                    || bootsStack.getItem() == NewexpItems.EDBOOTS
                    || bootsStack.getItem() == NewexpItems.ENBOOTS
            ) && bootsStack.getDamage() > 0) {
                regenBoots += 1 ;
                while(regenBoots >= 800){
                    int temp = bootsStack.getDamage();
                    temp -= 1;
                    bootsStack.setDamage(temp);
                    regenBoots -= 800;
                }
            }
        }
    }
