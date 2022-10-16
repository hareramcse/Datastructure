package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		List<List<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = flights.length;
		// col 0 -- from, col 1 -- to, col 3 -- price
		for (int i = 0; i < m; i++) {
			adjList.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}

		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(0, src, 0));
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;

		while (!queue.isEmpty()) {
			Tuple tuple = queue.peek();
			queue.poll();
			int stops = tuple.first;
			int node = tuple.second;
			int cost = tuple.third;

			if (stops > K)
				continue;

			for (Pair pair : adjList.get(node)) {
				int adjNode = pair.first;
				int edgeWeight = pair.second;

				if (cost + edgeWeight < dist[adjNode] && stops <= K) {
					dist[adjNode] = cost + edgeWeight;
					queue.add(new Tuple(stops + 1, adjNode, cost + edgeWeight));
				}
			}
		}

		if (dist[dst] == Integer.MAX_VALUE)
			return -1;
		return dist[dst];
	}
}