package com.tterrag.simpleTransmutations;

import com.tterrag.simpleTransmutations.block.ModBlock;
import com.tterrag.simpleTransmutations.item.ModItem;
import com.tterrag.simpleTransmutations.lib.Reference;
import com.tterrag.simpleTransmutations.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class SimpleTransmutations {
		
	@Instance(Reference.MOD_ID)
	public static SimpleTransmutations instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModItem.init();
		ModBlock.init();
		

		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModItem.addNames();		
		ModItem.registerRecipes();
		ModBlock.addNames();
		//ModBlock.registerRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

