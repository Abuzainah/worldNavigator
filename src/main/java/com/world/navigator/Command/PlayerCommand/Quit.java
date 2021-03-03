package com.world.navigator.Command.PlayerCommand;

import com.world.navigator.Game.Game;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Items.Currency;
import com.world.navigator.Items.Item;
import com.world.navigator.Items.Room;
import com.world.navigator.Command.Command;

import java.util.HashMap;
import java.util.Map;

public class Quit extends Command {

    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Room room = player.getCurrentRoom();
        HashMap<String, Item> items = player.getAllItems();
        Game game = request.getGame();

        for(Map.Entry<String, Item> i:items.entrySet()){
            if(i.getValue() instanceof Currency){
                game.distributeCurrency(player, (Currency) i.getValue());
            }else{
                room.putItemOnFloor(i.getValue());
                player.removeItem(i.getKey());
            }
        }
        room.getPlayers().remove(player);
    }
}
