package com.hs.shortestpath;

//Java program to replace all of the O's
//in the matrix with their shortest
//distance from a guard

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceFromaGuardInBank {

//Store dimensions of the matrix
	int M = 5;
	int N = 5;

	class Node {
		int i, j, dist;

		Node(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}

//These arrays are used to get row
//and column numbers of 4 neighbors
//of a given cell
	int row[] = { -1, 0, 1, 0 };
	int col[] = { 0, 1, 0, -1 };

//Return true if row number and
//column number is in range
	boolean isValid(int i, int j) {
		if ((i < 0 || i > M - 1) || (j < 0 || j > N - 1))
			return false;

		return true;
	}

//Return true if current cell is
//an open area and its distance
//from guard is not calculated yet
	boolean isSafe(int i, int j, char matrix[][], int output[][]) {
		if (matrix[i][j] != 'O' || output[i][j] != -1)
			return false;

		return true;
	}

//Function to replace all of the O's
//in the matrix with their shortest
//distance from a guard
	void findDistance(char matrix[][]) {
		int output[][] = new int[M][N];
		Queue<Node> q = new LinkedList<Node>();

		// Finding Guards location and
		// adding into queue
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				// Initialize each cell as -1
				output[i][j] = -1;

				if (matrix[i][j] == 'G') {
					q.add(new Node(i, j, 0));

					// Guard has 0 distance
					output[i][j] = 0;
				}
			}
		}

		// Do till queue is empty
		while (!q.isEmpty()) {

			// Get the front cell in the queue
			// and update its adjacent cells
			Node curr = q.peek();
			int x = curr.i;
			int y = curr.j;
			int dist = curr.dist;

			// Do for each adjacent cell
			for (int i = 0; i < 4; i++) {

				// If adjacent cell is valid, has
				// path and not visited yet,
				// en-queue it.
				if (isValid(x + row[i], y + col[i])) {
					if (isSafe(x + row[i], y + col[i], matrix, output)) {
						output[x + row[i]][y + col[i]] = dist + 1;
						q.add(new Node(x + row[i], y + col[i], dist + 1));
					}
				}
			}

			// Dequeue the front cell as
			// its distance is found
			q.poll();
		}

		// Print output matrix
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

//Driver code
	public static void main(String args[]) {
		char matrix[][] = { { 'O', 'O', 'O', 'O', 'G' }, { 'O', 'W', 'W', 'O', 'O' }, { 'O', 'O', 'O', 'W', 'O' },
				{ 'G', 'W', 'W', 'W', 'O' }, { 'O', 'O', 'O', 'O', 'G' } };

		MinDistanceFromaGuardInBank g = new MinDistanceFromaGuardInBank();

		g.findDistance(matrix);
	}
}

//This code is contributed by Shobhit Yadav
