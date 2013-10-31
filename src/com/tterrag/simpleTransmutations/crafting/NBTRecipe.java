package com.tterrag.simpleTransmutations.crafting;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author Archadia
 *
 */
public class NBTRecipe implements IRecipe {

	public static final int GRID_HEIGHT = 3;
	public static final int GRID_WIDTH = 3;

    private ItemStack output = null;
    private Object[] input = null;
    
    private String nbtName;
    
    private int width = 0;
    private int height = 0;
    
    private boolean mirrored = true;
	
    public NBTRecipe(ItemStack result, String name, Object... recipe)
    {
        output = result.copy();
        
        nbtName = name;
        
        String shape = "";
        int idx = 0;

        if(recipe[idx] instanceof Boolean)
        {
            mirrored = (Boolean)recipe[idx];
            
            if(recipe[idx+1] instanceof Object[])
            {
                recipe = (Object[])recipe[idx+1];
            }
            else {
                idx = 1;
            }
        }

        if(recipe[idx] instanceof String[])
        {
            String[] parts = ((String[])recipe[idx++]);

            for(String s : parts)
            {
                width = s.length();
                shape += s;
            }

            height = parts.length;
        }
        else {
            while(recipe[idx] instanceof String)
            {
                String s = (String)recipe[idx++];
                shape += s;
                width = s.length();
                height++;
            }
        }

        if(width * height != shape.length())
        {
            String ret = "Invalid shaped ore recipe: ";
            
            for(Object tmp :  recipe)
            {
                ret += tmp + ", ";
            }
            
            ret += output;
            
            throw new RuntimeException(ret);
        }

        HashMap<Character, Object> itemMap = new HashMap<Character, Object>();

        for(; idx < recipe.length; idx += 2)
        {
            Character chr = (Character)recipe[idx];
            Object in = recipe[idx + 1];

            if(in instanceof ItemStack)
            {
                itemMap.put(chr, ((ItemStack)in).copy());
            }
            else if(in instanceof Item)
            {
                itemMap.put(chr, new ItemStack((Item)in));
            }
            else if(in instanceof Block)
            {
                itemMap.put(chr, new ItemStack((Block)in));
            }
            else if(in instanceof String)
            {
                itemMap.put(chr, OreDictionary.getOres((String)in));
            }
            else {
                String ret = "Invalid shaped ore recipe: ";
                
                for(Object tmp :  recipe)
                {
                    ret += tmp + ", ";
                }
                
                ret += output;
                throw new RuntimeException(ret);
            }
        }

        input = new Object[width * height];
        int x = 0;
        
        for(char chr : shape.toCharArray())
        {
            input[x++] = itemMap.get(chr);
        }
    }
	
    @Override
    public boolean matches(InventoryCrafting inv, World world)
    {
        for(int x = 0; x <= GRID_WIDTH - width; x++)
        {
            for(int y = 0; y <= GRID_HEIGHT - height; ++y)
            {
                if(checkMatch(inv, x, y, true))
                {
                    return true;
                }

                if(mirrored && checkMatch(inv, x, y, false))
                {
                    return true;
                }
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
	private boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror)
    {
        for(int x = 0; x < GRID_WIDTH; x++)
        {
            for(int y = 0; y < GRID_HEIGHT; y++)
            {
                int subX = x - startX;
                int subY = y - startY;
                Object target = null;

                if(subX >= 0 && subY >= 0 && subX < width && subY < height)
                {
                    if(mirror)
                    {
                        target = input[width - subX - 1 + subY * width];
                    }
                    else {
                        target = input[subX + subY * width];
                    }
                }

                ItemStack slot = inv.getStackInRowAndColumn(x, y);

                if(target instanceof ItemStack)
                {
                    if(!checkItemEquals((ItemStack)target, slot))
                    {
                        return false;
                    }
                }
                else if(target instanceof ArrayList)
                {
                    boolean matched = false;

                    for(ItemStack item : (ArrayList<ItemStack>)target)
                    {
                        matched = matched || checkItemEquals(item, slot);
                    }

                    if(!matched)
                    {
                        return false;
                    }
                }
                else if(target == null && slot != null)
                {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkItemEquals(ItemStack target, ItemStack input)
    {
        if(input == null && target != null || input != null && target == null)
        {
            return false;
        }
        else if(input == null && target == null)
        {
                return true;
        }
        
        if(target.itemID != input.itemID)
        {
                return false;
        }
        
        if(target == input) {
        	return true;
        }
        
        return true;
    }

    public NBTRecipe setMirrored(boolean mirror)
    {
        mirrored = mirror;
        return this;
    }

    public Object[] getInput()
    {
        return input;
    }

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
        ItemStack result = output.copy();
        
        for(int i = 0; i < 9; i++) {
        	ItemStack invSlot = inventory.getStackInSlot(i);
        	if(invSlot != null) {
        		System.out.println(invSlot.getTagCompound().getString("Contains: ") + " Crafting Handler *************");
        		if(nbtName.compareTo(invSlot.getTagCompound().getString("Contains: ")) == 0) {
        	        return result;
        		}
        	}
        }
        return null;
	}

	@Override
	public int getRecipeSize() {
        return input.length;
	}

	@Override
	public ItemStack getRecipeOutput() {
        return output; 
	}

}
