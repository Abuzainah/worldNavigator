package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Seller extends Wall {
    private ArrayList<Goods> goods;

    @JsonCreator
    public Seller(@JsonProperty("goods") ArrayList<Goods> goods){
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "seller";
    }

    public ArrayList<Goods> getAllGoods(){
        return goods;
    }

    public Goods getGoodsAt(int index){
        return goods.get(index);
    }
}
