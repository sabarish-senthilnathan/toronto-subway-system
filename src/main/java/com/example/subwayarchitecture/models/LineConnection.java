package com.example.subwayarchitecture.models;

/**
 * The class representing a connection in a subway line.
 */
public class LineConnection {
	/**
	 * One end of the connection.
	 */
	private Station station1;

	/**
	 * Other end of the connection.
	 */
	private Station station2;

	/**
	 * The distance between stations.
	 */
	private int travelDistance;

	/**
	 * The sole constructor for the LineConnection class.
	 * 
	 * @param station1
	 * @param station2
	 * @param travelDistance
	 */
	public LineConnection(Station station1, Station station2, int travelDistance) {
		this.station1 = station1;
		this.station2 = station2;
		this.travelDistance = travelDistance;
	}

	public Station getStation1() {
		return station1;
	}

	public void setStation1(Station station1) {
		this.station1 = station1;
	}

	public Station getStation2() {
		return station2;
	}

	public void setStation2(Station station2) {
		this.station2 = station2;
	}

	public int getTravelDistance() {
		return travelDistance;
	}

	public void setTravelDistance(int travelDistance) {
		this.travelDistance = travelDistance;
	}
}
