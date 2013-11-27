package com.tterrag.simpleTransmutations.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.block.BlockInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ItemRedstoneGlove extends Item
{

	private float weaponDamage;
	private static int replaceId = 0, replaceMeta = 0;
	private static boolean replace = false;

	public ItemRedstoneGlove(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(ItemInfo.REDSTONE_GLOVE_UNLOC_NAME);
		setMaxStackSize(1);
	}
	
	public ItemRedstoneGlove()
	{super(0);}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":"
				+ ItemInfo.REDSTONE_GLOVE_ICON);
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ)
	{
		if (!world.isRemote
				&& (world.getBlockId(x, y, z) != Block.pistonBase.blockID
						&& world.getBlockId(x, y, z) != Block.pistonStickyBase.blockID || world
						.getBlockMetadata(x, y, z) != 1))
		{
			replace = false;
			for (int i = 0; i < 6; i++)
			{
				switch (i)
				{
				case 0:
					if (world.isAirBlock(x, y + 1, z)
							|| world.getBlockId(x, y + 1, z) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x, y + 1, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 1:
					if (world.isAirBlock(x + 1, y, z)
							|| world.getBlockId(x + 1, y, z) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x + 1, y, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 2:
					if (world.isAirBlock(x, y, z + 1)
							|| world.getBlockId(x, y, z + 1) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x, y, z + 1,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 3:
					if (world.isAirBlock(x, y, z - 1)
							|| world.getBlockId(x, y, z - 1) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x, y, z - 1,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 4:
					if (world.isAirBlock(x - 1, y, z)
							|| world.getBlockId(x - 1, y, z) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x - 1, y, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 5:
					replaceId = world.getBlockId(x, y - 1, z);
					replaceMeta = world.getBlockMetadata(x, y - 1, z);
					
					if (world.isAirBlock(x, y - 1, z)
							|| world.getBlockId(x, y - 1, z) == BlockInfo.INVISIBLE_REDSTONE_ID)
					{
						world.setBlock(x, y - 1, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					else if (world.getBlockTileEntity(x, y - 1, z) == null)
					{
						replace = true;
						world.setBlock(x, y - 1, z, BlockInfo.INVISIBLE_REDSTONE_ID);
					}
					break;
				default:
					return false;
				}
			}
		} else if (!world.isRemote
				&& (world.getBlockId(x, y, z) == Block.pistonBase.blockID || world
						.getBlockId(x, y, z) == Block.pistonStickyBase.blockID)
				&& world.getBlockMetadata(x, y, z) == 1)
		{
			replace = false;
			for (int i = 0; i < 6; i++)
			{
				switch (i)
				{
				case 0:
					break;
				case 1:
					if (world.isAirBlock(x + 1, y, z))
					{
						world.setBlock(x + 1, y, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}					
					break;
				case 2:
					if (world.isAirBlock(x, y, z + 1))
					{
						world.setBlock(x, y, z + 1,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 3:
					if (world.isAirBlock(x, y, z - 1))
					{
						world.setBlock(x, y, z - 1,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 4:
					if (world.isAirBlock(x - 1, y, z))
					{
						world.setBlock(x - 1, y, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					break;
				case 5:
					replaceId = world.getBlockId(x, y - 1, z);
					replaceMeta = world.getBlockMetadata(x, y - 1, z);
					
					if (world.isAirBlock(x, y - 1, z))
					{
						world.setBlock(x, y - 1, z,
								BlockInfo.INVISIBLE_REDSTONE_ID, 0, 3);
						return false;
					}
					else if (world.getBlockTileEntity(x, y - 1, z) == null)
					{
						replace = true;
						world.setBlock(x, y - 1, z, BlockInfo.INVISIBLE_REDSTONE_ID);
					}
					break;
				default:
					return false;
				}
			}
		}
		else
			return false;
		return true;
	}

	public static int getReplaceId()
	{
		return replaceId;
	}

	public static int getReplaceMeta()
	{
		return replaceMeta;
	}

	public static boolean willReplace()
	{
		return replace;
	}
}
