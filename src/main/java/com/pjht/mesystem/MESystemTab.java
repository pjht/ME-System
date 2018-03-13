package com.pjht.mesystem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MESystemTab extends CreativeTabs {

	public MESystemTab() {
		super(MESystem.modId);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.AIR);
	}


}
