package com.example.subwayarchitecture.models;

import java.util.Map;
import java.util.NavigableSet;

import org.joda.time.LocalTime;

import com.example.subwayarchitecture.enums.Day;

/**
 * The class representing the schedule of the subway lines for each day of the
 * week.
 */
public class Schedule {
	/**
	 * The key-value pairs representing the day of the week and the arrival times.
	 */
	private Map<Day, NavigableSet<LocalTime>> timings;

	/**
	 * The sole constructor for the Schedule class.
	 * 
	 * @param timings
	 */
	public Schedule(Map<Day, NavigableSet<LocalTime>> timings) {
		this.timings = timings;
	}

	public Map<Day, NavigableSet<LocalTime>> getTimings() {
		return timings;
	}

	public void setTimings(Map<Day, NavigableSet<LocalTime>> timings) {
		this.timings = timings;
	}
}
