package com.hs.gs;

import java.util.Arrays;

/* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
** Instructions to candidate.
**  1) Given an array of non-negative integers representing the elevations
**     from the vertical cross section of a range of hills, determine how
**     many units of snow could be captured between the hills. 
**
**     See the example array and elevation map below.
**                                 ___
**             ___                |   |        ___
**            |   |        ___    |   |___    |   |
**         ___|   |    ___|   |   |   |   |   |   |
**     ___|___|___|___|___|___|___|___|___|___|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**                                 ___
**             ___                |   |        ___
**            |   | *   *  _*_  * |   |_*_  * |   |
**         ___|   | *  _*_|   | * |   |   | * |   |
**     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
**     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
**
**     Solution: In this example 13 units of snow (*) could be captured.
**
**  2) Consider adding some additional tests in doTestsPass().
**  3) Implement computeSnowpack() correctly.
*/

class SnowPack {
	/*
	 ** Find the amount of snow that could be captured.
	 */
	public static Integer computeSnowpack(Integer[] arr) {
		// Check for empty array
		if (arr.length == 0) {
			return 0;
		}

		Integer total = 0;
		Integer left_highest[] = new Integer[arr.length];
		Integer left_max = 0;
		for (Integer i = 0; i < arr.length; i++) {
			if (arr[i] > left_max)
				left_max = arr[i];
			left_highest[i] = left_max;
		}
		Integer right_max = 0;
		for (Integer i = arr.length - 1; i > 0; i--) {
			if (arr[i] > right_max)
				right_max = arr[i];
			if (Math.min(right_max, left_highest[i]) > arr[i])
				total += Math.min(right_max, left_highest[i]) - arr[i];
		}

		System.out.println(Arrays.toString(arr) + ' ' + total);
		return total;
	}

	/*
	 ** Returns true if the tests pass. Otherwise, returns false;
	 */
	public static boolean doTestsPass() {
		boolean result = true;
		result &= computeSnowpack(new Integer[] { 0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 }) == 13;
		result &= computeSnowpack(new Integer[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }) == 10;
		result &= computeSnowpack(new Integer[] { 0, 0, 0, 0, 0 }) == 0;
		result &= computeSnowpack(new Integer[] { 0, 0, 1, 0, 0 }) == 0;
		result &= computeSnowpack(new Integer[] { 1 }) == 0;
		result &= computeSnowpack(new Integer[] {}) == 0;

		return result;
	}

	/*
	 ** Execution entry point.
	 */
	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
