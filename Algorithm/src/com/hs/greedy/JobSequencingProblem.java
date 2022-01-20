package com.hs.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem {

	// Each job has a unique-id,
	// profit and deadline
	char id;
	int deadline, profit;

	// Constructors
	public JobSequencingProblem() {
	}

	public JobSequencingProblem(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	// Function to schedule the jobs take 2
	// arguments arraylist and no of jobs to schedule
	void printJobScheduling(ArrayList<JobSequencingProblem> arr, int t) {
		// Length of array
		int n = arr.size();

		// Sort all jobs according to
		// decreasing order of profit
		Collections.sort(arr, (a, b) -> b.profit - a.profit);

		// To keep track of free time slots
		boolean result[] = new boolean[t];

		// To store result (Sequence of jobs)
		char job[] = new char[t];

		// Iterate through all given jobs
		for (int i = 0; i < n; i++) {
			// Find a free slot for this job
			// (Note that we start from the
			// last possible slot)
			for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {

				// Free slot found
				if (result[j] == false) {
					result[j] = true;
					job[j] = arr.get(i).id;
					break;
				}
			}
		}

		// Print the sequence
		for (char jb : job) {
			System.out.print(jb + " ");
		}
		System.out.println();
	}

	// Driver code
	public static void main(String args[]) {
		ArrayList<JobSequencingProblem> arr = new ArrayList<JobSequencingProblem>();

		arr.add(new JobSequencingProblem('a', 2, 100));
		arr.add(new JobSequencingProblem('b', 1, 19));
		arr.add(new JobSequencingProblem('c', 2, 27));
		arr.add(new JobSequencingProblem('d', 1, 25));
		arr.add(new JobSequencingProblem('e', 3, 15));

		// Function call
		System.out.println("Following is maximum " + "profit sequence of jobs");

		JobSequencingProblem job = new JobSequencingProblem();

		// Calling function
		job.printJobScheduling(arr, 3);
	}

}