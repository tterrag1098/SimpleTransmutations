package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMuttonCooked extends ItemFood
{
	public ItemMuttonCooked()
	{
		super(10, 2.5F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.COOKED_MUTTON_UNLOC_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.COOKED_MUTTON_ICON);
	}
}
