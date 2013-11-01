package com.tterrag.simpleTransmutations.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TilePowderAggregator extends TileEntity implements IInventory
{
	ItemStack[] inventory = new ItemStack[2];
	public int energyStored;
	public static int maxEnergy = 1000;
			
	public TilePowderAggregator()
	{
		
	}
	
	public void updateEntity()
	{
		super.updateEntity();
		if(!worldObj.isRemote) {
			if(worldObj.isDaytime()) {
				if(worldObj.getWorldTime()%20 == 0) {
					setEnergyStored(getEnergyStored() + 10);
				}
			}
			
			if(inventory[0] != null) {
				if(inventory[0].itemID == Item.coal.itemID) {
					--inventory[0].stackSize;
					if(inventory[0].stackSize <= 0) {
						inventory[0] = null;
					}
					setEnergyStored(getEnergyStored() + 100);
				}
			}
		}
		if(energyStored >= 1000) {
			fabricateOutput();
			setEnergyStored(getEnergyStored() - 1000);
		}
	}
	
	public void fabricateOutput() {
		ItemStack stack = new ItemStack(Item.blazePowder);
		
		if(inventory[1] == null) {
			inventory[1] = stack.copy();
		} else if(inventory[1].isItemEqual(stack)) {
			inventory[1].stackSize += stack.stackSize;
		}
	}
	
	public void setEnergyStored(int value)
	{
		energyStored = value;
	}
	
	public int getEnergyStored()
	{
		return energyStored;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
        return this.inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.inventory[i] != null)
        {
            ItemStack itemstack;

            if (this.inventory[i].stackSize <= j)
            {
                itemstack = this.inventory[i];
                this.inventory[i] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[i].splitStack(j);

                if (this.inventory[i].stackSize == 0)
                {
                    this.inventory[i] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.inventory[i] != null)
        {
            ItemStack itemstack = this.inventory[i];
            this.inventory[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.inventory[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "PowderAgg";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
}
