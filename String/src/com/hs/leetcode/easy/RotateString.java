package com.hs.leetcode.easy;

public class RotateString {
	public boolean rotateString(String s, String goal) {
		return s.length() == goal.length() && (s + s).contains(goal);
	}

	public static void main(String[] args) {
		RotateString obj = new RotateString();
		String s = "abcd";
		String goal = "dabc";
		boolean rotateString = obj.rotateString(s, goal);
		System.out.println(rotateString);
	}
}
