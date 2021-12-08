package com.hs.connectivity;

import java.util.Stack;
import java.util.Vector;

public class EulerianPathInUnDirectedGraph {

	// Function to find out the path
	// It takes the adjacency matrix
	// representation of the graph as input
	static void findpath(int[][] graph, int n) {
		Vector<Integer> numofadj = new Vector<>();

		// Find out number of edges each vertex has
		for (int i = 0; i < n; i++)
			numofadj.add(accumulate(graph[i], 0));

		// Find out how many vertex has odd number edges
		int startPoint = 0, numofodd = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (numofadj.elementAt(i) % 2 == 1) {
				numofodd++;
				startPoint = i;
			}
		}

		// If number of vertex with odd number of edges
		// is greater than two return "No Solution".
		if (numofodd > 2) {
			System.out.println("No Solution");
			return;
		}

		// If there is a path find the path
		// Initialize empty stack and path
		// take the starting current as discussed
		Stack<Integer> stack = new Stack<>();
		Vector<Integer> path = new Vector<>();
		int cur = startPoint;

		// Loop will run until there is element in the stack
		// or current edge has some neighbour.
		while (!stack.isEmpty() || accumulate(graph[cur], 0) != 0) {

			// If current node has not any neighbour
			// add it to path and pop stack
			// set new current to the popped element
			if (accumulate(graph[cur], 0) == 0) {
				path.add(cur);
				cur = stack.pop();

				// If the current vertex has at least one
				// neighbour add the current vertex to stack,
				// remove the edge between them and set the
				// current to its neighbour.
			} else {
				for (int i = 0; i < n; i++) {
					if (graph[cur][i] == 1) {
						stack.add(cur);
						graph[cur][i] = 0;
						graph[i][cur] = 0;
						cur = i;
						break;
					}
				}
			}
		}

		// print the path
		for (int ele : path)
			System.out.print(ele + " -> ");
		System.out.println(cur);
	}

	static int accumulate(int[] arr, int sum) {
		for (int i : arr)
			sum += i;
		return sum;
	}

	// Driver Code
	public static void main(String[] args) {

		// Test case 1
		int[][] graph1 = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0 },
				{ 1, 0, 0, 0, 0 } };
		int n = graph1.length;
		findpath(graph1, n);

		// Test case 2
		int[][] graph2 = { { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 1, 0, 1, 0, 0 } };
		n = graph2.length;
		findpath(graph2, n);

		// Test case 3
		int[][] graph3 = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1 },
				{ 1, 1, 0, 1, 0 } };
		n = graph3.length;
		findpath(graph3, n);
	}

}