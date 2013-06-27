package org.meicogsci.legobot1.behaviors;

import lejos.robotics.subsumption.Behavior;
import org.meicogsci.legobot1.BotSingleton;

public class WallAlign implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
	
	@Override
	public boolean takeControl() {
		return (bot.nextAction == "align");
	}

	@Override
	public void action() {
		bot.nextAction = "";
		
	}

	@Override
	public void suppress() {
		_suppressed = true;
	}

}
