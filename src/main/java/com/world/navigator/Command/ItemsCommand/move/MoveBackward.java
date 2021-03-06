package com.world.navigator.Command.ItemsCommand.move;

import com.world.navigator.Items.Door;
import com.world.navigator.Items.Room;
import com.world.navigator.Items.Wall;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class MoveBackward extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        try{
            Door door = (Door) player.getOppositeWall();
            MoveChecker moveChecker = new MoveChecker(player, door, request);

            if(!moveChecker.preCheck()) return;

            /*
             * this part to know the direction in new room
             * by calculate the new degree
             */
            Room source = moveChecker.getSourceRoom();
            Room destination = moveChecker.getDestinationRoom();

            for (int i = 0; i < destination.getNumberOfWalls(); ++i) {
                try{
                    Wall wall = destination.getWall(i);

                    Door door2 = (Door) wall;
                    if (door2.getOppositeDirection(destination.getRoomID()) == source.getRoomID()) {
                        int numberOfWalls = destination.getNumberOfWalls();
                        player.setDirection((Integer) (i * 360 / numberOfWalls));
                    }
                }catch(ClassCastException e){
                    continue;
                }
            }

            request.addMessageToResponse("you moved backward");

            moveChecker.postCheck();
        }catch(ClassCastException e){
            request.addMessageToResponse("there should be a door behind you to move backward");
        }
    }
}
