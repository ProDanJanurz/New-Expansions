package net.new_expansions.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;
import net.new_expansions.mixin.BrewingRecipeRegistryMixin;

public class NewexpPotions {
	//public static final Potion LUCK_POTION = new Potion(new StatusEffectInstance(StatusEffects.LUCK, 300, 0));
	
	public static void RegisterPotions(){
		//Registry.register(Registry.POTION, new Identifier(NewExpansions.MOD_ID, "luck_potion"), LUCK_POTION);
	}
	
	public static void RegisterPotionRecipes(){
		BrewingRecipeRegistryMixin.RegisterPotionRecipe(Potions.AWKWARD, NewexpItems.LUCKY_CLOVER, Potions.LUCK);
	}
}
