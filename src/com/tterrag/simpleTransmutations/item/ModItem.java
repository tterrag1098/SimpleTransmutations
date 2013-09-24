package com.tterrag.simpleTransmutations.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem
{
	public static Item tinyGlowstone;
	public static Item glowingRedstone;
	public static Item redstoneGlove;
	
	public static void init()
	{
		tinyGlowstone = new ItemTinyGlowstone(ItemInfo.TINY_GLOWSTONE_ID);
		glowingRedstone = new ItemGlowingRedstone(ItemInfo.GLOWING_REDSTONE_ID);
		redstoneGlove = new ItemGlowingRedstone(ItemInfo.REDSTONE_GLOVE_ID);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(tinyGlowstone , ItemInfo.TINY_GLOWSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone, ItemInfo.GLOWING_REDSTONE_LOC_NAME);
		LanguageRegistry.addName(redstoneGlove, ItemInfo.REDSTONE_GLOVE_LOC_NAME);
	}

	public static void registerRecipes()
	{
		ItemRecipes.addRecipes();
	}
}
