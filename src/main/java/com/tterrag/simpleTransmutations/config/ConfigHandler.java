package com.tterrag.simpleTransmutations.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{

	public static void init(File file)
	{
		Configuration config = new Configuration(file);

		config.load();

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

		/**
		 * Blaze Powder Aggregator configs
		 */
		ConfigKeys.productionInSunlight = config.get("Blaze Powder Aggregator", ConfigKeys.SUNLIGHT_PRODUCTION_KEY, 1.0).getDouble(1.0);
		ConfigKeys.productionFromFuel = config.get("Blaze Powder Aggregator", ConfigKeys.FUEL_PRODUCTION_KEY, 1.0).getDouble(1.0);
		ConfigKeys.doesProducePassively = config.get("Blaze Powder Aggregator", ConfigKeys.PRODUCE_PASSIVELY_KEY, true).getBoolean(true);

		config.save();
	}
}
