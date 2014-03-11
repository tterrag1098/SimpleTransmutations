package com.tterrag.simpleTransmutations.tile;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.item.ItemRedstoneGlove;

public class TileInvisibleRedstone extends TileEntity
{

	private int timer;
	private boolean replace, isAdvanced;
	private int meta;
	private Block replaceBlock;

	public TileInvisibleRedstone(int meta)
	{
		timer = BlockInfo.MAX_TIME;
		if (ItemRedstoneGlove.willReplace())
		{
			replace = true;
			replaceBlock = ItemRedstoneGlove.getReplaceBlock();
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
					this.worldObj.setBlock(xCoord, yCoord, zCoord, replaceBlock, meta, 3);
				else
					this.worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air, 0, 3);
			}
			timer--;
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		if (!isAdvanced)
			compound.setByte("Timer", (byte) timer);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		if (!isAdvanced)
			timer = compound.getByte("Timer");
	}
}
