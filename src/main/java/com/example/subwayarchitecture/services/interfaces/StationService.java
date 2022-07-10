package com.example.subwayarchitecture.services.interfaces;

import java.util.Map;

import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.models.Schedule;
import com.example.subwayarchitecture.models.Station;

/**
 * Service interface that defined methods to fetch station related information.
 */
public interface StationService {
	/**
	 * Method that takes in a station ID and return the station object.
	 * 
	 * @param id - station ID.
	 * @return   - a station object.
	 */
	public Station getStationById(int id) throws Exception;

	/**
	 * Method that takes in a station ID and returns a hash map containing the line
	 * and the schedule as key-value pairs.
	 * 
	 * @param id - station ID.
	 * @return   - an object containing the line and the arrival timings.
	 */
	public Map<Line, Schedule> getLineScheduleByStationId(int id)  throws Exception;
}
