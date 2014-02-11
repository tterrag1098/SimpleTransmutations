package com.tterrag.simpleTransmutations;

import net.minecraftforge.common.MinecraftForge;

import com.tterrag.simpleTransmutations.block.ModBlock;
import com.tterrag.simpleTransmutations.config.ConfigHandler;
import com.tterrag.simpleTransmutations.entity.EntityLivingHandler;
import com.tterrag.simpleTransmutations.entity.EntityPlayerHandler;
import com.tterrag.simpleTransmutations.item.ModItem;
import com.tterrag.simpleTransmutations.lib.Reference;
import com.tterrag.simpleTransmutations.network.PacketPipeline;
import com.tterrag.simpleTransmutations.proxy.CommonProxy;
import com.tterrag.simpleTransmutations.tile.ModTile;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class SimpleTransmutations {
		
	@Instance(Reference.MOD_ID)
	public static SimpleTransmutations instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final PacketPipeline pipeline = new PacketPipeline();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModItem.init();
		ModBlock.init();
		ModTile.init();
		
		MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
		MinecraftForge.EVENT_BUS.register(new EntityPlayerHandler());
		
		proxy.initSounds();
		proxy.initRenderers();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		pipeline.initalise();
		
		ModItem.registerRecipes();
		ModBlock.registerRecipes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		pipeline.postInitialise();
	}
}

