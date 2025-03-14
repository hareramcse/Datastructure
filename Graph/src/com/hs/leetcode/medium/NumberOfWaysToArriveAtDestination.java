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
			int u = road[0], v = road[1];
			long time = road[2];
			adjList.get(u).add(new Pair(v, time));
			adjList.get(v).add(new Pair(u, time));
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
			long cost = u.weight;

			if (cost > minCost[city])
				continue;

			for (Pair adjNode : adjList.get(city)) {
				int v = adjNode.destination;
				long edgeCost = adjNode.weight;
				
				if (cost + edgeCost < minCost[v]) {
					minCost[v] = cost + edgeCost;
					pq.add(new Pair(v, minCost[v]));
					ways[v] = ways[city];
				} else if (cost + edgeCost == minCost[v])
					ways[v] = (ways[v] % mod + ways[city] % mod) % mod;
			}
		}
		return (int) ways[target - 1];
	}
}