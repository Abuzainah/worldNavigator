package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.world.navigator.Strategies.OpenWithKey;

public class ChestKeyOneItem extends Chest {

    @JsonCreator
    public ChestKeyOneItem(
            @JsonProperty("key") String keyName,
            @JsonProperty("contents") ContentWithOneItem contents
    ) {
        super(LockFactory.getLock(keyName), new OpenWithKey(), contents, false);
    }

    @Override
    public String toString() {
        return "chest";
    }

}
