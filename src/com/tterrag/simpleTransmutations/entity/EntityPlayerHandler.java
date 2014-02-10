package com.tterrag.simpleTransmutations.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityPlayerHandler
{
	@SuppressWarnings("unchecked")
	@SubscribeEvent
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
			List<EntityPlayer> playerList = event.entityPlayer.worldObj.playerEntities;
			boolean allSleeping = true;
			for (EntityPlayer player : playerList)
			{
				if (!(player.equals(event.entityPlayer))
						&& !player.isPlayerSleeping())
					allSleeping = false;
			}
			if (!allSleeping)
			{
				for (EntityPlayer player : playerList)
				{
					if (!player.equals(event.entityPlayer))
						player.addChatMessage(new ChatComponentText(event.entityPlayer.getCommandSenderName()
								+ " is sleeping in a bed"));
				}

			}
			else
			{
				for (EntityPlayer player : playerList)
				{
					player.addChatMessage(new ChatComponentText("All players are now in a bed"));
				}
			}
		}
	}
}
