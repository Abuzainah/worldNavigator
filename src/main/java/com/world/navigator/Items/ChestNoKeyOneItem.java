package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.world.navigator.Strategies.OpenWithKey;

public class ChestNoKeyOneItem extends Chest {

    @JsonCreator
    public ChestNoKeyOneItem(
            @JsonProperty("contents") ContentWithOneItem contents
    ) {
        super(LockFactory.getLock("NoKey"), new OpenWithKey(), contents, true);
    }

    @Override
    public String toString() {
        return "chest";
    }
}
