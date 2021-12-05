package com.pro__group.new_expansions.blocks.entity;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.registry.NewexpBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewexpBlockEntityType {
    public static final BlockEntityType<NewexpStoneKilnBlockEntity> STONE_KILN = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(NewExpansions.MOD_ID, "stone_kiln"), FabricBlockEntityTypeBuilder.create(NewexpStoneKilnBlockEntity::new, NewexpBlocks.STONE_KILN).build(null));
    public static final BlockEntityType<NewexpEnchantedStatueBlockEntity> ENCHANTED_STATUE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(NewExpansions.MOD_ID, "enchanted_statue"), FabricBlockEntityTypeBuilder.create(NewexpEnchantedStatueBlockEntity::new, NewexpBlocks.ENCHANTED_NETHERITE_STATUE).build(null));

}