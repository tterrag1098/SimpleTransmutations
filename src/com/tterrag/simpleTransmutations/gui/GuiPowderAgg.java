package com.tterrag.simpleTransmutations.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.tterrag.simpleTransmutations.block.BlockInfo;
import com.tterrag.simpleTransmutations.container.ContainerPowderAgg;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

/**
 * @author Archadia
 *
 */
public class GuiPowderAgg extends GuiContainer {
	
	@SuppressWarnings("unused")
    private TilePowderAggregator tileINV;
    
    public GuiPowderAgg(InventoryPlayer par1InventoryPlayer, TilePowderAggregator tile) {
        super(new ContainerPowderAgg(par1InventoryPlayer, tile));
        this.tileINV = tile;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = BlockInfo.POWDER_AGGREGATOR_LOC_NAME;
        this.fontRenderer.drawString(s, this.xSize / 7, 7, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GuiInfo.TEXTURE_LOC, GuiInfo.AGGREGATOR_GUI_TEXTURE));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
              
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1 = tileINV.getProgress(12);
        
        //System.out.println(tileINV.getProgress(12));
        this.drawTexturedModalRect(k + 77, l + 34, 176, 250, 27, 200);
    }
}
