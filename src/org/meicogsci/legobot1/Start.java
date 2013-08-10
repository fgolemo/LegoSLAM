package org.meicogsci.legobot1;

import org.meicogsci.legobot1.behaviors.*;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import org.meicogsci.legobot1.map.MapForm;

public class Start {

    public static void main(String[] args) {
        NXTControl nxtctrl = new NXTControl(); // PC use
        nxtctrl.init(); //PC use

        BotSingleton.getInstance().nextAction = "scan";
        BotSingleton.getInstance().mapForm = new MapForm();
        
        Behavior makeScan = new MakeScan();
        Behavior wallAlign = new WallAlign();
        Behavior shutdown = new Shutdown();
        Behavior turnRight = new TurnRight();
        Behavior bumpDetected = new BumpDetected();
        Behavior investigate = new InvestigateUnknown();
        Behavior updateMap = new UpdateMap();
        Behavior[] behaviorList = {makeScan, wallAlign, shutdown,
            bumpDetected, turnRight, investigate, updateMap};
        Arbitrator arbitrator = new Arbitrator(behaviorList);
        LCD.drawString("LegoSLAM Car", 0, 1);
        Button.waitForAnyPress();
        arbitrator.start();

        nxtctrl.exit(); // PC use
        System.exit(0);

    }
}
