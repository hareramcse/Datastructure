package com.hs.dp.mcm;

//887. Super Egg Drop Leetcode
public class EggDroppingTabular {

	public int superEggDrop(int k, int n) {
		int[][] dp = new int[k + 1][n + 1];
		return eggDrop(dp, k, n);
	}

	private int eggDrop(int[][] dp, int k, int n) {
		if (n <= 1)
			return 1;
		if (k == 1)
			return n;
		if (dp[k][n] > 0)
			return dp[k][n];
		int res = n;
		int low = 1, high = n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int breakMove = eggDrop(dp, k - 1, mid - 1);
			int safeMove = eggDrop(dp, k, n - mid);
			res = Math.min(res, Math.max(breakMove, safeMove) + 1);
			if (breakMove == safeMove)
				break;
			else if (breakMove > safeMove)
				high = mid;
			else
				low = mid + 1;
		}
		dp[k][n] = res;
		return res;
	}

	public static void main(String args[]) {
		EggDroppingTabular abcd = new EggDroppingTabular();
		int k = 2, n = 6;
		System.out.print("Minimum number of trials in worst case with " + k + " eggs and " + n + " floors is "
				+ abcd.superEggDrop(k, n));
	}
}