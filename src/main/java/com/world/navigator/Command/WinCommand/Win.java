package com.world.navigator.Command.WinCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class Win extends Command {

    @Override
    public void execute(Request request) {
        request.addMessageToResponse("you won the game");
    }
}
