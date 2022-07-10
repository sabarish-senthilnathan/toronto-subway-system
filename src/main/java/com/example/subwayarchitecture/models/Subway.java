package com.example.subwayarchitecture.models;

import java.util.List;

/**
 * Class representing the subway network.
 */
public class Subway {
	/**
	 * The subway lines.
	 */
	private List<Line> lines;

	/**
	 * All stations in the subway.
	 */
	private List<Station> stations;

	/**
	 * Public default constructor.
	 */
	public Subway() {

	}

	/***
	 * Parameterized constructor.
	 * 
	 * @param lines
	 * @param stations
	 */
	public Subway(List<Line> lines, List<Station> stations) {
		this.lines = lines;
		this.stations = stations;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Station> getStations() {
		return stations;
	}

}
