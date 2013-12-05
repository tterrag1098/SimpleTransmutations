package com.tterrag.simpleTransmutations.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
		GameRegistry.addRecipe((IRecipe)new NBTRecipe(new ItemStack(GioMod.powderAggregator), "Blaze", new Object[] {
			"bgb",
			"tEt",
			"ofo",
			
			'b', Item.blazePowder,
			'g', Block.glowStone,
			't', Item.ghastTear,
			'E', ModItem.essenceContainer,
			'o', Block.obsidian,
			'f', Block.furnaceIdle
		}));
	}
}
