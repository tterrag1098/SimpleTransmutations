package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTentacleBundleLarge extends ItemFood
{
	public ItemTentacleBundleLarge()
	{
		super(10, 2.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.LARGE_BUNDLE_UNLOC_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.LARGE_BUNDLE_ICON);
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
	{
		ItemStack stack = new ItemStack(Items.dye);
		if (!world.isRemote)
			if (!player.inventory.addItemStackToInventory(stack))
				player.dropItem(Items.dye, 1);
		return super.onEaten(itemStack, world, player);
	}
}
