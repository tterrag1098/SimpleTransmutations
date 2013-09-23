package com.tterrag.simpleTransmutations.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
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
		LanguageRegistry.addName(tinyGlowstone , ItemInfo.TINY_GLOWSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone, ItemInfo.GLOWING_REDSTONE_LOC_NAME);
	}

	public static void registerRecipes()
	{
		
		GameRegistry.addRecipe(new ItemStack (Item.redstone) ,
				new Object[] {"R",
							  "R",
			                   
			                   'R', glowingRedstone,
		});
		
		GameRegistry.addRecipe(new ItemStack (Item.glowstone) ,
				new Object[] {"RR",
			                   
			                   'R', glowingRedstone,
		});
		
		GameRegistry.addRecipe(new ItemStack (tinyGlowstone, 2) ,
				new Object[] {"R",
			                   
			                   'R', glowingRedstone,
		});
		
		ItemStack wood1 = new ItemStack(Block.wood, 1, 0);
		ItemStack wood2 = new ItemStack(Block.wood, 1, 1);
		ItemStack wood3 = new ItemStack(Block.wood, 1, 2);
		ItemStack wood4 = new ItemStack(Block.wood, 1, 3);
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.obsidian) ,
				new Object[] {
			wood1,
			wood1,
			wood1,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.obsidian) ,
				new Object[] {
			wood2,
			wood2,
			wood2,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.obsidian) ,
				new Object[] {
			wood3,
			wood3,
			wood3,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.obsidian) ,
				new Object[] {
			wood4,
			wood4,
			wood4,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.wood, 3) ,
				new Object[] {
			Block.obsidian,
			tinyGlowstone
		});

		GameRegistry.addShapelessRecipe(wood1 ,
				new Object[] {
			tinyGlowstone,
			wood4
		});
		GameRegistry.addShapelessRecipe(wood2 ,
				new Object[] {
			tinyGlowstone,
			wood1
		});
		GameRegistry.addShapelessRecipe(wood3 ,
				new Object[] {
			tinyGlowstone,
			wood2
		});
		GameRegistry.addShapelessRecipe(wood4 ,
				new Object[] {
			tinyGlowstone,
			wood3
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (glowingRedstone) ,
				new Object[] {
			Item.redstone,
			Item.glowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (glowingRedstone) ,
				new Object[] {
			tinyGlowstone,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.ingotIron, 8) ,
				new Object[] {
			Item.ingotGold,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.ingotGold, 1) ,
				new Object[] {
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.ingotGold, 4) ,
				new Object[] {
			Item.diamond,
			tinyGlowstone
		});

		GameRegistry.addShapelessRecipe(new ItemStack (Item.diamond) ,
				new Object[] {
			Item.ingotGold,
			Item.ingotGold,
			Item.ingotGold,
			Item.ingotGold,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.ingotIron, 4) ,
				new Object[] {
			Item.enderPearl,
			tinyGlowstone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Item.enderPearl) ,
				new Object[] {
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			Item.ingotIron,
			tinyGlowstone
		});
	}
}
