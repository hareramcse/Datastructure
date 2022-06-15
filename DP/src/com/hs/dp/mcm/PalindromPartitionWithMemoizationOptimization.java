package com.hs.dp.mcm;

import java.util.Arrays;

public class PalindromPartitionWithMemoizationOptimization {

	public int minCut(String str) {
        int i = 0;
		int j = str.length() - 1;
        int[][] dp = new int[str.length()][str.length()];
		for (int[] row : dp)
			Arrays.fill(row, -1);
        return solve(str, dp, i, j);
    }
    
    private int solve(String str, int[][] dp, int i, int j){
        if (i >= j || isPolindrome(str, i, j)) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		for (int k = i; k < j; k++) {
			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = solve(str, dp, i, k);
				dp[i][k] = left;
			}

			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = solve(str, dp, k + 1, j);
				dp[k + 1][j] = right;
			}
			int count = left + right + 1;
			min = Math.min(min, count);
		}
		return dp[i][j] = min;
    }
    
    private boolean isPolindrome(String str, int i, int j){
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++; 
            j--;
        }
        return true;
    }

	public static void main(String[] args) {
		PalindromPartitionWithMemoizationOptimization mcm = new PalindromPartitionWithMemoizationOptimization();
		String str = "ababbbabbababa";

		int minCount = mcm.minCut(str);
		System.out.println("Min cuts needed for Palindrome Partitioning is " + minCount);
	}
}