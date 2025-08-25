package com.hs.hard;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		// Ensure nums1 is the smaller array, because it will reduce time complexity
		if (n > m) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int low = 0, high = n;
		while (low <= high) {
			int cut1 = low + (high - low) / 2;
			int cut2 = (n + m + 1) / 2 - cut1;

			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int r1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			int r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

			if (l1 <= r2 && l2 <= r1) {
				if ((n + m) % 2 != 0)
					return Math.max(l1, l2);
				else
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
			} else if (l1 > r2)
				high = cut1 - 1;
			else
				low = cut1 + 1;
		}

		return 0.0;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
		int[] nums1 = { 1, 2 }, nums2 = { 3, 4 };
		double result = obj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}
}