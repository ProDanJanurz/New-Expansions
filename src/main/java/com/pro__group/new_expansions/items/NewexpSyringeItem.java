package com.pro__group.new_expansions.items;

import com.pro__group.new_expansions.registry.NewexpSounds;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NewexpSyringeItem extends Item {
    public NewexpSyringeItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        float a, b;
        ItemStack itemStack = user.getStackInHand(hand);
        a = user.getHealth();
        b = user.getMaxHealth();
        if(a < b){
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), NewexpSounds.SYRINGE_USE_SOUND, SoundCategory.NEUTRAL, 0.5F, 1.0F);
            user.getItemCooldownManager().set(this, 600);
            if (!world.isClient) {
                if(a < (b-8)) {
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 110, 0, false, false, false));
                    user.removeStatusEffect(StatusEffects.POISON);
                }else{
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0, false, false, false));
                    user.removeStatusEffect(StatusEffects.POISON);
                }
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