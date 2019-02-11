package com.hs.array.orderstatistics;

import java.util.Collections;
import java.util.PriorityQueue;

class KMaximumSumCombinationFromTwoArray {

	// function to display first K maximum sum combinations
	static void KMaxCombinations(int a[], int b[], int n, int k) {
		// max heap.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		// insert all the possible combinations in max heap.
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				pq.add(a[i] + b[j]);

		// pop first N elements from max heap and display them.
		int count = 0;

		while (count < k) {
			System.out.println(pq.peek());
			pq.remove();
			count++;
		}
	}

	public static void main(String[] args) {
		int A[] = { 4, 2, 5, 1 };
		int B[] = { 8, 0, 5, 3 };
		int N = A.length;
		int K = 3;

		KMaxCombinations(A, B, N, K);
	}
}