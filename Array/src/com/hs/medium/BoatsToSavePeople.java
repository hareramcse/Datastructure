package com.hs.medium;

import java.util.Arrays;

public class BoatsToSavePeople {
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int start = 0;
		int end = people.length - 1;
		int boat = 0;
		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				start++;
				end--;
			} else {
				end--;
			}
			boat++;
		}
		return boat;
	}

	public static void main(String[] args) {
		BoatsToSavePeople obj = new BoatsToSavePeople();
		int[] people = { 3, 2, 2, 1 };
		int limit = 3;

		int result = obj.numRescueBoats(people, limit);
		System.out.println(result);
	}
}
