package com.tterrag.simpleTransmutations.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem
{
	public static Item tinyGlowstone;
	public static Item glowingRedstone;

	public static void init()
	{
		tinyGlowstone = new ItemTinyGlowstone(ItemInfo.TINY_GLOWSTONE_ID);
		glowingRedstone = new ItemGlowingRedstone(ItemInfo.GLOWING_REDSTONE_ID);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(tinyGlowstone,
				ItemInfo.TINY_GLOWSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone,
				ItemInfo.GLOWING_REDSTONE_LOC_NAME);
	}

	public static void registerRecipes()
	{
		ItemRecipes.addRecipes();
	}
}
