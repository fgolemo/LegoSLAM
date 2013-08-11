package org.meicogsci.legobot1.behaviors;

import org.meicogsci.legobot1.BotSingleton;

import lejos.robotics.subsumption.Behavior;

public class UpdateMap implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
	
	@Override
	public boolean takeControl() {
		return (bot.nextAction == "map");
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suppress() {
		_suppressed = true;
	}

}
