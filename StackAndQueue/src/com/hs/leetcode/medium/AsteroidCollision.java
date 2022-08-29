package com.hs.leetcode.medium;

import java.util.Arrays;
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

				// while deleting in prev step if stack becomes empty
				// then we need to push that astroid into stack.
				// or if astroid is moving in same direction then it will never collide
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

	public static void main(String[] args) {
		AsteroidCollision obj = new AsteroidCollision();
		int[] arr = { 1, 5, 3, -4, 6, -7, 8 };
		int[] result = obj.asteroidCollision(arr);
		System.out.println(Arrays.toString(result));
	}
}