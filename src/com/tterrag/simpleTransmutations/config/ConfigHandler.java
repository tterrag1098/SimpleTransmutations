package com.tterrag.simpleTransmutations.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemInfo;

@SuppressWarnings("unused")
public class ConfigHandler {
	
	public static void init(File file) 
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		//BlockInfo.CHAIN_SMELTER_ID = config.getBlock(BlockInfo.CHAIN_SMELTER_KEY , BlockInfo.CHAIN_SMELTER_DEFAULT).getInt();
		
		ItemInfo.GLOWING_REDSTONE_ID = config.getItem(ItemInfo.GLOWING_REDSTONE_KEY , ItemInfo.GLOWING_REDSTONE_DEFAULT).getInt() - 256;
		ItemInfo.TINY_GLOWSTONE_ID = config.getItem(ItemInfo.TINY_GLOWSTONE_KEY , ItemInfo.TINY_GLOWSTONE_DEFAULT).getInt() - 256;
		
		config.save();
	}
}
