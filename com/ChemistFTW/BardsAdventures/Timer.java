package com.ChemistFTW.BardsAdventures;

import java.util.LinkedList;

/**
 * Created by ChemistFTW on 12.12.2014.
 */
public class Timer extends EventCaller {
    private boolean isDoneOnce = true;
    private double period;   // Done in seconds
    private double leftover;
    private boolean isStarted = false;
    private boolean isExpired = false;
    private boolean isPaused = false;
    private boolean isShouldBeDestroyedNextGameTick = false;
    public boolean GetIsExpired(){
        return this.isExpired;
    }
    public void SetExpired(boolean isExpired){
        this.isExpired = isExpired;
    }
    public boolean GetIsStarted(){
        return this.isStarted;
    }
    public double GetLeftTime(){
        return this.leftover;
    }
    public void SetLeftTime(double time) {
        this.leftover = time;
    }
    public double GetPeriod(){
        return this.period;
    }
    public void SetPeriod(double newperiod){
        this.period = newperiod;
    }
    public void DoPause(){
        this.isPaused = true;
    }
    public boolean GetIsPaused(){
        return this.isPaused;
    }

    public void DoStart(){
        this.isStarted = true;
        this.DoMakeHappenEventsByID(EventTypes.EVENT_TIMER_STARTED);
    }
    public void DoPause(boolean shouldPause){
        this.isPaused = shouldPause;
        this.DoMakeHappenEventsByID(EventTypes.EVENT_TIMER_PAUSED);
    }
    public Timer(boolean isDoneOnce, double period, boolean isStartNow){
        this.period = period;
        this.isDoneOnce = isDoneOnce;
        this.SetLeftTime(period);
        if (isStartNow){
            this.DoStart();
        }
        this.DoMakeHappenEventsByID(EventTypes.EVENT_TIMER_CREATED);
    }
    public void DoStandartTick(){                            //Is called from GameTickHandler;
        if (!this.GetIsExpired()){                         //Check for expiration
            if (GetIsStarted()) {                          //Check for started
                if (!GetIsPaused()) {
                    if (GetLeftTime() > 0) {                        //May be it is expired, but is not set as yet?
                        SetLeftTime(GetLeftTime() - (Application.tickHandler.SKIP_TICKS));

                        System.out.println("Debug point" + this.GetLeftTime());
                        } else {
                        if(this.isDoneOnce) {
                            SetLeftTime(-0.005);
                            SetExpired(true);
                        }else{SetLeftTime(GetPeriod());}
                        this.DoMakeHappenEventsByID(EventTypes.EVENT_TIMER_EXPIRED);
                    }
                }
            }
        }
    }
    public void DoDestroy(){                                    //We will destroy this timer by deleting it from LinkedList in GameTickHandler, so no reference means no object, right?
        this.isShouldBeDestroyedNextGameTick = true;            //But do not forget to nullify any other references too!!
    }
    public boolean isShouldBeDestroyedNextGameTick(){
        return this.isShouldBeDestroyedNextGameTick;
    }
}
