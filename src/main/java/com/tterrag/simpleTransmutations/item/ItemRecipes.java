package com.tterrag.simpleTransmutations.item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.crafting.NBTMachineRecipes;

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
		/*
		 * Recipes for crafting with Glowing Redstone
		 */
		GameRegistry.addRecipe(new ItemStack(Items.redstone), new Object[] { "R", "R",

		'R', ModItem.glowingRedstone, });

		GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust), new Object[] { "RR",

		'R', ModItem.glowingRedstone, });

		GameRegistry.addRecipe(new ItemStack(ModItem.tinyGlowstone, 2), new Object[] { "R",

		'R', ModItem.glowingRedstone, });

		/*
		 * Crafting Glowing Redstone
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(ModItem.glowingRedstone), new Object[] { Items.redstone, Items.glowstone_dust });

		GameRegistry.addShapelessRecipe(new ItemStack(ModItem.glowingRedstone), new Object[] { ModItem.tinyGlowstone, ModItem.tinyGlowstone });

		/*
		 * Wood itemStacks for log to log transmutations
		 */
		ItemStack wood1 = new ItemStack(Blocks.log, 1, 0);
		ItemStack wood2 = new ItemStack(Blocks.log, 1, 1);
		ItemStack wood3 = new ItemStack(Blocks.log, 1, 2);
		ItemStack wood4 = new ItemStack(Blocks.log, 1, 3);
		
		/*
		 * Wood to Obsidian recipes
		 */
		if (ConfigKeys.woodToObsidian)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian), new Object[] { wood1, wood1, wood1, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian), new Object[] { wood2, wood2, wood2, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian), new Object[] { wood3, wood3, wood3, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.obsidian), new Object[] { wood4, wood4, wood4, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log, 3), new Object[] { Blocks.obsidian, ModItem.tinyGlowstone });
		}

		/*
		 * Wood to Wood recipes
		 */
		if (ConfigKeys.woodToWood)
		{
			GameRegistry.addShapelessRecipe(wood1, new Object[] { ModItem.tinyGlowstone, wood4 });
			GameRegistry.addShapelessRecipe(wood2, new Object[] { ModItem.tinyGlowstone, wood1 });
			GameRegistry.addShapelessRecipe(wood3, new Object[] { ModItem.tinyGlowstone, wood2 });
			GameRegistry.addShapelessRecipe(wood4, new Object[] { ModItem.tinyGlowstone, wood3 });
		}

		/*
		 * Iron to Gold recipes
		 */
		if (ConfigKeys.ironToGold)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 8), new Object[] { Items.gold_ingot, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 1), new Object[] { Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot,
					Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, ModItem.tinyGlowstone });
		}

		/*
		 * Gold to Diamond recipes
		 */
		if (ConfigKeys.goldToDiamond)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[] { Items.diamond, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond), new Object[] { Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, Items.gold_ingot, ModItem.tinyGlowstone });
		}

		/*
		 * Iron to Enderpearl recipes
		 */
		if (ConfigKeys.ironToEnderpearl)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[] { Items.ender_pearl, ModItem.tinyGlowstone });

			GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl), new Object[] { Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, Items.iron_ingot, ModItem.tinyGlowstone });
		}

		/*
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
				ink = new ItemStack(Items.dye, 1, i);
				if (i < 15)
					inkResult = new ItemStack(Items.dye, 1, i + 1);
				else
					inkResult = new ItemStack(Items.dye, 1, 0);

				if (i == COCOA_DAMAGE || i == BONEMEAL_DAMAGE || i == LAPIS_DAMAGE)
					;
				// DO NOTHING
				else if (i == COCOA_DAMAGE - 1 || i == BONEMEAL_DAMAGE - 1 || i == LAPIS_DAMAGE - 1)
				{
					ink = new ItemStack(Items.dye, 1, i);
					if (i != 14 && i != 2)
						inkResult = new ItemStack(Items.dye, 1, i + 2);
					else if (i == 2)
						inkResult = new ItemStack(Items.dye, 1, i + 3);
					else
						inkResult = new ItemStack(Items.dye, 1, 1);

					GameRegistry.addShapelessRecipe(inkResult, new Object[] { ink, ModItem.tinyGlowstone });
				}
				else
				{
					ink = new ItemStack(Items.dye, 1, i);
					if (i < 15)
						inkResult = new ItemStack(Items.dye, 1, i + 1);
					else
						inkResult = new ItemStack(Items.dye, 1, 0);

					GameRegistry.addShapelessRecipe(inkResult, new Object[] { ink, ModItem.tinyGlowstone });
				}
			}
		}

		/*
		 * Iron to Clay recipes
		 */
		if (ConfigKeys.ironToClay)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.clay, 4), new Object[] { ModItem.tinyGlowstone, Items.iron_ingot });

			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot), new Object[] { ModItem.tinyGlowstone, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay });
		}

		/*
		 * Recipe for redstone glove
		 */
		GameRegistry.addRecipe(new ItemStack(ModItem.redstoneGlove), new Object[] { " t ", "gwg", "i i", 'g', ModItem.glowingRedstone, 't', Blocks.redstone_torch, 'w', Blocks.wool, 'i',
				Items.iron_ingot });

		/*
		 * food recipes
		 */
		GameRegistry.addRecipe(new ItemStack(ModItem.smallTentacleBundle), new Object[] { "ss", "ss", 's', ModItem.squidTentacle, });

		GameRegistry.addRecipe(new ItemStack(ModItem.largeTentacleBundle), new Object[] { "sss", "sss", "sss", 's', ModItem.squidTentacle, });

		GameRegistry.addRecipe(new ItemStack(ModItem.largeTentacleBundle), new Object[] { "bbb", 'b', ModItem.smallTentacleBundle, });

		GameRegistry.addRecipe(new ItemStack(ModItem.smallCalamariPlatter), new Object[] { "cc", "cc", 'c', ModItem.calamari, });

		GameRegistry.addRecipe(new ItemStack(ModItem.largeCalamariPlatter), new Object[] { "ccc", "ccc", "ccc", 'c', ModItem.calamari, });

		GameRegistry.addRecipe(new ItemStack(ModItem.largeCalamariPlatter), new Object[] { "bbb", 'b', ModItem.smallCalamariPlatter, });

		/*
		 * Optional redstone recipes
		 */
		if (ConfigKeys.allowRedstoneTransmutation)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 6), new Object[] { Items.gold_ingot, Items.gold_ingot, ModItem.tinyGlowstone });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot), new Object[] { Blocks.redstone_block, Blocks.redstone_block, Blocks.redstone_block, ModItem.tinyGlowstone });
		}

		/*
		 * Essence Container Recipe
		 */
		GameRegistry.addRecipe(new ItemStack(ModItem.essenceContainer),
				new Object[] { "ili", "sbs", "ili", 'i', Blocks.iron_bars, 'l', Items.leather, 's', Items.slime_ball, 'b', Items.glass_bottle, });

		NBTMachineRecipes.instance().addPowderAggRecipe(Items.coal, new ItemStack(Items.blaze_powder));
	}

	public static void addSmeltingRecipes()
	{
		FurnaceRecipes.smelting().func_151396_a(ModItem.squidTentacle, new ItemStack(ModItem.calamari, 1), 0.1F);
		FurnaceRecipes.smelting().func_151396_a(ModItem.smallTentacleBundle, new ItemStack(ModItem.calamari, 4), 0.4F);
		FurnaceRecipes.smelting().func_151396_a(ModItem.largeTentacleBundle, new ItemStack(ModItem.calamari, 9), 1.0F);
		FurnaceRecipes.smelting().func_151396_a(ModItem.rawMutton, new ItemStack(ModItem.cookedMutton), 0.2F);
	}
}
