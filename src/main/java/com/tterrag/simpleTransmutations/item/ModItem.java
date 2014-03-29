package com.tterrag.simpleTransmutations.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItem
{
	public static boolean hasEssenceNames = false;
	public static ArrayList<String> essenceNames = new ArrayList<String>();

	public static Item tinyGlowstone;
	public static Item glowingRedstone;
	public static Item redstoneGlove;
	public static Item squidTentacle;
	public static Item rawMutton;
	public static Item cookedMutton;
	public static Item smallTentacleBundle;
	public static Item largeTentacleBundle;
	public static Item calamari;
	public static Item smallCalamariPlatter;
	public static Item largeCalamariPlatter;
	public static Item essenceContainer;

	public static void init()
	{
		tinyGlowstone = new ItemTinyGlowstone();
		glowingRedstone = new ItemGlowingRedstone();
		redstoneGlove = new ItemRedstoneGlove();
		squidTentacle = new ItemTentacle();
		rawMutton = new ItemMuttonRaw();
		cookedMutton = new ItemMuttonCooked();
		smallTentacleBundle = new ItemTentacleBundleSmall();
		largeTentacleBundle = new ItemTentacleBundleLarge();
		calamari = new ItemCalamari();
		smallCalamariPlatter = new ItemCalamariPlatterSmall();
		largeCalamariPlatter = new ItemCalamariPlatterLarge();
		essenceContainer = new ItemEssenceContainer();

		registerItems();
	}

	private static void registerItems()
	{
		GameRegistry.registerItem(tinyGlowstone, ItemInfo.SMALL_GLOWING_REDSTONE_UNLOC_NAME);
		GameRegistry.registerItem(glowingRedstone, ItemInfo.GLOWING_REDSTONE_UNLOC_NAME);
		GameRegistry.registerItem(redstoneGlove, ItemInfo.REDSTONE_GLOVE_UNLOC_NAME);
		GameRegistry.registerItem(squidTentacle, ItemInfo.SQUID_TENTACLE_UNLOC_NAME);
		GameRegistry.registerItem(rawMutton, ItemInfo.RAW_MUTTON_UNLOC_NAME);
		GameRegistry.registerItem(cookedMutton, ItemInfo.COOKED_MUTTON_UNLOC_NAME);
		GameRegistry.registerItem(smallTentacleBundle, ItemInfo.SMALL_BUNDLE_UNLOC_NAME);
		GameRegistry.registerItem(largeTentacleBundle, ItemInfo.LARGE_BUNDLE_UNLOC_NAME);
		GameRegistry.registerItem(calamari, ItemInfo.CALAMARI_UNLOC_NAME);
		GameRegistry.registerItem(smallCalamariPlatter, ItemInfo.SMALL_PLATTER_UNLOC_NAME);
		GameRegistry.registerItem(largeCalamariPlatter, ItemInfo.LARGE_PLATTER_UNLOC_NAME);
		GameRegistry.registerItem(essenceContainer, ItemInfo.ESSENCE_CONTAINER_UNLOC_NAME);
	}

	public static void registerRecipes()
	{
		ItemRecipes.addRecipes();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void createEssenceNameList()
	{
		Iterator<Object> iter = EntityList.classToStringMapping.entrySet().iterator();

		String entityLivingName;

		while (iter.hasNext())
		{
			Entry e = (Entry) iter.next();
			entityLivingName = (String) e.getValue();

			essenceNames.add(entityLivingName);
		}

		hasEssenceNames = true;
	}
}
