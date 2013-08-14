package org.meicogsci.legobot1.behaviors;

import lejos.robotics.subsumption.Behavior;
import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.State;

public class WallAlign implements Behavior {
	BotSingleton bot = BotSingleton.getInstance();
	State state;

	private boolean _suppressed = false;
	private boolean isAligned[];//is the i-th segment aligned?
	@Override
	public boolean takeControl() {
		return (bot.nextAction == "align");
	}

	@Override
	public void action() {
		state = bot.history.states.getLast();
		bot.nextAction = "";
		float[] distances = bot.history.states.getLast().scan.distances;
		int minvalue=0;
// Find closest element
		for (int i=0;i<6;i++)
		{
			if (distances[i]>distances[i+1])
					minvalue=i+1;
		}
		for (int i = 0; i < distances.length; i++) {
			float distance = distances[i];
			System.out.println("distance "+i+": "+distance);
		}
		for (int i = state.scan.lastAngle - 7; i < state.scan.lastAngle - 1; i++) {
		//	int leftAngle = state.scan.angles[i];
		//	int rightAngle = state.scan.angles[i + 1];
			float leftDistance = state.scan.distances[i];
			float rightDistance = state.scan.distances[i + 1];
			
			double lsq = Math.pow(leftDistance, 2);
			double rsq = Math.pow(rightDistance, 2);
			double wallLength = Math.sqrt(lsq + rsq - (Math.sqrt(2)*lsq*rsq) );
			double leftWallAngle = Math.acos( (Math.pow(wallLength, 2) + lsq - rsq)/(2*lsq*wallLength) );
		//	double rightWallAngle = 180 - 30 - leftWallAngle;
			
			if (Math.round(leftWallAngle)==60)
				isAligned[i]=true;
			else
				isAligned[i]=false;
			
			}	
//align to closest element (if not aligned)
		int alignedToElement=-1;
		for(int i=0; i<6; i++){
			if (isAligned[i]==true)
				alignedToElement=i;
		}
		if(alignedToElement==-1)
			//align to closest
			;
	}

	@Override
	public void suppress() {
		_suppressed = true;
	}

}
