package com.tterrag.simpleTransmutations.crafting;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

/**
 * @author Archadia
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class NBTMachineRecipes {

	private static NBTMachineRecipes instanceBase = new NBTMachineRecipes();
	
	public static NBTMachineRecipes instance() {
		return instanceBase;
	}
	
	
	public enum Recipe {
		POWDERAGG(new HashMap<Integer, ItemStack>());
		
		public HashMap map;
		public int input;
		
		Recipe(HashMap map) {
			this.map = map;
		}
		
		public ItemStack getResult(int input) {
			ItemStack item = (ItemStack) this.map.get(input);
			if (item == null) {
				return null;
			}
			return (ItemStack)this.map.get(input);
		}
		
		public int getInput() {
			return input;
		}
		
		public void put(int input, Object output) {
			map.put(input, output);
			this.input = input;
		}
	}
	
	 public void addPowderAggRecipe(int input, ItemStack output) {
		 Recipe.POWDERAGG.put(input, output);
	 }
}
