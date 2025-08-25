package com.hs.medium;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int low = 1;
		int high = 0;
		for (int pile : piles) {
			high = Math.max(high, pile);
		}

		int result = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canFinish(piles, h, mid)) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	private boolean canFinish(int[] piles, int h, int mid) {
		int hoursNeeded = 0;
		for (int pile : piles) {
			hoursNeeded += Math.ceil((double) pile / mid);
		}

		return hoursNeeded <= h;
	}

	public static void main(String[] args) {
		KokoEatingBananas obj = new KokoEatingBananas();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		int result = obj.minEatingSpeed(piles, h);
		System.out.println(result);
	}
}
