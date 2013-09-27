package com.tterrag.simpleTransmutations.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRawMutton extends ItemFood
{
	public ItemRawMutton(int id)
	{
		super(id, 2, 0.4F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.RAW_MUTTON_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.RAW_MUTTON_ICON);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world,
			EntityPlayer player)
	{
		int rand;
		player.inventory.addItemStackToInventory(new ItemStack(Item.bone));
		rand = (int) (Math.random() * 3);
		if (rand == 0)
			player.addPotionEffect(new PotionEffect(17, 300, 5));
		rand = (int) (Math.random() * 4);
		if (rand == 0)
			player.addPotionEffect(new PotionEffect(19, 200, 1));
		rand = (int) (Math.random() * 5);
		if (rand == 0)
			player.addPotionEffect(new PotionEffect(9, 400, 1));
		rand = (int) (Math.random() * 6);
		if (rand == 0)
		{
			if (player.getHealth() < 1.5F)
			{
				player.setHealth(0F);
				player.setDead();
			}
			if (!world.isRemote)
				player.addChatMessage(player.username + " wanted those bones a little too much.");
		}
		return super.onEaten(stack, world, player);
	}
}

