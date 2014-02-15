package com.tterrag.simpleTransmutations.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.container.ContainerPowderAgg;
import com.tterrag.simpleTransmutations.gui.GuiPowderAgg;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Simple Transmutations
 * 
 * ClientProxy
 * 
 * @author tterrag
 * @license 
 * 
 */
public class CommonProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID) {
			case 0:
				return new ContainerPowderAgg(player.inventory, (TilePowderAggregator) tile_entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		switch(ID) {
			case 0:
				return new GuiPowderAgg(player.inventory, (TilePowderAggregator) tile_entity);
		}
		return null;
	}
	
	public void initSounds() {
		
	}

	public void initRenderers() {
		
	}
	
}
