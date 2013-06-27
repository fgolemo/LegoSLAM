package org.meicogsci.legobot1;

import java.io.IOException;

import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTCommandConnector;
import lejos.pc.comm.NXTConnector;

public class NXTControl { //PC USE ONLY
	
	private NXTConnector conn;
	
	public void init() {
		conn = new NXTConnector();
		conn.addLogListener(new NXTCommLogListener() {
			public void logEvent(String message) {
				System.out.println(message);
			}

			public void logEvent(Throwable throwable) {
				System.err.println(throwable.getMessage());
			}
		});
		conn.setDebug(true);
		if (!conn.connectTo("btspp://NXT", NXTComm.LCP)) {
			System.err.println("Failed to connect");
			System.exit(1);
		}
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm()));
	}
	
	public void exit() {
		try {
			conn.close();
		} catch (IOException e) {
			System.out.println("Error while closing the connection");
			e.printStackTrace();
		}
	}
}
