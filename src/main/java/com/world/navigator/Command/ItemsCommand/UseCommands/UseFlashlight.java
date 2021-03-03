package com.world.navigator.Command.ItemsCommand.UseCommands;

import com.world.navigator.Items.Flashlight;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class UseFlashlight extends Command {
    @Override
    public void execute(Request request) {
        Flashlight flashlight = (Flashlight) request.getPlayer().getItem("flashlight");

        if (flashlight != null) {
            if (flashlight.isOn()) {
                flashlight.switchOff();
                request.addMessageToResponse("flashlight is off");
            } else {
                flashlight.switchOn();
                request.addMessageToResponse("flashlight is on");
            }
        }else{
            request.addMessageToResponse("there is no flashlight to use");
        }

    }
}
