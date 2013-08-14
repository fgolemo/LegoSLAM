package org.meicogsci.legobot1.behaviors;
import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.Scan;
import org.meicogsci.legobot1.State;

import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class TurnRight implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;

	@Override
	public boolean takeControl() {
		return (bot.nextAction == "turn");
	}

	@Override
	public void action() 
	{
		bot.nextAction = "";
		System.out.println("helloturnright");
		Motor.B.setSpeed(360);
        Motor.C.setSpeed(360);
        Motor.B.rotate(180);
    	Motor.C.rotate(-215);
        
		bot.nextAction = "scan";
		
	}

	@Override
	public void suppress() {
		_suppressed = true;

	}

}
