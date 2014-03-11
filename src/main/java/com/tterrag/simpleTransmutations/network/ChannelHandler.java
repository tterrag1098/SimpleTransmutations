package com.tterrag.simpleTransmutations.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;

public class ChannelHandler extends FMLIndexedMessageToMessageCodec<ITransmutationPacket>
{
	public ChannelHandler()
	{
		addDiscriminator(0, AggregatorPacket.class);
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ITransmutationPacket msg, ByteBuf target) throws Exception
	{
		msg.encodeInto(target);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, ITransmutationPacket msg)
	{
		msg.decodeInto(source);
	}
}
