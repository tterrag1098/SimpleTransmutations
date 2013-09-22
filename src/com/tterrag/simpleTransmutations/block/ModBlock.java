package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.tterrag.simpleTransmutations.item.ItemGlowingRedstone;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.item.ItemTinyGlowstone;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock {

	public static Block chainSmelter;
	
	public static void init() {
		chainSmelter = new BlockChainSmelter(BlockInfo.CHAIN_SMELTER_ID);
	}

	public static void addNames() {
		LanguageRegistry.addName(chainSmelter,
				BlockInfo.CHAIN_SMELTER_LOC_NAME);
	}
}
