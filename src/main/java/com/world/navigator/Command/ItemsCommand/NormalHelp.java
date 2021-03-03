package com.world.navigator.Command.ItemsCommand;

import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class NormalHelp extends Command {
    @Override
    public void execute(Request request) {
        request.addMessageToResponse("move {left|right}: to move clockwise or counter-clockwise");
        request.addMessageToResponse("move {forward|backward}: to move between rooms");
        request.addMessageToResponse("check : take one of these arguments");
        request.addMessageToResponse(" - mirror: loot key behind mirror");
        request.addMessageToResponse(" - painting: loot key behind painting");
        request.addMessageToResponse(" - chest: loot one item (gold, flashlight, painting)");
        request.addMessageToResponse(" - door: to check if the door is open or close");
        request.addMessageToResponse("look: to see what in front of you");
        request.addMessageToResponse("trade: to enter trade mood if these is a seller in front of you");
        request.addMessageToResponse("switchlight: to turn on or turn off the room light");
        request.addMessageToResponse("use key <key name>: to open a closed chest or door");
        request.addMessageToResponse("use flashlight: turn on or turn off the flashlight");
        request.addMessageToResponse("playerstatus (this command run in any mode): to show your items, gold and direction");
    }
}
