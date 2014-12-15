package com.ChemistFTW.BardsAdventures;

/**
 * Created by ChemistFTW on 12.12.2014.
 */
public class Button {
    int x0;
    int y0;
    int xSize;
    int ySize;
    boolean show = false;
    public Button(){
        x0 = 0;
        y0 = 0;
        xSize = 0;
        ySize = 0;
    }
    public Button(int x0,int y0,int xSize,int ySize){
        this.x0 = x0;
        this.y0 = y0;
        this.xSize = xSize;
        this.ySize = ySize;
    }
    public void ButtonShow(boolean doShow){
        this.show = doShow;
    }
    public void ButtonSetSprite(Sprite sprite){

    }
    public void ButtonAddEvent(){
        // PUT EVENT HERE!!!
    }
}
