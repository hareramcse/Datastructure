package com.hs.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Job1 {
	public int startTime;
	public int endTime;
	public int profit;

	public Job1(int startTime, int endTime, int profit) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.profit = profit;
	}
}

public class MaximumProfitInJobScheduling {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job1[] jobs = new Job1[n];

		for (int i = 0; i < n; ++i)
			jobs[i] = new Job1(startTime[i], endTime[i], profit[i]);

		Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);

		for (int i = 0; i < n; ++i)
			startTime[i] = jobs[i].startTime;

		return getMaxProfit(jobs);
	}

	private int getMaxProfit(Job1[] jobs) {
		int maxProfit = 0;
		Queue<Job1> minHeap = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);

		for (Job1 job : jobs) {
			while (!minHeap.isEmpty() && job.startTime >= minHeap.peek().endTime)
				maxProfit = Math.max(maxProfit, minHeap.poll().profit);
			minHeap.offer(new Job1(job.startTime, job.endTime, job.profit + maxProfit));
		}

		while (!minHeap.isEmpty())
			maxProfit = Math.max(maxProfit, minHeap.poll().profit);

		return maxProfit;
	}
}
