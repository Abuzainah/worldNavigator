package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Door extends Wall {
    private Passage passage;

    @JsonCreator
    public Door(
            @JsonProperty("passage") Passage passage
    ){
        this.passage = passage;
    }

    public int getOppositeDirection(int side){
        if(side == passage.getSide1()) return passage.getSide2();
        else return passage.getSide1();
    }

    public Key getKey(){
        return (Key) passage.getLock();
    }

    public boolean isOpen(){
        return passage.isOpen();
    }

    public boolean openDoor(Lock lock){
        return passage.openPassage(lock);
    }

    @Override
    public String toString() {
        return "door";
    }
}
