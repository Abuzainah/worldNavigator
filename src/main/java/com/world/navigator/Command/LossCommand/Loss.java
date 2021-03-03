package com.world.navigator.Command.LossCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class Loss extends Command {
    @Override
    public void execute(Request request) {
        request.addMessageToResponse("you lost the game");
    }
}
