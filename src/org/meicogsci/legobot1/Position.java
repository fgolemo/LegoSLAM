package org.meicogsci.legobot1;

public class Position {

    public float x; // in cm
    public float y; // in cm
    public float angle; // in degree
    public boolean isCalculated; // false if assumed, true if calculated

    public Position() {
        x = 0;
        y = 0;
        angle = 0;
        isCalculated = false;
    }
}
