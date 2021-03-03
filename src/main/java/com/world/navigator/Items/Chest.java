package com.world.navigator.Items;

import com.world.navigator.Strategies.OpenMethod;

public abstract class Chest extends Wall{
    private Lock lockType;
    private OpenMethod openMethod;
    private Content contents;
    private boolean open;
    private boolean areItemsCollected = false;

    public Chest(Lock lockType, OpenMethod openMethod, Content contents, boolean open) {
        this.lockType = lockType;
        this.openMethod = openMethod;
        this.contents = contents;
        this.open = open;
    }

    public boolean isOpen(){
        return open;
    }

    public Lock getLockType() {
        return lockType;
    }

    public boolean openChest(Lock lock){
        open = openMethod.isMatch(lock, lockType);
        return open;
    }

    public Content getChestItems(){
        if(open && !areItemsCollected) {
            areItemsCollected = true;
            return contents;
        }
        return null;
    }

    public boolean isThereItemInChest(){
        return !areItemsCollected;
    }
}
