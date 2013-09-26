package com.tterrag.simpleTransmutations.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemCalamari extends ItemFood
{
	public ItemCalamari(int id)
	{
		super(id, 3, 2.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.CALAMARI_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.CALAMARI_ICON);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 24;
    }
}
