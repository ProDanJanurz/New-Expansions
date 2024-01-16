package net.new_expansions.mixin.client;

import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.new_expansions.items.equipment.NewexpArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(HeadFeatureRenderer.class)
public abstract class HeadFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T> & ModelWithHead> extends FeatureRenderer<T, M> {
	public HeadFeatureRendererMixin(FeatureRendererContext<T, M> context) {
		super(context);
	}

	@Shadow public static void translate(MatrixStack matrices, boolean villager){
		float f = 0.625F;
		matrices.translate(0.0, -0.25, 0.0);
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
		matrices.scale(0.625F, -0.625F, -0.625F);
		if (villager) {
			matrices.translate(0.0, 0.1875, 0.0);
		}
	}

	@Shadow @Final private float scaleY;
	@Shadow @Final private float scaleX;
	@Shadow @Final private float scaleZ;
	@Shadow @Final private Map<SkullBlock.SkullType, SkullBlockEntityModel> headModels;
	@Shadow @Final private HeldItemRenderer heldItemRenderer;

	/**
	 * @author Pro__Dan
	 * @reason fix head rendering bug with helmets
	 */
	@Overwrite
	public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
		ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
		if (!itemStack.isEmpty()) {
			Item item = itemStack.getItem();
			matrixStack.push();
			matrixStack.scale(this.scaleX, this.scaleY, this.scaleZ);
			boolean bl = livingEntity instanceof VillagerEntity || livingEntity instanceof ZombieVillagerEntity;
			float m;
			if (livingEntity.isBaby() && !(livingEntity instanceof VillagerEntity)) {
				m = 2.0F;
				float n = 1.4F;
				matrixStack.translate(0.0, 0.03125, 0.0);
				matrixStack.scale(0.7F, 0.7F, 0.7F);
				matrixStack.translate(0.0, 1.0, 0.0);
			}

			((ModelWithHead)this.getContextModel()).getHead().rotate(matrixStack);
			if (item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof AbstractSkullBlock) {
				m = 1.1875F;
				matrixStack.scale(1.1875F, -1.1875F, -1.1875F);
				if (bl) {
					matrixStack.translate(0.0, 0.0625, 0.0);
				}

				GameProfile gameProfile = null;
				if (itemStack.hasNbt()) {
					NbtCompound nbtCompound = itemStack.getNbt();
					if (nbtCompound.contains("SkullOwner", 10)) {
						gameProfile = NbtHelper.toGameProfile(nbtCompound.getCompound("SkullOwner"));
					}
				}

				matrixStack.translate(-0.5, 0.0, -0.5);
				SkullBlock.SkullType skullType = ((AbstractSkullBlock)((BlockItem)item).getBlock()).getSkullType();
				SkullBlockEntityModel skullBlockEntityModel = (SkullBlockEntityModel)this.headModels.get(skullType);
				RenderLayer renderLayer = SkullBlockEntityRenderer.getRenderLayer(skullType, gameProfile);
				SkullBlockEntityRenderer.renderSkull((Direction)null, 180.0F, f, matrixStack, vertexConsumerProvider, i, skullBlockEntityModel, renderLayer);
			}else{
				boolean armor = false ,armor2 = false;
				if ((item instanceof ArmorItem) && ((ArmorItem)item).getSlotType() == EquipmentSlot.HEAD) {
				 	armor = true;
				}
				if ((item instanceof NewexpArmorItem) && ((NewexpArmorItem)item).getSlotType() == EquipmentSlot.HEAD) {
					armor2 = true;
				}
				if(armor || armor2){

				}else{
					translate(matrixStack, bl);
					this.heldItemRenderer.renderItem(livingEntity, itemStack, ModelTransformationMode.HEAD, false, matrixStack, vertexConsumerProvider, i);
				}
			}

			matrixStack.pop();
		}
	}
}
