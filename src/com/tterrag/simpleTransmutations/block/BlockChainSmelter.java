package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.tile.TileChainSmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChainSmelter extends BlockContainer {
	
	public BlockChainSmelter(int id)
	{
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.CHAIN_SMELTER_UNLOC_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOC + ":" +  BlockInfo.CHAIN_SMELTER_ICON);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileChainSmelter();
	}
}
