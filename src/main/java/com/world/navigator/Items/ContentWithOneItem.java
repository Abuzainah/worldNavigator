package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentWithOneItem extends Content {

    @JsonCreator
    public ContentWithOneItem(@JsonProperty("item") Item item) {
        super(item);
    }
}
