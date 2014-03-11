package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.item.ItemEssenceContainer;
import com.tterrag.simpleTransmutations.item.ModItem;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityLivingHandler
{
	private static boolean usedEssenceContainer = false;
	private ItemStack stack;
	private EntityPlayer player;
	private String entity;
	private boolean hasChecked = false, dartcraftTrue;

	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (!hasChecked)
		{
			dartcraftTrue = Loader.isModLoaded("dartCraft");
			hasChecked = true;
		}

		if (!event.entity.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntitySquid && ConfigKeys.allowDropTentacles)
				event.entityLiving.dropItem(ModItem.squidTentacle, (int) (Math.random() * 4 + 1));
			else if (event.entityLiving instanceof EntitySheep && ConfigKeys.allowDropMutton && !dartcraftTrue)
				event.entityLiving.dropItem(ModItem.rawMutton, (int) (Math.random() * 2 + 1));

			if (usedEssenceContainer)
			{
				((ItemEssenceContainer) stack.getItem()).setName(stack, entity);
				usedEssenceContainer = false;
			}
		}
	}

	@SubscribeEvent
	public void onAttackEntityEvent(AttackEntityEvent event)
	{
		if (!event.entityPlayer.worldObj.isRemote && event.target.getEntityId() != -1)
		{
			player = event.entityPlayer;

			stack = player.getCurrentEquippedItem();

			if (stack != null && stack.getItem() == ModItem.essenceContainer)
			{
				for (String s : ModItem.essenceNames)
				{
					if (!usedEssenceContainer && s.equals(event.target.getEntityId()))
					{
						usedEssenceContainer = true;
						entity = s;
					}
				}
			}
			else if (stack != null && stack.getItem() != ModItem.essenceContainer)
			{
				usedEssenceContainer = false;
			}
		}
	}

}
