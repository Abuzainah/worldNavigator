package com.world.navigator.Command.FightCommands;

import com.world.navigator.Command.Command;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.PlayerCommand.PlayerStatus;
import com.world.navigator.Command.LossCommand.Loss;
import com.world.navigator.Command.ItemsCommand.Normal;
import com.world.navigator.Command.TradeCommand.Trade;
import com.world.navigator.Command.WinCommand.Win;

import java.util.HashMap;

public class General extends Command {
    private HashMap modes = new HashMap<String, Command>();

    public General(){
        this.addCommand("normal", new Normal());
        this.addCommand("fight", new Fight());
        this.addCommand("trade", new Trade());
        this.addCommand("loss", new Loss());
        this.addCommand("win", new Win());
        super.addCommand("playerstatus", new PlayerStatus());
    }

    @Override
    public void addCommand(String name, Command command){
        modes.put(name, command);
    }

    @Override
    public Command getCommand(String name){
        return (Command) modes.get(name);
    }

    @Override
    public void execute(Request request) {

        if(super.getCommand(request.getArgumentAt(0)) != null){
            super.getCommand(request.getArgumentAt(0)).execute(request);
        }
        else this.getCommand(request.getPlayer().getMode()).execute(request);
    }
}
