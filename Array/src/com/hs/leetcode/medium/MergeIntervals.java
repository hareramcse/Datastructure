package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();

		if (intervals.length == 0 || intervals == null)
			return res.toArray(new int[0][]);

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] interval : intervals) {
			// interval[0] means start of the interval
			// interval[1] means end of the interval
			if (interval[0] <= end) {
				end = Math.max(end, interval[1]);
			} else {
				res.add(new int[] { start, end });
				start = interval[0];
				end = interval[1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);
	}
}