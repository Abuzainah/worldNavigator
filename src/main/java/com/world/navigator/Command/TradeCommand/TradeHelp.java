package com.world.navigator.Command.TradeCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class TradeHelp extends Command {
    @Override
    public void execute(Request request) {
        request.addMessageToResponse("you are in the trade mode");
        request.addMessageToResponse("you can use one of these commands");
        request.addMessageToResponse("list: to list items that seller have");
        request.addMessageToResponse("buy <item number>: to buy an item you can use its number in the list command");
        request.addMessageToResponse("sell <item number>");
        request.addMessageToResponse("finish");
    }
}
