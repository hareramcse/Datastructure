package com.hs.medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Integer> stack = new Stack<>(); // stores indices
		for (int currDay = 0; currDay < temperatures.length; currDay++) {
			while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
				int prevDay = stack.pop();
				ans[prevDay] = currDay - prevDay;
			}
			stack.add(currDay);
		}
		return ans;
	}

	public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] result = obj.dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(result));
	}
}
