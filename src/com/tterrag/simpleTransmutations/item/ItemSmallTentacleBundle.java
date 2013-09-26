package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSmallTentacleBundle extends ItemFood
{
	public ItemSmallTentacleBundle(int id)
	{
		super(id, 5, 1.5F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.SMALL_BUNDLE_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.SMALL_BUNDLE_ICON);
	}
}
