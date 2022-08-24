package com.hs.leetcode.medium;

import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				// only previous one will explode
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
					stack.pop();
				}

				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				} else if (stack.peek() == Math.abs(asteroid)) {
					// both will explode
					stack.pop();
				}
			}
		}
		int[] result = new int[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return result;
	}
}
