package com.hs.stack.geekforgeeks;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {
	static int line = 1;

	static String showStack(Stack<Integer> stack) {
		String s = "[" + line++ + "] stack: ";
		if (stack.isEmpty()) {
			s += "X ";
		}
		for (Integer i : stack) {
			s += (i + "");
		}
		return s;
	}

	static int getMaxArea(int[] height) {
		int maxArea = 0;
		int top = 0;
		int area = 0;
		int i = 0;

		Stack<Integer> stack = new Stack<Integer>();

		// **** for every building height ****

		while (i < height.length) {

			// **** if stack is empty or height[i] is higher than the bar at top of stack
			if (stack.isEmpty() || (height[i] > height[stack.peek()])) {
				stack.push(i++);
			} else {
				top = stack.pop();
				// **** calculate the area with height[top] stack as smallest bar
				area = height[top] * (stack.empty() ? i : i - stack.peek() - 1);
				// **** update the max area (if needed) ****
				if (area > maxArea) {
					maxArea = area;
				}

			}
			// **** display the stack ****
			System.out.println(showStack(stack) + "area: " + area + " maxArea: " + maxArea + " i: " + i);
		}
		System.out.println("—- —- —-");
		// **** process the contents in the stack ****
		while (!stack.isEmpty()) {
			top = stack.pop();
			if (!stack.isEmpty()) {
				System.out.println("top: " + top + " peek: " + stack.peek());
			} else {
				System.out.println("top: " + top + " i: " + i);
			}
			area = height[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
			// **** update the max area (if needed) ****
			if (area > maxArea) {
				maxArea = area;
			}
			// **** display the stack ****
			System.out.println(showStack(stack) + "area: " + area + " maxArea: " + maxArea + " i: " + i);
		}
		return maxArea;
	}

	public static void main(String[] args) {

		// **** read building heights ****

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] h = new int[N];
		for (int n = 0; n < N; n++) {
			h[n] = sc.nextInt();
		}

		// **** compute and display max area ****
		System.out.println(getMaxArea(h));
		sc.close();
	}
}