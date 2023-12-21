package com.hs.easy;

public class HamiltonianCycle {
	private int noOfVertices;
	private int path[];

	HamiltonianCycle(int graph[][]) {
		this.noOfVertices = graph.length;
		path = new int[noOfVertices];
		for (int i = 0; i < noOfVertices; i++)
			path[i] = -1;
	}

	private int hamCycle(int graph[][]) {
		// Let us put vertex 0 as the first vertex in the path.
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == false) {
			System.out.println("\nSolution does not exist");
			return 0;
		}

		printSolution(path);
		return 1;
	}

	// A recursive utility function to solve hamiltonian cycle problem
	boolean hamCycleUtil(int graph[][], int path[], int pos) {
		// base case: If all vertices are included in Hamiltonian Cycle
		if (pos == noOfVertices) {
			// if there is an edge from the last included vertex to the first vertex
			if (graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}

		// Try different vertices as a next candidate in Hamiltonian Cycle.
		// We don't try for 0 as we included 0 as starting point
		for (int v = 1; v < noOfVertices; v++) {
			// Check if this vertex can be added to Hamiltonian Cycle
			if (isSafe(v, graph, path, pos)) {
				path[pos] = v;

				// recur to construct rest of the path
				if (hamCycleUtil(graph, path, pos + 1) == true)
					return true;

				// If adding vertex v doesn't lead to a solution, then remove it
				path[pos] = -1;
			}
		}

		// If no vertex can be added to Hamiltonian Cycle constructed so far
		return false;
	}

	// if the vertex v can be added at index 'pos'in the Hamiltonian Cycle
	private boolean isSafe(int v, int graph[][], int path[], int pos) {
		// Check if this vertex is an adjacent vertex of the previously added vertex.
		if (graph[path[pos - 1]][v] == 0)
			return false;

		// Check if the vertex has already been included.
		for (int i = 0; i < pos; i++)
			if (path[i] == v)
				return false;

		return true;
	}

	// A utility function to print solution
	private void printSolution(int path[]) {
		System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
		for (int i = 0; i < noOfVertices; i++)
			System.out.print(path[i] + " ");

		// Let us print the first vertex again to show the complete cycle
		System.out.println(path[0]);
	}

	// driver program to test above function
	public static void main(String args[]) {

		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };
		HamiltonianCycle hamiltonian = new HamiltonianCycle(graph1);
		hamiltonian.hamCycle(graph1);

		int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 }, };
		hamiltonian.hamCycle(graph2);
	}
}