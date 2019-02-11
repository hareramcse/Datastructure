package com.hs.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StairCase {
	public static Integer countSteps(Integer n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;

		List<Integer> counts = new ArrayList<>(Arrays.asList(0, 1, 2, 4));
		for (int i = 4; i <= n; ++i) {
			counts.add(counts.get(i - 1) + counts.get(i - 2) + counts.get(i - 3));
		}

		return counts.get(n);
	}

	public static boolean doTestsPass() {

		return countSteps(3) == 4 && countSteps(4) == 7 && countSteps(1) == 1 && countSteps(2) == 2
				&& countSteps(0) == 0 && countSteps(-5) == 0 && countSteps(10) == 274 && countSteps(36) == 2082876103; // Will
																														// cause
																														// naive
																														// solution
																														// to
																														// time-out
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}

		for (Integer n = 1; n <= 5; n++) {
			Integer numberOfCombinations = countSteps(n);
			System.out.println(n + " steps => " + numberOfCombinations);
		}
	}
}
