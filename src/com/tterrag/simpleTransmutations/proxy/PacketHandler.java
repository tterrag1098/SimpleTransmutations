package com.tterrag.simpleTransmutations.proxy;

import com.tterrag.simpleTransmutations.gui.GuiPowderAgg;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{		
		GuiScreen gui = Minecraft.getMinecraft().currentScreen;
		
		if (packet.data[0] == 0)
		{
			byte[] bytes = packet.data;
			int energy = 0;
			energy = ((bytes[1] & 255) | ((bytes[2] & 255) << 8) | ((bytes[3] & 255) << 16) | (bytes[4] & 255) << 24);

			if (gui instanceof GuiPowderAgg)
			{
				((GuiPowderAgg)gui).energyStored = energy;
			}
		}
		if (packet.data[5] == 1)
		{
			byte[] bytes = packet.data;
			int progress = 0;
			progress = ((bytes[6] & 255) | ((bytes[7] & 255) << 8) | ((bytes[8] & 255) << 16) | (bytes[9] & 255) << 24);

			if (gui instanceof GuiPowderAgg)
			{
				((GuiPowderAgg)gui).burnProgress = progress;
			}
		}

		if (gui instanceof GuiPowderAgg)
		{
			if (packet.data[10] == 1)
				((GuiPowderAgg)gui).isBurning = true;
			else
				((GuiPowderAgg)gui).isBurning = false;
		}
	}

}
