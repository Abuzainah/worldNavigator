package com.world.navigator.Command.TradeCommand;

import com.world.navigator.Items.Currency;
import com.world.navigator.Items.Item;
import com.world.navigator.Items.Goods;
import com.world.navigator.Items.Seller;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

import java.util.ArrayList;

class TradeList extends Command {
    @Override
    public void execute(Request request) {
        Seller seller = (Seller) request.getPlayer().getFacedWall();
        ArrayList<Goods> goods = seller.getAllGoods();

        for(int i = 0;i < goods.size();++i){
            Item item = goods.get(i).getItem();
            Currency currency = goods.get(i).getPrice();

            request.addMessageToResponse((i + 1) + " " + item.toString() + " " + currency.getAmount());
        }
    }
}