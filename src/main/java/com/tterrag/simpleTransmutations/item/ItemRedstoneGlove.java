package com.tterrag.simpleTransmutations.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.block.ModBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRedstoneGlove extends Item
{
	private static Block replaceId = Blocks.air;
	private static int replaceMeta = 0, damage;
	private static boolean replace = false;

	public ItemRedstoneGlove()
	{
		super();
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return stack.getItemDamage() == 0 ? ItemInfo.REDSTONE_GLOVE_UNLOC_NAME : ItemInfo.ADV_REDSTONE_GLOVE_UNLOC_NAME;
	}

	private IIcon[] icons = new IIcon[2];

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icons[0] = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.REDSTONE_GLOVE_ICON);

		icons[1] = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.ADV_REDSTONE_GLOVE_ICON);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1 & 1];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.stackTagCompound.setInteger("numPlaced", 0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		super.addInformation(stack, player, list, par4);

		if (stack.getItemDamage() > 0 && stack.hasTagCompound())
			list.add("Signals Placed: " + stack.getTagCompound().getInteger("numPlaced"));
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		damage = stack.getItemDamage();
		int[] newCoords = null;

		if (!world.isRemote && (world.getBlock(x, y, z) != Blocks.piston && world.getBlock(x, y, z) != Blocks.sticky_piston || world.getBlockMetadata(x, y, z) != 1))
		{
			if (stack.hasTagCompound())
				stack.stackTagCompound.setInteger("numPlaced", stack.getTagCompound().getInteger("numPlaced") + 1);
			else
			{
				stack.setTagCompound(new NBTTagCompound());
				stack.stackTagCompound.setInteger("numPlaced", 1);
			}

			replace = false;
			for (int i = 0; i < 6; i++)
			{
				switch (i)
				{
				case 0:
					if (world.isAirBlock(x, y + 1, z) || world.getBlock(x, y + 1, z) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x, y + 1, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y + 1, z };
					}
					break;
				case 1:
					if (world.isAirBlock(x + 1, y, z) || world.getBlock(x + 1, y, z) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x + 1, y, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x + 1, y, z };
					}
					break;
				case 2:
					if (world.isAirBlock(x, y, z + 1) || world.getBlock(x, y, z + 1) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x, y, z + 1, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y, z + 1 };
					}
					break;
				case 3:
					if (world.isAirBlock(x, y, z - 1) || world.getBlock(x, y, z - 1) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x, y, z - 1, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y, z - 1 };
					}
					break;
				case 4:
					if (world.isAirBlock(x - 1, y, z) || world.getBlock(x - 1, y, z) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x - 1, y, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x - 1, y, z };
					}
					break;
				case 5:
					replaceId = world.getBlock(x, y - 1, z);
					replaceMeta = world.getBlockMetadata(x, y - 1, z);

					if (world.isAirBlock(x, y - 1, z) || world.getBlock(x, y - 1, z) == ModBlock.invisibleRedstone)
					{
						world.setBlock(x, y - 1, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y - 1, z };
					}
					else if (world.getTileEntity(x, y - 1, z) == null)
					{
						replace = true;
						world.setBlock(x, y - 1, z, ModBlock.invisibleRedstone);
						newCoords = new int[] { x, y - 1, z };
					}
					break;
				}
			}
		}
		else if (!world.isRemote && (world.getBlock(x, y, z) == Blocks.piston || world.getBlock(x, y, z) == Blocks.sticky_piston) && world.getBlockMetadata(x, y, z) == 1)
		{
			if (stack.hasTagCompound())
				stack.stackTagCompound.setInteger("numPlaced", stack.getTagCompound().getInteger("numPlaced") + 1);
			else
			{
				stack.setTagCompound(new NBTTagCompound());
				stack.stackTagCompound.setInteger("numPlaced", 1);
			}
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
						world.setBlock(x + 1, y, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x + 1, y, z };
					}
					break;
				case 2:
					if (world.isAirBlock(x, y, z + 1))
					{
						world.setBlock(x, y, z + 1, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y, z + 1 };
					}
					break;
				case 3:
					if (world.isAirBlock(x, y, z - 1))
					{
						world.setBlock(x, y, z - 1, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y, z - 1 };
					}
					break;
				case 4:
					if (world.isAirBlock(x - 1, y, z))
					{
						world.setBlock(x - 1, y, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x - 1, y, z };
					}
					break;
				case 5:
					replaceId = world.getBlock(x, y - 1, z);
					replaceMeta = world.getBlockMetadata(x, y - 1, z);

					if (world.isAirBlock(x, y - 1, z))
					{
						world.setBlock(x, y - 1, z, ModBlock.invisibleRedstone, damage, 3);
						newCoords = new int[] { x, y - 1, z };
					}
					else if (world.getTileEntity(x, y - 1, z) == null)
					{
						replace = true;
						world.setBlock(x, y - 1, z, ModBlock.invisibleRedstone);
						newCoords = new int[] { x, y - 1, z };
					}
					break;
				}
			}
			addNewCoordTag(stack, newCoords);
			return false;
		}
		else
			return false;
		return true;
	}

	private void addNewCoordTag(ItemStack stack, int[] newCoords)
	{
		if (newCoords == null || stack.getItemDamage() == 0)
			return;

		int[] currentCoords;

		if (stack.hasTagCompound() && stack.stackTagCompound.hasKey("coords"))
		{
			currentCoords = stack.stackTagCompound.getIntArray("coords");
		}
		else if (stack.hasTagCompound())
		{
			currentCoords = new int[15];
		}
		else
			throw new NullPointerException("you dun goofed");

		for (int i = 0; i < 15; i += 3)
		{
			int index = 0;
			boolean matches = true;
			while (matches)
			{
				matches = newCoords[index] == currentCoords[index + i];
				index++;
			}
			if (!matches)
			{
			}
		}
	}

	public static Block getReplaceBlock()
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
