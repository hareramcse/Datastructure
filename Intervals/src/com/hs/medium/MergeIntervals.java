package com.hs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList<>();

		if (intervals == null || intervals.length == 0)
			return result.toArray(new int[0][]);

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int[] previous = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] current = intervals[i];

			// overlap → merge
			if (current[0] <= previous[1]) {
				previous[1] = Math.max(previous[1], current[1]);
			} else {
				result.add(previous);
				previous = current;
			}
		}
		result.add(previous);

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		MergeIntervals obj = new MergeIntervals();
		int[][] intervals = { { 1, 3 }, { 2, 4 }, { 2, 6 }, { 8, 9 }, { 8, 10 }, { 9, 11 }, { 15, 18 }, { 16, 17 } };

		int[][] result = obj.merge(intervals);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
