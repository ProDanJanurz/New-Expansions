package net.new_expansions.items.usables;

import net.new_expansions.registry.NewexpSounds;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NewexpSmallMedkitItem extends Item {
    public NewexpSmallMedkitItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.getHealth() < user.getMaxHealth()){
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), NewexpSounds.SMALL_MEDKIT_USE_SOUND, SoundCategory.NEUTRAL, 0.5F, 1.0F);
            user.getItemCooldownManager().set(this, 600);
            if (!world.isClient) {
                user.setHealth(user.getHealth() + 4);
                user.setAbsorptionAmount(user.getAbsorptionAmount() + 2);
                user.removeStatusEffect(StatusEffects.POISON);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 110, 0, false, false, false));
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

            return TypedActionResult.success(itemStack, world.isClient());
        }else{
            return TypedActionResult.fail(itemStack);
        }
    }
}