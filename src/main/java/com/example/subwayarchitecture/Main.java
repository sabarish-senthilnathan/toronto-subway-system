package com.example.subwayarchitecture;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.example.subwayarchitecture.enums.Day;
import com.example.subwayarchitecture.enums.Direction;
import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.models.Schedule;
import com.example.subwayarchitecture.models.Station;
import com.example.subwayarchitecture.services.ScheduleServiceImpl;
import com.example.subwayarchitecture.services.StationServiceImpl;

public class Main {
	static DateTimeFormatter builder = DateTimeFormat.forPattern("hh:mm a");

	public static void main(String[] args) throws Exception {
		// Outputs the next arrival time of subway lines given a station, time and direction.
		StationServiceImpl stationServiceImpl = new StationServiceImpl();
		ScheduleServiceImpl scheduleServiceImpl = new ScheduleServiceImpl(stationServiceImpl);

		// The next arrival time of the subway line at station with ID 8, time 6:55 and direction South.
		int stationId1 = 8;
		Station station1 = stationServiceImpl.getStationById(stationId1);
		Map<Line, LocalTime> nextLine1 = scheduleServiceImpl.getNextLine(stationId1, new LocalTime(07, 55), Day.MONDAY,
				Direction.SOUTH);
		printNextArrivalTimes(nextLine1, station1);

		// The next arrival time of the subway line at station with ID 4, time 7:30 and
		// direction East.
		int stationId2 = 4;
		Station station2 = stationServiceImpl.getStationById(stationId2);
		Map<Line, LocalTime> nextLine2 = scheduleServiceImpl.getNextLine(stationId2, new LocalTime(05, 30), Day.MONDAY,
				Direction.EAST);
		printNextArrivalTimes(nextLine2, station2);

		// Gets and prints the arrival time schedule for station ID 8.
		Map<Line, Schedule> lineSchedule1 = station1.getLineTimeTable();
		printLineSchedule(lineSchedule1);

		// Gets and prints the arrival time schedule for station ID 4.
		Map<Line, Schedule> lineSchedule2 = station2.getLineTimeTable();
		printLineSchedule(lineSchedule2);
	}

	/**
	 * Method that prints the next arrival times of subway lines at a station.
	 * 
	 * @param nextLines - hash map of the line and arrival time info as key-value pairs.
	 */
	private static void printNextArrivalTimes(Map<Line, LocalTime> nextLines, Station station) {
		for (Map.Entry<Line, LocalTime> line : nextLines.entrySet()) {
			String lineName = line.getKey().getName();
			String arrivalTime = builder.print(line.getValue());
			System.out.println(String.format("The next lines arriving at station: %s", station.getName()));
			System.out.println(String.format("Line: %s: at %s", lineName, arrivalTime));
			System.out.println("");
		}
	}

	/**
	 * Method that prints the arrival time schedule for a station. 
	 * 
	 * @param lineSchedule - hash map of the line and schedule info as key-value pairs.
	 */
	private static void printLineSchedule(Map<Line, Schedule> lineSchedule) {
		for (Map.Entry<Line, Schedule> schedule : lineSchedule.entrySet()) {
			String lineName = schedule.getKey().getName();
			Map<Day, NavigableSet<LocalTime>> arrivalTimings = schedule.getValue().getTimings();
			System.out.println(lineName + " schedule: ");
			System.out.println("");
			
			for (Map.Entry<Day, NavigableSet<LocalTime>> localTime : arrivalTimings.entrySet()) {
				String day = localTime.getKey().toString();
				System.out.println(day + ":");		
				Iterator<LocalTime> iterator = localTime.getValue().iterator();
				
				while(iterator.hasNext()) {
					System.out.println(builder.print(iterator.next()));
				}
				
				System.out.println("");
			}
			
			System.out.println("");
		}
	}
}
