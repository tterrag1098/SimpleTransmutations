package com.tterrag.simpleTransmutations.crafting;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Archadia
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class NBTMachineRecipes
{

	private static NBTMachineRecipes instanceBase = new NBTMachineRecipes();

	public static NBTMachineRecipes instance()
	{
		return instanceBase;
	}

	public enum Recipe
	{
		POWDERAGG(new HashMap<Item, ItemStack>());

		public HashMap map;
		public Item input;

		Recipe(HashMap map)
		{
			this.map = map;
		}

		public ItemStack getResult(int input)
		{
			ItemStack item = (ItemStack) this.map.get(input);
			if (item == null)
			{
				return null;
			}
			return (ItemStack) this.map.get(input);
		}

		public Item getInput()
		{
			return input;
		}

		public void put(Item input, Object output)
		{
			map.put(input, output);
			this.input = input;
		}
	}

	public void addPowderAggRecipe(Item input, ItemStack output)
	{
		Recipe.POWDERAGG.put(input, output);
	}
}
