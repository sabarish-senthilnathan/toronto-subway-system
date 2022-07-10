package com.example.subwayarchitecture.models;

import java.util.List;
import java.util.Map;

/**
 * The class representing the stations on a map. Acts as a vertex in a graph.
 */
public class Station {
	/**
	 * The ID of the subway station.
	 */
	private int id;

	/**
	 * The name of the subway station.
	 */
	private String name;

	/**
	 * The subway lines that arrive to the station.
	 */
	private List<Line> lines;

	/**
	 * The subway lines and its arrival times to the station.
	 */
	private Map<Line, Schedule> lineTimeTable;

	/**
	 * The sole constructor.
	 * 
	 * @param id
	 * @param name
	 */
	public Station(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLineTimeTable(Map<Line, Schedule> lineTimeTable) {
		this.lineTimeTable = lineTimeTable;
	}

	public Map<Line, Schedule> getLineTimeTable() {
		return lineTimeTable;
	}
}
