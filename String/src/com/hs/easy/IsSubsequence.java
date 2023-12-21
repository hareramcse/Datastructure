package com.hs.easy;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;

		int i = 0;
		for (int j = 0; j < t.length(); j++) {
			if (t.charAt(j) != s.charAt(i)) {
				continue;
			} else {
				i++;
				if (i == s.length())
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		IsSubsequence obj = new IsSubsequence();
		String s = "abc";
		String t = "ahbgdc";
		boolean result = obj.isSubsequence(s, t);
		System.out.println(result);
	}
}
