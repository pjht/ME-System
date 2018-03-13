package com.pjht.mesystem.item;

import net.minecraft.item.ItemStack;

public class ItemFuel extends ItemBase {
    
    public String fuelName;
    public int burnTime;

    public ItemFuel(String name, String fuelName, int burnTime) {
        super(name);
        
        this.fuelName = fuelName;
        this.burnTime = burnTime;
    }
    
    public int getItemBurnTime(ItemStack itemStack) {
        return burnTime;
    }    
    
}
