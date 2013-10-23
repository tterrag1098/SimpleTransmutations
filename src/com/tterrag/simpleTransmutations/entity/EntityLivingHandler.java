package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.item.ItemEssenceContainer;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.item.ModItem;

public class EntityLivingHandler 
{
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (!event.entity.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntitySquid && ConfigKeys.allowDropTentacles)
				event.entityLiving.dropItem(ItemInfo.SQUID_TENTACLE_ID + 256, (int) (Math.random() * 4 + 1));
			else if (event.entityLiving instanceof EntitySheep && ConfigKeys.allowDropMutton)
				event.entityLiving.dropItem(ItemInfo.RAW_MUTTON_ID + 256, (int) (Math.random() * 2 + 1));
			
			
		}
	}
	
	@ForgeSubscribe
	public void onAttackEntityEvent(AttackEntityEvent event)
	{
		EntityPlayer player;
		if (!event.entityPlayer.worldObj.isRemote && event.target.getEntityName() != null)
		{
			System.out.println(event.target.getEntityName());
		
			player = (EntityPlayer) event.entityPlayer;
			
			ItemStack stack = player.getCurrentEquippedItem();
			 
			if (stack.itemID == ItemInfo.ESSENCE_CONTAINER_ID + 256)
			{
				int damage = 0;
				for (String s : ModItem.essenceNames)
				{
					if (s.equals(event.target.getEntityName()))
						stack.setItemDamage(damage);
					damage++;
				}
				stack.getItem().addInformation(stack, player, stack.getTooltip(player, true), false);
			}
				
		}
	}
	
	
}
