package com.tterrag.simpleTransmutations.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemRedstoneGlove;

public class TileInvisibleRedstone extends TileEntity {
	
	private int timer;
	private boolean replace, isAdvanced;
	private int id, meta;

	public TileInvisibleRedstone(int meta)
	{
		timer = BlockInfo.MAX_TIME;
		if (ItemRedstoneGlove.willReplace())
		{
			replace = true;
			id = ItemRedstoneGlove.getReplaceId();
			meta = ItemRedstoneGlove.getReplaceMeta();
		}	
		
		isAdvanced = meta > 0;
	}
	
	@Override
	public void updateEntity()
	{
		if (!worldObj.isRemote && !isAdvanced)
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

		if (!isAdvanced)
			compound.setByte("Timer" , (byte) timer);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		if (!isAdvanced)
			timer = compound.getByte("Timer");
	}
}
