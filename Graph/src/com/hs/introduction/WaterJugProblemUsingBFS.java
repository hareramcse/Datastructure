package com.hs.introduction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class WaterJugProblemUsingBFS {

	private void BFS(int source, int destination, int target) {
		// This 2d array is used as a hashmap to keep track of already visited
		// values and avoid repetition
		int m[][] = new int[1000][1000];
		for (int[] i : m) {
			Arrays.fill(i, -1);
		}

		boolean isSolvable = false;
		Vector<Pair> path = new Vector<Pair>();

		Queue<Pair> queue = new LinkedList<Pair>(); // queue to maintain states
		queue.add(new Pair(0, 0)); // Initialing with initial state

		while (!queue.isEmpty()) {

			Pair currentQuantity = queue.poll(); // current state

			// doesn't met jug constraints
			if ((currentQuantity.first > source || currentQuantity.second > destination || currentQuantity.first < 0
					|| currentQuantity.second < 0))
				continue;

			// if this state is already visited
			if (m[currentQuantity.first][currentQuantity.second] > -1)
				continue;

			// filling the vector for constructing the solution path
			path.add(new Pair(currentQuantity.first, currentQuantity.second));

			// marking current state as visited
			m[currentQuantity.first][currentQuantity.second] = 1;

			// if we reach solution state, put ans=1
			if (currentQuantity.first == target || currentQuantity.second == target) {
				isSolvable = true;
				if (currentQuantity.first == target) {
					if (currentQuantity.second != 0)

						// fill final state
						path.add(new Pair(currentQuantity.first, 0));
				} else {
					if (currentQuantity.first != 0)

						// fill final state
						path.add(new Pair(0, currentQuantity.second));
				}

				// print the solution path
				int sz = path.size();
				for (int i = 0; i < sz; i++)
					System.out.println("(" + path.get(i).first + ", " + path.get(i).second + ")");
				break;
			}

			// if we have not reached final state then, start developing intermediate
			// states to reach solution state
			queue.add(new Pair(currentQuantity.first, destination)); // fill Jug2
			queue.add(new Pair(source, currentQuantity.second)); // fill Jug1

			for (int amount = 0; amount <= Math.max(source, destination); amount++) {

				// pour amount ap from Jug2 to Jug1
				int c = currentQuantity.first + amount;
				int d = currentQuantity.second - amount;

				// check if this state is possible or not
				if (c == source || (d == 0 && d >= 0))
					queue.add(new Pair(c, d));

				// Pour amount ap from Jug 1 to Jug2
				c = currentQuantity.first - amount;
				d = currentQuantity.second + amount;

				// check if this state is possible or not
				if ((c == 0 && c >= 0) || d == destination)
					queue.add(new Pair(c, d));
			}

			queue.add(new Pair(source, 0)); // Empty Jug2
			queue.add(new Pair(0, destination)); // Empty Jug1
		}

		// No, solution exists if ans=0
		if (!isSolvable)
			System.out.print("No solution");
	}

	public static void main(String args[]) {
		WaterJugProblemUsingBFS object = new WaterJugProblemUsingBFS();

		int jug1 = 4, jug2 = 3, target = 2;
		System.out.println("Path from initial state to solution state ::");
		object.BFS(jug1, jug2, target);
	}

}