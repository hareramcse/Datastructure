package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWaysToArriveAtDestination {
	public int countPaths(int n, int[][] roads) {
		List<List<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = roads.length;
		for (int i = 0; i < m; i++) {
			adjList.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
			adjList.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
		}

		Queue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
		int[] dist = new int[n];
		int[] ways = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
			ways[0] = 0;
		}

		dist[0] = 0;
		ways[0] = 1;
		pq.add(new Pair(0, 0));
		int mod = (int) (1e9 + 7);

		while (!pq.isEmpty()) {
			int dis = pq.peek().first;
			int node = pq.peek().second;
			pq.remove();

			for (Pair pair : adjList.get(node)) {
				int adjNode = pair.first;
				int edgeWeight = pair.second;

				if (dis + edgeWeight < dist[adjNode]) {
					dist[adjNode] = dis + edgeWeight;
					pq.add(new Pair(dis + edgeWeight, adjNode));
					ways[adjNode] = ways[node];
				} else if (dis + edgeWeight == dist[adjNode]) {
					ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
				}
			}
		}
		return ways[n - 1] % mod;
	}
}
