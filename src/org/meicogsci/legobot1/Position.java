package org.meicogsci.legobot1;

import org.meicogsci.legobot1.map.Direction;

public class Position {

    public int x; // in Map Fields
    public int y; // in Map Fields
    public Direction angle; // in degree
    public boolean isCalculated; // false if just moved there, true if verified through scanning
    public Position() {
        x = 0;
        y = 0;
        angle = Direction.UP;
        isCalculated = false;
    }
}
