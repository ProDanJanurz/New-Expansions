package com.pro__group.new_expansions.registry;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class NewexpTags {
    public static final Tag<Block> DRILL_MINEABLE = TagRegistry.block(new Identifier("newexp", "mineable/drill"));
}
