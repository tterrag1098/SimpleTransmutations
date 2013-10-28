package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {

	public static Block invisibleRedstone;
	
	public static void init() {
		
		invisibleRedstone = new BlockInvisibleRedstone(BlockInfo.INVISIBLE_REDSTONE_ID);
		GameRegistry.registerBlock(invisibleRedstone, BlockInfo.INVISIBLE_REDSTONE_KEY);
	}

	public static void addNames() {
		
		LanguageRegistry.addName(invisibleRedstone, BlockInfo.INVISIBLE_REDSTONE_LOC_NAME);
	}
	
	public static void registerRecpies()
	{
		BlockRecipes.addRecipes();
	}
}