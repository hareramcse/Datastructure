package com.hs.gs;

/* Problem Name is &&& Train Map &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 * 4) If time permits, some possible follow-ups.
 */

/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class TrainSolutionBFS {
	/**
	 * class Station
	 * <p>
	 * Respresents Station in the rail network. Each station is identified by unique
	 * name. Station is connected with other stations - this information is stored
	 * in the 'neighbours' field. Two station objects with the same name are equal
	 * therefore they are considered to be same station.
	 */
	private static class Station {
		private String name;
		private List<Station> neighbours;

		public Station(String name) {
			this.name = name;
			this.neighbours = new ArrayList<>(3);
		}

		String getName() {
			return name;
		}

		void addNeighbour(Station v) {
			this.neighbours.add(v);
		}

		List<Station> getNeighbours() {
			return this.neighbours;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Station && this.name.equals(((Station) obj).getName());
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.name);
		}
	}

	/**
	 * class TrainMap
	 * <p>
	 * Respresents whole rail network - consists of number of the Station objects.
	 * Stations in the map are bi-directionally connected. Distance between any 2
	 * stations is of same constant distance unit. This implies that shortest
	 * distance between any 2 stations depends only on number of stations in between
	 */
	private static class TrainMap {

		private HashMap<String, Station> stations;

		public TrainMap() {
			this.stations = new HashMap<>();
		}

		public TrainMap addStation(String name) {
			Station s = new Station(name);
			this.stations.putIfAbsent(name, s);
			return this;
		}

		public Station getStation(String name) {
			return this.stations.get(name);
		}

		public TrainMap connectStations(Station fromStation, Station toStation) {
			if (fromStation == null) {
				throw new IllegalArgumentException("From station is null");
			}
			if (toStation == null) {
				throw new IllegalArgumentException("From station is null");
			}
			fromStation.addNeighbour(toStation);
			toStation.addNeighbour(fromStation);
			return this;
		}

		public List<Station> shortestPath(String from, String to) {
			List<Station> result = new ArrayList<>();
			Station source = getStation(from);
			Station destination = getStation(to);
			Set<Station> visitedSet = new HashSet<>();
			Map<Station, Station> predecessor = new HashMap<>();
			LinkedList<Station> queue = new LinkedList<>();

			queue.add(source);
			visitedSet.add(source);
			predecessor.put(source, null);

			if (isDestinationReachable(destination, visitedSet, queue, predecessor))
				result = buildPathUsingPredecessor(predecessor, destination);

			return result;
		}

		private List<Station> buildPathUsingPredecessor(Map<Station, Station> predecessor, Station destination) {

			List<Station> result = new ArrayList<>();
			Stack<Station> stack = new Stack<>();
			stack.push(destination);

			Station nextStation = predecessor.get(destination);
			while (nextStation != null) {
				stack.push(nextStation);
				nextStation = predecessor.get(nextStation);
			}

			while (stack.size() > 0) {
				result.add(stack.pop());
			}

			return result;
		}

		private boolean isDestinationReachable(Station destination, Set<Station> visitedSet, LinkedList<Station> queue,
				Map<Station, Station> predecessor) {

			while (queue.size() > 0) {
				Station currentStation = queue.remove();

				for (int i = 0; i < currentStation.getNeighbours().size(); i++) {
					Station nextStation = currentStation.getNeighbours().get(i);
					if (visitedSet.contains(nextStation))
						continue;

					visitedSet.add(nextStation);
					queue.add(nextStation);
					predecessor.put(nextStation, currentStation);

					if (nextStation.equals(destination))
						return true;
				}
			}

			return false;
		}

		public static String convertPathToStringRepresentation(List<Station> path) {
			if (path.isEmpty()) {
				return "";
			}
			return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
		}
	}

	public static boolean doTestsPass() {
		// todo: implement more tests, please
		// feel free to make testing more elegant
		TrainMap trainMap = new TrainMap();

		trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street")
				.addStation("Moorgate").addStation("Farringdon").addStation("Barbican").addStation("Russel Square")
				.addStation("Holborn").addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

		trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
				.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
				.connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
				.connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
				.connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
				.connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
				.connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
				.connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
				.connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
				.connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

		String expected = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
		String result = TrainMap
				.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's"));

		System.out.println(expected);
		System.out.println(result);

		expected = "King's Cross St Pancras->Angel->Old Street";
		result = TrainMap
				.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "Old Street"));

		System.out.println(expected);
		System.out.println(result);

		return expected.equals(result);
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
