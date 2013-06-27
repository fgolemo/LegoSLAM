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
	private int[] angles = {-90,-60,-30,0,30,60,90};  
	private UltrasonicSensor us;
	
	public Scan() {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = 255;
		}
		us = new UltrasonicSensor(US_PORT);
	}
	
	public void doScan() {
		US_MOTOR.rotateTo(0);
		try {
			for (int i = 0; i < angles.length; i++) {
				int angle = angles[i];
				US_MOTOR.rotateTo(angle);
				Thread.sleep(M_WAIT);
				distances[i] =  getMeasures(M_COUNT);
			}
		} catch (InterruptedException e) {
			System.out.println("Measuring interrupted");
		} finally {
			US_MOTOR.rotateTo(0);
		}
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
