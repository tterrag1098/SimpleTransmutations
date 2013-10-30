package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCalamariPlatterSmall extends ItemFood
{
	public ItemCalamariPlatterSmall(int id)
	{
		super(id, 10, 3.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.SMALL_PLATTER_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.SMALL_PLATTER_ICON);
	}
}
