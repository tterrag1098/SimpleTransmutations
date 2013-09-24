package com.tterrag.simpleTransmutations.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.lib.RecipeIDs;

@SuppressWarnings("unused")
public class ConfigHandler {
	
	public static void init(File file) 
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		//BlockInfo.CHAIN_SMELTER_ID = config.getBlock(BlockInfo.CHAIN_SMELTER_KEY , BlockInfo.CHAIN_SMELTER_DEFAULT).getInt();
		
		ItemInfo.GLOWING_REDSTONE_ID = config.getItem(ItemInfo.GLOWING_REDSTONE_KEY , ItemInfo.GLOWING_REDSTONE_DEFAULT).getInt() - 256;
		ItemInfo.TINY_GLOWSTONE_ID = config.getItem(ItemInfo.TINY_GLOWSTONE_KEY , ItemInfo.TINY_GLOWSTONE_DEFAULT).getInt() - 256;
		ItemInfo.REDSTONE_GLOVE_ID = config.getItem(ItemInfo.REDSTONE_GLOVE_KEY , ItemInfo.REDSTONE_GLOVE_DEFAULT).getInt() - 256;
		
		RecipeIDs.woodToObsidian = config.get("Recipes", RecipeIDs.WOOD_TO_OBSIDIAN_KEY, true).getBoolean(true);
		RecipeIDs.woodToWood = config.get("Recipes", RecipeIDs.WOOD_TO_WOOD_KEY, true).getBoolean(true);
		RecipeIDs.ironToGold = config.get("Recipes", RecipeIDs.IRON_TO_GOLD_KEY, true).getBoolean(true);
		RecipeIDs.goldToDiamond = config.get("Recipes", RecipeIDs.GOLD_TO_DIAMOND_KEY, true).getBoolean(true);
		RecipeIDs.ironToEnderpearl = config.get("Recipes", RecipeIDs.IRON_TO_ENDERPEARL_KEY, true).getBoolean(true);
		RecipeIDs.inkTransmutation = config.get("Recipes", RecipeIDs.INK_TRANSMUTATION_KEY, true).getBoolean(true);
	  /*RecipeIDs.allowBonemealTransmutation = config.get("Ink Transmutation Rules", RecipeIDs.ALLOW_BONEMEAL_KEY, false).getBoolean(false);
		RecipeIDs.allowInkSacTransmutation = config.get("Ink Transmutation Rules", RecipeIDs.ALLOW_INK_KEY, false).getBoolean(false);
		RecipeIDs.allowLapisTransmutation = config.get("Ink Transmutation Rules", RecipeIDs.ALLOW_LAPIS_KEY, false).getBoolean(false);*/
		
		config.save();
	}
}
