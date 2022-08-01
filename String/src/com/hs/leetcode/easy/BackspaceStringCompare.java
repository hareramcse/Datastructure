package com.hs.leetcode.easy;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
        String a = backspaceCompareUtil(s);
        String b = backspaceCompareUtil(t);
        return a.equals(b);
    }
    
    private String backspaceCompareUtil(String s){
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != '#')
                ans.append(ch);
            else if(ans.length() != 0)
                ans.deleteCharAt(ans.length() - 1);
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