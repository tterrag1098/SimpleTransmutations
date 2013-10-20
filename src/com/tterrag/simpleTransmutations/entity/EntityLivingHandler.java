package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.item.ItemInfo;

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
	
	
}
