package com.world.navigator.Command.ItemsCommand.UseCommands;

import com.world.navigator.Items.Chest;
import com.world.navigator.Items.Key;
import com.world.navigator.Items.Door;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class UseKey extends Command {
    @Override
    public void execute(Request request) {
        String keyName = request.getArgumentAt(2);
        Player player = request.getPlayer();
        Key key = (Key) player.getItem(keyName);

        if(key != null){
            Wall wall = player.getFacedWall();
            if(wall instanceof Chest){
                if(((Chest) wall).isOpen()) request.addMessageToResponse("the chest is already open");
                else if(((Chest) wall).openChest(key)){
                    request.addMessageToResponse("the chest is now open");
                }else request.addMessageToResponse("can not open this chest using this key");
            }else if(wall instanceof Door){
                if(((Door) wall).isOpen()) request.addMessageToResponse("the door is already open");
                else if(((Door) wall).openDoor(key)){
                    request.addMessageToResponse("the door is now open");
                }else request.addMessageToResponse("can not open this door using this key");
            }else{
                request.addMessageToResponse("there is no door or chest in front of you");
            }
        }else{
            request.addMessageToResponse("there is no such key with you");
        }
    }
}
