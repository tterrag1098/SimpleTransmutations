package com.tterrag.simpleTransmutations.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ItemRedstoneGlove extends Item{
	
	public ItemRedstoneGlove (int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.REDSTONE_GLOVE_UNLOC_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":" + ItemInfo.REDSTONE_GLOVE_ICON);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) 
	{
		float rot = player.getRotationYawHead();
		System.out.println(rot);
		return false;
	}
}
