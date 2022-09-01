package com.hs.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInWindowsSizeK {
	public List<Integer> solve(int arr[], int K) {
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[j] < 0) {
				queue.add(arr[j]);
			}
			if (j - i + 1 == K) {
				if (!queue.isEmpty()) {
					ans.add(queue.peek());
					if (queue.peek() == arr[i]) {
						queue.poll();
					}
				} else {
					ans.add(0);
				}
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		FirstNegativeNumberInWindowsSizeK fnniwsk = new FirstNegativeNumberInWindowsSizeK();
		int arr[] = { 12, -1, -7, 8, -15, 30, 13, 28 };
		int k = 3;
		List<Integer> result = fnniwsk.solve(arr, k);
		System.out.println(result);
	}
}