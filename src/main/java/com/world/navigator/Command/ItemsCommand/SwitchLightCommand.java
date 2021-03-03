package com.world.navigator.Command.ItemsCommand;

import com.world.navigator.Items.Room;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class SwitchLightCommand extends Command {
    @Override
    public void execute(Request request) {
        Room room = request.getPlayer().getCurrentRoom();

        if(room.hasLight()){
            if(!room.isLightOn()) {
                room.switchLightOn();
                request.addMessageToResponse("light switched on");
            }
            else {
                room.switchLightOff();
                request.addMessageToResponse("light switched off");
            }
        }else{
            request.addMessageToResponse("there is no light to switch on");
        }
    }
}
