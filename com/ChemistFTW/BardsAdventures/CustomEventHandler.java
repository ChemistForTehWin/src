package com.ChemistFTW.BardsAdventures;

import java.util.LinkedList;

/**
 * Created by ChemistFTW on 13.12.2014.
 */


public final class CustomEventHandler {
    private LinkedList<Event> events;

    public CustomEventHandler() {
        this.events = new LinkedList<>();
        System.out.println("EventHandler started!");
    }

    public void RegisterEvent(Event event) {
        events.add(event);
    }

    public void ProcessEvents() {
        events.forEach((Event event) -> {
                    if (event.isHappened) {
                        if (!event.isRepeatable) {
                            events.remove(event);
                        }
                        event.onHappen();
                    }
                }
        );
    }


}
