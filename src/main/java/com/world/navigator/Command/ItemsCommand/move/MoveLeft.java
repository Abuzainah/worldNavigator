package com.world.navigator.Command.ItemsCommand.move;

import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class MoveLeft extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        int unitSize = 360 / player.getCurrentRoom().getNumberOfWalls();

        double oldDirection = player.getDirection();
        double newDirection = oldDirection - unitSize;

        if(newDirection >= 0) player.setDirection(newDirection);
        else player.setDirection(360 + newDirection);

        String message = "you moved left";
        request.addMessageToResponse(message);
    }
}
