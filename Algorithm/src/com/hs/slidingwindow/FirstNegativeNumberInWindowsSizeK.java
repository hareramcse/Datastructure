package com.hs.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInWindowsSizeK {

	private void solve(int arr[], int K) {
		int i = 0;
		int j = 0;
		Queue<Integer> queue = new LinkedList<>();
		while (j < arr.length) {
			if (arr[j] < 0) {
				queue.add(arr[j]);
			}
			if (j - i + 1 == K) {
				if (!queue.isEmpty()) {
					System.out.println(queue.peek());
					if (queue.peek() == arr[i]) {
						queue.poll();
					}
				} else {
					System.out.println(0);
				}
				i++;
			}
			j++;
		}
	}

	public static void main(String[] args) {
		FirstNegativeNumberInWindowsSizeK fnniwsk = new FirstNegativeNumberInWindowsSizeK();
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		fnniwsk.solve(arr, 3);
	}
}
