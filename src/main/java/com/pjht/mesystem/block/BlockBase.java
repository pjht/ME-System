package com.pjht.mesystem.block;

import com.pjht.mesystem.MESystem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;

public class BlockBase extends Block {

	protected String name;

	public BlockBase(Material material, String name) {
		super(material);
	
		this.name = name;
	
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MESystem.creativeTab);
	}
	
	public void registerItemModel(Item itemBlock) {
		MESystem.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	public Boolean isTileEntity() {
		return false;
	}

	public Boolean isOredict() {
		return false;
	}
	
	public Class<? extends TileEntity> getTileEntityClass() {
		return null;
	}

	public void initOreDict() {
	}
} 