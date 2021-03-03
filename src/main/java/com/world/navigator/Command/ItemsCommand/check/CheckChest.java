package com.world.navigator.Command.ItemsCommand.check;

import com.world.navigator.Items.Chest;
import com.world.navigator.Items.Currency;
import com.world.navigator.Items.Flashlight;
import com.world.navigator.Items.Item;
import com.world.navigator.Items.Lock;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class CheckChest extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Wall wall = player.getFacedWall();

        if(!(wall instanceof Chest)){
            request.addMessageToResponse("There is no chest in front of you");
            return;
        }

        Chest chest = (Chest) wall;

        if(chest.isOpen() && chest.isThereItemInChest()){
            Item item = chest.getChestItems().getItem();
            if((item instanceof Lock) || (item instanceof Flashlight)){
                player.addItem(item.toString(), item);
                request.addMessageToResponse(item.toString() + " is looted");
            }else if(item instanceof Currency){
                Currency currency= (Currency) player.getItem(item.toString());
                currency.increase(((Currency) item).getAmount());
                request.addMessageToResponse(((Currency) item).getAmount() + " " + ((Currency) item).toString() + " is looted");
            }
        }else if(!chest.isThereItemInChest()){
            request.addMessageToResponse("nothing to be looted");
        }else{
            request.addMessageToResponse("Chest closed, " + chest.getLockType().toString() + " is needed to unlock");
        }
    }
}
