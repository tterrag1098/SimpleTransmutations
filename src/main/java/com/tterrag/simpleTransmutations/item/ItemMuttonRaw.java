package com.tterrag.simpleTransmutations.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.tterrag.simpleTransmutations.config.ConfigKeys;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMuttonRaw extends ItemFood
{

	private static boolean hasWarned = false;
	private static boolean eatenOne = false;

	public ItemMuttonRaw()
	{
		super(2, 0.0F, true);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.RAW_MUTTON_UNLOC_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.RAW_MUTTON_ICON);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{

		int rand;

		if (!world.isRemote)
		{
			if (!player.inventory.addItemStackToInventory(new ItemStack(Items.bone)))
			{
				player.dropItem(Items.bone, 1);
			}
			eatenOne = true;
		}

		if (ConfigKeys.muttonWillKill && !world.isRemote)
		{
			rand = (int) (Math.random() * 2);
			if (rand == 0)
				player.addPotionEffect(new PotionEffect(17, 300, 6));

			rand = (int) (Math.random() * 2.3);
			if (rand == 0)
				player.addPotionEffect(new PotionEffect(19, 200, 2));

			rand = (int) (Math.random() * 4);
			if (rand == 0)
				player.addPotionEffect(new PotionEffect(9, 400, 0));

			if (player.getHealth() < 4.0F && eatenOne && hasWarned)
			{
				player.setHealth(0F);
				player.inventory.dropAllItems();
				player.setDead();

				for (EntityPlayer playerIter : (List<EntityPlayer>) player.worldObj.playerEntities)
				{
					playerIter.addChatMessage(new ChatComponentText(player.getCommandSenderName() + " wanted those bones a little too much"));
				}
				hasWarned = false;
				eatenOne = false;
			}
			else if (player.getHealth() < 8.0F && !hasWarned)
			{
				player.addChatMessage(new ChatComponentText("You should probably stop eating those..."));
				hasWarned = true;
			}
		}
		else if (!world.isRemote)
		{
			rand = (int) (Math.random() * 10);
			if (rand < 8)
				player.addPotionEffect(new PotionEffect(17, 400, 0));
		}

		return super.onEaten(stack, world, player);
	}
}
