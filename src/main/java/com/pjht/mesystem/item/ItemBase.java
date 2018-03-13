package com.pjht.mesystem.item;

import com.pjht.mesystem.MESystem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MESystem.creativeTab);
	}
	
	public void registerItemModel() {
		MESystem.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	public Boolean isOredict() {
		return false;
	}

	public void initOreDict() {
	}
}
