package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Goods {
    private Item item;
    private Gold price;

    @JsonCreator
    public Goods(@JsonProperty("item") Item item,@JsonProperty("amount") Integer amount){
        this.item = item;
        this.price = new Gold(amount);
    }
}
