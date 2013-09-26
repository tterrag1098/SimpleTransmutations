package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRawMutton extends ItemFood
{
	public ItemRawMutton(int id)
	{
		super(id, 2, 1.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.RAW_MUTTON_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.RAW_MUTTON_ICON);
	}
}
