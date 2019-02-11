package com.hs.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BesAverageGrade {
	public static Integer bestAverageGrade(String[][] scores) {
		if (scores.length == 0) {
			return 0;
		}

		HashMap<String, ArrayList<Integer>> studentsToScores = new HashMap<String, ArrayList<Integer>>();
		for (String[] scoreRow : scores) {
			if (scoreRow.length != 2)
				return 0;

			String student = scoreRow[0];
			Integer score = Integer.parseInt(scoreRow[1]);

			ArrayList<Integer> currentScores = studentsToScores.get(student);
			if (currentScores == null) {
				currentScores = new ArrayList<Integer>();
				currentScores.add(score);
				studentsToScores.put(student, currentScores);
			} else {
				currentScores.add(score);
			}
		}

		double max = -Double.MAX_VALUE;
		for (ArrayList<Integer> studentScores : studentsToScores.values()) {
			Integer sum = 0;
			for (Integer i : studentScores) {
				sum += i;
			}

			double average = sum / (double) studentScores.size();
			max = Math.max(max, average);
		}

		return (int) Math.floor(max);
	}

	public static boolean doTestsPass() {
		Map<String[][], Integer> testCases = new HashMap<>();

		testCases.put(new String[][] { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } },
				87);
		testCases.put(new String[][] {}, 0);
		testCases.put(new String[][] { { "Sarah", "91" }, { "Goldie", "92" }, { "Elaine", "93" }, { "Elaine", "95" },
				{ "Goldie", "94" }, { "Sarah", "93" } }, 94);
		testCases.put(new String[][] { { "Janie", "-66" }, { "Janie", "0" }, { "Gina", "-88" }, { "Bobby", "0" },
				{ "Gina", "44" }, { "Bobby", "0" }, { "Bobby", "-6" } }, -2);
		testCases.put(new String[][] { { "Alpha", "99" }, { "Bravo", "99" }, { "Charlie", "99" }, { "Delta", "99" },
				{ "Echo", "99" }, { "Foxtrot", "99" }, { "Foxtrot", "99" } }, 99);
		testCases.put(new String[][] { { "Gerald", "91" }, { "Gerald", "92" } }, 91);
		testCases.put(new String[][] { { "Barry", "-66" }, { "Barry", "-65" }, { "Alfred", "-122" } }, -66);

		boolean passed = true;
		for (Map.Entry<String[][], Integer> entry : testCases.entrySet()) {
			Integer actual = bestAverageGrade(entry.getKey());
			if (actual != entry.getValue()) {
				passed = false;
				System.out.println("Failed for " + Arrays.deepToString(entry.getKey()) + "\n  expected "
						+ entry.getValue() + ", actual " + actual);
			}
		}

		return passed;
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
