package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 784. Letter Case Permutation Medium
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        String op = "";
        letterCasePermutationUtil(s, op, result);
        return result;
    }
    
    private void letterCasePermutationUtil(String ip, String op, List<String> result) {
		if (ip.length() == 0) {
			result.add(op);
			return;
		}
		if (Character.isLetter(ip.charAt(0))) {
			String op1 = op;
			String op2 = op;

			op1 = op1 + Character.toLowerCase(ip.charAt(0));
			op2 = op2 + Character.toUpperCase(ip.charAt(0));
			ip = ip.substring(1);
			letterCasePermutationUtil(ip, op1, result);
			letterCasePermutationUtil(ip, op2, result);
		} else {
			String op1 = op;
			op1 = op1 + ip.charAt(0);
			ip = ip.substring(1);
			letterCasePermutationUtil(ip, op1, result);
		}
	}

	public static void main(String[] args) {
		String ip = "aB1cD";
		LetterCasePermutation pas = new LetterCasePermutation();
		List<String> letterCasePermutation = pas.letterCasePermutation(ip);
		System.out.println(letterCasePermutation);
	}
}