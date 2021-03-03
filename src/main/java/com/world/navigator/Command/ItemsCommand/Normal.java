package com.world.navigator.Command.ItemsCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;
import com.world.navigator.Command.PlayerCommand.Quit;
import com.world.navigator.Command.ItemsCommand.check.CheckCommand;
import com.world.navigator.Command.ItemsCommand.look.LookCommand;
import com.world.navigator.Command.ItemsCommand.move.MoveCommand;
import com.world.navigator.Command.ItemsCommand.UseCommands.UseCommand;

public class Normal extends Command {

    public Normal(){
        addCommand("use", new UseCommand());
        addCommand("check", new CheckCommand());
        addCommand("look", new LookCommand());
        addCommand("move", new MoveCommand());
        addCommand("switchlight", new SwitchLightCommand());
        addCommand("help", new NormalHelp());
        addCommand("trade", new TradeCommand());
        addCommand("quit", new Quit());
    }

    @Override
    public void execute(Request request) {
        int argumentIndex = 0;
        Command nextHandler = getCommand(request.getArgumentAt(argumentIndex));
        if(nextHandler == null){
            request.addMessageToResponse("invalid command");
        }else{
            nextHandler.execute(request);
        }
    }
}
