package com.world.navigator.Strategies;

import com.world.navigator.Items.Lock;
import com.world.navigator.Items.NoKey;

public class OpenWithoutKey implements OpenMethod {

    @Override
    public boolean isMatch(Lock k1, Lock k2) {
        NoKey noKey1 = (NoKey) k1;
        NoKey noKey2 = (NoKey) k2;
        return noKey1.equals(noKey2);
    }
}
