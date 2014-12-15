package com.ChemistFTW.BardsAdventures;

public class Application {
    public static CustomEventHandler customEventHandler = new CustomEventHandler();
    public static GameTickHandler tickHandler = new GameTickHandler();

    public static void start(){

        AppWindow appWindow = new AppWindow();
        appWindow.setVisible(true);
        Scripts scripts = new Scripts();
        scripts.RunAll();
        tickHandler.isGamePaused = false;
        tickHandler.GameTickHandlerStart();
    }
    public static void init(){

    }

    public static void main(String[] args){

        init();
        start();
    }

}
