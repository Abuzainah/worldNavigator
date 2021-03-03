package com.world.navigator.Command.ItemsCommand.check;

import com.world.navigator.Items.PaintingWithOneKey;
import com.world.navigator.Items.Key;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class CheckPainting extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Wall wall = player.getFacedWall();

        if(!(wall instanceof PaintingWithOneKey)){
            request.addMessageToResponse("there is no painting in front of you");
            return;
        }

        PaintingWithOneKey painting = (PaintingWithOneKey) wall;

        if(painting.foundKey()){
            Key key = painting.takeKey();
            player.addItem(key.getName(), key);
            request.addMessageToResponse("The " + key.getName() + " was acquired");
        }
        else request.addMessageToResponse("no item found");
    }
}
