package com.ChemistFTW.BardsAdventures;


public class Application {
    public static CustomEventHandler customEventHandler = new CustomEventHandler();
    public static GameTickHandler tickHandler = new GameTickHandler();
    public static Scripts scripts = new Scripts();
    public static void start() {

        AppWindow appWindow = new AppWindow();
        appWindow.setVisible(true);
        scripts.RunAll();
        tickHandler.isGamePaused = false;
        tickHandler.GameTickHandlerStart();
    }

    public static void init() {

    }
    public void run(){

    }
    public static void main(String[] args) {

        init();
        start();
    }

}
