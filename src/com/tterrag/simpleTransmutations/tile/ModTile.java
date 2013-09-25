package com.tterrag.simpleTransmutations.tile;

import com.tterrag.simpleTransmutations.block.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTile
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileInvisibleRedstone.class, BlockInfo.INVISIBLE_REDSTONE_KEY);
		
	}
}
