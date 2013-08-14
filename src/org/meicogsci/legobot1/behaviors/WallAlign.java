package org.meicogsci.legobot1.behaviors;

import lejos.robotics.subsumption.Behavior;
import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.State;

public class WallAlign implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	State state;

	private boolean _suppressed = false;
	
	@Override
	public boolean takeControl() {
		return (bot.nextAction == "align");
	}

	@Override
	public void action() {
		state = bot.history.states.getLast();
		bot.nextAction = "";
		float[] distances = bot.history.states.getLast().scan.distances;
		for (int i = 0; i < distances.length; i++) {
			float distance = distances[i];
			System.out.println("distance "+i+": "+distance);
		}
		for (int i = state.scan.lastAngle - 7; i < state.scan.lastAngle - 1; i++) {
			int leftAngle = state.scan.angles[i];
			int rightAngle = state.scan.angles[i + 1];
			float leftDistance = state.scan.distances[i];
			float rightDistance = state.scan.distances[i + 1];
			
			//add code for measuring straight lines and align with 36 and -43 degrees
			}
	}

	@Override
	public void suppress() {
		_suppressed = true;
	}

}
