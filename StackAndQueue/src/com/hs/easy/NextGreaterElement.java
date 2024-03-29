package com.hs.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(Integer num : nums2){
            while(!stack.isEmpty() && stack.peek() < num){
            	map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for(int i = 0; i< nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
