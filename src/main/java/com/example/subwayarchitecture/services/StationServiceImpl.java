package com.example.subwayarchitecture.services;

import java.util.Map;

import com.example.subwayarchitecture.helpers.SubwayHelper;
import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.models.Schedule;
import com.example.subwayarchitecture.models.Station;
import com.example.subwayarchitecture.services.interfaces.StationService;

/**
 *  Service class to fetch station related information.
 */
public class StationServiceImpl implements StationService {
	/**
	 * Method that takes in a station ID and return the station object.
	 * 
	 * @param id - station ID.
	 * @return   - a station object.
	 * @throws Exception 
	 */
	public Station getStationById(int id) throws Exception {
		return new SubwayHelper().getStationById(id);
	}

	/**
	 * Method that takes in a station ID and returns a hash map containing the line
	 * and the schedule as key-value pairs.
	 * 
	 * @param id - station ID.
	 * @return   - an object containing the line and the arrival timings.
	 */
	public Map<Line, Schedule> getLineScheduleByStationId(int id) throws Exception {
		return getStationById(id).getLineTimeTable();
	}
}
