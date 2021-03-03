package com.world.navigator.Command.ItemsCommand.check;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class CheckCommand extends Command {

    public CheckCommand(){
        addCommand("door", new CheckDoor());
        addCommand("chest", new CheckChest());
        addCommand("painting", new CheckPainting());
        addCommand("mirror", new CheckMirror());
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
