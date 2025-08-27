package com.hs.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			if (asteroid > 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()) {
					stack.pop(); // // right asteroid destroyed, continue checking
				}

				// if asteroid is moving in same direction then it will never collide
				if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				} else if (Math.abs(asteroid) == stack.peek()) {
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