package net.new_expansions.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.new_expansions.render.NewexpHudOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin{
	@Inject(method = "renderStatusBars", at = @At(value = "TAIL"))
	private void renderStatusBars(DrawContext context, CallbackInfo ci) {
		NewexpHudOverlay.renderTrueArmor(context);
	}

}
