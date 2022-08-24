package com.hs.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
	private int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i< nums.length; i++){
        	minHeap.add(nums[i]);
            if(minHeap.size() > k){
            	minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    
    public static void main(String[] args){
    	KthLargestElement sol = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int res = sol.findKthLargest(nums, k);
        System.out.println(res);
    }
}