package com.tterrag.simpleTransmutations.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemRedstoneGlove;

public class TileInvisibleRedstone extends TileEntity {
	
	private int timer;
	private boolean replace;
	private int id, meta;

	public TileInvisibleRedstone()
	{
		timer = BlockInfo.MAX_TIME;
		if (ItemRedstoneGlove.willReplace())
		{
			replace = true;
			id = ItemRedstoneGlove.getReplaceId();
			meta = ItemRedstoneGlove.getReplaceMeta();
		}	
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
				if (replace)
					this.worldObj.setBlock(xCoord, yCoord, zCoord, id, meta, 3);  
				else
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
