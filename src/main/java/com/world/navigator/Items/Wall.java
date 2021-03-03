package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.world.navigator.Items.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Door.class, name = "door"),
        @JsonSubTypes.Type(value = MirrorWithOneKey.class, name = "mirrorWithOneKey"),
        @JsonSubTypes.Type(value = PaintingWithOneKey.class, name = "paintingWithOneKey"),
        @JsonSubTypes.Type(value = EmptyWall.class, name = "emptyWall"),
        @JsonSubTypes.Type(value = ChestKeyOneItem.class, name = "chestKeyOneItem"),
        @JsonSubTypes.Type(value = ChestNoKeyOneItem.class, name = "chestNoKeyOneItem"),
        @JsonSubTypes.Type(value = Seller.class, name = "seller")
})
public abstract class Wall {

}
