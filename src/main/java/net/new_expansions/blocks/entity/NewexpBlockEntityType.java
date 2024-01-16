package net.new_expansions.blocks.entity;

import net.new_expansions.NewExpansions;
import net.new_expansions.registry.NewexpBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class NewexpBlockEntityType {
    public static BlockEntityType<NewexpEnchantedStatueBlockEntity> ENCHANTED_STATUE;
	public static void RegisterEntityType(){
		ENCHANTED_STATUE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NewExpansions.MOD_ID, "enchanted_statue"), FabricBlockEntityTypeBuilder.create(NewexpEnchantedStatueBlockEntity::new, NewexpBlocks.ENCHANTED_NETHERITE_STATUE).build(null));
	}
}