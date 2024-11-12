package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.hs.graph.shortestpath.Pair;

public class NumberOfWaysToArriveAtDestination {
	public int countPaths(int n, int[][] roads) {
		List<List<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] road : roads) {
			int src = road[0], dest = road[1];
			long time = road[2];
			adjList.get(src).add(new Pair(dest, time));
			adjList.get(dest).add(new Pair(src, time));
		}

		return shortestPath(adjList, 0, n);
	}

	private int shortestPath(List<List<Pair>> adjList, int src, int target) {
		Queue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.weight, y.weight));

		long[] minCost = new long[target];
		Arrays.fill(minCost, Long.MAX_VALUE);

		long[] ways = new long[target];
		ways[src] = 1;
		minCost[src] = 0;

		pq.add(new Pair(src, 0));
		int mod = (int) (1e9 + 7);

		while (!pq.isEmpty()) {
			Pair u = pq.poll();
			int city = u.destination;
			long currCost = u.weight;

			if (currCost > minCost[city])
				continue;

			for (Pair adjNode : adjList.get(city)) {
				int neighbour = adjNode.destination;
				long cost = adjNode.weight;
				if (currCost + cost < minCost[neighbour]) {
					minCost[neighbour] = currCost + cost;
					pq.offer(new Pair(neighbour, minCost[neighbour]));
					ways[neighbour] = ways[city];
				} else if (currCost + cost == minCost[neighbour])
					ways[neighbour] = (ways[neighbour] % mod + ways[city] % mod) % mod;
			}
		}
		return (int) ways[target - 1];
	}
}