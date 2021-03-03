package com.world.navigator.Command.ItemsCommand.look;

import com.world.navigator.Items.Flashlight;
import com.world.navigator.Items.Room;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class LookCommand extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Flashlight flashlight = (Flashlight) player.getItem("flashlight");

        Room room = player.getCurrentRoom();

        if((flashlight != null && flashlight.isOn()) || room.isLightOn())
            request.addMessageToResponse(player.getFacedWall().toString());
        else request.addMessageToResponse("Dark");
    }
}
