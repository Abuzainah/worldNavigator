package com.world.navigator.Command.TradeCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class TradeFinish extends Command {
    @Override
    public void execute(Request request) {
        request.getPlayer().setMode("normal");
        request.addMessageToResponse("you left the trade mode");
    }
}