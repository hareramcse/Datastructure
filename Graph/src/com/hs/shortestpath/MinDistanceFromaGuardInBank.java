package com.hs.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceFromaGuardInBank {

	private int M = 5;
	private int N = 5;

	// These arrays are used to get row and column numbers of 4 neighbors of a given
	// cell
	int row[] = { -1, 0, 1, 0 };
	int col[] = { 0, 1, 0, -1 };

	// Function to replace all of the O's in the matrix with their shortest distance
	// from a guard
	private void findDistance(char matrix[][]) {
		int output[][] = new int[M][N];
		Queue<Node> queue = new LinkedList<Node>();

		// Finding Guards location and adding into queue
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				// Initialize each cell as -1
				output[i][j] = -1;

				if (matrix[i][j] == 'G') {
					queue.add(new Node(i, j, 0));

					// Guard has 0 distance
					output[i][j] = 0;
				}
			}
		}

		// Do till queue is empty
		while (!queue.isEmpty()) {

			// Get the front cell in the queue and update its adjacent cells
			Node curr = queue.peek();
			int source = curr.src;
			int destination = curr.dest;
			int distance = curr.distance;

			// Do for each adjacent cell
			for (int i = 0; i < 4; i++) {

				// If adjacent cell is valid, has path and not visited yet, en-queue it.
				if (isValid(source + row[i], destination + col[i])) {
					if (isSafe(source + row[i], destination + col[i], matrix, output)) {
						output[source + row[i]][destination + col[i]] = distance + 1;
						queue.add(new Node(source + row[i], destination + col[i], distance + 1));
					}
				}
			}

			// Dequeue the front cell as its distance is found
			queue.poll();
		}

		// Print output matrix
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Return true if row number and column number is in range
	private boolean isValid(int i, int j) {
		if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1))
			return false;

		return true;
	}

	// Return true if current cell is an open area and its distance from guard is
	// not calculated yet
	private boolean isSafe(int i, int j, char matrix[][], int output[][]) {
		if (matrix[i][j] != 'O' || output[i][j] != -1)
			return false;

		return true;
	}

	// Driver code
	public static void main(String args[]) {
		MinDistanceFromaGuardInBank g = new MinDistanceFromaGuardInBank();

		char matrix[][] = { { 'O', 'O', 'O', 'O', 'G' }, { 'O', 'W', 'W', 'O', 'O' }, { 'O', 'O', 'O', 'W', 'O' },
				{ 'G', 'W', 'W', 'W', 'O' }, { 'O', 'O', 'O', 'O', 'G' } };

		g.findDistance(matrix);
	}
}
