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
