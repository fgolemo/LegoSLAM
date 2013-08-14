package org.meicogsci.legobot1.behaviors;

import org.meicogsci.legobot1.BotSingleton;

import lejos.robotics.subsumption.Behavior;

public class InvestigateUnknown implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return (false);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
