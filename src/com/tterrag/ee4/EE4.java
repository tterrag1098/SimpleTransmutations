package com.tterrag.ee4;

import com.tterrag.ee4.item.ModItem;
import com.tterrag.ee4.lib.Reference;
import com.tterrag.ee4.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class EE4 {
		
	@Instance(Reference.MOD_ID)
	public static EE4 instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModItem.init();
		

		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModItem.addNames();		
		ModItem.registerRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

