package com.hs.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public List<Integer> majorityElement(int[] nums) {
		int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;

		// Finding candidate
		for (int num : nums) {
			if (candidate1 == num) {
				count1++;
			} else if (candidate2 == num) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// Verifying candidate
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (candidate1 == num)
				count1++;
			if (candidate2 == num)
				count2++;
		}

		// Checking if candidate is majority element
		List<Integer> ansList = new ArrayList<>();
		if (count1 > nums.length / 3)
			ansList.add(candidate1);
		
		if (count2 > nums.length / 3)
			ansList.add(candidate2);

		return ansList;
	}

	public static void main(String[] args) {
		MajorityElement2 obj = new MajorityElement2();
		int[] arr = { 2, 2 };
		List<Integer> result = obj.majorityElement(arr);
		System.out.println(result);
	}
}