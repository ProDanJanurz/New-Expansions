package net.new_expansions.registry;

import com.google.common.collect.ImmutableSet;
import com.ibm.icu.impl.locale.XCldrStub;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.new_expansions.NewExpansions;
import org.jetbrains.annotations.Nullable;

public class NewexpTradeOffers {
	
	//public static final PointOfInterestType TSPOI = register("tspoi", Blocks.OBSIDIAN);
	//public static final PointOfInterestType TSPOI = register("tspoi", Blocks.OBSIDIAN);
	//public static final VillagerProfession TS = register("ts", PointOfInterestTypes.TOOLSMITH, SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);
	//public static final VillagerProfession TS = register("ts", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(NewExpansions.MOD_ID,
	//		"tspoi")), SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH);
	//"newexp:tspoi"
	public static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound) {
		return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(NewExpansions.MOD_ID, id),
				VillagerProfessionBuilder.create().id(new Identifier(NewExpansions.MOD_ID, id)).workstation(heldWorkstation)
						.workSound(workSound).build());
	}
	
	public static PointOfInterestType register(String n, Block b){
		return PointOfInterestHelper.register(new Identifier(NewExpansions.MOD_ID, n), 1, 1,
				ImmutableSet.copyOf(b.getStateManager().getStates()));
	}
	
	public static void RegisterTradeOffers(){
		//TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1,
		//factories -> {
		//	factories.add((entity, random) -> new TradeOffer(
		//		new ItemStack(Items.EMERALD, 1),
		//		new ItemStack(Items.OBSIDIAN, 3),
		//		1, 1, 1 ));
		//});
	}
}
