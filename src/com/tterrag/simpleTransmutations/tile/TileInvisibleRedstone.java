package com.tterrag.simpleTransmutations.tile;

import com.tterrag.simpleTransmutations.block.BlockInfo;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileInvisibleRedstone extends TileEntity {
	
	private int timer;

	public TileInvisibleRedstone()
	{
		timer = BlockInfo.MAX_TIME;
	}
	
	@Override
	public void updateEntity()
	{
		if (!worldObj.isRemote)
		{
			if (timer > 0)
			{
				timer--;
			}
			else if (timer == 0)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, 0, 0, 3);
			}
			timer--;
		}

	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setByte("Timer" , (byte) timer);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		timer = compound.getByte("Timer");
	}
}
