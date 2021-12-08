package com.hs.heap;

import java.util.PriorityQueue;

public class SmallestDerangementOfSequence {

	private void generate_derangement(int N) {
		//Generate Sequence and insert
		//into a priority queue.
		int[] S = new int[N + 1];

		PriorityQueue<Integer> PQ = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			S[i] = i;
			PQ.add(S[i]);
		}

		//Generate Least Derangement
		int[] D = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int d = PQ.peek();
			PQ.remove();
			if (d != S[i] || i == N) {
				D[i] = d;
			} else {
				D[i] = PQ.peek();
				PQ.remove();
				PQ.add(d);
			}
		}

		if (D[N] == S[N]) {
			int t = D[N - 1];
			D[N - 1] = D[N];
			D[N] = t;
		}

		//Print Derangement
		for (int i = 1; i <= N; i++)
			System.out.printf("%d ", D[i]);
		System.out.printf("\n");
	}

	//Driver code
	public static void main(String[] args) {
		SmallestDerangementOfSequence array = new SmallestDerangementOfSequence();
		array.generate_derangement(10);
	}
}