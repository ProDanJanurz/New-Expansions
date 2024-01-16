package net.new_expansions.items.equipment;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpTags;

public class NewexpMiningToolItem extends NewexpToolItem implements Vanishable {
	private final TagKey<Block> effectiveBlocks;
	protected final float miningSpeed;
	private final float attackDamage;
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	
	NewexpMiningToolItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
		super(material, settings);
		this.effectiveBlocks = effectiveBlocks;
		this.miningSpeed = material.getMiningSpeedMultiplier();
		this.attackDamage = attackDamage + material.getAttackDamage();
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", (double)attackSpeed, EntityAttributeModifier.Operation.ADDITION));
		this.attributeModifiers = builder.build();
	}
	
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
		return state.isIn(this.effectiveBlocks) ? this.miningSpeed : 1.0F;
	}
	
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(2, attacker, (e) -> {
			e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
		});
		return true;
	}
	
	public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
		if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
			stack.damage(1, miner, (e) -> {
				e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
			});
		}
		
		return true;
	}
	
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
	
	public float getAttackDamage() {
		return this.attackDamage;
	}
	
	public boolean isSuitableFor(BlockState state) {
		int toolMaterial = this.getMaterial().getMiningLevel();
		
		if (toolMaterial < 5 && (state.isIn(BlockTags.NEEDS_DIAMOND_TOOL) && !state.isIn(NewexpTags.DIAMOND_TOOL_LEVEL))) {
			return false;
		} else if (toolMaterial < 4 && (state.isIn(BlockTags.NEEDS_IRON_TOOL) && !state.isIn(NewexpTags.IRON_TOOL_LEVEL) && !state.isIn(NewexpTags.GOLD_TOOL_LEVEL))) {
			return false;
		} else if (toolMaterial < 2 && (state.isIn(BlockTags.NEEDS_STONE_TOOL) && !state.isIn(NewexpTags.STONE_TOOL_LEVEL) && !state.isIn(NewexpTags.COPPER_TOOL_LEVEL))) {
			return false;
		}
		
		if (toolMaterial < 7 && state.isIn(NewexpTags.JEWELED_TOOL_LEVEL)) {
			return false;
		} else if (toolMaterial < 6 && state.isIn(NewexpTags.NETHERITE_TOOL_LEVEL)) {
			return false;
		} else if (toolMaterial < 5 && state.isIn(NewexpTags.DIAMOND_TOOL_LEVEL)) {
			return false;
		} else if (toolMaterial < 4 && state.isIn(NewexpTags.GOLD_TOOL_LEVEL)) {
			return false;
		} else if (toolMaterial < 3 && state.isIn(NewexpTags.IRON_TOOL_LEVEL)) {
			return false;
		} else if (toolMaterial < 2 && state.isIn(NewexpTags.COPPER_TOOL_LEVEL)) {
			return false;
		} else {
			return (toolMaterial >= 1 || !state.isIn(NewexpTags.STONE_TOOL_LEVEL)) && state.isIn(this.effectiveBlocks);
		}
	}
}