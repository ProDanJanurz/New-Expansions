package net.new_expansions.mixin;

import net.new_expansions.items.equipment.NewexpArmorItem;
import net.new_expansions.registry.NewexpItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.*;
import net.new_expansions.registry.NewexpTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin{

    @Inject(
            method = "wearsGoldArmor",
            at = @At("TAIL"),
            cancellable = true
    )
    private static void wearsNewexpGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        final ItemStack head = entity.getEquippedStack(EquipmentSlot.HEAD);
        final ItemStack body = entity.getEquippedStack(EquipmentSlot.CHEST);
        final ItemStack legs = entity.getEquippedStack(EquipmentSlot.LEGS);
        final ItemStack feet = entity.getEquippedStack(EquipmentSlot.FEET);
        if(
                head.isIn(NewexpTags.GOLD_ARMOR_ITEM)
                || body.isIn(NewexpTags.GOLD_ARMOR_ITEM)
                || legs.isIn(NewexpTags.GOLD_ARMOR_ITEM)
                || feet.isIn(NewexpTags.GOLD_ARMOR_ITEM)
        ) {
            cir.setReturnValue(true);
        }
    }

}
