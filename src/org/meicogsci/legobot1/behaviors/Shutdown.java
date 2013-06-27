package org.meicogsci.legobot1.behaviors;

import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class Shutdown implements Behavior {

	public Shutdown() {
	}

	public boolean takeControl() {
		return Button.ESCAPE.isDown();
	}

	public void suppress() {
		// Since this is highest priority behavior, suppress will never be
		// called.
	}

	public void action() {
		System.exit(0);
	}

}
