package com.hs.dp.mcm;

public class EggDroppingProblem {
	private int eggDrop(int n, int k) {
		// If there are no floors, then no trials needed.
		// OR if there is one floor, one trial needed.
		if (k == 1 || k == 0)
			return k;

		// We need k trials for one egg and k floors
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE;

		// Consider all droppings from 1st floor to kth floor and
		// return the minimum of these values plus 1.
		for (int i = 1; i <= k; i++) {
			int res = Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));
			min = Math.min(min, res);
		}
		return min + 1;
	}

	public static void main(String args[]) {
		EggDroppingProblem abcd = new EggDroppingProblem();
		int n = 2, k = 10;
		System.out.print("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is "
				+ abcd.eggDrop(n, k));
	}
}