package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
		List<List<Node>> adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : times) {
			int u = edge[0];
			int v = edge[1];
			int w = edge[2];
			adjList.get(u).add(new Node(v, w));
		}

		Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
		pq.add(new int[] { k, 0 });

		int[] distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k] = 0;

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int u = current[0];
			int time = current[1];

			if (time > distance[u])
				continue;

			for (Node adjNode : adjList.get(u)) {
				int v = adjNode.destination;
				int edgeTime = adjNode.weight;

				if (time + edgeTime < distance[v]) {
					distance[v] = time + edgeTime;
					pq.add(new int[] { v, time + edgeTime });
				}
			}
		}

		// Find the maximum time taken to reach any node
		int maxTime = 0;
		for (int i = 1; i <= n; i++) {
			maxTime = Math.max(maxTime, distance[i]);
		}
		return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
	}

	public static void main(String[] args) {
		NetworkDelayTime obj = new NetworkDelayTime();
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4, k = 2;
		int result = obj.networkDelayTime(times, n, k);
		System.out.println(result);
	}

}