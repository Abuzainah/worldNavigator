package com.world.navigator.Game;

import com.world.navigator.Items.Maze;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Request {
    @Setter @Getter
    private Game game;
    @Setter @Getter
    private Player player;
    @Setter @Getter
    private Maze maze;
    private String[] commands;
    private ArrayList<String> response = new ArrayList<>();


    public String getArgumentAt(int index) {
        if(index >= commands.length) return null;
        return commands[index];
    }

    public void splitCommandToArguments(String command) {
        this.commands = command.split("\\s+");
    }

    public void addMessageToResponse(String message){
        response.add(message);
    }

    public void clearResponse(){
        response.clear();
    }

    public ArrayList<String> getResponse(){
        return response;
    }
}
