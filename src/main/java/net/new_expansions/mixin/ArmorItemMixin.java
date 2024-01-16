package net.new_expansions.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.new_expansions.materials.NewexpArmorMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.new_expansions.registry.NewexpAttributes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;
@Mixin(ArmorItem.class)
public abstract class ArmorItemMixin {

    /*
    @Shadow @Final private static UUID[] MODIFIERS;
    @Shadow @Final @Mutable private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    @Shadow @Final protected float knockbackResistance;

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void constructor(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings, CallbackInfo info) {
        UUID uUID = MODIFIERS[slot.getEntitySlotId()];
        /*
        if (material == NewexpArmorMaterials.GG) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.GG.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.GD) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.GD.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.GN) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.GN.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.GE) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.GE.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.DG) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.G.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.DN) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.N.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.NG) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.G.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.NN) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.N.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.EG) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.G.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.EN) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.N.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.G) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.G.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        if (material == NewexpArmorMaterials.N) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        
            this.attributeModifiers.forEach(builder::put);
        
            builder.put(
                    NewexpAttributes.TRUE_ARMOR,
                    new EntityAttributeModifier(uUID,
                            "True armor",
                            NewexpArmorMaterials.N.getTrueProtectionAmount(slot),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        
            this.attributeModifiers = builder.build();
        }
        
    }
    */
}
