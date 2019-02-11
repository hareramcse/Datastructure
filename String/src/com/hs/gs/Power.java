package com.hs.gs;

public class Power {
	public static double power(double base, int exp) {
		if (base == 0)
			return 0;
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		int positiveExp = (exp < 0) ? exp * -1 : exp;
		double result = (positiveExp % 2 == 0) ? power(base * base, positiveExp / 2)
				: base * power(base * base, (positiveExp - 1) / 2);
		return exp < 0 ? 1 / result : result;
	}

	public static boolean doTestPass() {
		double base[] = { 2, 2, 2.3, 0, 5.5, 6.2 };
		int exponent[] = { 4, -3, 20, 10, 0, 1 };
		boolean doTestsPass = true;
		double tolerance = 0.0001;

		for (int i = 0; i < base.length; ++i) {
			double actual = power(base[i], exponent[i]);
			double expected = Math.pow(base[i], exponent[i]);
			boolean currentResult = Math.abs(actual - expected) < tolerance;
			doTestsPass = doTestsPass && currentResult;
			if (!doTestsPass)
				System.out.println("Failed");
		}
		return doTestsPass;
	}

	public static void main(String[] args) {
		if (doTestPass())
			System.out.println("All Tests Pass");
		else
			System.out.println("There are test failures");
	}
}
