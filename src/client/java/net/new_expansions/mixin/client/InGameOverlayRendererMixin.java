package net.new_expansions.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Environment(EnvType.CLIENT)
@Mixin(InGameOverlayRenderer.class)
public abstract class InGameOverlayRendererMixin {
	private static final Identifier UNDERWATER_TEXTURE = new Identifier("textures/misc/underwater.png");
	private static BlockState getInWallBlockState(PlayerEntity player) {
		BlockPos.Mutable mutable = new BlockPos.Mutable();

		for(int i = 0; i < 8; ++i) {
			double d = player.getX() + (double)(((float)((i >> 0) % 2) - 0.5F) * player.getWidth() * 0.8F);
			double e = player.getEyeY() + (double)(((float)((i >> 1) % 2) - 0.5F) * 0.1F);
			double f = player.getZ() + (double)(((float)((i >> 2) % 2) - 0.5F) * player.getWidth() * 0.8F);
			mutable.set(d, e, f);
			BlockState blockState = player.getWorld().getBlockState(mutable);
			if (blockState.getRenderType() != BlockRenderType.INVISIBLE && blockState.shouldBlockVision(player.getWorld(), mutable)) {
				return blockState;
			}
		}

		return null;
	}

	private static void renderInWallOverlay(Sprite sprite, MatrixStack matrices) {
		RenderSystem.setShaderTexture(0, sprite.getAtlasId());
		RenderSystem.setShader(GameRenderer::getPositionColorTexProgram);
		BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
		float f = 0.1F;
		float g = -1.0F;
		float h = 1.0F;
		float i = -1.0F;
		float j = 1.0F;
		float k = -0.5F;
		float l = sprite.getMinU();
		float m = sprite.getMaxU();
		float n = sprite.getMinV();
		float o = sprite.getMaxV();
		Matrix4f matrix4f = matrices.peek().getPositionMatrix();
		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE);
		bufferBuilder.vertex(matrix4f, -1.0F, -1.0F, -0.5F).color(0.1F, 0.1F, 0.1F, 1.0F).texture(m, o).next();
		bufferBuilder.vertex(matrix4f, 1.0F, -1.0F, -0.5F).color(0.1F, 0.1F, 0.1F, 1.0F).texture(l, o).next();
		bufferBuilder.vertex(matrix4f, 1.0F, 1.0F, -0.5F).color(0.1F, 0.1F, 0.1F, 1.0F).texture(l, n).next();
		bufferBuilder.vertex(matrix4f, -1.0F, 1.0F, -0.5F).color(0.1F, 0.1F, 0.1F, 1.0F).texture(m, n).next();
		BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
	}

	private static void renderUnderwaterOverlay(MinecraftClient client, MatrixStack matrices) {
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.setShaderTexture(0, UNDERWATER_TEXTURE);
		BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
		BlockPos blockPos = BlockPos.ofFloored(client.player.getX(), client.player.getEyeY(), client.player.getZ());
		float f = LightmapTextureManager.getBrightness(client.player.getWorld().getDimension(), client.player.getWorld().getLightLevel(blockPos));
		RenderSystem.enableBlend();
		RenderSystem.setShaderColor(f, f, f, 0.1F);
		float g = 4.0F;
		float h = -1.0F;
		float i = 1.0F;
		float j = -1.0F;
		float k = 1.0F;
		float l = -0.5F;
		float m = -client.player.getYaw() / 64.0F;
		float n = client.player.getPitch() / 64.0F;
		Matrix4f matrix4f = matrices.peek().getPositionMatrix();
		bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
		bufferBuilder.vertex(matrix4f, -1.0F, -1.0F, -0.5F).texture(4.0F + m, 4.0F + n).next();
		bufferBuilder.vertex(matrix4f, 1.0F, -1.0F, -0.5F).texture(0.0F + m, 4.0F + n).next();
		bufferBuilder.vertex(matrix4f, 1.0F, 1.0F, -0.5F).texture(0.0F + m, 0.0F + n).next();
		bufferBuilder.vertex(matrix4f, -1.0F, 1.0F, -0.5F).texture(4.0F + m, 0.0F + n).next();
		BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
	}

	private static void renderFireOverlay(MinecraftClient client, MatrixStack matrices) {
		BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
		RenderSystem.setShader(GameRenderer::getPositionColorTexProgram);
		RenderSystem.depthFunc(519);
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		Sprite sprite = ModelLoader.FIRE_1.getSprite();
		RenderSystem.setShaderTexture(0, sprite.getAtlasId());
		float f = sprite.getMinU();
		float g = sprite.getMaxU();
		float h = (f + g) / 2.0F;
		float i = sprite.getMinV();
		float j = sprite.getMaxV();
		float k = (i + j) / 2.0F;
		float l = sprite.getAnimationFrameDelta();
		float m = MathHelper.lerp(l, f, h);
		float n = MathHelper.lerp(l, g, h);
		float o = MathHelper.lerp(l, i, k);
		float p = MathHelper.lerp(l, j, k);
		float q = 1.0F;

		for(int r = 0; r < 2; ++r) {
			matrices.push();
			float s = -0.5F;
			float t = 0.5F;
			float u = -0.5F;
			float v = 0.5F;
			float w = -0.5F;
			matrices.translate((float)(-(r * 2 - 1)) * 0.24F, -0.3F, 0.0F);
			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees((float)(r * 2 - 1) * 10.0F));
			Matrix4f matrix4f = matrices.peek().getPositionMatrix();
			bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR_TEXTURE);
			bufferBuilder.vertex(matrix4f, -0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).texture(n, p).next();
			bufferBuilder.vertex(matrix4f, 0.5F, -0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).texture(m, p).next();
			bufferBuilder.vertex(matrix4f, 0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).texture(m, o).next();
			bufferBuilder.vertex(matrix4f, -0.5F, 0.5F, -0.5F).color(1.0F, 1.0F, 1.0F, 0.9F).texture(n, o).next();
			BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
			matrices.pop();
		}

		RenderSystem.disableBlend();
		RenderSystem.depthMask(true);
		RenderSystem.depthFunc(515);
	}

	/**
	 * @author Pro__Dan
	 * @reason Added extra fire resistance functionality
	 */
	@Overwrite
	public static void renderOverlays(MinecraftClient client, MatrixStack matrices) {
		PlayerEntity playerEntity = client.player;
		if (!playerEntity.noClip) {
			BlockState blockState = getInWallBlockState(playerEntity);
			if (blockState != null) {
				renderInWallOverlay(client.getBlockRenderManager().getModels().getModelParticleSprite(blockState), matrices);
			}
		}
		if (!client.player.isSpectator()) {
			if (client.player.isSubmergedIn(FluidTags.WATER)) {
				renderUnderwaterOverlay(client, matrices);
			}

			if (client.player.isOnFire() && !(client.player.hasStatusEffect(StatusEffects.FIRE_RESISTANCE))) {
				renderFireOverlay(client, matrices);
			}
		}

	}
}
