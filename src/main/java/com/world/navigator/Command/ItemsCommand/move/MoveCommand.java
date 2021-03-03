package com.world.navigator.Command.ItemsCommand.move;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class MoveCommand extends Command {

    public MoveCommand(){
        addCommand("right", new MoveRight());
        addCommand("left", new MoveLeft());
        addCommand("forward", new MoveForward());
        addCommand("backward", new MoveBackward());
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
