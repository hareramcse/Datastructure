package com.hs.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {

	static void waiter() {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		Stack<Integer> stackA = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			stackA.push(scanner.nextInt());
		}

		int prime = 2;
		for (int i = 0; i < q; i++) {
			Stack<Integer> stackB = new Stack<Integer>();
			Stack<Integer> nextA = new Stack<Integer>();
			while (!stackA.empty()) {
				int num = stackA.pop();
				if (num % prime == 0) {
					stackB.push(num);
				} else {
					nextA.push(num);
				}
			}
			printStack(stackB);
			stackA = nextA;
			prime = nextPrime(prime);
		}
		printStack(stackA);
		scanner.close();
	}

	static void printStack(Stack<Integer> s) {
		while (!s.empty()) {
			System.out.println(s.pop());
		}
	}

	static int[] convertStackToInteger(Stack<Integer> stack) {
		int i = 0;
		int[] val = new int[stack.size()];
		while (!stack.empty()) {
			val[i++] = stack.pop();
		}
		return val;
	}

	static int nextPrime(int begin) {
		for (int i = begin + 1;; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		waiter();
	}
}
