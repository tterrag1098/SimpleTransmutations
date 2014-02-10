package com.tterrag.simpleTransmutations.block;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import com.tterrag.simpleTransmutations.crafting.NBTRecipe;
import com.tterrag.simpleTransmutations.crafting.NBTRecipeHandler;
import com.tterrag.simpleTransmutations.item.ModItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRecipes
{
	public static void addRecipes()
	{
		NBTRecipeHandler handler = new NBTRecipeHandler();
		GameRegistry.addRecipe((IRecipe)new NBTRecipe(new ItemStack(ModBlock.powderAggregator), "Blaze", new Object[] {
			"bgb",
			"tEt",
			"ofo",
			
			'b', Items.blaze_powder,
			'g', Blocks.glowstone,
			't', Items.ghast_tear,
			'E', ModItem.essenceContainer,
			'o', Blocks.obsidian,
			'f', Blocks.furnace
		}));
	}
}
