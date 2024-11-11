package com.hs.graph.shortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtaThresholdDistance {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		List<List<Node>> adjList = new ArrayList<>();
		int m = edges[0].length;

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];
			
			adjList.get(u).add(new Node(v, w));
			adjList.get(v).add(new Node(u, w));
		}

		int min = Integer.MAX_VALUE;
		int res = -1;

		for (int i = 0; i < n; i++) {
			Queue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
			boolean[] visited = new boolean[n];
			int count = 0;
			pq.add(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node u = pq.poll();
				int node = u.destination;
				int curDist = u.weight;

				if (visited[node])
					continue;

				visited[node] = true;

				count++;

				for (Node adjNode : adjList.get(node)) {
					int a = adjNode.destination;
					int b = adjNode.weight;
					if (!visited[a] && curDist + b <= distanceThreshold) {
						pq.add(new Node(a, curDist + b));
					}
				}
			}

			if (count - 1 <= min) {
				min = count - 1;
				res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindTheCityWithTheSmallestNumberOfNeighborsAtaThresholdDistance obj = new FindTheCityWithTheSmallestNumberOfNeighborsAtaThresholdDistance();
		int n = 4;
		int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		int distanceThreshold = 4;
		int result = obj.findTheCity(n, edges, distanceThreshold);
		System.out.println(result);
	}
}
