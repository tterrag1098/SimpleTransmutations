package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.item.ItemEssenceContainer;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.item.ModItem;

public class EntityLivingHandler 
{
	private static boolean usedEssenceContainer = false;
	private ItemStack stack;
	private EntityPlayer player;
	private String entity;
	
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (!event.entity.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntitySquid && ConfigKeys.allowDropTentacles)
				event.entityLiving.dropItem(ItemInfo.SQUID_TENTACLE_ID + 256, (int) (Math.random() * 4 + 1));
			else if (event.entityLiving instanceof EntitySheep && ConfigKeys.allowDropMutton)
				event.entityLiving.dropItem(ItemInfo.RAW_MUTTON_ID + 256, (int) (Math.random() * 2 + 1));
			
			if (usedEssenceContainer)
			{
				((ItemEssenceContainer) stack.getItem()).setName(stack, entity);				
				usedEssenceContainer = false;
			}
		}
	}
	
	@ForgeSubscribe
	public void onAttackEntityEvent(AttackEntityEvent event)
	{
		if (!event.entityPlayer.worldObj.isRemote && event.target.getEntityName() != null)
		{		
			player = (EntityPlayer) event.entityPlayer;
			
			stack = player.getCurrentEquippedItem();
			 
			if (stack != null && stack.itemID == ItemInfo.ESSENCE_CONTAINER_ID + 256)
			{
				for (String s : ModItem.essenceNames)
				{
					if (!usedEssenceContainer && s.equals(event.target.getEntityName()))
					{
						usedEssenceContainer = true;
						entity = s;
					}
				}
			}		
			else if (stack != null && stack.itemID != ItemInfo.ESSENCE_CONTAINER_ID + 256)
			{
				usedEssenceContainer = false;
			}
		}
	}
	
	
}
