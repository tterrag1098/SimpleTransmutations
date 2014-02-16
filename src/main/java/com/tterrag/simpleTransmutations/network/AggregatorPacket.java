package com.tterrag.simpleTransmutations.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

import com.tterrag.simpleTransmutations.gui.GuiPowderAgg;

public class AggregatorPacket implements ITransmutationPacket
{
	int energy, progress;
	boolean isBurning;
	
	public AggregatorPacket()
	{
		energy = 0;
		progress = 0;
		isBurning = false;
	}
	
	public AggregatorPacket(int energy, int progress, boolean isBurning)
	{
		this.energy = energy;
		this.progress = progress;
		this.isBurning = isBurning;
	}
	
	@Override
	public void encodeInto(ByteBuf buffer)
	{
		buffer.writeInt(energy);
		buffer.writeInt(progress);
		buffer.writeBoolean(isBurning);
	}

	@Override
	public void decodeInto(ByteBuf buffer)
	{
		energy = buffer.readInt();
		progress = buffer.readInt();
		isBurning = buffer.readBoolean();
		
		Minecraft mc = Minecraft.getMinecraft();
		
		if (mc.currentScreen instanceof GuiPowderAgg)
		{
			((GuiPowderAgg) mc.currentScreen).energyStored = energy;
			((GuiPowderAgg) mc.currentScreen).burnProgress = progress;
			((GuiPowderAgg) mc.currentScreen).isBurning = isBurning;
		}
	}
}
