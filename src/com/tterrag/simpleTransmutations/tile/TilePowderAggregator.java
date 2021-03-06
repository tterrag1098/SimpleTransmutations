package com.tterrag.simpleTransmutations.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import universalelectricity.prefab.network.IPacketReceiver;

import com.google.common.io.ByteArrayDataInput;
import com.tterrag.simpleTransmutations.config.ConfigKeys;

import cpw.mods.fml.common.registry.GameRegistry;

public class TilePowderAggregator extends TileEntity implements IPacketReceiver, ISidedInventory
{
	public ItemStack[] inventory = new ItemStack[2];
	public int energyStored;
	private long worldTime, prevWorldTime = -1;
	public static int maxEnergy = 1000;
	public int burnTimeLeft = 0;
	public boolean isBurning = false;
	private float currentLight;
	private int currentItemBurnTime;

	public TilePowderAggregator()
	{

	}

	public static int getItemBurnTime(ItemStack par0ItemStack)
	{
		if (par0ItemStack == null)
		{
			return 0;
		}
		else
		{
			int i = par0ItemStack.getItem().itemID;
			Item item = par0ItemStack.getItem();

			if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
			{
				Block block = Block.blocksList[i];

				if (block == Block.woodSingleSlab)
				{
					return 150;
				}

				if (block.blockMaterial == Material.wood)
				{
					return 300;
				}

				if (block == Block.coalBlock)
				{
					return 16000;
				}
			}

			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
				return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
				return 200;
			if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD"))
				return 200;
			if (i == Item.stick.itemID)
				return 100;
			if (i == Item.coal.itemID)
				return 1600;
			if (i == Item.bucketLava.itemID)
				return 20000;
			if (i == Block.sapling.blockID)
				return 100;
			if (i == Item.blazeRod.itemID)
				return 2400;
			return GameRegistry.getFuelValue(par0ItemStack);
		}
	}

	public void updateEntity()
	{
		super.updateEntity();

		if (worldObj.getLightBrightness(xCoord, yCoord, zCoord) < 0.8F)
			worldObj.updateAllLightTypes(xCoord, yCoord, zCoord);

		if (!worldObj.isRemote && ((inventory[1] != null && inventory[1].stackSize < 64) || inventory[1] == null))
		{
			currentLight = worldObj.getLightBrightness(xCoord, yCoord + 1, zCoord) * 15;
			worldTime = worldObj.getWorldTime();

			if (prevWorldTime == -1)
				prevWorldTime = worldTime;
			
			if ((worldTime) % 20 == 0 && worldTime != prevWorldTime && ConfigKeys.doesProducePassively)
			{
				// Confusing line, this adds the current light of the block
				// (divided by 2.5) multiplied by the config value, times a
				// constant 2 if the block can see the sun, giving the player an
				// advantage if the block can see the sky.
				setEnergyStored((int) Math.round(getEnergyStored() + ((currentLight / 2.5) * ConfigKeys.productionInSunlight) * (worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) ? 2 : 1)));
				
				prevWorldTime = worldTime;
			}

			if ((inventory[0] != null && getItemBurnTime(inventory[0]) > 0) || isBurning)
			{
				if (isBurning)
				{
					burnTimeLeft -= 3;
					if (worldObj.getWorldTime() % 20 == 10)
						setEnergyStored(getEnergyStored() + (int) Math.round(15 * ConfigKeys.productionFromFuel));
				}
				else if (inventory[0].stackSize >= 0)
				{
					isBurning = true;
					currentItemBurnTime = getItemBurnTime(inventory[0]);
					burnTimeLeft = getItemBurnTime(inventory[0]);
					
					if (inventory[0].stackSize > 1)
						inventory[0].stackSize--;
					else
						inventory[0] = null;
				}
				if (burnTimeLeft <= 0)
					isBurning = false;
			}
		}
		if (energyStored >= 1000)
		{
			fabricateOutput();
			setEnergyStored(getEnergyStored() - 1000);
		}
	}

	public void fabricateOutput()
	{
		ItemStack stack = new ItemStack(Item.blazePowder);

		if (inventory[1] == null)
		{
			inventory[1] = stack.copy();
		}
		else if (inventory[1].isItemEqual(stack) && inventory[1].stackSize < 64)
		{
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
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return this.inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j)
	{
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
	public ItemStack getStackInSlotOnClosing(int i)
	{
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
	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		this.inventory[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
		{
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName()
	{
		return "PowderAgg";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}

	@Override
	public void openChest()
	{
		// Do Nothing
	}

	@Override
	public void closeChest()
	{
		// Do Nothing
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return (i == 0 && getItemBurnTime(itemstack) > 0);
	}

	@Override
	public void handlePacketData(INetworkManager network, int packetType, Packet250CustomPayload packet, EntityPlayer player, ByteArrayDataInput dataStream)
	{
		this.energyStored = dataStream.readInt();
	}

	public int getBurnTimeLeft()
	{
		if (currentItemBurnTime > 0)
		{
			int returnVal = (int) Math.round((Math.abs(burnTimeLeft - currentItemBurnTime) / (currentItemBurnTime / 12)));
			if (returnVal != 0)
				return returnVal;
			else
				return -1;
		}
		else
			return -1;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return var1 == 1 || var1 == 2 || var1 == 4 ? new int[] { 0 } : new int[] { 1 };
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j)
	{
		return j == 1 || j == 2 || j == 4;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i)
		{
			if (this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		tag.setTag("Items", nbttaglist);

		tag.setInteger("energyStored", energyStored);
		tag.setLong("prevWorldTime", prevWorldTime);
		tag.setInteger("burnTimeLeft", burnTimeLeft);
		tag.setBoolean("isBurning", isBurning);
		tag.setInteger("currentItemBurnTime", currentItemBurnTime);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);

		NBTTagList nbttaglist = tag.getTagList("Items");
		this.inventory = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.inventory.length)
			{
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		energyStored = tag.getInteger("energyStored");
		prevWorldTime = tag.getLong("prevWorldTime");
		burnTimeLeft = tag.getInteger("burnTimeLeft");
		isBurning = tag.getBoolean("isBurning");
		currentItemBurnTime = tag.getInteger("currentItemBurnTime");
	}

}
