package com.tterrag.simpleTransmutations.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem
{
	public static Item tinyGlowstone;
	public static Item glowingRedstone;
	public static Item redstoneGlove;
	public static Item squidTentacle;
	public static Item rawMutton;
	public static Item cookedMutton;
	public static Item smallTentacleBundle;
	public static Item largeTentacleBundle;
	public static Item calamari;
	public static Item smallCalamariPlatter;
	public static Item largeCalamariPlatter;
	
	
	public static void init()
	{
		tinyGlowstone = new ItemTinyGlowstone(ItemInfo.TINY_GLOWSTONE_ID);
		glowingRedstone = new ItemGlowingRedstone(ItemInfo.GLOWING_REDSTONE_ID);
		redstoneGlove = new ItemRedstoneGlove(ItemInfo.REDSTONE_GLOVE_ID);
		squidTentacle = new ItemSquidTentacle(ItemInfo.SQUID_TENTACLE_ID);
		rawMutton = new ItemRawMutton(ItemInfo.RAW_MUTTON_ID);
		cookedMutton = new ItemCookedMutton(ItemInfo.COOKED_MUTTON_ID);
		smallTentacleBundle = new ItemSmallTentacleBundle(ItemInfo.SMALL_BUNDLE_ID);
		largeTentacleBundle = new ItemLargeTentacleBundle(ItemInfo.LARGE_BUNDLE_ID);
		calamari = new ItemCalamari(ItemInfo.CALAMARI_ID);
		smallCalamariPlatter = new ItemSmallCalamariPlatter(ItemInfo.SMALL_PLATTER_ID);
		largeCalamariPlatter = new ItemLargeCalamariPlatter(ItemInfo.LARGE_PLATTER_ID);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(tinyGlowstone , ItemInfo.TINY_GLOWSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone, ItemInfo.GLOWING_REDSTONE_LOC_NAME);
		LanguageRegistry.addName(redstoneGlove, ItemInfo.REDSTONE_GLOVE_LOC_NAME);
		LanguageRegistry.addName(squidTentacle, ItemInfo.SQUID_TENTACLE_LOC_NAME);
		LanguageRegistry.addName(rawMutton, ItemInfo.RAW_MUTTON_LOC_NAME);
		LanguageRegistry.addName(cookedMutton, ItemInfo.COOKED_MUTTON_LOC_NAME);
		LanguageRegistry.addName(smallTentacleBundle, ItemInfo.SMALL_BUNDLE_LOC_NAME);
		LanguageRegistry.addName(largeTentacleBundle, ItemInfo.LARGE_BUNDLE_LOC_NAME);
		LanguageRegistry.addName(calamari, ItemInfo.CALAMARI_LOC_NAME);
		LanguageRegistry.addName(smallCalamariPlatter, ItemInfo.SMALL_PLATTER_LOC_NAME);
		LanguageRegistry.addName(largeCalamariPlatter, ItemInfo.LARGE_PLATTER_LOC_NAME);
	}

	public static void registerRecipes()
	{
		ItemRecipes.addRecipes();
	}
}
