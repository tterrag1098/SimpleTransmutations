package com.tterrag.simpleTransmutations.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEssenceContainer extends Item
{
	public ItemEssenceContainer(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME);
		setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":"
				+ ItemInfo.ESSENCE_CONTAINER_ICON);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity)
	{
		EntityLivingBase entityLiving;
		if (!player.worldObj.isRemote && entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getHealth() > 0)
		{
			entityLiving = (EntityLivingBase) entity;
			entityLiving.attackEntityFrom(null, 2);
			System.out.println(entityLiving.getEntityName());
			System.out.println(entityLiving.getHealth());
		}		
		return super.onLeftClickEntity(stack, player, entity);
	}
}
