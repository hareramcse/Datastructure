package com.hs.medium;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = 0;
		for (int pile : piles) {
			high = Math.max(high, pile);
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int totalHour = findTotalHour(piles, mid, h);
			if (totalHour <= h) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private int findTotalHour(int[] piles, int mid, int h) {
		int totalHour = 0;
		for (int i = 0; i < piles.length; i++) {
			totalHour += Math.ceil((double) piles[i] / mid);
		}

		return totalHour;
	}

	public static void main(String[] args) {
		KokoEatingBananas obj = new KokoEatingBananas();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		int result = obj.minEatingSpeed(piles, h);
		System.out.println(result);
	}
}
