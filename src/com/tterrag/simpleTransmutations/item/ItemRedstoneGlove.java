package com.tterrag.simpleTransmutations.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ItemRedstoneGlove extends Item{
	
	public ItemRedstoneGlove (int id)
	{
		super(id);
	}
	/*@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) 
	{
		if (world.getBlockPowerInput(x, y, z) == 0)
		{
			world.set
		}
	
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }*/
}
