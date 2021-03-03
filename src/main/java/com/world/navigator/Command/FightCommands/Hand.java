package com.world.navigator.Command.FightCommands;

import com.world.navigator.Command.Command;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;

class Hand extends Command {
    private Player player;
    private Player enemy;
    private Player winner;
    private Player loser;

    public void setFighters(Player player, Player enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public Player getWinner(){
        return winner;
    }

    public Player getLoser(){
        return loser;
    }

    @Override
    public void execute(Request request) {
        FightByHand fightByHand= FightFactory.get(player.getName(), enemy.getName());
        String hand = request.getArgumentAt(1);

        if(hand.equals("check")){
            checkResult(request, fightByHand);
            return;
        }
        if(!fightByHand.getHand(player.getName()).equals("")) {
            request.addMessageToResponse("you have already played");
            return;
        }
        if(hand.equals("rock") || hand.equals("paper") || hand.equals("scissor")){
            fightByHand.putHand(player.getName(), hand);
            checkResult(request, fightByHand);
        }else{
            request.addMessageToResponse("invalid command");
        }
    }

    private void checkResult(Request request, FightByHand fightByHand){
        String result = fightByHand.checkResult(player.getName(), enemy.getName());

        switch (result) {
            case "play":
                request.addMessageToResponse("you must enter a command (you probably tie with your enemy)");
                break;
            case "wait":
                request.addMessageToResponse("wait until your enemy play");
                break;
            case "tie":
                fightByHand.putHand(player.getName(), "");
                fightByHand.putHand(enemy.getName(), "");
                request.addMessageToResponse("fight again");
                break;
            case "win":
                winner = player;
                loser = enemy;
                request.addMessageToResponse("you won in this fight");
                break;
            default:
                winner = enemy;
                loser = player;
                request.addMessageToResponse("you lost in this fight");
                break;
        }
    }
}
