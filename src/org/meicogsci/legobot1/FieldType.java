package org.meicogsci.legobot1;

public enum FieldType {

    /**
     * a horizontal wall ─
     */
    HORIZONTAL_WALL,
    /**
     * a vertical wall │
     */
    VERTICAL_WALL,
    /**
     * corner with walls going left and down ┐
     */
    CORNER_LD,
    /**
     * corner with walls going right and down ┌
     */
    CORNER_RD,
    /**
     * corner with walls going left and up ┘
     */
    CORNER_LU,
    /**
     * corner with wall going right and up └
     */
    CORNER_RU,
    /**
     * unknown field ▒
     */
    UNKNOWN,
    /**
     * empty space (space symbol)
     */
    EMPTY,
    /**
     * current position x
     */
    POSITION
}
