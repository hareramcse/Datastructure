package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumProbability {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		List<List<Node>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			double prob = succProb[i];
			adjList.get(u).add(new Node(v, prob));
			adjList.get(v).add(new Node(u, prob));
		}

		double[] probabilities = new double[n];
		probabilities[start_node] = 1.0; // Start node has a probability of 1

		Queue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
		pq.add(new Node(start_node, 1.0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int u = current.destination;
			double probU = current.probability;

			// If we reach the end node, return the probability
			if (u == end_node)
				return probU;

			// Visit each neighbor
			for (Node adjNode : adjList.get(u)) {
				int v = adjNode.destination;
				double probUV = adjNode.probability;

				// Update the probability if we found a higher one
				if (probU * probUV > probabilities[v]) {
					probabilities[v] = probU * probUV;
					pq.offer(new Node(v, probabilities[v]));
				}
			}
		}

		// If we cannot reach the end node, return 0.0
		return 0.0;
	}

	static class Node {
		int destination;
		double probability;

		Node(int destination, double probability) {
			this.destination = destination;
			this.probability = probability;
		}
	}

	public static void main(String[] args) {
		PathWithMaximumProbability obj = new PathWithMaximumProbability();
		int n = 3, start = 0, end = 2;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		double[] succProb = { 0.5, 0.5, 0.2 };
		double result = obj.maxProbability(n, edges, succProb, start, end);
		System.out.println(result);
	}
}
