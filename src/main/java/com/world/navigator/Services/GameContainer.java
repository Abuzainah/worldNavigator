package com.world.navigator.Services;

import com.world.navigator.Game.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class GameContainer {
    private HashMap<String, Game> games;

    public GameContainer(){
        games = new HashMap<>();
    }

    public boolean addGameWithAdmin(String gameName, String adminName){
        if(!games.containsKey(gameName)){
            games.put(gameName, new Game());
            games.get(gameName).createMaze();
            games.get(gameName).addPlayer(adminName);
            return true;
        }else{
            return false;
        }
    }

    public String addPlayerToGame(String gameName, String playerName){
        if(didThisGameStart(gameName)){
            return "you can't enter a game that already started";
        }
        else if(games.containsKey(gameName)){
            return games.get(gameName).addPlayer(playerName);
        }else{
            return "wrong game name";
        }
    }

    public boolean didThisGameStart(String gameName){
        if(games.containsKey(gameName)) return games.get(gameName).isStart();
        return false;
    }

    public void startGame(String gameName){
        try{
            games.get(gameName).startGame();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void process(String gameName, String playerName, String command){
        games.get(gameName).process(playerName, command);
    }

    public ArrayList<MessageString> getResult(String gameName, String playerName){
        return games.get(gameName).getResult(playerName);
    }

    public void removePlayer(String game, String player) {
        games.get(game).removePlayer(player);
        if(games.get(game).numberOfPlayers() == 0) games.remove(game);
    }
}
