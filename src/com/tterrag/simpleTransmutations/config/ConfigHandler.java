package com.tterrag.simpleTransmutations.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.lib.ConfigKeys;

public class ConfigHandler {
	
	public static void init(File file) 
	{
		Configuration config = new Configuration(file);
		
		config.load();
				
		ItemInfo.GLOWING_REDSTONE_ID = config.getItem(ItemInfo.GLOWING_REDSTONE_KEY , ItemInfo.GLOWING_REDSTONE_DEFAULT).getInt() - 256;
		ItemInfo.TINY_GLOWSTONE_ID = config.getItem(ItemInfo.TINY_GLOWSTONE_KEY , ItemInfo.TINY_GLOWSTONE_DEFAULT).getInt() - 256;
		ItemInfo.REDSTONE_GLOVE_ID = config.getItem(ItemInfo.REDSTONE_GLOVE_KEY , ItemInfo.REDSTONE_GLOVE_DEFAULT).getInt() - 256;
		
		BlockInfo.INVISIBLE_REDSTONE_ID = config.getBlock(BlockInfo.INVISIBLE_REDSTONE_KEY, BlockInfo.INVISIBLE_REDSTONE_DEFAULT).getInt();
		
		ConfigKeys.woodToObsidian = config.get("Recipes", ConfigKeys.WOOD_TO_OBSIDIAN_KEY, true).getBoolean(true);
		ConfigKeys.woodToWood = config.get("Recipes", ConfigKeys.WOOD_TO_WOOD_KEY, true).getBoolean(true);
		ConfigKeys.ironToGold = config.get("Recipes", ConfigKeys.IRON_TO_GOLD_KEY, true).getBoolean(true);
		ConfigKeys.goldToDiamond = config.get("Recipes", ConfigKeys.GOLD_TO_DIAMOND_KEY, true).getBoolean(true);
		ConfigKeys.ironToEnderpearl = config.get("Recipes", ConfigKeys.IRON_TO_ENDERPEARL_KEY, true).getBoolean(true);
		ConfigKeys.inkTransmutation = config.get("Recipes", ConfigKeys.INK_TRANSMUTATION_KEY, true).getBoolean(true);
	  /*ConfigKeys.allowBonemealTransmutation = config.get("Ink Transmutation Rules", ConfigKeys.ALLOW_BONEMEAL_KEY, false).getBoolean(false);
		ConfigKeys.allowInkSacTransmutation = config.get("Ink Transmutation Rules", ConfigKeys.ALLOW_INK_KEY, false).getBoolean(false);
		ConfigKeys.allowLapisTransmutation = config.get("Ink Transmutation Rules", ConfigKeys.ALLOW_LAPIS_KEY, false).getBoolean(false);*/
		
		config.save();
	}
}
