package com.tterrag.simpleTransmutations.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.crafting.NBTRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRecipes
{
	public static void addRecipes()
	{
		addItemRecipes();
		addSmeltingRecipes();
	}
	
	public static void addItemRecipes()
	{
		/**
		 * Recipes for crafting with Glowing Redstone
		 */
		GameRegistry.addRecipe(new ItemStack(Item.redstone), new Object[] {
			"R",
			"R",

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
		if (ConfigKeys.woodToObsidian)
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
		if (ConfigKeys.woodToWood)
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
		if (ConfigKeys.ironToGold)
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
		if (ConfigKeys.goldToDiamond)
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
		if (ConfigKeys.ironToEnderpearl)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 4),
					new Object[] { Item.enderPearl, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Item.enderPearl),
					new Object[] { Item.ingotIron, Item.ingotIron, Item.ingotIron,
				Item.ingotIron, ModItem.tinyGlowstone });
		}
		
		/**
		 * Ink transmuting
		 */
		if (ConfigKeys.inkTransmutation)
		{			
			final int COCOA_DAMAGE = 3;
			final int BONEMEAL_DAMAGE = 15;
			final int LAPIS_DAMAGE = 4;
			
			ItemStack ink, inkResult;
			for (int i = 0; i < 16; i++)
			{
				ink = new ItemStack(Item.dyePowder, 1, i);
				if (i < 15) inkResult = new ItemStack(Item.dyePowder, 1, i + 1);
				else inkResult = new ItemStack(Item.dyePowder, 1 , 0);
				
				if (i == COCOA_DAMAGE || i == BONEMEAL_DAMAGE || i == LAPIS_DAMAGE);
					// DO NOTHING
				else if (i == COCOA_DAMAGE - 1 || i == BONEMEAL_DAMAGE - 1 || i == LAPIS_DAMAGE - 1)
				{
					ink = new ItemStack(Item.dyePowder, 1, i);
					if (i != 14 && i != 2) inkResult = new ItemStack(Item.dyePowder, 1 , i + 2);
					else if (i == 2) inkResult = new ItemStack(Item.dyePowder, 1, i + 3);
					else inkResult = new ItemStack(Item.dyePowder, 1, 1);
					
					GameRegistry.addShapelessRecipe(inkResult, 
							new Object[] { ink, ModItem.tinyGlowstone });
				}
				else
				{
					ink = new ItemStack(Item.dyePowder, 1, i);
					if (i < 15) inkResult = new ItemStack(Item.dyePowder, 1, i + 1);
					else inkResult = new ItemStack(Item.dyePowder, 1 , 0);
					
					GameRegistry.addShapelessRecipe(inkResult, 
							new Object[] { ink, ModItem.tinyGlowstone });
				}
			}
		}
		
		/**
		 * Iron to Clay recipes
		 */
		
		if (ConfigKeys.ironToClay)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Block.blockClay, 4),
					new Object[] { ModItem.tinyGlowstone, Item.ingotIron });
			
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron),
					new Object[] { ModItem.tinyGlowstone, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay });
		}
		
		/**
		 * Recipe for redstone glove
		 */
		GameRegistry.addRecipe(new ItemStack(ModItem.redstoneGlove),new Object[] {
			" t ",
			"gwg",
			"i i",

			'g', ModItem.glowingRedstone, 
			't', Block.torchRedstoneActive,
			'w', Block.cloth,
			'i', Item.ingotIron });
		
		/**
		 * food recipes
		 */
		GameRegistry.addRecipe(new ItemStack(ModItem.smallTentacleBundle),new Object[] {
			"ss",
			"ss",

			's', ModItem.squidTentacle, });
		
		GameRegistry.addRecipe(new ItemStack(ModItem.largeTentacleBundle),new Object[] {
			"sss",
			"sss",
			"sss",

			's', ModItem.squidTentacle, });
		
		GameRegistry.addRecipe(new ItemStack(ModItem.largeTentacleBundle),new Object[] {
			"bbb",

			'b', ModItem.smallTentacleBundle, });
		
		GameRegistry.addRecipe(new ItemStack(ModItem.smallCalamariPlatter),new Object[] {
			"cc",
			"cc",
			
			'c', ModItem.calamari, });
		
		GameRegistry.addRecipe(new ItemStack(ModItem.largeCalamariPlatter),new Object[] {
			"ccc",
			"ccc",
			"ccc",
			
			'c', ModItem.calamari, });
		
		GameRegistry.addRecipe(new ItemStack(ModItem.largeCalamariPlatter),new Object[] {
			"bbb",
			
			'b', ModItem.smallCalamariPlatter, });
		
		/**
		 * Optional redstone recipes
		 */
		if (ConfigKeys.allowRedstoneTransmutation)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Block.blockRedstone, 6), new Object[] {
				Item.ingotGold, Item.ingotGold, ModItem.tinyGlowstone });
			GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold), new Object[] {
				Block.blockRedstone, Block.blockRedstone, Block.blockRedstone, ModItem.tinyGlowstone });
		}
		
		/**
		 * Testing NBT recipes
		 */
		/*ItemStack NBTStack = new ItemStack(ModItem.essenceContainer, 1);
		((ItemEssenceContainer)NBTStack.getItem()).setName(NBTStack, "Pig");*/
		//System.out.println("*****************\n\n" + NBTStack.stackTagCompound + "\n\n***************");
		GameRegistry.addRecipe(new NBTRecipe(new ItemStack(Item.diamond), "Pig", new Object[] {
			"e",
			
			'e', ModItem.essenceContainer
		}));
	}
	
	public static void addSmeltingRecipes()
	{
		FurnaceRecipes.smelting().addSmelting(ItemInfo.SQUID_TENTACLE_ID + 256, new ItemStack(ModItem.calamari, 1), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ItemInfo.SMALL_BUNDLE_ID + 256, new ItemStack(ModItem.calamari, 4), 0.4F);
		FurnaceRecipes.smelting().addSmelting(ItemInfo.LARGE_BUNDLE_ID + 256, new ItemStack(ModItem.calamari, 9), 1.0F);
		FurnaceRecipes.smelting().addSmelting(ItemInfo.RAW_MUTTON_ID + 256, new ItemStack(ModItem.cookedMutton), 0.2F);
	}
}
