package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLargeTentacleBundle extends ItemFood
{
	public ItemLargeTentacleBundle(int id)
	{
		super(id, 10, 2.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.LARGE_BUNDLE_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.LARGE_BUNDLE_ICON);
	}
}
