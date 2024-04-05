package com.hs.easy;

public class HappyNumber {
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;

		// while loop is not used here because initially slow and
		// fast pointer will be equal only, so the loop won't run.
		do {
			slow = square(slow);
			fast = square(square(fast));
		} while (slow != fast);

		// if a cycle exists, then the number is not a happy number and slow will have a
		// value other than 1
		return slow == 1;
	}

	private int square(int n) {
		int result = 0;
		while (n > 0) {
			int remainder = n % 10;
			result += remainder * remainder;
			n = n / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
		int n = 19;
		boolean result = obj.isHappy(n);
		System.out.println(result);
	}
}