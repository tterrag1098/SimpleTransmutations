package com.tterrag.simpleTransmutations.proxy;

import com.tterrag.simpleTransmutations.gui.GuiPowderAgg;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player)
	{
		if (packet.data[0] == 0)
		{
			byte[] bytes = packet.data;
			int energy = 0;
			energy = ((bytes[1] & 255) | ((bytes[2] & 255) << 8)
					| ((bytes[3] & 255) << 16) | (bytes[4] & 255) << 24);

			if (Minecraft.getMinecraft().currentScreen instanceof GuiPowderAgg)
			{
				GuiPowderAgg gui = (GuiPowderAgg) Minecraft.getMinecraft().currentScreen;

				gui.energyStored = energy;
			}
		}
		if (packet.data[5] == 1)
		{
			byte[] bytes = packet.data;
			int progress = 0;
			progress = ((bytes[6] & 255) | ((bytes[7] & 255) << 8)
					| ((bytes[8] & 255) << 16) | (bytes[9] & 255) << 24);

			if (Minecraft.getMinecraft().currentScreen instanceof GuiPowderAgg)
			{
				GuiPowderAgg gui = (GuiPowderAgg) Minecraft.getMinecraft().currentScreen;
				
				gui.burnProgress = progress;
			}
		}
	}

}
