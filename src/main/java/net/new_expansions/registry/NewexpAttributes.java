package net.new_expansions.registry;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;

public class NewexpAttributes {
	
	public NewexpAttributes() {}
	
	public static EntityAttribute TRUE_ARMOR = register("true_armor", (new ClampedEntityAttribute("attribute.name.newexp.true_armor", 0.0D, 0.0D, 20.0D)).setTracked(true));
	public static EntityAttribute SOUL_METER = register("soul_meter", (new ClampedEntityAttribute("attribute.name.newexp.soul_meter", 0.0D, 0.0D, 100.0D)).setTracked(true));
	public static EntityAttribute KILLS = register("kills", (new ClampedEntityAttribute("attribute.name.newexp.kills", 0.0D, 0.0D, 4096.0D)).setTracked(true));
	public static EntityAttribute TAMED = register("tamed", (new ClampedEntityAttribute("attribute.name.newexp.tamed", 0.0D, 0.0D, 1.0D)).setTracked(true));
	
	private static EntityAttribute register(String id, EntityAttribute attribute) {
		return (EntityAttribute) Registry.register(Registries.ATTRIBUTE, new Identifier(NewExpansions.MOD_ID, id), attribute);
	}
}
