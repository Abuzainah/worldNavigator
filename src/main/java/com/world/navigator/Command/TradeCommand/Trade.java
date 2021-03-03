package com.world.navigator.Command.TradeCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;
import com.world.navigator.Command.PlayerCommand.Quit;

public class Trade extends Command {
    public Trade(){
        addCommand("buy", new TradeBuy());
        addCommand("sell", new TradeSell());
        addCommand("list", new TradeList());
        addCommand("finish", new TradeFinish());
        addCommand("help", new TradeHelp());
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
