package com.ChemistFTW.BardsAdventures;


import java.util.LinkedList;

/**
 * Created by ChemistFTW on 13.12.2014.
 */
class EventCaller {
    protected LinkedList<Event> associatedEvents = new LinkedList<>();
    public void DoAddAssociatedEvent(Event event){ this.associatedEvents.add(event);}
    public void DoMakeHappenEventsByID(int EventType){
        this.associatedEvents.forEach((Event event) -> { if(event.GetType()==EventType){event.DoSetHappen();}});
    }
}

class Event {
    protected boolean isHappened = false;
    protected boolean isRepeatable = false;
    protected int type = EventTypes.EVENT_NO_TYPE;
    protected TriggerAction triggerAction;
    public void DoAttachTriggerAction(TriggerAction triggerAction){ this.triggerAction = triggerAction; }
    public TriggerAction GetTriggerAction(){ return this.triggerAction; }
    public Event(boolean isRepeatable, int type){
        isHappened = false;
        this.isRepeatable = isRepeatable;
        this.type = type;
    }
    public void DoSetHappen(){ this.isHappened = true; }
    public Event(){
        this.isHappened = false;
        this.isRepeatable = false;
        this.type = EventTypes.EVENT_NO_TYPE;
    }
    public int GetType(){
        return this.type;
    }
    public void onHappen(){ this.GetTriggerAction().doTrigger(); }
}

class EventGameTick extends Event{
    protected GameTickHandler gameTickHandler;
    public GameTickHandler GetGameTickHandler(){
        return this.gameTickHandler;
    }
    public void SetGameTickHandler(GameTickHandler gameTickHandler){
        this.gameTickHandler = gameTickHandler;
    }
}

class EventGameTickHandlerTicking extends EventGameTick{
    public EventGameTickHandlerTicking(){
        this.isRepeatable = true;
        this.type = EventTypes.EVENT_GAME_TICK;
    }
}

class EventGameTickHandlerPaused extends EventGameTick{
    public EventGameTickHandlerPaused(){
        this.type = EventTypes.EVENT_GAME_PAUSED;
    }
}

class EventGameTickHandlerResumed extends EventGameTick{
    public EventGameTickHandlerResumed(){
        this.type = EventTypes.EVENT_GAME_RESUMED;
    }
}

class EventTimer extends Event{
    protected Timer timer;
    public Timer GetTimer(){
        return this.timer;
    }
    public void SetTimer(Timer timer){
        this.timer = timer;
    }
    public EventTimer(){
        this.type = EventTypes.EVENT_NO_TYPE;
    }
}

class EventTimerCreated extends EventTimer{
    public EventTimerCreated(){
        this.type = EventTypes.EVENT_TIMER_CREATED;
    }
}

class EventTimerStarted extends EventTimer{
    public EventTimerStarted(){
        this.type = EventTypes.EVENT_TIMER_STARTED;
    }
}

class EventTimerPaused extends EventTimer{
    public EventTimerPaused(){
        this.type = EventTypes.EVENT_TIMER_PAUSED;
    }
}

class EventTimerExpired extends EventTimer{
    public EventTimerExpired(){
        this.type = EventTypes.EVENT_TIMER_EXPIRED;
    }
}

class EventUnit extends Event{
    protected Unit unit;
    public void SetUnit(Unit unit){
        this.unit = unit;
    }
    public Unit GetUnit(){
        return this.unit;
    }
    public EventUnit(){
        this.type = EventTypes.EVENT_NO_TYPE;
    }
}

class EventUnitNoSource extends EventUnit{
    public EventUnitNoSource(){
        this.type = EventTypes.EVENT_NO_TYPE;
    }
}

class EventUnitCreated extends EventUnitNoSource{
    public EventUnitCreated(){
        this.type = EventTypes.EVENT_UNIT_CREATED;
    }
}

class EventUnitDied extends EventUnitNoSource{
    public EventUnitDied(){
        this.type = EventTypes.EVENT_UNIT_DIED;
    }
}

class EventUnitInteraction extends EventUnit{
    protected Unit interactingUnit;
    public void SetInteractingUnit(Unit interactingUnit){
        this.interactingUnit = interactingUnit;
    }
    public Unit GetInteractingUnit(){
        return interactingUnit;
    }
}

class EventUnitInteractionDamaged extends EventUnitInteraction{
    protected double damageValue;
    public EventUnitInteractionDamaged(){
        this.type = EventTypes.EVENT_UNIT_DAMAGED;
        this.isRepeatable = true;
    }
    public void SetDamageValue(double damageValue){
        this.damageValue = damageValue;
    }
    public double GetDamageValue(){
        return this.damageValue;
    }
}

class EventUnitInteractionKilled extends EventUnitInteraction{
    public EventUnitInteractionKilled(){
        this.type = EventTypes.EVENT_UNIT_KILLED;
    }
}

class EventUnitInteractionCastedSpell extends EventUnitInteraction{
    protected int spellId;
    public EventUnitInteractionCastedSpell(){
        this.type = EventTypes.EVENT_UNIT_CASTEDSPELL;
        this.isRepeatable = true;
    }
    public void SetCastedSpellId(int spellId){
        this.spellId = spellId;
    }
    public int GetCastedSpellId(){
        return this.spellId;
    }
}

class EventButton extends Event{
    protected Button button;
    public void SetButton(Button button){
        this.button = button;
    }
    public Button GetButton(){
        return this.button;
    }
}
