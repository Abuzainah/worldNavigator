package com.world.navigator.Items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.world.navigator.Strategies.OpenMethod;
import com.world.navigator.Strategies.OpenWithKey;
import com.world.navigator.Strategies.OpenWithoutKey;
import com.world.navigator.Items.Lock;
import com.world.navigator.Items.LockFactory;
import lombok.Data;

@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Passage{
    private int id;
    private int side1;
    private int side2;
    private Lock lock;
    private boolean open = false;
    private OpenMethod openMethod;

    @JsonCreator
    public Passage(@JsonProperty("id") int id,
                   @JsonProperty("side1") int side1,
                   @JsonProperty("side2") int side2,
                   @JsonProperty("key") String keyName
    ) {
        this.id = id;
        this.side1 = side1;
        this.side2 = side2;
        this.lock = LockFactory.getLock(keyName);
        if(keyName.equals("NoKey")){
            this.openMethod = new OpenWithoutKey();
            this.open = true;
        }else{
            this.openMethod = new OpenWithKey();
            this.open = false;
        }
    }

    public boolean openPassage(Lock lock){
        return this.open = this.openMethod.isMatch(this.lock, lock);
    }

    @Override
    public String toString() {
        return "Passage";
    }
}
