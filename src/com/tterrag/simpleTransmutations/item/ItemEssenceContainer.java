package com.tterrag.simpleTransmutations.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEssenceContainer extends Item
{
	public ItemEssenceContainer(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME);
		setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":"
				+ ItemInfo.ESSENCE_CONTAINER_ICON);
	}
}
