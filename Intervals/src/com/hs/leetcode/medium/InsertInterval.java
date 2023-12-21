package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		for (int[] interval : intervals) {
			if (newInterval[0] > interval[1]) {
				result.add(interval);
			} else if (newInterval[1] < interval[0]) {
				// it means newInterval starts before any other interval
				result.add(newInterval);
				// We are making this because once it is added to result there is nothing to add
				// as in input all the intervals are non overlapped
				// so we need to add input interval as well
				newInterval = interval;
			} else {
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		InsertInterval obj = new InsertInterval();
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 4, 8 };
		int[][] result = obj.insert(intervals, newInterval);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}