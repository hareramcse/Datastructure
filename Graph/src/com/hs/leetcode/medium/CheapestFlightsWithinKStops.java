package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		List<List<Node>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] flight : flights) {
			int from = flight[0], to = flight[1], price = flight[2];
			adjList.get(from).add(new Node(to, price));
		}

		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(0, src, 0));
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;

		while (!queue.isEmpty()) {
			Tuple u = queue.poll();
			int stops = u.first;
			int node = u.second;
			int cost = u.third;

			if (stops > K)
				continue;

			for (Node adjNode : adjList.get(node)) {
				int destination = adjNode.destination;
				int weight = adjNode.weight;

				if (cost + weight < dist[destination] && stops <= K) {
					dist[destination] = cost + weight;
					queue.add(new Tuple(stops + 1, destination, cost + weight));
				}
			}
		}

		if (dist[dst] == Integer.MAX_VALUE)
			return -1;
		return dist[dst];
	}

	public static void main(String[] args) {
		CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
		int[][] grid = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		int src = 0, dst = 3, k = 1;
		int result = obj.findCheapestPrice(grid.length, grid, src, dst, k);
		System.out.println(result);
	}
}