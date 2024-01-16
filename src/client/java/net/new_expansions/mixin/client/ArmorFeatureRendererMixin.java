package net.new_expansions.mixin.client;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.util.Identifier;
import net.new_expansions.items.trim.NewexpArmorTrim;
import net.new_expansions.items.equipment.NewexpArmorItem;
import net.new_expansions.items.equipment.NewexpDyableArmorItem;
import net.new_expansions.materials.NewexpArmorMaterial;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends BipedEntityModel<T>, A extends BipedEntityModel<T>> extends FeatureRenderer<T, M> {

	public ArmorFeatureRendererMixin(FeatureRendererContext<T, M> context) {
		super(context);
	}
	private static final Map<String, Identifier> ARMOR_TEXTURE_CACHE = Maps.newHashMap();

	@Shadow protected abstract void setVisible(A bipedModel, EquipmentSlot slot);

	@Shadow	protected abstract boolean usesInnerModel(EquipmentSlot slot);
	
	@Shadow @Final private SpriteAtlasTexture armorTrimsAtlas;
	
	protected Identifier getArmorTexture(ArmorItem item, boolean secondLayer, @Nullable String overlay) {
		String var10000 = item.getMaterial().getName();
		String string = "textures/models/armor/" + var10000 + "_layer_" + (secondLayer ? 2 : 1) + (overlay == null ? "" : "_" + overlay) + ".png";
		return (Identifier)ARMOR_TEXTURE_CACHE.computeIfAbsent(string, Identifier::new);
	}
	
	private void renderArmorParts(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArmorItem item, A model, boolean secondTextureLayer, float red, float green, float blue, @Nullable String overlay) {
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getArmorCutoutNoCull(this.getArmorTexture(item, secondTextureLayer, overlay)));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, red, green, blue, 1.0F);
	}
	
	private void renderTrim(ArmorMaterial material, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ArmorTrim trim, A model, boolean leggings) {
		Sprite sprite = this.armorTrimsAtlas.getSprite(leggings ? trim.getLeggingsModelId(material) : trim.getGenericModelId(material));
		VertexConsumer vertexConsumer = sprite.getTextureSpecificVertexConsumer(vertexConsumers.getBuffer(TexturedRenderLayers.getArmorTrims(((ArmorTrimPattern)trim.getPattern().value()).decal())));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
	}
	
	private void renderGlint(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, A model) {
		model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getArmorEntityGlint()), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
	}
	
	protected Identifier getNewexpArmorTexture(NewexpArmorItem item, boolean secondLayer, @Nullable String overlay) {
		String var10000 = item.getMaterial().getName();
		String string = "textures/models/armor/" + var10000 + "_layer_" + (secondLayer ? 2 : 1) + (overlay == null ? "" : "_" + overlay) + ".png";
		return (Identifier)ARMOR_TEXTURE_CACHE.computeIfAbsent(string, Identifier::new);
	}
	
	private void renderNewexpArmorParts(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, NewexpArmorItem item, A model, boolean secondTextureLayer, float red, float green, float blue, @Nullable String overlay) {
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getArmorCutoutNoCull(this.getNewexpArmorTexture(item, secondTextureLayer, overlay)));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, red, green, blue, 1.0F);
	}
	
	private void renderNewexpTrim(NewexpArmorMaterial material, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, NewexpArmorTrim trim, A model, boolean leggings) {
		Sprite sprite = this.armorTrimsAtlas.getSprite(leggings ? trim.getLeggingsModelId(material) : trim.getGenericModelId(material));
		VertexConsumer vertexConsumer = sprite.getTextureSpecificVertexConsumer(vertexConsumers.getBuffer(TexturedRenderLayers.getArmorTrims(((ArmorTrimPattern)trim.getPattern().value()).decal())));
		model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
	}

	/**
	 * @author Pro__Dan
	 * @reason add rendering to NewexpArmorItem
	 */
	@Overwrite
	private void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model) {
		ItemStack itemStack = entity.getEquippedStack(armorSlot);
		Item var9 = itemStack.getItem();
		if (var9 instanceof ArmorItem armorItem) {
			if (armorItem.getSlotType() == armorSlot) {
				((BipedEntityModel)this.getContextModel()).copyBipedStateTo(model);
				this.setVisible(model, armorSlot);
				boolean bl = this.usesInnerModel(armorSlot);
				if (armorItem instanceof DyeableArmorItem) {
					DyeableArmorItem dyeableArmorItem = (DyeableArmorItem)armorItem;
					int i = dyeableArmorItem.getColor(itemStack);
					float f = (float)(i >> 16 & 255) / 255.0F;
					float g = (float)(i >> 8 & 255) / 255.0F;
					float h = (float)(i & 255) / 255.0F;
					this.renderArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, f, g, h, (String)null);
					this.renderArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, 1.0F, 1.0F, 1.0F, "overlay");
				} else {
					this.renderArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, 1.0F, 1.0F, 1.0F, (String)null);
				}
				
				ArmorTrim.getTrim(entity.getWorld().getRegistryManager(), itemStack, true).ifPresent((trim) -> {
					this.renderTrim(armorItem.getMaterial(), matrices, vertexConsumers, light, trim, model, bl);
				});
				if (itemStack.hasGlint()) {
					this.renderGlint(matrices, vertexConsumers, light, model);
				}
				
			}
		}
		if (var9 instanceof NewexpArmorItem armorItem) {
			if (armorItem.getSlotType() == armorSlot) {
				((BipedEntityModel)this.getContextModel()).copyBipedStateTo(model);
				this.setVisible(model, armorSlot);
				boolean bl = this.usesInnerModel(armorSlot);
				
				if (armorItem instanceof NewexpDyableArmorItem) {
					NewexpDyableArmorItem dyeableArmorItem = (NewexpDyableArmorItem)armorItem;
					int i = dyeableArmorItem.getColor(itemStack);
					float f = (float)(i >> 16 & 255) / 255.0F;
					float g = (float)(i >> 8 & 255) / 255.0F;
					float h = (float)(i & 255) / 255.0F;
					this.renderNewexpArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, f, g, h, (String)null);
					this.renderNewexpArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, 1.0F, 1.0F, 1.0F, "overlay");
				} else {
					this.renderNewexpArmorParts(matrices, vertexConsumers, light, armorItem, model, bl, 1.0F, 1.0F, 1.0F, (String)null);
				}
				
				NewexpArmorTrim.getTrim(entity.getWorld().getRegistryManager(), itemStack).ifPresent((trim) -> {
					this.renderNewexpTrim(armorItem.getMaterial(), matrices, vertexConsumers, light, trim, model, bl);
				});
				if (itemStack.hasGlint()) {
					this.renderGlint(matrices, vertexConsumers, light, model);
				}
				
			}
		}
	}
}