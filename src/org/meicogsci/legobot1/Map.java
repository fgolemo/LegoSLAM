package org.meicogsci.legobot1;

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
	 * field[row][column], each field taking up UNITLENGTH cm
	 */
	public Field[][] fields = new Field[MAP_HEIGHT][MAP_WIDTH];
	
	public Map() {
		this._fillUnknown();
	}
	
	private void _fillUnknown() {
		for (int row = 0; row < fields.length; row++) {
			for (int column = 0; column < fields[row].length; column++) {
				fields[row][column].type = FieldType.UNKNOWN;
			}
		}
	}
}
