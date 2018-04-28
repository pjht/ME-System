package com.pjht.mesystem.item;


import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	public static Map<String,ItemBase> items = new HashMap<String,ItemBase>();
	
	public static void init() {
		registerItem("8080_chip");
		registerItem("8080_ic");
		registerItem("8080_pcb_blank");
		registerItem("8080_pcb");
		registerItemBlueprint("8080_blueprint");
		registerItemBlueprint("8080_pcb_blueprint");
		registerItem("8k_sram_ic");
		registerItem("8k_sram_chip");
		registerItemBlueprint("8k_sram_blueprint");
		registerItem("comparator_chip");
		registerItem("comparator_ic");
		registerItemBlueprint("comparator_blueprint");
		//NEXT ITEM HERE
	}
	
	public static void register(IForgeRegistry<Item> registry) {
		for (ItemBase item: items.values()) {
		    registry.register(item);
		}
	}
	
	public static void registerModels() {
		for (ItemBase item: items.values()) {
		    item.registerItemModel();
		}
	}
	
	private static void registerItem(String name) { 
		items.put(name, new ItemBase(name));
	}
	
    private static void registerItemBlueprint(String name) { 
        items.put(name, new ItemBlueprint(name));
    }

	private static void registerOredict(String name, String oredict) {
		items.put(name, new ItemOre(name,oredict));
	}
	
	private static void registerFuel(String name, String fuelName, int burnTime) {
		items.put(name, new ItemFuel(name, fuelName, burnTime));
	}

	public static void initOreDict() {
		for (ItemBase item: items.values()) {
			if (item.isOredict()) {
				item.initOreDict();
			}
		}
	}
}