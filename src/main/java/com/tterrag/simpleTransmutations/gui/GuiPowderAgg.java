package com.tterrag.simpleTransmutations.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.container.ContainerPowderAgg;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

public class GuiPowderAgg extends GuiContainer
{
	@SuppressWarnings("unused")
	private TilePowderAggregator tileINV;
	public int energyStored;
	public int burnProgress;
	public boolean isBurning = false;

	public GuiPowderAgg(InventoryPlayer par1InventoryPlayer, TilePowderAggregator tile)
	{
		super(new ContainerPowderAgg(par1InventoryPlayer, tile));
		this.tileINV = tile;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = BlockInfo.POWDER_AGGREGATOR_LOC_NAME;
		this.fontRendererObj.drawString(s, this.xSize / 7, 7, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GuiInfo.TEXTURE_LOC, GuiInfo.AGGREGATOR_GUI_TEXTURE));
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		// Current max is 1000, if changed the number multiplied must be changed
		// to the correct factor of 1000.
		this.drawTexturedModalRect(k + 77, l + 34, 176, 250, 0 + (int) (energyStored / 41.25) * 1, 16);

		if (isBurning)
			this.drawTexturedModalRect(k + 56, l + 57 + burnProgress, 176, 11 + burnProgress, 16, 27);
	}

	public int getXSize()
	{
		return this.xSize;
	}
}
