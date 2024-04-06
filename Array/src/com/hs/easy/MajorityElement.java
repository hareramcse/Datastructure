package com.hs.easy;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int candidate = 0;
        int count = 0;
        
        // Finding candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        
        // Verifying candidate
        count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            }
        }
        
        // Checking if candidate is majority element
        if (count > nums.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element");
        }
    }
}