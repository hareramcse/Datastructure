package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

// An element is leader if it is greater than all the elements to its right side. 
// And the rightmost element is always a leader.
public class LeaderInArray {

	private List<Integer> printLeaders(int arr[], int n) {
		int max_from_right = arr[n - 1];

		List<Integer> ans = new ArrayList<>();
		// Rightmost element is always leader
		ans.add(max_from_right);

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > max_from_right) {
				max_from_right = arr[i];
				ans.add(max_from_right);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LeaderInArray array = new LeaderInArray();
		int arr[] = new int[] { 16, 17, 4, 3, 5, 2 };
		int n = arr.length;
		List<Integer> result = array.printLeaders(arr, n);
		System.out.println(result);
	}
}