package com.hs.easy;

/*
 *  We use two pointers:
	slow moves one step at a time, fast moves two steps at a time.
	If there’s a cycle, slow and fast will eventually meet. If fast becomes 1, then no cycle → happy number.
 * */
public class HappyNumber {
	public boolean isHappy(int n) {
		int slow = n;
		int fast = getNext(n);

		while (fast != 1 && slow != fast) {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}

		// If fast reached 1, number is happy
		return fast == 1;
	}
	
	private int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int digit = n % 10;
			totalSum += digit * digit;
			n /= 10;
		}
		return totalSum;
	}

	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
		int n = 19;
		boolean result = obj.isHappy(n);
		System.out.println(result);
	}
}