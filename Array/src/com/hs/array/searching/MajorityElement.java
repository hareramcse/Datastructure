package com.hs.array.searching;

import java.util.HashMap;
import java.util.Map;

/*
 * A majority element in an array A[] of size n is an element that appears more than n/2 times 
 * (and hence there is at most one such element)
 * */
public class MajorityElement {

	private static void findMajority(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i]) + 1;
				if (count > arr.length / 2) {
					System.out.println("Majority element " + arr[i]);
					return;
				} else {
					map.put(arr[i], count);
				}
			} else {
				map.put(arr[i], 1);
			}
		}
		System.out.println("No Majority element");
	}

	public static void main(String[] args) {
		int arr[] = { 2, 2, 2, 2, 5, 5, 2, 3, 3 };

		findMajority(arr);
	}
}