package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.SimpleTransmutations;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

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
	
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	public TileEntity createTileEntity(World world, int metadata) {
		return new TilePowderAggregator();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te instanceof TilePowderAggregator && !player.isSneaking()) {
			player.openGui(SimpleTransmutations.instance, 0, world, x, y, z);
			System.out.println("Hey!");
			return true;
		}
		return false;
    }
}
