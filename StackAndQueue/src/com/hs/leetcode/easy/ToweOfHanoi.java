package com.hs.leetcode.easy;

public class ToweOfHanoi {

	public void towerOfHanoi(String source, String dest, String helper, int n) {
		if (n == 1) {
			System.out.println("Moving plate " + n + " from " + source + " to " + dest);
			return;
		}

		towerOfHanoi(source, helper, dest, n - 1);
		System.out.println("Moving plate " + n + " from " + source + " to " + dest);
		towerOfHanoi(helper, dest, source, n - 1);
	}

	public static void main(String[] args) {
		ToweOfHanoi rev = new ToweOfHanoi();
		int n = 3;
		String source = "source", helper = "helper", dest = "dest";
		rev.towerOfHanoi(source, dest, helper, n);
	}
}