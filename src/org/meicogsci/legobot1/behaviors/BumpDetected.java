package org.meicogsci.legobot1.behaviors;

import org.meicogsci.legobot1.BotSingleton;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class BumpDetected implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
    TouchSensor touch = new TouchSensor(SensorPort.S1);
	
	@Override
	public boolean takeControl() {
		
		return touch.isPressed();
	}

	@Override
	public void action() {
		bot.nextAction = "";
		Motor.B.setSpeed(360);
        Motor.C.setSpeed(360);
        Motor.B.rotate(180);
    	Motor.C.rotate(180);
		bot.nextAction = "scan";
	}

	@Override
	public void suppress() {
		_suppressed = true;
	}

}
