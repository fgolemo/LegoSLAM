package org.meicogsci.legobot1;

public class Position {

    public float x; // in cm
    public float y; // in cm
    public float angle; // in degree
    public boolean isAligned; // false if just moved there, true if aligned to a wall

    public Position() {
        x = 0;
        y = 0;
        angle = 0;
        isAligned = false;
    }
}
