package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaintingWithOneKey extends Frontage {
    private boolean hidden;
    private Key key;

    @JsonCreator
    public PaintingWithOneKey(
            @JsonProperty("hidden") boolean hidden,
            @JsonProperty("key") String keyName
    ){
        this.hidden = hidden;
        this.key = (Key) LockFactory.getLock(keyName);
    }

    public PaintingWithOneKey(){
        this.hidden = false;
    }

    public void setKey(Key key) {
        this.key = key;
        this.hidden = true;
    }

    public boolean foundKey(){
        return hidden;
    }

    public Key takeKey(){
        if(!this.hidden) return null;
        this.hidden = false;
        return this.key;
    }

    @Override
    public String toString() {
        return "painting";
    }
}
