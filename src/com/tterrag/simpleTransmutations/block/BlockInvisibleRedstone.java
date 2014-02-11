package com.tterrag.simpleTransmutations.block;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.tile.TileInvisibleRedstone;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInvisibleRedstone extends BlockContainer {
	
	private int meta;
	
	public BlockInvisibleRedstone() {
		super(Material.rock);
		setHardness(1000F);
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.INVISIBLE_REDSTONE_UNLOC_NAME;
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon icon;
		
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) 
	{
		icon = register.registerIcon(BlockInfo.TEXTURE_LOC + ":" + BlockInfo.INVISIBLE_REDSTONE_ICON);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return icon;
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		meta = par1World.getBlockMetadata(par2, par3, par4);
		
		super.onBlockAdded(par1World, par2, par3, par4);
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

		player.addChatComponentMessage(new ChatComponentText("called"));
	}

	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
	{
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
	public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public boolean isAir(IBlockAccess world, int x, int y, int z)
	{
		return true;	
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileInvisibleRedstone(var2);
	}
}
