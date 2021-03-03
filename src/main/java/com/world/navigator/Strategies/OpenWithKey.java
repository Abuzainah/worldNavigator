package com.world.navigator.Strategies;

import com.world.navigator.Items.Key;
import com.world.navigator.Items.Lock;

public class OpenWithKey implements OpenMethod {
    @Override
    public boolean isMatch(Lock k1, Lock k2) {
        Key key1 = (Key) k1;
        Key key2 = (Key) k2;
        return key1.equals(key2);
    }
}
