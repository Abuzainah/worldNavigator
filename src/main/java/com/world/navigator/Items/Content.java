package com.world.navigator.Items;

public abstract class Content {
    private Item item;

    public Content(Item item) {
        this.item = item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
