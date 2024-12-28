package com.hs.medium;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0;
		int currentGas = 0, startIndex = 0;

		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			currentGas += gas[i] - cost[i];

			// If we run out of gas, reset the starting point
			if (currentGas < 0) {
				startIndex = i + 1; // Start from the next station
				currentGas = 0;
			}
		}

		// Check if the total gas is sufficient
		return totalGas >= totalCost ? startIndex : -1;
	}

	public static void main(String[] args) {
		GasStation obj = new GasStation();
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		int result = obj.canCompleteCircuit(gas, cost);
		System.out.println(result);
	}
}
