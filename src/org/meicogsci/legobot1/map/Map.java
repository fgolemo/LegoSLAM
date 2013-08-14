package org.meicogsci.legobot1.map;

import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.Field;
import org.meicogsci.legobot1.FieldType;
import org.meicogsci.legobot1.Position;
import org.meicogsci.legobot1.Scan;
import org.meicogsci.legobot1.State;

public class Map {

	/**
	 * length of a field in the map in cm
	 */
	public static final int UNITLENGTH = 30;
	/**
	 * map width in UNITLENGTH cm
	 */
	public static final int MAP_WIDTH = 10;
	/**
	 * map height in UNITLENGTH cm
	 */
	public static final int MAP_HEIGHT = 10;
	/**
	 * error rate in full degrees
	 */
	public static final int ERROR_RATE = 2;
	/**
	 * field[row][column], each field taking up UNITLENGTH cm
	 */
	public Field[][] fields = new Field[MAP_HEIGHT][MAP_WIDTH];

	public Map() {
		_fillUnknown(); // not needed as each field does this by default
	}

	private void _fillUnknown() {
		for (int row = 0; row < fields.length; row++) {
			for (int column = 0; column < fields[row].length; column++) {
				fields[row][column] = new Field();
				fields[row][column].type = FieldType.UNKNOWN;
			}
		}
	}

	public void updateFromLastScan() {
		State state = BotSingleton.getInstance().history.states.getLast();
//		if (state.position.angle != 90 && state.position.angle != 180
//				&& state.position.angle != 270 && state.position.angle != 0) {
//			System.out
//					.println("Sorry, can't update map, because Bot is not aligned");
//			return;
//		}
		for (int i = 0; i < state.scan.lastAngle - 1; i++) {
			int leftAngle = state.scan.angles[i];
			int rightAngle = state.scan.angles[i + 1];
			float leftDistance = state.scan.distances[i];
			float rightDistance = state.scan.distances[i + 1];
			Triangle tri = new Triangle(leftAngle, rightAngle, leftDistance,
					rightDistance);
			_updateFromTriangle(tri, state.position);
		}

	}

	private void _updateFromTriangle(Triangle tri, Position pos) {
		if (!tri.isHorizontal && !tri.isVertical) {
			// Bresenham-Algo to fill blanks into fields between bot and wall 
		}

		if (!tri.mayHaveGap && tri.isHorizontal) {
			Coord left = tri.getLeftCoords(pos.angle, "left");
			Coord right = tri.getLeftCoords(pos.angle, "right");
			_drawHorzWall(pos, left, right);
		}
	}
	
	private void _drawHorzWall(Position pos, Coord start, Coord end) {
		int y = (int) Math.ceil(start.y/UNITLENGTH);
		if (pos.angle.equals(Direction.UP))
			y = -y;
		int xStart = (int) Math.ceil(start.x/UNITLENGTH);
		int xEnd = (int) Math.ceil(end.x/UNITLENGTH);
		int yDiff = pos.y + y;
		int xDiffStart = pos.x + xStart;
		int xDiffEnd = pos.x + xEnd;
		if (yDiff < 0 || yDiff >= MAP_HEIGHT) {
			_shitftMapUpDown(yDiff);
		}
		if (xDiffStart < 0) {
			_shitftMapRightLeft(xDiffStart);
		}
		if (xDiffEnd >= MAP_WIDTH ) {
			_shitftMapRightLeft(xDiffEnd);
		}
	}
	
	private void _shitftMapUpDown(int steps) {
		if (steps < 0) { // => shift down, start bottom
			for (int row = fields.length-1; row >= 0; row--) {
				for (int column = 0; column < fields[row].length; column++) {
					Field fieldNew;
					if (row + steps < 0) 
						fieldNew = new Field(); 
					else
						fieldNew = fields[row+steps][column];
					fields[row][column] =  fieldNew;
				}
			}
		} else { //shift up, start top
			for (int row = 0; row < fields.length; row++) {
				for (int column = 0; column < fields[row].length; column++) {
					Field fieldNew;
					if (row + steps >= MAP_HEIGHT) 
						fieldNew = new Field(); 
					else
						fieldNew = fields[row+steps][column];
					fields[row][column] =  fieldNew;
				}
			}
		}
	}
	
	private void _shitftMapRightLeft(int steps) {
		if (steps < 0) { //shift right, start right
			for (int row = 0; row < fields.length; row++) {
				for (int column = fields[row].length-1; column >= 0 ; column--) {
					Field fieldNew;
					if (column + steps < 0) 
						fieldNew = new Field(); 
					else
						fieldNew = fields[steps][column+steps];
					fields[row][column] =  fieldNew;
				}
			}
		} else { //shift left, start left
			for (int row = 0; row < fields.length; row++) {
				for (int column = 0; column < fields[row].length; column++) {
					Field fieldNew;
					if (column + steps >= MAP_WIDTH) 
						fieldNew = new Field(); 
					else
						fieldNew = fields[row][column+steps];
					fields[row][column] =  fieldNew;
				}
			}
		}
	}
	
	private void _drawOwnPosition(int steps) {

	}
}
