package com.tterrag.simpleTransmutations.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
		tinyGlowstone = new ItemTinyGlowstone(ItemInfo.SMALL_GLOWING_REDSTONE_ID);
		glowingRedstone = new ItemGlowingRedstone(ItemInfo.GLOWING_REDSTONE_ID);
		redstoneGlove = new ItemRedstoneGlove(ItemInfo.REDSTONE_GLOVE_ID);
		squidTentacle = new ItemTentacle(ItemInfo.SQUID_TENTACLE_ID);
		rawMutton = new ItemMuttonRaw(ItemInfo.RAW_MUTTON_ID);
		cookedMutton = new ItemMuttonCooked(ItemInfo.COOKED_MUTTON_ID);
		smallTentacleBundle = new ItemTentacleBundleSmall(ItemInfo.SMALL_BUNDLE_ID);
		largeTentacleBundle = new ItemTentacleBundleLarge(ItemInfo.LARGE_BUNDLE_ID);
		calamari = new ItemCalamari(ItemInfo.CALAMARI_ID);
		smallCalamariPlatter = new ItemCalamariPlatterSmall(ItemInfo.SMALL_PLATTER_ID);
		largeCalamariPlatter = new ItemCalamariPlatterLarge(ItemInfo.LARGE_PLATTER_ID);
		essenceContainer = new ItemEssenceContainer(ItemInfo.ESSENCE_CONTAINER_ID);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(tinyGlowstone, ItemInfo.SMALL_GLOWING_REDSTONE_LOC_NAME);
		LanguageRegistry.addName(glowingRedstone, ItemInfo.GLOWING_REDSTONE_LOC_NAME);
		LanguageRegistry.instance().addStringLocalization(ItemInfo.REDSTONE_GLOVE_UNLOC_NAME + ".name", ItemInfo.REDSTONE_GLOVE_LOC_NAME);
		LanguageRegistry.instance().addStringLocalization(ItemInfo.ADV_REDSTONE_GLOVE_UNLOC_NAME + ".name", ItemInfo.ADV_REDSTONE_GLOVE_LOC_NAME);
		LanguageRegistry.addName(squidTentacle, ItemInfo.SQUID_TENTACLE_LOC_NAME);
		LanguageRegistry.addName(rawMutton, ItemInfo.RAW_MUTTON_LOC_NAME);
		LanguageRegistry.addName(cookedMutton, ItemInfo.COOKED_MUTTON_LOC_NAME);
		LanguageRegistry.addName(smallTentacleBundle, ItemInfo.SMALL_BUNDLE_LOC_NAME);
		LanguageRegistry.addName(largeTentacleBundle, ItemInfo.LARGE_BUNDLE_LOC_NAME);
		LanguageRegistry.addName(calamari, ItemInfo.CALAMARI_LOC_NAME);
		LanguageRegistry.addName(smallCalamariPlatter, ItemInfo.SMALL_PLATTER_LOC_NAME);
		LanguageRegistry.addName(largeCalamariPlatter, ItemInfo.LARGE_PLATTER_LOC_NAME);
		LanguageRegistry.addName(essenceContainer, ItemInfo.ESSENCE_CONTAINER_LOC_NAME);
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
