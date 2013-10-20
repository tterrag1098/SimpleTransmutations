package com.tterrag.simpleTransmutations.entity;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class EntityPlayerHandler
{
	@SuppressWarnings("unchecked")
	@ForgeSubscribe
	public void onPlayerSleep(PlayerSleepInBedEvent event)
	{		
		boolean canSleep = false;
		
		if (!event.entityPlayer.worldObj.isRemote)
        {
            if (event.entityPlayer.isPlayerSleeping() || !event.entityPlayer.isEntityAlive())
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

            if (Math.abs(event.entityPlayer.posX - (double)event.x) > 3.0D || Math.abs(event.y - (double)event.y) > 2.0D || Math.abs(event.z - (double)event.z) > 3.0D)
            {
            	return;
            }

            double d0 = 8.0D;
            double d1 = 5.0D;
            List list = event.entityPlayer.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getAABBPool().getAABB((double)event.x - d0, (double)event.y - d1, (double)event.z - d0, (double)event.x + d0, (double)event.y + d1, (double)event.z + d0));

            if (!list.isEmpty())
            {
            	return;
            }
            canSleep = true;
		}

		if (canSleep)
		{
			for (EntityPlayer player : (List<EntityPlayer>) event.entityPlayer.worldObj.playerEntities)
			{

				player.addChatMessage(event.entityPlayer.username
						+ " is sleeping in a bed");
			}

		}
		/*if (!event.entityPlayer.worldObj.isRemote && event.entityPlayer.sleepInBedAt(event.x, event.y, event.z) == EnumStatus.OK)
		{
			MinecraftServer server = MinecraftServer.getServer();

			WorldServer[] worldServers = server.worldServers;

			for (WorldServer ws : worldServers)
			{
				for (EntityPlayer player : (List<EntityPlayer>) ws.playerEntities)
				{
					if (event.result == EnumStatus.OK)

					player.addChatMessage(player.username
							+ " is sleeping in a bed.");
				}
			}
		}
		/*List<EntityPlayer> playerList = null;
		if (!event.entityPlayer.worldObj.isRemote)
		{
			if (event.entityPlayer.worldObj.playerEntities instanceof List<?>)
			{
				playerList = event.entityPlayer.worldObj.playerEntities;
			}
			if (playerList != null)
			{
				Iterator<EntityPlayer> iter = playerList.iterator();
				while (iter.hasNext())
				{
					iter.next().addChatMessage(
							event.entityPlayer.username
									+ " is sleeping in a bed.");
				}
			}
		}*/
	}
}
