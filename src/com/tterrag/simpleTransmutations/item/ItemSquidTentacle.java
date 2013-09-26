package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSquidTentacle extends ItemFood
{
	public ItemSquidTentacle(int id)
	{
		super(id, 2, 1.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.SQUID_TENTACLE_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.SQUID_TENTACLE_ICON);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 24;
    }
	
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
		int rand = (int) (Math.random() * 10);
		
		ItemStack stack = new ItemStack(Item.dyePowder);
		
		if (rand == 0)
			player.inventory.addItemStackToInventory(stack);
        return super.onEaten(itemStack, world, player);
    }
}
