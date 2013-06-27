package org.meicogsci.legobot1;

import java.util.Date;

public class State {
	public Date date;
	public Position position;
	public Scan scan;
	
	public State() {
		date = new Date();
	}
}
