package com.tterrag.simpleTransmutations.container;

import ibxm.Player;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.tterrag.simpleTransmutations.SimpleTransmutations;
import com.tterrag.simpleTransmutations.network.AggregatorPacket;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

import cpw.mods.fml.common.FMLCommonHandler;

public class ContainerPowderAgg extends Container
{
	private TilePowderAggregator tileEnt;
	private EntityPlayer player;

	public ContainerPowderAgg(InventoryPlayer par1InventoryPlayer, TilePowderAggregator tile)
	{
		bindPlayerInventory(par1InventoryPlayer);

		this.player = par1InventoryPlayer.player;
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
				this.addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
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
		Slot slot = (Slot) this.inventorySlots.get(par2);

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
			if (par2 < 36)
			{
				if (TilePowderAggregator.getItemBurnTime(itemstack) > 0)
				{
					if (!this.mergeItemStack(itemstack1, 36, 37, false))
						return null;
					slot.onSlotChange(itemstack1, itemstack);
				}
				else if (par2 < 27)
				{
					if (!this.mergeItemStack(itemstack1, 27, 36, false))
						return null;
					slot.onSlotChange(itemstack1, itemstack);
				}
				else if (par2 > 26 && par2 < 36)
				{
					if (!this.mergeItemStack(itemstack1, 0, 26, false))
						return null;
					slot.onSlotChange(itemstack1, itemstack);
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
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
			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
				return null;
			}
		}
		return itemstack;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void detectAndSendChanges()
	{
		for (ICrafting c : (List<ICrafting>) crafters)
		{
			if (c instanceof Player)
			{
				AggregatorPacket packet = new AggregatorPacket(tileEnt.getEnergyStored(), tileEnt.getBurnTimeLeft(), tileEnt.isBurning);
				SimpleTransmutations.pipeline.sendTo(packet, (EntityPlayerMP) this.player);
			}
		}
		super.detectAndSendChanges();
	}

}
