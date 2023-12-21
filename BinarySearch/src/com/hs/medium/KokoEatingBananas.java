package com.hs.medium;

public class KokoEatingBananas {
	public int minEatingSpeed(int[] piles, int h) {
		int max = 0;
		for (int pile : piles) {
			max = Math.max(max, pile);
		}

		if (piles.length == h) {
			return max;
		}

		int low = 1;
		int high = max;
		int ans = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(piles, mid, h)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
	}

	private boolean isPossible(int[] piles, int mid, int h) {
		int res = 0;
		for (int i = 0; i < piles.length; i++) {
			res += Math.ceil(piles[i] * 1.0 / mid);
		}

		return res <= h;
	}
}
