package com.tterrag.simpleTransmutations;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.tterrag.simpleTransmutations.container.ContainerPowderAgg;
import com.tterrag.simpleTransmutations.tile.TilePowderAggregator;

/**
 * @author Archadia
 *
 */
public class GuiPowderAgg extends GuiContainer {
	
    private static TilePowderAggregator tileINV = new TilePowderAggregator();
    
    public GuiPowderAgg(InventoryPlayer par1InventoryPlayer, TilePowderAggregator tile) {
        super(new ContainerPowderAgg(par1InventoryPlayer, tile));
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = this.tileINV.isInvNameLocalized() ? this.tileINV.getInvName() : I18n.getString(this.tileINV.getInvName());
        this.fontRenderer.drawString(s, this.xSize / 2 + 44, 7, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation("***","textures/gui/***.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
