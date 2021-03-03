package com.world.navigator.Command.ItemsCommand;

import com.world.navigator.Items.Seller;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

public class TradeCommand extends Command {

    @Override
    public void execute(Request request) {
        if(request.getPlayer().getFacedWall() instanceof Seller) {
            request.getPlayer().setMode("trade");
            request.addMessageToResponse("you are in the trade mode");
        }else{
            request.addMessageToResponse("there is no seller in front of you");
        }
    }
}
