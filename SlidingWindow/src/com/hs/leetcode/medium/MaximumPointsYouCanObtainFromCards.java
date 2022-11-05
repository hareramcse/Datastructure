package com.hs.leetcode.medium;

public class MaximumPointsYouCanObtainFromCards {
	public int maxScore(int[] cardPoints, int k) {
		int windowSize = cardPoints.length - k, minSum = Integer.MAX_VALUE;
		int currentSum = 0, totalSum = 0;
		int i = 0, j = 0;
		while (j < cardPoints.length) {
			totalSum += cardPoints[j];
			currentSum += cardPoints[j];

			// Here we are finding minimum sum of subarray of size len-k
			if (j - i + 1 == windowSize) {
				minSum = Math.min(minSum, currentSum);
				currentSum -= cardPoints[i];
				i++;
			}
			j++;
		}
		// to return the max sum of k element is totalSum - minSum of len-k element
		return totalSum - (minSum == Integer.MAX_VALUE ? 0 : minSum);
	}

	public static void main(String[] args) {
		MaximumPointsYouCanObtainFromCards obj = new MaximumPointsYouCanObtainFromCards();
		int[] cardPoints = { 100, 40, 17, 9, 73, 75 };
		int k = 3;
		int result = obj.maxScore(cardPoints, k);
		System.out.println(result);
	}
}