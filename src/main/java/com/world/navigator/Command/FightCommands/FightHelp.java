package com.world.navigator.Command.FightCommands;

import com.world.navigator.Command.Command;
import com.world.navigator.Game.Request;

class FightHelp extends Command {
    @Override
    public void execute(Request request) {
        request.addMessageToResponse("you can fight your enemy by enter \"hand\" command with one of its arguments");
        request.addMessageToResponse("hand {rock|paper|scissor}");
        request.addMessageToResponse("or you can write this command \"hand check\" to check the result");
    }
}
