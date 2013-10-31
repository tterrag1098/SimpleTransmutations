package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPowderAggregator extends Block
{
	public BlockPowderAggregator(int id)
	{
		super (id, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(4.0F);
		setUnlocalizedName(BlockInfo.POWDER_AGGREGATOR_UNLOC_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		//TO-DO register icons
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		//TO-DO return the correct side
		return null;
	}
}
