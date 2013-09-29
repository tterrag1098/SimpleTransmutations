package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
		int rand = (int) (Math.random() * 3);
		
		ItemStack stack = new ItemStack(Item.dyePowder);
		
		if (rand == 0 && !world.isRemote)
			if (!player.inventory.addItemStackToInventory(stack))
				player.dropItem(Item.dyePowder.itemID, 1);
        return super.onEaten(itemStack, world, player);
    }
}
