package com.leetcode.easy;

public class NumberCompliment {
	public int findComplement(int num) {
		int no = 0;
		int power = 0;

		while (no < num) {
			no += Math.pow(2, power);
			power++;
		}

		return no - num;
	}

	public static void main(String[] args) {
		NumberCompliment obj = new NumberCompliment();
		int n = 5;
		int result = obj.findComplement(n);
		System.out.println(result);
	}
}