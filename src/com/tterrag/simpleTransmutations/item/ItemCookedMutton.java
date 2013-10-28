package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCookedMutton extends ItemFood
{
	public ItemCookedMutton (int id)
	{
		super(id, 8, 2.5F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.COOKED_MUTTON_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.COOKED_MUTTON_ICON);
	}
}
