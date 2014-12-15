package com.ChemistFTW.BardsAdventures;

import java.util.LinkedList;

/**
 * Created by ChemistFTW on 12.12.2014.
 */

public class Unit extends EventCaller {
    private double healthPoints;
    private int level;
    private int faction;
    private String unitclass;
    private String unitname;

    public double GetHealth() {
        return this.healthPoints;
    }

    public void SetHealthpoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public boolean GetIsDead() {
        return this.GetHealth() > 0;
    }

    public int GetFaction() {         //0 = Player, 1 = Neutral, 2 = Enemy;
        return this.faction;
    }

    public void SetFaction(int FACTION) {
        this.faction = FACTION;
    }

    public int GetLevel() {
        return this.level;
    }

    public void SetLevel(int level) {
        this.level = level;
    }

    public void Unit(double Health, int level, int faction, String unitclass, String unitname) {
        this.SetHealthpoints(Health);
        this.level = level;
        this.SetFaction(faction);
        this.unitclass = unitclass;
        this.unitname = unitname;
    }

    public void DoDie() {
        this.healthPoints = -1.00;
        this.DoMakeHappenEventsByID(EventTypes.EVENT_UNIT_DIED);
    }

    public void DoPureDamageFrom(Unit damager, double damagevalue) {
        this.healthPoints -= damagevalue;
        this.DoMakeHappenEventsByID(EventTypes.EVENT_UNIT_DAMAGED);
        if (this.healthPoints < 0) {
            this.DoMakeHappenEventsByID(EventTypes.EVENT_UNIT_KILLED);
        }
    }
}
