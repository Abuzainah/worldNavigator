package com.world.navigator.Command.ItemsCommand.check;

import com.world.navigator.Items.Door;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class CheckDoor extends Command {
    @Override
    public void execute(Request request) {
        Wall wall = request.getPlayer().getFacedWall();

        if(!(wall instanceof Door)){
            request.addMessageToResponse("there is no door in front of you");
            return;
        }
        Door door = (Door) wall;

        if(door.isOpen()){
            request.addMessageToResponse("Door is open");
        }else{
            request.addMessageToResponse("Door is locked, " + door.getKey().toString() + " is needed to unlock");
        }
    }
}
