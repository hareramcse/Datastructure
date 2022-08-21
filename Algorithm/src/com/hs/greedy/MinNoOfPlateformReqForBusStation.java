package com.hs.greedy;

import java.util.Arrays;

public class MinNoOfPlateformReqForBusStation {

	public int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plateformNeeded = 1, result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				plateformNeeded++;
				i++;
			} else if (arr[i] > dep[j]) {
				plateformNeeded--;
				j++;
			}
			result = Math.max(plateformNeeded, result);
		}
		return result;
	}

	public static void main(String[] args) {
		MinNoOfPlateformReqForBusStation mp = new MinNoOfPlateformReqForBusStation();
		int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
		int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
		int n = arr.length;
		System.out.println("Minimum Number of Platforms Required = " + mp.findPlatform(arr, dep, n));
	}
}