package net.new_expansions.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AnvilScreen.class)
public abstract class AnvilScreenMixin extends ForgingScreen<AnvilScreenHandler> {
	@Shadow @Final private PlayerEntity player;

	public AnvilScreenMixin(AnvilScreenHandler handler, PlayerInventory playerInventory, Text title, Identifier texture) {
		super(handler, playerInventory, title, texture);
	}

	private static final Identifier TEXTURE = new Identifier("textures/gui/container/anvil.png");
	private static final Text TOO_EXPENSIVE_TEXT = Text.translatable("container.repair.expensive");

	/**
	 * @author Pro__Dan
	 * @reason removed level limit
	 */
	@Overwrite
	public void drawForeground(DrawContext context, int mouseX, int mouseY) {
		super.drawForeground(context, mouseX, mouseY);
		int i = ((AnvilScreenHandler)this.handler).getLevelCost();
		if (i > 0) {
			int j = 8453920;
			Object text;
			if (i >= 999999999 && !this.client.player.getAbilities().creativeMode) {
				text = TOO_EXPENSIVE_TEXT;
				j = 16736352;
			} else if (!((AnvilScreenHandler)this.handler).getSlot(2).hasStack()) {
				text = null;
			} else {
				text = Text.translatable("container.repair.cost", new Object[]{i});
				if (!((AnvilScreenHandler)this.handler).getSlot(2).canTakeItems(this.player)) {
					j = 16736352;
				}
			}
			
			if (text != null) {
				int k = this.backgroundWidth - 8 - this.textRenderer.getWidth((StringVisitable)text) - 2;
				boolean l = true;
				context.fill(k - 2, 67, this.backgroundWidth - 8, 79, 1325400064);
				context.drawTextWithShadow(this.textRenderer, (Text)text, k, 69, j);
			}
		}
		
	}
}
