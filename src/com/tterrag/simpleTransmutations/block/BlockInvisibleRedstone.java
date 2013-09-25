package com.tterrag.simpleTransmutations.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.tile.TileInvisibleRedstone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInvisibleRedstone extends BlockContainer {
	public BlockInvisibleRedstone(int id) {
		super(id, Material.rock);
		setHardness(1000F);
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("DON'T TOUCH");
	}
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
		
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		icon = register.registerIcon(BlockInfo.TEXTURE_LOC + ":" + BlockInfo.INVISIBLE_REDSTONE_ICON);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		return icon;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean canCollideCheck(int par1, boolean par2) {
		return this.isCollidable();
	}

	@Override
	public boolean isCollidable() {
		return false;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public boolean canProvidePower() {
		return true;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4,
			net.minecraft.entity.player.EntityPlayer player) {

		player.addChatMessage("called");
	}

	@Override
	public boolean isBlockReplaceable(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2,
			int par3, int par4, int par5) {
		return 15;
	}
	
	@Override
	public int getRenderBlockPass()
    {
        return 0;
    }
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileInvisibleRedstone();
	}
}
