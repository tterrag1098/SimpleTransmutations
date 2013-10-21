package com.tterrag.simpleTransmutations.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEssenceContainer extends Item
{
	public ItemEssenceContainer(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
	}
}
