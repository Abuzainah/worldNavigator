package com.world.navigator.Command;

import com.world.navigator.Game.Request;

import java.util.HashMap;

public abstract class Command {
    private HashMap nextLevel = new HashMap<String, Command>();

    public void addCommand(String name, Command command){
        nextLevel.put(name, command);
    }

    public Command getCommand(String name){
        return (Command) nextLevel.get(name);
    }

    public abstract void execute(Request request);
}
