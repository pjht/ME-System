package com.pjht.mesystem.item;

public class ItemBlueprint extends ItemBase {

    public ItemBlueprint(String name) {
        super(name);
        this.setContainerItem(this);
    }
}
