package com.world.navigator.Command.ItemsCommand.UseCommands;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class UseCommand extends Command {

    public UseCommand(){
        addCommand("key", new UseKey());
        addCommand("flashlight", new UseFlashlight());
    }

    @Override
    public void execute(Request request) {
        int argumentIndex = 1;
        Command nextHandler = getCommand(request.getArgumentAt(argumentIndex));
        if(nextHandler == null){
            request.addMessageToResponse("invalid command");
        }else{
            nextHandler.execute(request);
        }
    }

}
