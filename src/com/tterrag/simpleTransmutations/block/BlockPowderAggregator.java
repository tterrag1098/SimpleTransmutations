package com.tterrag.simpleTransmutations.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(4.0F);
		setLightValue(0.6F);
		setUnlocalizedName(BlockInfo.POWDER_AGGREGATOR_UNLOC_NAME);
	}

	private Icon[] icons = new Icon[4];

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		int i = 0;
		for (String s : BlockInfo.POWDER_AGGREGATOR_ICON)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOC + ":" + s);
			i++;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{

		switch (side)
		{
		case 0: return icons[2];
		case 1: return icons[0];
		case 2: return icons[3];
		case 3: return icons[1];
		case 4: return icons[3];
		case 5: return icons[1];
		default: return null;
		}
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TilePowderAggregator();
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof TilePowderAggregator && !player.isSneaking())
		{
			player.openGui(SimpleTransmutations.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public void breakBlock(World world, int par2, int par3, int par4,
			int par5, int par6)
	{
		TilePowderAggregator tile = (TilePowderAggregator) world
				.getBlockTileEntity(par2, par3, par4);

		if (tile != null && !world.isRemote)
		{
			for (int j1 = 0; j1 < tile.getSizeInventory(); ++j1)
			{
				ItemStack itemstack = tile.getStackInSlot(j1);

				if (itemstack != null)
				{
					float f = (float) Math.random();
					float f1 = (float) Math.random();
					float f2 = (float) Math.random();

					while (itemstack.stackSize > 0)
					{
						Random rand = new Random();
						int k1 = rand.nextInt(21) + 10;

						if (k1 > itemstack.stackSize)
						{
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						EntityItem entityitem = new EntityItem(world,
								(double) ((float) par2 + f),
								(double) ((float) par3 + f1),
								(double) ((float) par4 + f2), new ItemStack(
										itemstack.itemID, k1,
										itemstack.getItemDamage()));

						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound(
									(NBTTagCompound) itemstack.getTagCompound()
											.copy());
						}

						entityitem.motionX = (int) Math.random() * 2;
						entityitem.motionY = (int) Math.random() * 2;
						entityitem.motionZ = (int) Math.random() * 2;
						world.spawnEntityInWorld(entityitem);
					}
				}
			}

			world.func_96440_m(par2, par3, par4, par5);
		}

		super.breakBlock(world, par2, par3, par4, par5, par6);
	}
}
