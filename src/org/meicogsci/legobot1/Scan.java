package org.meicogsci.legobot1;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.remote.RemoteMotor;

public class Scan {

    public static final int M_COUNT = 3; // number of measurements to take in each step
    public static final int M_WAIT = 100; // number of milliseconds to wait after turning the sensor
    private static final SensorPort US_PORT = SensorPort.S4; // US sensor port
    private static final RemoteMotor US_MOTOR = Motor.A; // US motor port
    public float[] distances = new float[7]; // all in cm, range from ~3 - ~180. "255" equals error.
    public int[] angles = {-90, -60, -30, 0, 30, 60, 90};
    public int lastAngle = 0;
    private UltrasonicSensor us;
    public boolean isDone = false;

    public Scan() {
        for (int i = 0; i < distances.length; i++) {
            distances[i] = 255;
        }
        us = new UltrasonicSensor(US_PORT);
        isDone = false;
    }

    public boolean doScan() {
        if (lastAngle >= angles.length) {
        	isDone = true;
    		return false;
        } else {
        
            int angle = angles[lastAngle];
            US_MOTOR.rotateTo(angle);
            distances[lastAngle] = getMeasures(M_COUNT);
        	lastAngle++;
        	try {
				Thread.sleep(M_WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            return true;
        }
    }
    
    public void resetPos() {
    	US_MOTOR.rotateTo(0);
    }

    private float getMeasures(int count) {
        us.continuous();
        float out = 0;
        for (int i = 0; i < count; i++) {
            int dist = us.getDistance();
            out += dist;
//			System.out.println("m" + i + ": " + dist);
        }
        out /= count;
        us.off();
        return out;
    }
}
