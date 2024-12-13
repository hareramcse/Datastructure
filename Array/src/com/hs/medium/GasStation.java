package com.hs.medium;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}
		// If totalCost is greater than totalGas, it is not possible to complete the
		// circuit
		if (totalGas < totalCost)
			return -1;

		int remainsGas = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			remainsGas = remainsGas + (gas[i] - cost[i]);
			// If remainsGas becomes negative, it means need to check next station if we can
			// start
			if (remainsGas < 0) {
				remainsGas = 0;
				start = i + 1;
			}
		}
		return start;
	}
}
