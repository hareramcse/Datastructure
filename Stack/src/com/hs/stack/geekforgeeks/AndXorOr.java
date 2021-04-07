package com.hs.stack.geekforgeeks;

import java.util.Scanner;
import java.util.Stack;

public class AndXorOr {

	static int solve(int[] a) {
		int result = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int number : a) {
			while (!stack.empty()) {
				result = Math.max(result, calculate(number, stack.peek()));

				if (number < stack.peek()) {
					stack.pop();
				} else {
					break;
				}
			}

			stack.push(number);
		}
		return result;
	}

	static int calculate(int x, int y) {
		return ((x & y) ^ (x | y)) & (x ^ y);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		System.out.println(solve(A));

		sc.close();
	}
}
