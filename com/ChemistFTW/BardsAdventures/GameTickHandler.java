package com.ChemistFTW.BardsAdventures;


import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by ChemistFTW on 11.12.2014.
 */
public class GameTickHandler {
    public static final int FRAMES_PER_SECOND = 25;
    public static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
    public CustomEventHandler customEventHandler = Application.customEventHandler;
    public boolean isGamePaused = true;
    private LinkedList<Timer> timers = new LinkedList<>();
    int sleepTime = 0;

    public boolean isGameRunning = false;

    public void ProcessTimers() {
        timers.forEach((Timer timer) -> {
            if (timer.isShouldBeDestroyedNextGameTick()) {
                timers.remove(timer);
            } else {
                timer.DoStandartTick();
            }
        });

    }

    public void RegisterTimer(Timer timer) {
        timers.add(timer);
    }

    public void GameTickHandlerStart() {

        System.out.println("GameTickHandler started!");
        while (isGameRunning) {
            try {
                TimeUnit.MILLISECONDS.sleep(SKIP_TICKS);
            } catch (InterruptedException ex) {

                System.out.println("Something interrupted me!");
            }
            if (!isGamePaused) {
                this.ProcessTimers();
            }
            customEventHandler.ProcessEvents();

        }
    }

    public GameTickHandler() {
        this.isGameRunning = true;


    }
}
