package com.hs.dp.mcm;

public class EggDroppingProblem {
	private int eggDrop(int k, int n) {
		// If there are no floors, then no trials needed.
		// OR if there is one floor, one trial needed.
		if (n == 0 || n == 1)
			return n;

		// We need k trials for one egg and k floors
		if (k == 1)
			return n;

		int min = n;

		// Consider all droppings from 1st floor to nth floor and
		// return the minimum of these values plus 1.
		for (int i = 1; i <= n; i++) {
			int res = 1 + Math.max(eggDrop(k - 1, i - 1), eggDrop(k, n - i));
			min = Math.min(min, res);
		}
		return min;
	}

	public static void main(String args[]) {
		EggDroppingProblem abcd = new EggDroppingProblem();
		int k = 2, n = 6;
		System.out.print("Minimum number of trials in worst case with " + k + " eggs and " + n + " floors is "
				+ abcd.eggDrop(k, n));
	}
}