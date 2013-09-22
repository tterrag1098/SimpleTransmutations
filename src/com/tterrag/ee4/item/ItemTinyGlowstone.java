package com.tterrag.ee4.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTinyGlowstone extends Item {
	
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;
	
	public ItemTinyGlowstone(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.TINY_GLOWSTONE_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.TINY_GLOWSTONE_ICON);
	}
}
