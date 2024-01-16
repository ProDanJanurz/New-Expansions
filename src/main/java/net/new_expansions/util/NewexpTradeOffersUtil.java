package net.new_expansions.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SuspiciousStewIngredient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.map.MapIcon;
import net.minecraft.item.map.MapState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.*;
import net.minecraft.world.gen.structure.Structure;
import net.new_expansions.registry.NewexpItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.minecraft.item.DyeItem;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SuspiciousStewItem;

public class NewexpTradeOffersUtil {
	private static int DEFAULT_MAX_USES = 12;
	private static final int COMMON_MAX_USES = 16;
	private static final int RARE_MAX_USES = 3;
	private static final int NOVICE_SELL_XP = 1;
	private static final int NOVICE_BUY_XP = 2;
	private static final int APPRENTICE_SELL_XP = 5;
	private static final int APPRENTICE_BUY_XP = 10;
	private static final int JOURNEYMAN_SELL_XP = 10;
	private static final int JOURNEYMAN_BUY_XP = 20;
	private static final int EXPERT_SELL_XP = 15;
	private static final int EXPERT_BUY_XP = 30;
	private static final int MASTER_TRADE_XP = 30;
	private static final float LOW_PRICE_MULTIPLIER = 0.05F;
	private static final float HIGH_PRICE_MULTIPLIER = 0.2F;
	
	public static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Object, Object> map) {
		return new Int2ObjectOpenHashMap(map);
	}
	
	public interface Factory {
		@Nullable
		TradeOffer create(Entity entity, Random random);
	}
	
	public static class BuyFactory implements TradeOffers.Factory {
		private final Item buy;
		private final int price;
		private final int maxUses;
		private final int experience;
		private final float multiplier;
		
		public BuyFactory(ItemConvertible item, int price, int maxUses, int experience) {
			this.buy = item.asItem();
			this.price = price;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = 0.05F;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			ItemStack itemStack = new ItemStack(this.buy, this.price);
			return new TradeOffer(itemStack, new ItemStack(NewexpItems.COIN), this.maxUses, this.experience, this.multiplier);
		}
	}
	
	public static class SellItemFactory implements TradeOffers.Factory {
		private final ItemStack sell;
		private final int price;
		private final int count;
		private final int maxUses;
		private final int experience;
		private final float multiplier;
		
		public SellItemFactory(Block block, int price, int count, int maxUses, int experience) {
			this(new ItemStack(block), price, count, maxUses, experience);
		}
		
		public SellItemFactory(Item item, int price, int count, int experience) {
			this((ItemStack)(new ItemStack(item)), price, count, 12, experience);
		}
		
		public SellItemFactory(Item item, int price, int count, int maxUses, int experience) {
			this(new ItemStack(item), price, count, maxUses, experience);
		}
		
		public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience) {
			this(stack, price, count, maxUses, experience, 0.05F);
		}
		
		public SellItemFactory(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
			this.sell = stack;
			this.price = price;
			this.count = count;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = multiplier;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			return new TradeOffer(new ItemStack(NewexpItems.COIN, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
		}
	}
	
	public static class SellSuspiciousStewFactory implements TradeOffers.Factory {
		private final List<SuspiciousStewIngredient.StewEffect> stewEffects;
		private final int experience;
		private final float multiplier;
		
		public SellSuspiciousStewFactory(StatusEffect effect, int duration, int experience) {
			this(List.of(new SuspiciousStewIngredient.StewEffect(effect, duration)), experience, 0.05F);
		}
		
		public SellSuspiciousStewFactory(List<SuspiciousStewIngredient.StewEffect> stewEffects, int experience, float multiplier) {
			this.stewEffects = stewEffects;
			this.experience = experience;
			this.multiplier = multiplier;
		}
		
		@Nullable
		public TradeOffer create(Entity entity, Random random) {
			ItemStack itemStack = new ItemStack(Items.SUSPICIOUS_STEW, 1);
			SuspiciousStewItem.writeEffectsToStew(itemStack, this.stewEffects);
			return new TradeOffer(new ItemStack(Items.EMERALD, 1), itemStack, 12, this.experience, this.multiplier);
		}
	}
	
	public static class ProcessItemFactory implements TradeOffers.Factory {
		private final ItemStack secondBuy;
		private final int secondCount;
		private final int price;
		private final ItemStack sell;
		private final int sellCount;
		private final int maxUses;
		private final int experience;
		private final float multiplier;
		
		public ProcessItemFactory(ItemConvertible item, int secondCount, Item sellItem, int sellCount, int maxUses, int experience) {
			this(item, secondCount, 1, sellItem, sellCount, maxUses, experience);
		}
		
		public ProcessItemFactory(ItemConvertible item, int secondCount, int price, Item sellItem, int sellCount, int maxUses, int experience) {
			this.secondBuy = new ItemStack(item);
			this.secondCount = secondCount;
			this.price = price;
			this.sell = new ItemStack(sellItem);
			this.sellCount = sellCount;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = 0.05F;
		}
		
		@Nullable
		public TradeOffer create(Entity entity, Random random) {
			return new TradeOffer(new ItemStack(NewexpItems.COIN, this.price), new ItemStack(this.secondBuy.getItem(), this.secondCount), new ItemStack(this.sell.getItem(), this.sellCount), this.maxUses, this.experience, this.multiplier);
		}
	}
	
	public static class SellEnchantedToolFactory implements TradeOffers.Factory {
		private final ItemStack tool;
		private final int basePrice;
		private final int maxUses;
		private final int experience;
		private final float multiplier;
		
		public SellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience) {
			this(item, basePrice, maxUses, experience, 0.05F);
		}
		
		public SellEnchantedToolFactory(Item item, int basePrice, int maxUses, int experience, float multiplier) {
			this.tool = new ItemStack(item);
			this.basePrice = basePrice;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = multiplier;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			int i = 5 + random.nextInt(15);
			ItemStack itemStack = EnchantmentHelper.enchant(random, new ItemStack(this.tool.getItem()), i, false);
			int j = Math.min(this.basePrice + i, 128);
			ItemStack itemStack2 = new ItemStack(NewexpItems.COIN, j);
			return new TradeOffer(itemStack2, itemStack, this.maxUses, this.experience, this.multiplier);
		}
	}
	
	public static class TypeAwareBuyForOneEmeraldFactory implements TradeOffers.Factory {
		private final ImmutableMap<Object, Object> map;
		private final int count;
		private final int maxUses;
		private final int experience;
		
		public TypeAwareBuyForOneEmeraldFactory(int count, int maxUses, int experience, ImmutableMap<Object, Object> map) {
			Registries.VILLAGER_TYPE.stream().filter((villagerType) -> {
				return !map.containsKey(villagerType);
			}).findAny().ifPresent((villagerType) -> {
				throw new IllegalStateException("Missing trade for villager type: " + Registries.VILLAGER_TYPE.getId(villagerType));
			});
			this.map = map;
			this.count = count;
			this.maxUses = maxUses;
			this.experience = experience;
		}
		
		@Nullable
		public TradeOffer create(Entity entity, Random random) {
			if (entity instanceof VillagerDataContainer) {
				ItemStack itemStack = new ItemStack((ItemConvertible)this.map.get(((VillagerDataContainer)entity).getVillagerData().getType()), this.count);
				return new TradeOffer(itemStack, new ItemStack(NewexpItems.COIN), this.maxUses, this.experience, 0.05F);
			} else {
				return null;
			}
		}
	}
	
	public static class SellPotionHoldingItemFactory implements TradeOffers.Factory {
		private final ItemStack sell;
		private final int sellCount;
		private final int price;
		private final int maxUses;
		private final int experience;
		private final Item secondBuy;
		private final int secondCount;
		private final float priceMultiplier;
		
		public SellPotionHoldingItemFactory(Item arrow, int secondCount, Item tippedArrow, int sellCount, int price, int maxUses, int experience) {
			this.sell = new ItemStack(tippedArrow);
			this.price = price;
			this.maxUses = maxUses;
			this.experience = experience;
			this.secondBuy = arrow;
			this.secondCount = secondCount;
			this.sellCount = sellCount;
			this.priceMultiplier = 0.05F;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			ItemStack itemStack = new ItemStack(NewexpItems.COIN, this.price);
			List<Potion> list = (List)Registries.POTION.stream().filter((potionx) -> {
				return !potionx.getEffects().isEmpty() && BrewingRecipeRegistry.isBrewable(potionx);
			}).collect(Collectors.toList());
			Potion potion = (Potion)list.get(random.nextInt(list.size()));
			ItemStack itemStack2 = PotionUtil.setPotion(new ItemStack(this.sell.getItem(), this.sellCount), potion);
			return new TradeOffer(itemStack, new ItemStack(this.secondBuy, this.secondCount), itemStack2, this.maxUses, this.experience, this.priceMultiplier);
		}
	}
	
	public static class EnchantBookFactory implements TradeOffers.Factory {
		private final int experience;
		
		public EnchantBookFactory(int experience) {
			this.experience = experience;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			List<Enchantment> list = (List)Registries.ENCHANTMENT.stream().filter(Enchantment::isAvailableForEnchantedBookOffer).collect(Collectors.toList());
			Enchantment enchantment = (Enchantment)list.get(random.nextInt(list.size()));
			int i = MathHelper.nextInt(random, enchantment.getMinLevel(), MathHelper.clamp(enchantment.getMaxLevel()-1,enchantment.getMinLevel(),enchantment.getMaxLevel()));
			ItemStack itemStack = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, i));
			int j = 2 + random.nextInt(5 + i * 10) + 3 * i;
			if (enchantment.isTreasure()) {
				return create(entity, random);
			}
			
			if (j > 64) {
				j = 64;
			}
			
			return new TradeOffer(new ItemStack(NewexpItems.COIN, j), new ItemStack(Items.BOOK), itemStack, 12, this.experience, 0.01F);
		}
	}
	
	public static class SellMapFactory implements TradeOffers.Factory {
		private final int price;
		private final TagKey<Structure> structure;
		private final String nameKey;
		private final MapIcon.Type iconType;
		private final int maxUses;
		private final int experience;
		
		public SellMapFactory(int price, TagKey<Structure> structure, String nameKey, MapIcon.Type iconType, int maxUses, int experience) {
			this.price = price;
			this.structure = structure;
			this.nameKey = nameKey;
			this.iconType = iconType;
			this.maxUses = maxUses;
			this.experience = experience;
		}
		
		@Nullable
		public TradeOffer create(Entity entity, Random random) {
			if (!(entity.getWorld() instanceof ServerWorld)) {
				return null;
			} else {
				ServerWorld serverWorld = (ServerWorld) entity.getWorld();
				BlockPos blockPos = serverWorld.locateStructure(this.structure, entity.getBlockPos(), 100, true);
				if (blockPos != null) {
					ItemStack itemStack = FilledMapItem.createMap(serverWorld, blockPos.getX(), blockPos.getZ(), (byte)2, true, true);
					FilledMapItem.fillExplorationMap(serverWorld, itemStack);
					MapState.addDecorationsNbt(itemStack, blockPos, "+", this.iconType);
					itemStack.setCustomName(Text.translatable(this.nameKey));
					return new TradeOffer(new ItemStack(NewexpItems.COIN, this.price), new ItemStack(Items.COMPASS), itemStack, this.maxUses, this.experience, 0.2F);
				} else {
					return null;
				}
			}
		}
	}
	
	public static class SellDyedArmorFactory implements TradeOffers.Factory {
		private final Item sell;
		private final int price;
		private final int maxUses;
		private final int experience;
		
		public SellDyedArmorFactory(Item item, int price) {
			this(item, price, 12, 1);
		}
		
		public SellDyedArmorFactory(Item item, int price, int maxUses, int experience) {
			this.sell = item;
			this.price = price;
			this.maxUses = maxUses;
			this.experience = experience;
		}
		
		public TradeOffer create(Entity entity, Random random) {
			ItemStack itemStack = new ItemStack(NewexpItems.COIN, this.price);
			ItemStack itemStack2 = new ItemStack(this.sell);
			if (this.sell instanceof DyeableArmorItem) {
				List<DyeItem> list = Lists.newArrayList();
				list.add(getDye(random));
				if (random.nextFloat() > 0.7F) {
					list.add(getDye(random));
				}
				
				if (random.nextFloat() > 0.8F) {
					list.add(getDye(random));
				}
				
				itemStack2 = DyeableItem.blendAndSetColor(itemStack2, list);
			}
			
			return new TradeOffer(itemStack, itemStack2, this.maxUses, this.experience, 0.2F);
		}
		
		private static DyeItem getDye(Random random) {
			return DyeItem.byColor(DyeColor.byId(random.nextInt(16)));
		}
	}
}