package com.world.navigator.Command.PlayerCommand;

import com.world.navigator.Items.Currency;
import com.world.navigator.Items.Item;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

import java.util.HashMap;
import java.util.Map;

public class PlayerStatus extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();

        request.addMessageToResponse("mode = " + player.getMode());
        request.addMessageToResponse("direction = " + player.getDirection());
        request.addMessageToResponse("room = " + player.getCurrentRoom().getRoomID());

        HashMap<String, Item> items = player.getAllItems();

        for(Map.Entry<String, Item> entry : items.entrySet()){
            if(entry.getValue() instanceof Currency)
                request.addMessageToResponse(entry.getKey() + " = " + ((Currency) entry.getValue()).getAmount());
        }

        for(Map.Entry<String, Item> entry : items.entrySet()){
            if(!(entry.getValue() instanceof Currency))
                request.addMessageToResponse(entry.getKey());
        }
    }
}
