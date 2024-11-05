package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int n = intervals.length, i = 0;
		List<int[]> result = new ArrayList<>();

		// add all the intervals ending before newInterval starts
		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// merge all overlapping intervals to one considering newInterval
		while (i < n && newInterval[1] >= intervals[i][0]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		result.add(newInterval);

		// add remaining intervals
		while (i < n) {
			result.add(intervals[i]);
			i++;
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		InsertInterval obj = new InsertInterval();
		int[][] intervals = { { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 1, 2 };
		int[][] result = obj.insert(intervals, newInterval);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}