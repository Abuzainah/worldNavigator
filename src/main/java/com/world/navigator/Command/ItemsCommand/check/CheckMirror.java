package com.world.navigator.Command.ItemsCommand.check;

import com.world.navigator.Items.MirrorWithOneKey;
import com.world.navigator.Items.Key;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class CheckMirror extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Wall wall = player.getFacedWall();

        if(!(wall instanceof MirrorWithOneKey)){
            request.addMessageToResponse("there is no mirror in front of you");
            return;
        }

        MirrorWithOneKey mirror = (MirrorWithOneKey) wall;

        if(mirror.foundKey()){
            Key key = mirror.takeKey();
            player.addItem(key.getName(), key);
            request.addMessageToResponse("The " + key.getName() + " was acquired");
        }
        else request.addMessageToResponse("no item found");
    }
}
