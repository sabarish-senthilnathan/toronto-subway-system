package com.example.subwayarchitecture.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.joda.time.LocalTime;

import com.example.subwayarchitecture.enums.Day;
import com.example.subwayarchitecture.enums.Direction;
import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.models.Schedule;
import com.example.subwayarchitecture.models.Station;
import com.example.subwayarchitecture.services.interfaces.ScheduleService;

/**
 * Service class to fetch schedule related information.
 */
public class ScheduleServiceImpl implements ScheduleService {
	private StationServiceImpl stationService;

	public ScheduleServiceImpl(StationServiceImpl stationService) {
		this.stationService = stationService;
	}

	/**
	 * Method which takes in the station ID, a time, a day and direction and returns
	 * the next available line arriving to the station.
	 *
	 * @param stationId   - the station ID.
	 * @param currentTime - time in HH:mm format.
	 * @param day         - the day of the week.
	 * @param direction   - the direction.
	 * @return            - an object containing the line and the next arriving time of the
	 *                      line.
	 * @throws Exception
	 */
	public Map<Line, LocalTime> getNextLine(int stationId, LocalTime currentTime, Day day, Direction direction)
			throws Exception {
		Map<Line, LocalTime> nextLine = new HashMap<Line, LocalTime>();

		try {
			Station station = this.stationService.getStationById(stationId);
			Map<Line, Schedule> linesFilteredByDirection = station.getLineTimeTable()
					.entrySet()
					.stream()
					.filter(map -> map.getKey().getDirection() == direction)
					.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

			for (Entry<Line, Schedule> line : linesFilteredByDirection.entrySet()) {
				Optional<NavigableSet<LocalTime>> scheduleFilterByDay = line.getValue().getTimings()
						.entrySet()
						.stream()
						.filter(map -> map.getKey() == day)
						.map(Map.Entry::getValue)
						.findFirst();

				if (scheduleFilterByDay == null)
					throw new Exception(
							String.format("No schedule found for station id: %s", String.valueOf(stationId)));

				LocalTime nextLineTime = scheduleFilterByDay.get().ceiling(currentTime);
				nextLine.put(line.getKey(), nextLineTime);
			}
		} catch (Exception ex) {
			throw ex;
		}

		return nextLine;
	}
}
