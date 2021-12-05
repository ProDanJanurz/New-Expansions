package com.pro__group.new_expansions.mixin;

import com.pro__group.new_expansions.registry.NewexpItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.*;
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
        final ItemStack a = entity.getEquippedStack(EquipmentSlot.HEAD);
        final ItemStack b = entity.getEquippedStack(EquipmentSlot.CHEST);
        final ItemStack c = entity.getEquippedStack(EquipmentSlot.LEGS);
        final ItemStack d = entity.getEquippedStack(EquipmentSlot.FEET);
        if(
                a.getItem() == NewexpItems.GHELMET
                || b.getItem() == NewexpItems.GCHESTPALTE
                || c.getItem() == NewexpItems.GLEGGINGS
                || d.getItem() == NewexpItems.GBOOTS
                || a.getItem() == NewexpItems.GGHELMET
                || b.getItem() == NewexpItems.GGCHESTPALTE
                || c.getItem() == NewexpItems.GGLEGGINGS
                || d.getItem() == NewexpItems.GGBOOTS
                || a.getItem() == NewexpItems.DGHELMET
                || b.getItem() == NewexpItems.DGCHESTPALTE
                || c.getItem() == NewexpItems.DGLEGGINGS
                || d.getItem() == NewexpItems.DGBOOTS
                || a.getItem() == NewexpItems.NGHELMET
                || b.getItem() == NewexpItems.NGCHESTPALTE
                || c.getItem() == NewexpItems.NGLEGGINGS
                || d.getItem() == NewexpItems.NGBOOTS
                || a.getItem() == NewexpItems.EGHELMET
                || b.getItem() == NewexpItems.EGCHESTPALTE
                || c.getItem() == NewexpItems.EGLEGGINGS
                || d.getItem() == NewexpItems.EGBOOTS
        ) {
            cir.setReturnValue(true);
        }
    }

}
