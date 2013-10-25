package com.tterrag.simpleTransmutations.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.tterrag.simpleTransmutations.config.ConfigKeys;
import com.tterrag.simpleTransmutations.item.ItemEssenceContainer;
import com.tterrag.simpleTransmutations.item.ItemInfo;
import com.tterrag.simpleTransmutations.item.ModItem;

public class EntityLivingHandler 
{
	private static boolean usedEssenceContainer = false;
	private ItemStack stack;
	private EntityPlayer player;
	private int damage;
	private String entity;
	
	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if (!event.entity.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntitySquid && ConfigKeys.allowDropTentacles)
				event.entityLiving.dropItem(ItemInfo.SQUID_TENTACLE_ID + 256, (int) (Math.random() * 4 + 1));
			else if (event.entityLiving instanceof EntitySheep && ConfigKeys.allowDropMutton)
				event.entityLiving.dropItem(ItemInfo.RAW_MUTTON_ID + 256, (int) (Math.random() * 2 + 1));
			
			if (usedEssenceContainer)
			{
				System.out.println(damage + " kill event");				
				
				((ItemEssenceContainer) stack.getItem()).setName(stack, entity);
				
				System.out.println(stack.getTagCompound() + " NBT");
				
				usedEssenceContainer = false;
			}
		}
	}
	
	@ForgeSubscribe
	public void onAttackEntityEvent(AttackEntityEvent event)
	{
		if (!event.entityPlayer.worldObj.isRemote && event.target.getEntityName() != null && !usedEssenceContainer)
		{
			System.out.println(event.target.getEntityName());
		
			player = (EntityPlayer) event.entityPlayer;
			
			stack = player.getCurrentEquippedItem();
			 
			if (stack != null && stack.itemID == ItemInfo.ESSENCE_CONTAINER_ID + 256)
			{
				damage = -1;
				for (String s : ModItem.essenceNames)
				{
					if (!usedEssenceContainer)
						damage++;
					if (s.equals(event.target.getEntityName()) && ((EntityLivingBase) event.target).getHealth() < 2F)
					{
						usedEssenceContainer = true;
						System.out.println(s + " event" + "\ndamage: " + damage + ModItem.essenceNames.get(damage));
						entity = s;
					}
				}
			}		
		}
	}
	
	
}
