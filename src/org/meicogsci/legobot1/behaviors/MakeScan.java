package org.meicogsci.legobot1.behaviors;

import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.Scan;
import org.meicogsci.legobot1.State;

import lejos.robotics.subsumption.Behavior;

public class MakeScan implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	private boolean _suppressed = false;
	private Scan scan;

	@Override
	public boolean takeControl() {
		return (bot.nextAction == "scan");
	}

	@Override
	public void action() {
		bot.nextAction = "";
		scan = new Scan();
		while (!_suppressed && !scan.isDone) {
			boolean working = scan.doScan();
			if (!working)
				break;
		}
		if (bot.history.states.size() == 0
				|| bot.history.states.getLast().scan.isDone == false) {
			State state = new State();
			state.scan = scan;
			bot.history.states.add(state);
		} else {
			bot.history.states.getLast().scan = scan;
		}
		bot.map.updateFromLastScan();
		scan.resetPos();
		bot.nextAction = "align";
	}

	@Override
	public void suppress() {
		_suppressed = true;
		scan.resetPos();
	}

}
