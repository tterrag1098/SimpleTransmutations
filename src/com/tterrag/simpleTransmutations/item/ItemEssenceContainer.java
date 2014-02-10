package com.tterrag.simpleTransmutations.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceContainer extends Item
{
	Iterator<?> iter;

	public ItemEssenceContainer()
	{
		super();
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":"
				+ ItemInfo.ESSENCE_CONTAINER_ICON);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity)
	{
		if (!(ModItem.hasEssenceNames))
		{
			ModItem.createEssenceNameList();
		}
		return super.onLeftClickEntity(stack, player, entity);
	}

	public String getName(ItemStack item)
	{
		if (!item.hasTagCompound())
		{
			item.setTagCompound(new NBTTagCompound());
			item.stackTagCompound.setString("Contains: ", "");
		}
		return item.stackTagCompound.getString("Contains: ");
	}

	public void setName(ItemStack item, String name)
	{
		if (!item.hasTagCompound())
		{
			item.setTagCompound(new NBTTagCompound());
		}
		item.stackTagCompound.setString("Contains: ", name);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4)
	{
		super.addInformation(stack, player, list, par4);

		list.add("Contains: " + getName(stack));

	}
}
