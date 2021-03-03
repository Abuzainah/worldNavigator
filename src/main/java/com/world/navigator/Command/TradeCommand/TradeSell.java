package com.world.navigator.Command.TradeCommand;

import com.world.navigator.Items.Currency;
import com.world.navigator.Items.Item;
import com.world.navigator.Items.Goods;
import com.world.navigator.Items.Seller;
import com.world.navigator.Game.Player;
import com.world.navigator.Game.Request;
import com.world.navigator.Command.Command;

class TradeSell extends Command {
    @Override
    public void execute(Request request) {
        Player player = request.getPlayer();
        Seller seller = (Seller) request.getPlayer().getFacedWall();

        try {
            int indexOfItem = Integer.parseInt(request.getArgumentAt(1));
            indexOfItem--;
            Goods goods = seller.getGoodsAt(indexOfItem);
            Item item = goods.getItem();
            Currency itemPrice = goods.getPrice();
            Currency playerMoney = (Currency) player.getItem(itemPrice.toString());

            if(player.getItem(item.toString()) == null){
                request.addMessageToResponse("you don\'t have this item");
            }else{
                playerMoney.increase(itemPrice.getAmount());
                player.removeItem(item.toString());
                request.addMessageToResponse("your deal is done");
            }
        }catch(NumberFormatException e){
            request.addMessageToResponse("the index of item must be number");
            return;
        }catch (IndexOutOfBoundsException e){
            request.addMessageToResponse("there is no such item");
            return;
        }
    }
}
