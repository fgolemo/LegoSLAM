package org.meicogsci.legobot1.map;

public class Triangle {
	public int leftAngle;
	public int rightAngle;
	public float leftDistance;
	public float rightDistance;
	
	public double wallLength;
	public double leftWallAngle;
	public double rightWallAngle;
	
	public boolean isHorizontal;
	public boolean isVertical;
	public boolean mayHaveGap;
	
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
	}
}
