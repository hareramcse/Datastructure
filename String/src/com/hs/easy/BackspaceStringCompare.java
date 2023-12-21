package com.hs.easy;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		String a = backspaceCompareUtil(s);
		String b = backspaceCompareUtil(t);
		return a.equals(b);
	}

	private String backspaceCompareUtil(String s) {
		StringBuilder ans = new StringBuilder();
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '#') {
				count++;
			} else if (count != 0) {
				count--;
			} else {
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		BackspaceStringCompare obj = new BackspaceStringCompare();
		String s = "ab##";
		String t = "c#d#";
		boolean backspaceCompare = obj.backspaceCompare(s, t);
		System.out.println(backspaceCompare);
	}
}