package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.ArrayList;

public class Maze {
    private final ArrayList<Room> rooms;

    @JsonCreator
    public Maze(@JsonProperty("rooms") ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoomAt(int roomID){
        return rooms.get(roomID);
    }

    public int getNumOfRooms(){
        return rooms.size();
    }
}
