package net.new_expansions.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.new_expansions.NewExpansions;
import net.new_expansions.registry.NewexpAttributes;

public class NewexpHudOverlay{
	private static final Identifier TRUE_ARMOR_EMPTY = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/true_armor_empty.png");
	private static final Identifier TRUE_ARMOR_HALF = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/true_armor_half.png");
	private static final Identifier TRUE_ARMOR_FULL = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/true_armor_full.png");
	private static final Identifier ICONS = new Identifier("textures/gui/icons.png");

	private static final Identifier SOUL_METER_0 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_0.png");
	private static final Identifier SOUL_METER_1 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_1.png");
	private static final Identifier SOUL_METER_2 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_2.png");
	private static final Identifier SOUL_METER_3 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_3.png");
	private static final Identifier SOUL_METER_4 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_4.png");
	private static final Identifier SOUL_METER_5 = new Identifier(NewExpansions.MOD_ID,"textures/gui/icons/soul_meter_5.png");

	public static void renderTrueArmor(DrawContext context) {
		int x = 0;
		MinecraftClient client = MinecraftClient.getInstance();
		int true_armor = (int) client.player.getAttributeValue(NewexpAttributes.TRUE_ARMOR);
		int m = client.getWindow().getScaledWidth() / 2 - 91;
		int o = client.getWindow().getScaledHeight() - 49;
		int i = MathHelper.ceil(client.player.getHealth());
		float f = Math.max((float)client.player.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float)Math.max(i, i));
		int p = MathHelper.ceil(client.player.getAbsorptionAmount());
		int q = MathHelper.ceil((f + (float)p) / 2.0F / 10.0F);
		int r = Math.max(10 - (q - 2), 3);
		if(client.player.getAttributeValue(EntityAttributes.GENERIC_ARMOR) < 1){
			o += 10;
		}
		int s = o - (q - 1) * r - 10;
		if(!client.player.isCreative() && !client.player.isSpectator()){
			for(int w = 0; w < 10; ++w) {
				if (true_armor > 0) {
					x = m + w * 8;
					if (w * 2 + 1 < true_armor) {
						context.drawTexture(TRUE_ARMOR_FULL, x, s, 0, 0, 9, 9,9,9);
					}
					if (w * 2 + 1 == true_armor) {
						context.drawTexture(TRUE_ARMOR_HALF, x, s, 0, 0, 9, 9,9,9);
					}
					if (w * 2 + 1 > true_armor) {
						context.drawTexture(TRUE_ARMOR_EMPTY, x, s, 0, 0, 9, 9,9,9);
					}
				}
			}
		}
	}

	public static void renderSoulMeter(MatrixStack matrixStack) {
		int x = 0;
		int y = 0;
		MinecraftClient client = MinecraftClient.getInstance();
		int soul_meter = (int) client.player.getAttributeValue(NewexpAttributes.SOUL_METER);
		int m = client.getWindow().getScaledWidth();
		int o = client.getWindow().getScaledHeight();
		if(!client.player.isCreative() && !client.player.isSpectator()){

		}
	}

}
