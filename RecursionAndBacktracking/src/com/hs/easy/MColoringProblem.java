package com.hs.easy;

public class MColoringProblem {
	private int V = 4;
	private int color[];

	/*
	 * This function solves the m Coloring problem using Backtracking. It returns
	 * false if the m colors cannot be assigned, otherwise return true and prints
	 * assignments of colors to all vertices. Please note that there may be more
	 * than one solutions, this function prints one of the feasible solutions.
	 */
	private boolean graphColoring(int graph[][], int m) {
		// Initialize all color values as 0. This initialization
		// is needed correct functioning of isSafe()
		color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = 0;

		// Call graphColoringUtil() for vertex 0
		if (!graphColoringUtil(graph, m, color, 0)) {
			System.out.println("Solution does not exist");
			return false;
		}

		// Print the solution
		printSolution(color);
		return true;
	}

	// A recursive utility function to solve m coloring problem
	private boolean graphColoringUtil(int graph[][], int m, int color[], int v) {
		// base case: If all vertices are assigned a color then return true
		if (v == V)
			return true;

		// Consider this vertex v and try different colors
		for (int c = 1; c <= m; c++) {
			// Check if assignment of color c to v is fine
			if (isSafe(v, graph, color, c)) {
				color[v] = c;

				// recur to assign colors to rest of the vertices
				if (graphColoringUtil(graph, m, color, v + 1))
					return true;

				// If assigning color c doesn't lead to a solution then remove it
				color[v] = 0;
			}
		}

		// If no color can be assigned to this vertex then return false
		return false;
	}

	// A utility function to check if the current color assignment is safe for
	// vertex v
	private boolean isSafe(int v, int graph[][], int color[], int c) {
		for (int i = 0; i < V; i++)
			if (graph[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	// A utility function to print solution
	private void printSolution(int color[]) {
		System.out.println("Solution Exists: Following" + " are the assigned colors");
		for (int i = 0; i < V; i++)
			System.out.print(" " + color[i] + " ");
		System.out.println();
	}

	// driver program to test above function
	public static void main(String args[]) {
		MColoringProblem mColoringProblem = new MColoringProblem();
		int graph[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3; // Number of colors
		mColoringProblem.graphColoring(graph, m);
	}
}