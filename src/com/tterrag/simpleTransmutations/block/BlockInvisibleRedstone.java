package com.tterrag.simpleTransmutations.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInvisibleRedstone extends Block
{
	public BlockInvisibleRedstone (int id)
	{
		super(id, Material.rock);
		setHardness(1000F);
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("DON'T TOUCH");
		
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	@Override
	public boolean isBlockSolid(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return false;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return true;
    }

	@Override
	public boolean canCollideCheck(int par1, boolean par2)
    {
        return this.isCollidable();
    }
	
	@Override
	public boolean isCollidable()
    {
        return false;
    }
	
	@Override
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	@Override
	public boolean canProvidePower()
	{
        return true;
    }
	
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return true;
    }
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, net.minecraft.entity.player.EntityPlayer player) {
		
		player.addChatMessage("called");
	}
}

