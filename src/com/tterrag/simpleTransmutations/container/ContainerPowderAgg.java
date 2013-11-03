package com.tterrag.simpleTransmutations.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

/**
 * @author Archadia
 * 
 */
public class ContainerPowderAgg extends Container
{

	@SuppressWarnings("unused")
	private TilePowderAggregator tileEnt;

	public ContainerPowderAgg(InventoryPlayer par1InventoryPlayer,
			TilePowderAggregator tile)
	{
		bindPlayerInventory(par1InventoryPlayer);

		this.tileEnt = (TilePowderAggregator) tile;

		addSlotToContainer(new Slot(tile, 0, 56, 38));
		addSlotToContainer(new SlotAggregator(tile, 1, 106, 38));
	}

	public void bindPlayerInventory(InventoryPlayer inv)
	{
		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inv, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		 ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();
	            
	            if (par2 == 36 || par2 == 37)
	            {
	            	if (!this.mergeItemStack(itemstack1, 27, 36, false))
	            	{
	            		if (!this.mergeItemStack(itemstack1, 0, 27, false))
	            			return null;
	            	}
	            	slot.onSlotChange(itemstack1, itemstack);
	            }
	            if (par2 < 37)
	            {
	            	if (TilePowderAggregator.getItemBurnTime(itemstack) > 0)
	            	{
	            		if (!this.mergeItemStack(itemstack1, 36, 37, false))
	            			return null;
	            		slot.onSlotChange(itemstack1, itemstack);
	            	}
	            }
	        
	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }
	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	        }

	        return itemstack;
	}
}
