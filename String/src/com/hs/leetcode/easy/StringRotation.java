package com.hs.leetcode.easy;

// 796. Rotate String Leetcode Easy
public class StringRotation {
	public boolean rotateString(String s, String goal) {
		return (s.length() == goal.length()) && (s + s).contains(goal);
	}

	public static void main(String[] args) {
		StringRotation obj = new StringRotation();
		String s = "abcd";
		String goal = "dabc";
		boolean rotateString = obj.rotateString(s, goal);
		System.out.println(rotateString);
	}
}
