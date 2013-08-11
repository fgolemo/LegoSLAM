package org.meicogsci.legobot1.map;

import org.meicogsci.legobot1.BotSingleton;
import org.meicogsci.legobot1.Field;
import org.meicogsci.legobot1.FieldType;
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
		if (state.position.angle != 90 && state.position.angle != 180
				&& state.position.angle != 270 && state.position.angle != 0) {
			System.out
					.println("Sorry, can't update map, because Bot is not aligned");
			return;
		}
		for (int i = 0; i < state.scan.lastAngle - 1; i++) {
			int leftAngle = state.scan.angles[i];
			int rightAngle = state.scan.angles[i + 1];
			float leftDistance = state.scan.distances[i];
			float rightDistance = state.scan.distances[i + 1];
			Triangle tri = new Triangle(leftAngle, rightAngle, leftDistance,
					rightDistance);
			_updateFromTriangle(tri);
		}

	}

	private void _updateFromTriangle(Triangle tri) {
		if (!tri.isHorizontal && !tri.isVertical) {
			// tricky: just fill in the blanks between position and wall and set
			// "unknown" as direct wall
		}

		if (!tri.mayHaveGap && tri.isHorizontal) {

		}
	}

	private void _drawOwnPosition() {

	}
}
