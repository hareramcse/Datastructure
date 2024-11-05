package com.hs.medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int result = 0;
		int currentEnd = intervals[0][1];

		for (int i = 1; i < intervals.length; i++)
			if (intervals[i][0] >= currentEnd)
				currentEnd = intervals[i][1];
			else {
				currentEnd = Math.min(currentEnd, intervals[i][1]);
				result++;
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
