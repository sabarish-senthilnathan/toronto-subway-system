package com.example.subwayarchitecture.models;

import java.util.List;

import com.example.subwayarchitecture.enums.Direction;

/**
 * The class representing subway lines.
 */
public class Line {
	/**
	 * The ID of the subway line.
	 */
	private int id;

	/**
	 * The name of the subway line.
	 */
	private String name;

	/**
	 * The color of the subway line.
	 */
	private String color;

	/**
	 * The direction of the subway line.
	 */
	private Direction direction;

	/**
	 * The connections comprising the subway line.
	 */
	private List<LineConnection> connections;

	/**
	 * The arrival times of the subway line.
	 */
	private Schedule startTimings;

	/**
	 * The constructor of the Line object.
	 * 
	 * @param id
	 * @param name
	 * @param color
	 * @param direction
	 */
	public Line(int id, String name, String color, Direction direction) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.direction = direction;
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

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public List<LineConnection> getConnections() {
		return connections;
	}

	public void setConnections(List<LineConnection> connections) {
		this.connections = connections;
	}

	public Schedule getStartTimings() {
		return startTimings;
	}

	public void setStartTimings(Schedule startTimings) {
		this.startTimings = startTimings;
	}
}
