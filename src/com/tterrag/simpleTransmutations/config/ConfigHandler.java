package com.tterrag.simpleTransmutations.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemInfo;

public class ConfigHandler {
	
	public static void init(File file) 
	{
		Configuration config = new Configuration(file);
		
		config.load();
				
		/**
		 * Item ID configs
		 */
		ItemInfo.GLOWING_REDSTONE_ID = config.getItem(ItemInfo.GLOWING_REDSTONE_KEY , ItemInfo.GLOWING_REDSTONE_DEFAULT).getInt() - 256;
		ItemInfo.SMALL_GLOWING_REDSTONE_ID = config.getItem(ItemInfo.SMALL_GLOWING_REDSTONE_KEY , ItemInfo.SMALL_GLOWING_REDSTONE_DEFAULT).getInt() - 256;
		ItemInfo.REDSTONE_GLOVE_ID = config.getItem(ItemInfo.REDSTONE_GLOVE_KEY , ItemInfo.REDSTONE_GLOVE_DEFAULT).getInt() - 256;
		ItemInfo.SQUID_TENTACLE_ID = config.getItem(ItemInfo.SQUID_TENTACLE_KEY , ItemInfo.SQUID_TENTACLE_DEFAULT).getInt() - 256;
		ItemInfo.RAW_MUTTON_ID = config.getItem(ItemInfo.RAW_MUTTON_KEY , ItemInfo.RAW_MUTTON_DEFAULT).getInt() - 256;
		ItemInfo.COOKED_MUTTON_ID = config.getItem(ItemInfo.COOKED_MUTTON_KEY , ItemInfo.COOKED_MUTTON_DEFAULT).getInt() - 256;
		ItemInfo.SMALL_BUNDLE_ID = config.getItem(ItemInfo.SMALL_BUNDLE_KEY , ItemInfo.SMALL_BUNDLE_DEFAULT).getInt() - 256;
		ItemInfo.LARGE_BUNDLE_ID = config.getItem(ItemInfo.LARGE_BUNDLE_KEY , ItemInfo.LARGE_BUNDLE_DEFAULT).getInt() - 256;
		ItemInfo.CALAMARI_ID = config.getItem(ItemInfo.CALAMARI_KEY , ItemInfo.CALAMARI_DEFAULT).getInt() - 256;
		ItemInfo.SMALL_PLATTER_ID = config.getItem(ItemInfo.SMALL_PLATTER_KEY , ItemInfo.SMALL_PLATTER_DEFAULT).getInt() - 256;
		ItemInfo.LARGE_PLATTER_ID = config.getItem(ItemInfo.LARGE_PLATTER_KEY , ItemInfo.LARGE_PLATTER_DEFAULT).getInt() - 256;
		ItemInfo.ESSENCE_CONTAINER_ID = config.getItem(ItemInfo.ESSENCE_CONTAINER_KEY, ItemInfo.ESSENCE_CONTAINER_DEFAULT).getInt() - 256;
		
		/**
		 * Block ID configs
		 */
		BlockInfo.INVISIBLE_REDSTONE_ID = config.getBlock(BlockInfo.INVISIBLE_REDSTONE_KEY, BlockInfo.INVISIBLE_REDSTONE_DEFAULT).getInt();
		
		/**
		 * Transmutation recipe configs
		 */
		ConfigKeys.woodToObsidian = config.get("Recipes", ConfigKeys.WOOD_TO_OBSIDIAN_KEY, true).getBoolean(true);
		ConfigKeys.woodToWood = config.get("Recipes", ConfigKeys.WOOD_TO_WOOD_KEY, true).getBoolean(true);
		ConfigKeys.ironToGold = config.get("Recipes", ConfigKeys.IRON_TO_GOLD_KEY, true).getBoolean(true);
		ConfigKeys.goldToDiamond = config.get("Recipes", ConfigKeys.GOLD_TO_DIAMOND_KEY, true).getBoolean(true);
		ConfigKeys.ironToEnderpearl = config.get("Recipes", ConfigKeys.IRON_TO_ENDERPEARL_KEY, true).getBoolean(true);
		ConfigKeys.ironToGold = config.get("Recipes", ConfigKeys.IRON_TO_CLAY_KEY, true).getBoolean(true);
		ConfigKeys.inkTransmutation = config.get("Recipes", ConfigKeys.INK_TRANSMUTATION_KEY, true).getBoolean(true);
		ConfigKeys.allowRedstoneTransmutation = config.get("Recipes", ConfigKeys.GOLD_TO_REDSTONE_KEY, false).getBoolean(false);
		
		/**
		 * Drop configs
		 */
		ConfigKeys.allowDropMutton = config.get("Drops", ConfigKeys.DROP_MUTTON_KEY, true).getBoolean(true);
		ConfigKeys.allowDropTentacles = config.get("Drops", ConfigKeys.DROP_TENTACLES_KEY, true).getBoolean(true);
		
		/**
		 * Other configs
		 */
		ConfigKeys.allowBedMessage = config.get("Other", ConfigKeys.BED_MESSAGE_KEY, true).getBoolean(true);
		ConfigKeys.muttonWillKill = config.get("Other", ConfigKeys.MUTTON_KILL_KEY, true).getBoolean(true);
		
		config.save();
	}
}
