package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {

	public static Block chainSmelter;
	
	public static void init() {
		chainSmelter = new BlockChainSmelter(BlockInfo.CHAIN_SMELTER_ID, false);
		GameRegistry.registerBlock(chainSmelter, BlockInfo.CHAIN_SMELTER_KEY);
	}

	public static void addNames() {
		LanguageRegistry.addName(chainSmelter,
				BlockInfo.CHAIN_SMELTER_LOC_NAME);
	}
}
