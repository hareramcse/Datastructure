package com.hs.medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

		int result = 0;
		int previousEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (previousEnd > intervals[i][0]) {
				result++;
			} else {
				previousEnd = intervals[i][1];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		int[][] intervals = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 } };
		int result = obj.eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
}
