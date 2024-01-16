package net.new_expansions.blocks.entity;

import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.passive.*;
import net.new_expansions.NewExpansions;
import net.new_expansions.registry.NewexpSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Monster;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.sound.SoundCategory;
import org.jetbrains.annotations.Nullable;

public class NewexpEnchantedStatueBlockEntity extends BlockEntity{
    public NewexpEnchantedStatueBlockEntity(BlockPos pos, BlockState state) {
        super(NewexpBlockEntityType.ENCHANTED_STATUE,pos, state);
    }
    @Nullable
    private LivingEntity targetEntity;
    @Nullable
    private UUID targetUuid;
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.containsUuid("Target")) {
            this.targetUuid = nbt.getUuid("Target");
        } else {
            this.targetUuid = null;
        }

    }

    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.targetEntity != null) {
            nbt.putUuid("Target", this.targetEntity.getUuid());
        }
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket()  {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, NewexpEnchantedStatueBlockEntity blockEntity) {
        long l = world.getTime();
        if(l % 20L == 0L) {
            updateTargetEntity(world, pos, blockEntity);
            givePlayersEffects(world, pos);
            attackHostileEntity(world, pos, state, blockEntity);
            healFriendlyEntity(world, pos);
        }
    }

    private static void givePlayersEffects(World world, BlockPos pos) {
        int j = 32;
        int k = pos.getX();
        int l = pos.getY();
        int m = pos.getZ();
        Box box = (new Box((double)k, (double)l, (double)m, (double)(k + 1), (double)(l + 1), (double)(m + 1))).expand((double)j).stretch(0.0D, (double)world.getHeight(), 0.0D);
        List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
        if (!list.isEmpty()) {
            Iterator var10 = list.iterator();

            while(var10.hasNext()) {
                PlayerEntity playerEntity = (PlayerEntity)var10.next();
                if (pos.isWithinDistance(playerEntity.getBlockPos(), (double)j)) {
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 410, 0, true, true));
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 410, 0, true, true));
                }
            }

        }
    }
    private static void healFriendlyEntity(World world, BlockPos pos) {
        int j = 32;
        int k = pos.getX();
        int l = pos.getY();
        int m = pos.getZ();
        Box box = (new Box((double)k, (double)l, (double)m, (double)(k + 1), (double)(l + 1), (double)(m + 1))).expand((double)j).stretch(0.0D, (double)world.getHeight(), 0.0D);
        List<IronGolemEntity> list1 = world.getNonSpectatingEntities(IronGolemEntity.class, box);
        if (!list1.isEmpty()) {
            Iterator var10 = list1.iterator();

            while(var10.hasNext()) {
                IronGolemEntity ironGolemEntity = (IronGolemEntity)var10.next();
                if (pos.isWithinDistance(ironGolemEntity.getBlockPos(), (double)j) && !ironGolemEntity.isAiDisabled()) {
                    ironGolemEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
        List<SnowGolemEntity> list2 = world.getNonSpectatingEntities(SnowGolemEntity.class, box);
        if (!list2.isEmpty()) {
            Iterator var10 = list2.iterator();

            while(var10.hasNext()) {
                SnowGolemEntity snowGolemEntity = (SnowGolemEntity)var10.next();
                if (pos.isWithinDistance(snowGolemEntity.getBlockPos(), (double)j) && !snowGolemEntity.isAiDisabled()) {
                    snowGolemEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
        List<VillagerEntity> list3 = world.getNonSpectatingEntities(VillagerEntity.class, box);
        if (!list3.isEmpty()) {
            Iterator var10 = list3.iterator();

            while(var10.hasNext()) {
                VillagerEntity villagerEntity = (VillagerEntity)var10.next();
                if (pos.isWithinDistance(villagerEntity.getBlockPos(), (double)j) && !villagerEntity.isAiDisabled()) {
                    villagerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
        List<WanderingTraderEntity> list4 = world.getNonSpectatingEntities(WanderingTraderEntity.class, box);
        if (!list4.isEmpty()) {
            Iterator var10 = list4.iterator();

            while(var10.hasNext()) {
                WanderingTraderEntity wanderingTraderEntity = (WanderingTraderEntity)var10.next();
                if (pos.isWithinDistance(wanderingTraderEntity.getBlockPos(), (double)j) && !wanderingTraderEntity.isAiDisabled()) {
                    wanderingTraderEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
        List<PiglinEntity> list5 = world.getNonSpectatingEntities(PiglinEntity.class, box);
        if (!list5.isEmpty()) {
            Iterator var10 = list5.iterator();
        
            while(var10.hasNext()) {
                PiglinEntity piglinEntity = (PiglinEntity)var10.next();
                if (pos.isWithinDistance(piglinEntity.getBlockPos(), (double)j) && !piglinEntity.isAiDisabled()) {
                    piglinEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
        List<PiglinBruteEntity> list6 = world.getNonSpectatingEntities(PiglinBruteEntity.class, box);
        if (!list6.isEmpty()) {
            Iterator var10 = list6.iterator();
        
            while(var10.hasNext()) {
                PiglinBruteEntity piglinBruteEntity = (PiglinBruteEntity)var10.next();
                if (pos.isWithinDistance(piglinBruteEntity.getBlockPos(), (double)j) && !piglinBruteEntity.isAiDisabled()) {
                    piglinBruteEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30, 0, false, true));
                }
            }
        }
    }
    private static Box getAttackZone(BlockPos pos) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        return (new Box((double)i, (double)j, (double)k, (double)(i + 1), (double)(j + 1), (double)(k + 1))).expand(24.0D);
    }

    @Nullable
    private static LivingEntity findTargetEntity(World world, BlockPos pos, UUID uuid) {
        List<LivingEntity> list = world.getEntitiesByClass(LivingEntity.class, getAttackZone(pos), (livingEntity) -> {
            return livingEntity.getUuid().equals(uuid);
        });
        return list.size() == 1 ? (LivingEntity)list.get(0) : null;
    }

    private static void updateTargetEntity(World world, BlockPos pos, NewexpEnchantedStatueBlockEntity blockEntity) {
        if (blockEntity.targetUuid == null) {
            blockEntity.targetEntity = null;
        } else if (blockEntity.targetEntity == null || !blockEntity.targetEntity.getUuid().equals(blockEntity.targetUuid)) {
            blockEntity.targetEntity = findTargetEntity(world, pos, blockEntity.targetUuid);
            if (blockEntity.targetEntity == null) {
                blockEntity.targetUuid = null;
            }
        }

    }
    private static void attackHostileEntity(World world, BlockPos pos, BlockState state, NewexpEnchantedStatueBlockEntity blockEntity) {
        LivingEntity livingEntity = blockEntity.targetEntity;
        if (blockEntity.targetEntity == null && blockEntity.targetUuid != null) {
            blockEntity.targetEntity = findTargetEntity(world, pos, blockEntity.targetUuid);
            blockEntity.targetUuid = null;
        } else if (blockEntity.targetEntity == null) {
            List<LivingEntity> list = world.getEntitiesByClass(LivingEntity.class, getAttackZone(pos), (livingEntityx) -> {
                if(livingEntityx instanceof PiglinEntity || livingEntityx instanceof PiglinBruteEntity){
                    return false;
                }
                return livingEntityx instanceof Monster;
            });
            if (!list.isEmpty()) {
                blockEntity.targetEntity = (LivingEntity)list.get(world.random.nextInt(list.size()));
            }
        } else if (!blockEntity.targetEntity.isAlive() || !pos.isWithinDistance(blockEntity.targetEntity.getBlockPos(), 24.0D)) {
            blockEntity.targetEntity = null;
        }

        if (blockEntity.targetEntity != null) {
            world.playSound((PlayerEntity)null, blockEntity.targetEntity.getX(), blockEntity.targetEntity.getY(), blockEntity.targetEntity.getZ(), NewexpSounds.ENCHANTED_NETHERITE_STATUE_ATTACK_SOUND, SoundCategory.BLOCKS, 0.1F, 1.0F);
            blockEntity.targetEntity.damage(world.getDamageSources().outOfWorld(), 5.0F);
            blockEntity.targetEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 410, 0, true, true));
        }

        if (livingEntity != blockEntity.targetEntity) {
            world.updateListeners(pos, state, state, 2);
        }

    }
}
