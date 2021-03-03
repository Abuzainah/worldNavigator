package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.world.navigator.Items.Currency;

public class Gold extends Currency {

    @JsonCreator
    public Gold(@JsonProperty("amount") int amount){
        super(amount);
    }
    @Override
    public String toString() {
        return "gold";
    }
}
