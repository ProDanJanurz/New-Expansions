package net.new_expansions.registry;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class NewexpGamerules {
	public static GameRules.Key<GameRules.BooleanRule> DO_NO_SLEEP;
	public static GameRules.Key<GameRules.BooleanRule> DO_FREEZE;
	public static GameRules.Key<GameRules.IntRule> TIME_BEFORE_FREEZE;
	public static GameRules.Key<GameRules.IntRule> FREEZE_SPEED;
	public static GameRules.Key<GameRules.BooleanRule> DO_SATURATION_REGENERATION;
	public static GameRules.Key<GameRules.BooleanRule> DO_HUNGER_REGENERATION;
	public static GameRules.Key<GameRules.IntRule> SATURATION_REGENERATION_SPEED;
	public static GameRules.Key<GameRules.IntRule> HUNGER_REGENERATION_SPEED;
	public static GameRules.Key<GameRules.IntRule> SATURATION_REGENERATION_LEVEL;
	public static GameRules.Key<GameRules.IntRule> SATURATION_REGENERATION_HUNGER_LEVEL;
	public static GameRules.Key<GameRules.IntRule> HUNGER_REGENERATION_LEVEL;
	public static GameRules.Key<GameRules.IntRule> SATURATION_REGENERATION_COST;
	public static GameRules.Key<GameRules.IntRule> HUNGER_REGENERATION_COST;
	public static GameRules.Key<GameRules.BooleanRule> ALLOW_SPRINTING;
	public static void RegisterGamerules(){
		DO_NO_SLEEP = GameRuleRegistry.register("doNoSleep", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));
		DO_FREEZE = GameRuleRegistry.register("doFreeze", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
		TIME_BEFORE_FREEZE = GameRuleRegistry.register("timeBeforeFreeze", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(24000, 0));
		FREEZE_SPEED = GameRuleRegistry.register("freezeSpeed", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(2, 1, 10));
		DO_SATURATION_REGENERATION = GameRuleRegistry.register("doSaturationRegeneration", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
		DO_HUNGER_REGENERATION = GameRuleRegistry.register("doHungerRegeneration", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
		SATURATION_REGENERATION_SPEED = GameRuleRegistry.register("SaturationRegenerationSpeed", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(20, 0, 100000));
		HUNGER_REGENERATION_SPEED = GameRuleRegistry.register("HungerRegenerationSpeed", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(400, 0, 100000));
		SATURATION_REGENERATION_LEVEL = GameRuleRegistry.register("SaturationRegenerationLevel", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(4, 0, 20));
		SATURATION_REGENERATION_HUNGER_LEVEL = GameRuleRegistry.register("SaturationRegenerationHungerLevel", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(16, 0, 20));
		HUNGER_REGENERATION_LEVEL = GameRuleRegistry.register("HungerRegenerationLevel", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(11, 0, 20));
		SATURATION_REGENERATION_COST = GameRuleRegistry.register("SaturationRegenerationCost", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(600, 0, 10000));
		HUNGER_REGENERATION_COST = GameRuleRegistry.register("HungerRegenerationCost", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(400, 0, 10000));
		ALLOW_SPRINTING = GameRuleRegistry.register("allowSprinting", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
	}
}