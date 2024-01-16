package net.new_expansions.items.magic_items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpSounds;

public class NewexpCharm extends Item {
    public NewexpCharm(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.getHealth() < user.getMaxHealth()){
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), NewexpSounds.BANDAGE_USE_SOUND, SoundCategory.NEUTRAL, 0.5F, 1.0F);
            user.getItemCooldownManager().set(this, 300);
            if (!world.isClient) {
                user.setHealth(user.getHealth() + 2);
            }
            return TypedActionResult.success(itemStack, world.isClient());
        }else{
            return TypedActionResult.fail(itemStack);
        }
    }
}