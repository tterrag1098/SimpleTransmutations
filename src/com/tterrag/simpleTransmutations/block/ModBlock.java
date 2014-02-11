package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {

	public static Block invisibleRedstone;
	public static Block powderAggregator;
	
	public static void init() {
		
		invisibleRedstone = new BlockInvisibleRedstone();
		GameRegistry.registerBlock(invisibleRedstone, BlockInfo.POWDER_AGGREGATOR_UNLOC_NAME);
		
		powderAggregator = new BlockPowderAggregator();
		GameRegistry.registerBlock(powderAggregator, BlockInfo.POWDER_AGGREGATOR_UNLOC_NAME);
	}

	public static void registerRecipes()
	{
		BlockRecipes.addRecipes();
	}
}