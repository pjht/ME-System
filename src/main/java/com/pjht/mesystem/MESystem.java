package com.pjht.mesystem;

import com.pjht.mesystem.block.ModBlocks;
import com.pjht.mesystem.item.ModItems;
import com.pjht.mesystem.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MESystem.modId, name = MESystem.name, version = MESystem.version)
public class MESystem {
	public static final String modId = "mesystem";
	public static final String name = "ME System addon for SSSP";
	public static final String version = "1.0.0";

	@Mod.Instance(modId)
	public static MESystem instance;

	@SidedProxy(serverSide = "com.pjht.mesystem.proxy.CommonProxy", clientSide = "com.pjht.mesystem.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final MESystemTab creativeTab = new MESystemTab();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
		ModItems.init();
		ModBlocks.init();
	}
	

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModItems.initOreDict();
		ModBlocks.initOreDict();
		ModRecipes.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerItemModels();
		}
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
	}
	
}
