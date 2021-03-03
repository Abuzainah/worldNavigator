package com.world.navigator.Command.FightCommands;

import java.util.HashMap;

class FightFactory {

    private static HashMap<String, FightByHand> fights = new HashMap<>();

    public static FightByHand get(String playerName, String enemyName){
        if(fights.containsKey(playerName))
            return fights.get(playerName);

        else{
            FightByHand fightByHand = new FightByHand(playerName, enemyName);
            fights.put(playerName, fightByHand);
            fights.put(enemyName, fightByHand);

            return fightByHand;
        }
    }

    public static void remove(String myName, String enemyName){
        fights.remove(myName);
        fights.remove(enemyName);
    }
}
