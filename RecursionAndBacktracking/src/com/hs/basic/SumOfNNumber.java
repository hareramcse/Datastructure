package com.hs.basic;

public class SumOfNNumber {
	public int sum(int n) {
		if (n == 0)
			return 0;
		return n + sum(n - 1);
	}

	public static void main(String[] args) {
		SumOfNNumber obj = new SumOfNNumber();
		int n = 3;
		int sum = obj.sum(n);
		System.out.println(sum);
	}
}
