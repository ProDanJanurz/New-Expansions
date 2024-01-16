package net.new_expansions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.new_expansions.registry.NewexpBlocks;

public class NewexpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(NewexpBlocks.MAGMATO_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NewexpBlocks.MAGNETIC_RAIL, RenderLayer.getCutout());
    }
}