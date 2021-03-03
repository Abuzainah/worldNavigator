package com.world.navigator.Game;

import org.apache.commons.lang3.time.StopWatch;

public class Timer {

    private StopWatch stopWatch;
    private int totalTime;

    public void startTimer(){
        stopWatch = StopWatch.createStarted();
    }

    public void initializeTimeInMilliSecond(int totalTime){
        this.totalTime =  totalTime;
    }

    public boolean isTimeFinished(){
        if(stopWatch.getTime() > totalTime){
            if(!stopWatch.isStopped()) stopWatch.stop();
            return true;
        }
        return false;
    }

 }
