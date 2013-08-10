package org.meicogsci.legobot1.behaviors;
import org.lejos.sample.bumpercar.BumperCar;
import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.Scan;
import org.meicogsci.legobot1.State;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Motor;

public class turnRight implements Behavior{
	
	  
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
	
	@Override
	public boolean takeControl() {
		return (bot.nextAction == "turn");
	}
	
	@Override
	public void action() {
		bot.nextAction = "";
	      Motor.B.setSpeed(360);
	      Motor.C.setSpeed(360);
	      turnNinety();
	    bot.nextAction = "scan";
	}
	 private static void turnNinety()
	    {
	    	Motor.B.rotate(180);
	    	Motor.C.rotate(-210);
	    }
	@Override
	public void suppress() {
		_suppressed = true;
	}

}
