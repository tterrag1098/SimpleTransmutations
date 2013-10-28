package com.tterrag.simpleTransmutations.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;

public class EntityPlayerHandler
{
	@SuppressWarnings("unchecked")
	@ForgeSubscribe
	public void onPlayerSleep(PlayerSleepInBedEvent event)
	{
		boolean canSleep = false;

		if (!event.entityPlayer.worldObj.isRemote && ConfigKeys.allowBedMessage)
		{
			if (event.entityPlayer.isPlayerSleeping()
					|| !event.entityPlayer.isEntityAlive())
			{
				return;
			}

			if (!event.entityPlayer.worldObj.provider.isSurfaceWorld())
			{
				return;
			}

			if (event.entityPlayer.worldObj.isDaytime())
			{
				return;
			}

			if (Math.abs(event.entityPlayer.posX - (double) event.x) > 3.0D
					|| Math.abs(event.y - (double) event.y) > 2.0D
					|| Math.abs(event.z - (double) event.z) > 3.0D)
			{
				return;
			}

			double d0 = 8.0D;
			double d1 = 5.0D;
			List<Entity> list = event.entityPlayer.worldObj
					.getEntitiesWithinAABB(
							EntityMob.class,
							AxisAlignedBB.getAABBPool().getAABB(
									(double) event.x - d0,
									(double) event.y - d1,
									(double) event.z - d0,
									(double) event.x + d0,
									(double) event.y + d1,
									(double) event.z + d0));

			if (!list.isEmpty())
			{
				return;
			}
			canSleep = true;
		}

		if (ConfigKeys.allowBedMessage && canSleep
				&& event.entityPlayer.worldObj.playerEntities.size() > 1)
		{
			boolean allSleeping = true;
			for (EntityPlayer player : (List<EntityPlayer>) event.entityPlayer.worldObj.playerEntities)
			{
				if (!(player.equals(event.entityPlayer))
						&& !player.isPlayerSleeping())
					allSleeping = false;
			}
			if (!allSleeping)
			{
				for (EntityPlayer player : (List<EntityPlayer>) event.entityPlayer.worldObj.playerEntities)
				{
					if (!player.equals(event.entityPlayer)
							&& !player.isPlayerSleeping())
						player.addChatMessage(event.entityPlayer.username
								+ " is sleeping in a bed");
				}

			}
			else
			{
				for (EntityPlayer player : (List<EntityPlayer>) event.entityPlayer.worldObj.playerEntities)
				{
					player.addChatMessage("All players are now in a bed");
				}
			}
		}
	}
}
