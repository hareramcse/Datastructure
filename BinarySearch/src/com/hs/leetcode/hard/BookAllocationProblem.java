package com.hs.leetcode.hard;

public class BookAllocationProblem {
	public static int findPages(int[] A, int N, int M) {
		 if (N < M)
	            return -1;
		 
		int low = 0;
		int high = 0;
		for (int page : A) {
			high += page;
			low = Math.max(low, page);
		}

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (isPossible(A, mid, M)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean isPossible(int[] A, int mid, int M) {
		int studentsRequired = 1;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (sum > mid) {
				studentsRequired++;
				sum = A[i];
			}
		}
		return studentsRequired <= M;
	}
}