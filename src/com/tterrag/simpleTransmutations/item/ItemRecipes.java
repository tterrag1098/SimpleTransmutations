package com.tterrag.simpleTransmutations.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.tterrag.simpleTransmutations.lib.RecipeIDs;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRecipes
{
	public static void addRecipes()
	{
		/**
		 * Recipes for crafting with Glowing Redstone
		 */
		GameRegistry.addRecipe(new ItemStack(Item.redstone), new Object[] {
			"R", "R",

			'R', ModItem.glowingRedstone, });

		GameRegistry.addRecipe(new ItemStack(Item.glowstone), new Object[] {
			"RR",

			'R', ModItem.glowingRedstone, });

		GameRegistry.addRecipe(new ItemStack(ModItem.tinyGlowstone, 2), new Object[] {
			"R",

			'R', ModItem.glowingRedstone, });
		
		/**
		 * Crafting Glowing Redstone
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(ModItem.glowingRedstone),
				new Object[] { Item.redstone, Item.glowstone });

		GameRegistry.addShapelessRecipe(new ItemStack(ModItem.glowingRedstone),
				new Object[] { ModItem.tinyGlowstone, ModItem.tinyGlowstone });
		
		/**
		 * Wood itemStacks for log to log transmutations
		 */
		ItemStack wood1 = new ItemStack(Block.wood, 1, 0);
		ItemStack wood2 = new ItemStack(Block.wood, 1, 1);
		ItemStack wood3 = new ItemStack(Block.wood, 1, 2);
		ItemStack wood4 = new ItemStack(Block.wood, 1, 3);

		/**
		 * Wood to Obsidian recipes
		 */
		if (RecipeIDs.woodToObsidian)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian),
					new Object[] { wood1, wood1, wood1, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian),
					new Object[] { wood2, wood2, wood2, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian),
					new Object[] { wood3, wood3, wood3, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian),
					new Object[] { wood4, wood4, wood4, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Block.wood, 3),
					new Object[] { Block.obsidian, ModItem.tinyGlowstone });
		}

		/**
		 * Wood to Wood recipes
		 */
		if (RecipeIDs.woodToWood)
		{
			GameRegistry.addShapelessRecipe(wood1, new Object[] {
					ModItem.tinyGlowstone, wood4 });
			GameRegistry.addShapelessRecipe(wood2, new Object[] {
					ModItem.tinyGlowstone, wood1 });
			GameRegistry.addShapelessRecipe(wood3, new Object[] {
					ModItem.tinyGlowstone, wood2 });
			GameRegistry.addShapelessRecipe(wood4, new Object[] {
					ModItem.tinyGlowstone, wood3 });
		}

		/**
		 * Iron to Gold recipes
		 */
		if (RecipeIDs.ironToGold)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 8),
					new Object[] { Item.ingotGold, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 1),
					new Object[] { Item.ingotIron, Item.ingotIron,
				Item.ingotIron, Item.ingotIron, Item.ingotIron,
				Item.ingotIron, Item.ingotIron, Item.ingotIron,
				ModItem.tinyGlowstone });
		}

		/**
		 * Gold to Diamond recipes
		 */
		if (RecipeIDs.goldToDiamond)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 4),
					new Object[] { Item.diamond, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond),
					new Object[] { Item.ingotGold, Item.ingotGold,
				Item.ingotGold, Item.ingotGold, ModItem.tinyGlowstone });
		}

		/**
		 * Iron to Enderpearl recipes
		 */
		if (RecipeIDs.ironToEnderpearl)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 4),
					new Object[] { Item.enderPearl, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Item.enderPearl),
					new Object[] { Item.ingotIron, Item.ingotIron, Item.ingotIron,
				Item.ingotIron, ModItem.tinyGlowstone });
		}
	}
}
