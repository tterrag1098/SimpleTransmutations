package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.lib.ConfigKeys;

public class EntityLivingHandler 
{
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (event.entityLiving instanceof EntitySquid && ConfigKeys.allowDropTentacles)
			event.entityLiving.dropItem(ItemInfo.SQUID_TENTACLES_ID, (int) (Math.random() * 4 + 1));
		else if (event.entityLiving instanceof EntitySheep && ConfigKeys.allowDropMutton)
			event.entityLiving.dropItem(ItemInfo.RAW_MUTTON_ID, (int) (Math.random() * 2 + 1));
	}
}
