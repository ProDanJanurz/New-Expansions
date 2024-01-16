package net.new_expansions.items.equipment;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.new_expansions.materials.NewexpArmorMaterial;
import net.new_expansions.registry.NewexpAttributes;

import java.util.EnumMap;
import java.util.List;
import java.util.UUID;

public class NewexpArmorItem extends Item implements Equipment {
	private static final EnumMap<NewexpArmorItem.Type, UUID> MODIFIERS = (EnumMap)Util.make(new EnumMap(NewexpArmorItem.Type.class), (uuidMap) -> {
		uuidMap.put(NewexpArmorItem.Type.BOOTS, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
		uuidMap.put(NewexpArmorItem.Type.LEGGINGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
		uuidMap.put(NewexpArmorItem.Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
		uuidMap.put(NewexpArmorItem.Type.HELMET, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
	});
	public static final DispenserBehavior DISPENSER_BEHAVIOR = new ItemDispenserBehavior() {
		protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
			return dispenseArmor(pointer, stack) ? stack : super.dispenseSilently(pointer, stack);
		}
	};
	protected final Type type;
	private final int protection;
	private final int trueProtection;
	private final float toughness;
	protected final float knockbackResistance;
	protected final NewexpArmorMaterial material;
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	
	public static boolean dispenseArmor(BlockPointer pointer, ItemStack armor) {
		BlockPos blockPos = pointer.pos().offset((Direction)pointer.state().get(DispenserBlock.FACING));
		List<LivingEntity> list = pointer.world().getEntitiesByClass(LivingEntity.class, new Box(blockPos), EntityPredicates.EXCEPT_SPECTATOR.and(new EntityPredicates.Equipable(armor)));
		if (list.isEmpty()) {
			return false;
		} else {
			LivingEntity livingEntity = (LivingEntity)list.get(0);
			EquipmentSlot equipmentSlot = MobEntity.getPreferredEquipmentSlot(armor);
			ItemStack itemStack = armor.split(1);
			livingEntity.equipStack(equipmentSlot, itemStack);
			if (livingEntity instanceof MobEntity) {
				((MobEntity)livingEntity).setEquipmentDropChance(equipmentSlot, 2.0F);
				((MobEntity)livingEntity).setPersistent();
			}
			return true;
		}
	}
	
	public NewexpArmorItem(NewexpArmorMaterial material, Type type, Item.Settings settings) {
		super(settings.maxDamageIfAbsent(material.getDurability(type)));
		this.material = material;
		this.type = type;
		this.protection = material.getProtection(type);
		this.trueProtection = material.getTrueProtection(type);
		this.toughness = material.getToughness(type);
		this.knockbackResistance = material.getKnockbackResistance(type);
		DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		UUID uUID = (UUID)MODIFIERS.get(type);
		builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uUID, "Armor modifier", (double)this.protection, EntityAttributeModifier.Operation.ADDITION));
		builder.put(NewexpAttributes.TRUE_ARMOR, new EntityAttributeModifier(uUID, "True armor modifier", (double)this.trueProtection, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(uUID, "Armor toughness", (double)this.toughness, EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uUID, "Armor knockback resistance", (double)this.knockbackResistance, EntityAttributeModifier.Operation.ADDITION));
		
		this.attributeModifiers = builder.build();
	}
	
	public void inventoryTick(ItemStack stack, World world, Entity entity, int invSlot, boolean selected) {
		if (!world.isClient) {
			if(stack.getDamage() > 0 && world.getTime() % 400 == 0){
				switch (this.getMaterial().toString()) {
					case "ENDITE", "GOLD_ENHANCEMENT_ENDITE", "DIAMOND_ENHANCEMENT_ENDITE", "NETHERITE_ENHANCEMENT_ENDITE" -> stack.setDamage(Math.max(stack.getDamage() - 2, 0));
					case "ENDITE_ENHANCEMENT_GOLD", "ENDITE_ENHANCEMENT_DIAMOND", "ENDITE_ENHANCEMENT_NETHERITE" -> stack.setDamage(Math.max(stack.getDamage() - 1, 0));
					case "ENDITE_ENHANCEMENT_ENDITE" -> stack.setDamage(Math.max(stack.getDamage() - 4, 0));
					default -> {
					}
				}
			}
			
			if(((LivingEntity)entity).getEquippedStack(EquipmentSlot.HEAD).getItem() == this && !((LivingEntity)entity).isSubmergedIn(FluidTags.WATER) && this.getMaterial().toString() == "TURTLE"){
				((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 610, 0, false, false, true));
			}
			
			if(((LivingEntity)entity).getEquippedStack(EquipmentSlot.FEET).getItem() == this && ((LivingEntity)entity).isOnGround()){
				switch (this.getMaterial().toString()) {
					case "ENDITE", "GOLD_ENHANCEMENT_ENDITE", "DIAMOND_ENHANCEMENT_ENDITE", "NETHERITE_ENHANCEMENT_ENDITE" -> ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 410, 0, false, false, true));
					case "ENDITE_ENHANCEMENT_ENDITE" -> ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 810, 0, false, false, true));
					default -> {}
				}
			}
			
			if(stack.getDamage() > stack.getMaxDamage()){
				stack.setDamage(stack.getMaxDamage() - 1);
			}
		}
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return this.equipAndSwap(this, world, user, hand);
	}
	
	public Type getType() {
		return this.type;
	}
	
	public int getEnchantability() {
		return this.material.getEnchantability();
	}
	
	public NewexpArmorMaterial getMaterial() {
		return this.material;
	}
	
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return this.material.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
	}
	
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == this.type.getEquipmentSlot() ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
	
	public int getProtection() {
		return this.protection;
	}
	
	public int getTrueProtection() {
		return this.trueProtection;
	}
	
	public float getToughness() {
		return this.toughness;
	}
	
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	public EquipmentSlot getSlotType() {
		return this.type.getEquipmentSlot();
	}
	
	public SoundEvent getEquipSound() {
		return this.getMaterial().getEquipSound();
	}
	
	public static enum Type {
		HELMET(EquipmentSlot.HEAD, "helmet"),
		CHESTPLATE(EquipmentSlot.CHEST, "chestplate"),
		LEGGINGS(EquipmentSlot.LEGS, "leggings"),
		BOOTS(EquipmentSlot.FEET, "boots");
		
		private final EquipmentSlot equipmentSlot;
		private final String name;
		
		private Type(EquipmentSlot equipmentSlot, String name) {
			this.equipmentSlot = equipmentSlot;
			this.name = name;
		}
		
		public EquipmentSlot getEquipmentSlot() {
			return this.equipmentSlot;
		}
		
		public String getName() {
			return this.name;
		}
	}
}