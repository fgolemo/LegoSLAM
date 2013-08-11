package org.meicogsci.legobot1.map;

public class Triangle {
	public int leftAngle;
	public int rightAngle;
	public float leftDistance;
	public float rightDistance;
	
	public double wallLength;
	public double leftWallAngle;
	public double rightWallAngle;
	
	public boolean isHorizontal = false;
	public boolean isVertical = false;
	public boolean mayHaveGap = false;
	
	public Triangle(int leftAngle, int rightAngle,
			float leftDistance, float rightDistance) {
		this.leftAngle = leftAngle;
		this.rightAngle = rightAngle;
		this.leftDistance = leftDistance;
		this.rightDistance = rightDistance;
		calc();
	}
	
	public void calc() {
		double lsq = Math.pow(leftDistance, 2);
		double rsq = Math.pow(rightDistance, 2);
		wallLength = Math.sqrt(lsq + rsq - (Math.sqrt(2)*lsq*rsq) );
		leftWallAngle = Math.acos( (Math.pow(wallLength, 2) + lsq - rsq)/(2*lsq*wallLength) );
		rightWallAngle = 180 - 30 - leftWallAngle;
		if (wallLength > Map.UNITLENGTH)
			mayHaveGap = true;
		double hor, ver;
		if (leftAngle < 0 || rightAngle < 0) {
			hor = 180 - Math.abs(leftAngle) - leftWallAngle - 90;
			ver = 180 - Math.abs(rightAngle) - (90-rightWallAngle) - 90; 
		} else {
			hor = 180 - Math.abs(rightAngle) - rightWallAngle - 90;
			ver = 180 - Math.abs(leftAngle) - (90-leftWallAngle) - 90;
		}
		if (hor > -Map.ERROR_RATE && hor < Map.ERROR_RATE)
			isHorizontal = true;
		else if (ver > -Map.ERROR_RATE && ver < Map.ERROR_RATE)
			isVertical = true;
	}
}
