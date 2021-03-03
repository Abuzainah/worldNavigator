package com.world.navigator.Strategies;

import com.world.navigator.Items.Lock;

public interface OpenMethod {
     boolean isMatch(Lock lock1, Lock lock2);
}
