package org.meicogsci.legobot1;

public enum FieldType {
	HORIZONTAL_WALL,
	VERTICAL_WALL,
	CORNER_LD, // Corner with walls going left and down 
	CORNER_RD, // Corner with walls going right and down
	CORNER_LU, // Corner with walls going left and up _|
	CORNER_RU, // CORNER with wall going right and up |_
	UNKNOWN // unknown field
}
