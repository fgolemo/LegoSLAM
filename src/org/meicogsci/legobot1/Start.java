package org.meicogsci.legobot1;

import org.meicogsci.legobot1.behaviors.*;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Start {

	public static void main(String[] args) {
		NXTControl nxtctrl = new NXTControl(); // PC use
		nxtctrl.init(); //PC use
		
		BotSingleton.getInstance().nextAction = "scan";
		Behavior b1 = new MakeScan();
//		Behavior b2 = new DetectWall();
		Behavior b3 = new Shutdown();
		Behavior[] behaviorList = { b1, b3 };
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		LCD.drawString("LegoSLAM Car", 0, 1);
		Button.waitForAnyPress();
		arbitrator.start();
		
		nxtctrl.exit(); // PC use
		System.exit(0);

	}

}
