package net.new_expansions.items.equipment;

import net.minecraft.item.DyeableItem;
import net.new_expansions.materials.NewexpArmorMaterial;

public class NewexpDyableArmorItem extends NewexpArmorItem implements DyeableItem {
	public NewexpDyableArmorItem(NewexpArmorMaterial material, Type type, Settings settings) {
		super(material, type, settings);
	}
}
