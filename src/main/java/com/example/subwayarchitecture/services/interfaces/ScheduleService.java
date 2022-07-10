package com.example.subwayarchitecture.services.interfaces;

import java.util.Map;

import org.joda.time.LocalTime;

import com.example.subwayarchitecture.enums.Day;
import com.example.subwayarchitecture.enums.Direction;
import com.example.subwayarchitecture.models.Line;

/**
 * Service interface that defined methods to fetch schedule related information.
 */
public interface ScheduleService {
	/**
	 * Method which takes in the station ID, a time, a day and direction and returns
	 * the next available line arriving to the station.
	 *
	 * @param stationId   - the station ID.
	 * @param currentTime - time in HH:mm format.
	 * @param day         - the day of the week.
	 * @param direction   - the direction.
	 * @return            - an object containing the line and the next arrival time of the
	 *                      line.
	 * @throws Exception
	 */
	public Map<Line, LocalTime> getNextLine(int stationId, LocalTime currentTime, Day day, Direction direction)
			throws Exception;
}
