package com.hs.introduction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class WaterJugProblemUsingBFS {

	class Pair {
		int first, second;

		Pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	void BFS(int a, int b, int target) {
		// This 2d array is used as a hashmap
		// to keep track of already visited
		// values and avoid repetition
		int m[][] = new int[1000][1000];
		for (int[] i : m) {
			Arrays.fill(i, -1);
		}

		boolean isSolvable = false;
		Vector<Pair> path = new Vector<Pair>();

		Queue<Pair> q = new LinkedList<Pair>(); // queue to maintain states
		q.add(new Pair(0, 0)); // Initialing with initial state

		while (!q.isEmpty()) {

			Pair u = q.peek(); // current state

			q.poll(); // pop off used state

			// doesn't met jug constraints
			if ((u.first > a || u.second > b || u.first < 0 || u.second < 0))
				continue;

			// if this state is already visited
			if (m[u.first][u.second] > -1)
				continue;

			// filling the vector for constructing
			// the solution path
			path.add(new Pair(u.first, u.second));

			// marking current state as visited

			m[u.first][u.second] = 1;

			// System.out.println(m.get(new Pair(u.first, u.second)));

			// if we reach solution state, put ans=1
			if (u.first == target || u.second == target) {
				isSolvable = true;
				if (u.first == target) {
					if (u.second != 0)

						// fill final state
						path.add(new Pair(u.first, 0));
				} else {
					if (u.first != 0)

						// fill final state
						path.add(new Pair(0, u.second));
				}

				// print the solution path
				int sz = path.size();
				for (int i = 0; i < sz; i++)
					System.out.println("(" + path.get(i).first + ", " + path.get(i).second + ")");
				break;
			}

			// if we have not reached final state
			// then, start developing intermediate
			// states to reach solution state
			q.add(new Pair(u.first, b)); // fill Jug2
			q.add(new Pair(a, u.second)); // fill Jug1

			for (int ap = 0; ap <= Math.max(a, b); ap++) {

				// pour amount ap from Jug2 to Jug1
				int c = u.first + ap;
				int d = u.second - ap;

				// check if this state is possible or not
				if (c == a || (d == 0 && d >= 0))
					q.add(new Pair(c, d));

				// Pour amount ap from Jug 1 to Jug2
				c = u.first - ap;
				d = u.second + ap;

				// check if this state is possible or not
				if ((c == 0 && c >= 0) || d == b)
					q.add(new Pair(c, d));
			}

			q.add(new Pair(a, 0)); // Empty Jug2
			q.add(new Pair(0, b)); // Empty Jug1
		}

		// No, solution exists if ans=0
		if (!isSolvable)
			System.out.print("No solution");
	}

	// Driver code
	public static void main(String args[]) {
		int Jug1 = 4, Jug2 = 3, target = 2;

		System.out.println("Path from initial state to solution state ::");

		WaterJugProblemUsingBFS object = new WaterJugProblemUsingBFS();

		object.BFS(Jug1, Jug2, target);

	}

}