package com.hs.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
	public int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

		// Store end times of each room.
		Queue<Integer> minHeap = new PriorityQueue<>();

		for (int[] interval : intervals) {
			// No overlap, we can reuse the same room.
			if (!minHeap.isEmpty() && interval[0] >= minHeap.peek())
				minHeap.poll();
			minHeap.add(interval[1]);
		}

		return minHeap.size();
	}

	public static void main(String[] args) {
		MeetingRooms2 obj = new MeetingRooms2();
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int result = obj.minMeetingRooms(intervals);
		System.out.println(result);
	}
}