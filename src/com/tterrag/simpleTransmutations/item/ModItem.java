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
	
	public static void init()
	{
		tinyGlowstone = new ItemTinyGlowstone(ItemInfo.TINY_GLOWSTONE_ID);
		glowingRedstone = new ItemGlowingRedstone(ItemInfo.GLOWING_REDSTONE_ID);
		redstoneGlove = new ItemRedstoneGlove(ItemInfo.REDSTONE_GLOVE_ID);
		squidTentacle = new ItemSquidTentacle(ItemInfo.SQUID_TENTACLE_ID);
		rawMutton = new ItemRawMutton(ItemInfo.RAW_MUTTON_ID);
		cookedMutton = new ItemCookedMutton(ItemInfo.COOKED_MUTTON_ID);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(tinyGlowstone , ItemInfo.TINY_GLOWSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone, ItemInfo.GLOWING_REDSTONE_LOC_NAME);
		LanguageRegistry.addName(redstoneGlove, ItemInfo.REDSTONE_GLOVE_LOC_NAME);
		LanguageRegistry.addName(squidTentacle, ItemInfo.SQUID_TENTACLE_LOC_NAME);
		LanguageRegistry.addName(rawMutton, ItemInfo.RAW_MUTTON_LOC_NAME);
		LanguageRegistry.addName(cookedMutton, ItemInfo.COOKED_MUTTON_LOC_NAME);
	}

	public static void registerRecipes()
	{
		ItemRecipes.addRecipes();
	}
}
