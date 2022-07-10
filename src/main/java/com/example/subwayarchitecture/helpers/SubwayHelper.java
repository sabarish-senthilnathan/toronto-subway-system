package com.example.subwayarchitecture.helpers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.joda.time.LocalTime;

import com.example.subwayarchitecture.enums.Day;
import com.example.subwayarchitecture.enums.Direction;
import com.example.subwayarchitecture.models.Line;
import com.example.subwayarchitecture.models.LineConnection;
import com.example.subwayarchitecture.models.Schedule;
import com.example.subwayarchitecture.models.Station;
import com.example.subwayarchitecture.models.Subway;

/**
 * Helper class to populate mock stations and lines in the subway network.
 */
public class SubwayHelper {

	// dummy line speed in km/hr.
	private static int LINE_SPEED = 100;

	private static Subway subway = new Subway();

	private static List<Line> lines = new LinkedList<Line>();

	private static List<Station> stations = new LinkedList<Station>();

	/**
	 * Static initializer that creates mock stations and lines in the subway
	 * network.
	 */
	static {
		Line yongeUniversity = new Line(1, "Line 1 Yonge-University", "Yellow", Direction.SOUTH);
		Line bloorDanforth = new Line(2, "Line 2 Bloor-Danforth", "Green", Direction.EAST);

		Station kiplingStation = new Station(1, "Kipling");
		Station royalYorkStation = new Station(2, "Royal York");
		Station oldMillStation = new Station(3, "Old Mill");
		Station janetStation = new Station(4, "York University");

		List<Station> stations1 = new LinkedList<Station>();
		stations1.add(kiplingStation);
		stations1.add(royalYorkStation);
		stations1.add(oldMillStation);
		stations1.add(janetStation);

		LineConnection lineConnection1 = new LineConnection(kiplingStation, royalYorkStation, 3);
		LineConnection lineConnection2 = new LineConnection(royalYorkStation, oldMillStation, 10);
		LineConnection lineConnection3 = new LineConnection(oldMillStation, janetStation, 5);

		List<LineConnection> connections1 = new LinkedList<LineConnection>();
		connections1.add(lineConnection1);
		connections1.add(lineConnection2);
		connections1.add(lineConnection3);

		bloorDanforth.setConnections(connections1);

		// Set the schedule for Monday for the Bloor-Danforth line.
		Map<Day, NavigableSet<LocalTime>> bloorDanforthLineDaySchedule = new HashMap<Day, NavigableSet<LocalTime>>();
		NavigableSet<LocalTime> bloorDanforthTimings = new TreeSet<LocalTime>();
		bloorDanforthTimings.add(new LocalTime(6, 30));
		bloorDanforthTimings.add(new LocalTime(7, 30));
		bloorDanforthTimings.add(new LocalTime(7, 45));
		bloorDanforthTimings.add(new LocalTime(8, 10));
		bloorDanforthTimings.add(new LocalTime(9, 30));
		bloorDanforthTimings.add(new LocalTime(10, 10));

		Map<Day, NavigableSet<LocalTime>> bloorDanforthLineTueTimings = new HashMap<Day, NavigableSet<LocalTime>>();
		NavigableSet<LocalTime> bloorDanforthTimings2 = new TreeSet<LocalTime>();
		bloorDanforthTimings2.add(new LocalTime(5, 30));
		bloorDanforthTimings2.add(new LocalTime(6, 10));
		bloorDanforthTimings2.add(new LocalTime(6, 45));
		bloorDanforthTimings2.add(new LocalTime(7, 10));
		bloorDanforthTimings2.add(new LocalTime(7, 30));
		bloorDanforthTimings2.add(new LocalTime(8, 30));
		bloorDanforthTimings2.add(new LocalTime(10, 10));
		
		bloorDanforthLineDaySchedule.put(Day.MONDAY, bloorDanforthTimings);
		bloorDanforthLineDaySchedule.put(Day.TUESDAY, bloorDanforthTimings2);
		Schedule bloorDanforthLineSchedule = new Schedule(bloorDanforthLineDaySchedule);

		bloorDanforth.setStartTimings(bloorDanforthLineSchedule);

		lines.add(bloorDanforth);

		Station vaughn = new Station(5, "Kipling");
		Station highway407 = new Station(6, "Royal York");
		Station pioneerVillage = new Station(7, "Old Mill");
		Station york = new Station(8, "Jane");

		List<Station> stations2 = new LinkedList<Station>();
		stations2.add(vaughn);
		stations2.add(highway407);
		stations2.add(pioneerVillage);
		stations2.add(york);

		LineConnection lineConnection4 = new LineConnection(vaughn, highway407, 5);
		LineConnection lineConnection5 = new LineConnection(highway407, pioneerVillage, 10);
		LineConnection lineConnection6 = new LineConnection(pioneerVillage, york, 5);

		List<LineConnection> connections2 = new LinkedList<LineConnection>();
		connections2.add(lineConnection4);
		connections2.add(lineConnection5);
		connections2.add(lineConnection6);

		yongeUniversity.setConnections(connections1);

		// Sets the schedule for Monday for the Yonge-University line.
		Map<Day, NavigableSet<LocalTime>> yongeUniLineMonTimings = new HashMap<Day, NavigableSet<LocalTime>>();
		NavigableSet<LocalTime> yongeUniTimings = new TreeSet<LocalTime>();
		yongeUniTimings.add(new LocalTime(5, 00));
		yongeUniTimings.add(new LocalTime(5, 30));
		yongeUniTimings.add(new LocalTime(6, 30));
		yongeUniTimings.add(new LocalTime(6, 45));
		yongeUniTimings.add(new LocalTime(7, 10));
		yongeUniTimings.add(new LocalTime(8, 30));
		yongeUniTimings.add(new LocalTime(10, 10));

		yongeUniLineMonTimings.put(Day.MONDAY, yongeUniTimings);
		Schedule yongeUniLineSchedule = new Schedule(yongeUniLineMonTimings);

		yongeUniversity.setStartTimings(yongeUniLineSchedule);

		List<Line> yorkLines = new LinkedList<Line>();
		yorkLines.add(yongeUniversity);
		york.setLines(yorkLines);

		List<Line> janetStationLines = new LinkedList<Line>();
		janetStationLines.add(bloorDanforth);
		janetStation.setLines(janetStationLines);

		stations.addAll(stations1);
		stations.addAll(stations2);

		lines.add(bloorDanforth);
		lines.add(yongeUniversity);

		subway.setLines(lines);
		subway.setStations(stations);
	}

	/**
	 * Methods that returns all stations defined in the network.
	 * 
	 * @return - list of stations.
	 */
	public List<Station> getAllStations() {
		return stations;
	}

	/**
	 * Method that returns all subway lines.
	 * 
	 * @return - list of lines.
	 */
	public List<Line> getAllLines() {
		return lines;
	}

	/**
	 * Method that takes in a station ID and returns a station object.
	 * 
	 * @param id - station ID.
	 * @return   - a station object
	 * @throws     Exception
	 */
	public Station getStationById(int id) throws Exception {
		Optional<Station> station = getAllStations()
				.stream()
				.filter(s -> s.getId() == id)
				.findFirst();
		
		if (station == null)
			throw new Exception("No station found");
		
		Station stationToReturn = station.get();
		stationToReturn.setLineTimeTable(getScheduleByStation(stationToReturn));

		return stationToReturn;
	}

	/**
	 * Method that takes in a station object and gets the arrival schedule of the
	 * subway lines from the station.
	 * 
	 * @param station - a station object.
	 * @return -        a hash map containing the lines and the schedules as key-value
	 *                  pairs.
	 */
	public Map<Line, Schedule> getScheduleByStation(Station station) {
		Map<Line, Schedule> result = new HashMap<Line, Schedule>();
		List<Line> lines = station.getLines();

		for (Line line : lines) {
			Schedule startTimings = line.getStartTimings();
			int distance = 0;

			for (LineConnection lineConnection : line.getConnections()) {
				if (lineConnection.getStation2().getId() != station.getId()) {
					distance += lineConnection.getTravelDistance();
				} else {
					distance += lineConnection.getTravelDistance();
					break;
				}
			}

			double updateTime = (double) distance / (double) LINE_SPEED * 60;
			Map<Day, NavigableSet<LocalTime>> schedule = startTimings.getTimings();

			for (Entry<Day, NavigableSet<LocalTime>> entry : schedule.entrySet()) {
				NavigableSet<LocalTime> times = entry.getValue()
						.stream()
						.map(l -> l.plusMinutes((int) updateTime))
						.collect(Collectors.toCollection(TreeSet::new));
				entry.setValue(times);
			}

			result.put(line, startTimings);
		}

		return result;
	}
}
