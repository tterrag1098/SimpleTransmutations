package com.tterrag.simpleTransmutations.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEssenceContainer extends Item
{
	Iterator<Object> iter;

	public ItemEssenceContainer(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName(ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME);
		setMaxStackSize(1);
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOC + ":"
				+ ItemInfo.ESSENCE_CONTAINER_ICON);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME + stack.getItemDamage();
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity)
	{
		if (!(ModItem.hasEssenceNames))
		{
			ModItem.createEssenceNameList();
			for (String s : ModItem.essenceNames)
				System.out.println(s);
		}
		
			iter = EntityList.classToStringMapping.entrySet().iterator();
		int i = 0;
		EntityLivingBase entityLiving;

		if (!player.worldObj.isRemote && entity instanceof EntityLivingBase
				&& ((EntityLivingBase) entity).getHealth() < 3.0F)
		{
			entityLiving = (EntityLivingBase) entity;
			System.out.println(entityLiving.getEntityName());
			System.out.println(entityLiving.getHealth() - 1.0F);
			while (iter.hasNext())
			{
				Entry e = (Entry)iter.next();
                Class c = (Class)e.getKey();
                if(entity.getClass().isAssignableFrom(c))
                {
                	stack.setItemDamage(i);
					break;
				}
				i++;
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}

}
