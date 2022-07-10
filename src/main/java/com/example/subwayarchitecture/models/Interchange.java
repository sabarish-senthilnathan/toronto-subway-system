package com.example.subwayarchitecture.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Interchange object representing a station which is also an interchange.
 */
public class Interchange extends LineConnection {
	List<Line> lines = new LinkedList<Line>();
	private boolean isInterchange = true;

	/**
	 * The sole constructor for the the Interchange object.
	 * 
	 * @param station1       - one end of the connection.
	 * @param station2       - the other end of the connection.
	 * @param travelDistance - the distance between stations.
	 */
	public Interchange(Station station1, Station station2, int travelDistance) {
		super(station1, station2, travelDistance);
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	public boolean isInterchange() {
		return isInterchange;
	}

	public void setInterchange(boolean isInterchange) {
		this.isInterchange = isInterchange;
	}
}
