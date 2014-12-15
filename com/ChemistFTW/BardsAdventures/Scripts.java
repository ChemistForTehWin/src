package com.ChemistFTW.BardsAdventures;

/**
 * Created by ChemistFTW on 15.12.2014.
 */
@FunctionalInterface
interface ITriggerInterface { public void doTrigger(); }
class TriggerAction implements ITriggerInterface{  public void doTrigger(){  } }

public class Scripts {
    public void RunAll(){
        System.out.println("Scripts started!");
        Trigger1Creation();
    }

    private void Trigger1Creation() {
        Unit unit1 = new Unit();
        EventUnitDied died = new EventUnitDied();
        Application.customEventHandler.RegisterEvent(died);
        unit1.DoAddAssociatedEvent(died);
        died.DoAttachTriggerAction(new Trigger1Action());
        Timer timerToDie = new Timer(true,5000,true);
        EventTimerExpired eventTimerExpired = new EventTimerExpired();
        timerToDie.DoAddAssociatedEvent(eventTimerExpired);
        Application.tickHandler.RegisterTimer(timerToDie);
        Application.customEventHandler.RegisterEvent(eventTimerExpired);
        eventTimerExpired.DoAttachTriggerAction(new Trigger1Action2(unit1));


    }
    public class Trigger1Action extends TriggerAction{
        @Override
        public void doTrigger(){  System.out.println("Unit died!");  }
        public Trigger1Action(){ }
    }
    public class Trigger1Action2 extends TriggerAction{
        private Unit tokill;
        @Override
        public void doTrigger(){
            System.out.println("Timer expired and called unit kill!");
            tokill.DoDie();
        }
        public Trigger1Action2(Unit tokill){
            this.tokill = tokill;
        }
    }
}
