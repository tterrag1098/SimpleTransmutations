package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {

	public static Block invisibleRedstone;
	public static Block powderAggregator;
	
	public static void init() {
		
		invisibleRedstone = new BlockInvisibleRedstone(BlockInfo.INVISIBLE_REDSTONE_ID);
		GameRegistry.registerBlock(invisibleRedstone, BlockInfo.INVISIBLE_REDSTONE_KEY);
		
		powderAggregator = new BlockPowderAggregator(BlockInfo.POWDER_AGGREGATOR_ID);
		GameRegistry.registerBlock(powderAggregator, BlockInfo.POWDER_AGGREGATOR_KEY);
	}

	public static void addNames() {
		
		LanguageRegistry.addName(invisibleRedstone, BlockInfo.INVISIBLE_REDSTONE_LOC_NAME);
		LanguageRegistry.addName(powderAggregator, BlockInfo.POWDER_AGGREGATOR_LOC_NAME);
	}
	
	public static void registerRecpies()
	{
		BlockRecipes.addRecipes();
	}
}