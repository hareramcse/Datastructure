package com.hs.medium;

public class AllocateMinimumNumberOfPages {
	public int findMinimumPages(int[] pages, int m) {
		int n = pages.length;
		if (m > n) {
			return -1; // Not enough books to allocate to each student
		}

		int low = 0; // Minimum possible pages is the maximum in the array
		int high = 0; // Maximum possible pages is the sum of all pages
		for (int page : pages) {
			low = Math.max(low, page);
			high += page;
		}
		
		int result = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(pages, n, m, mid)) {
				result = mid;
				high = mid - 1; // Try for a smaller value
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	private boolean isPossible(int[] pages, int n, int m, int maxPages) {
		int studentsRequired = 1;
		int currentPageSum = 0;

		for (int page : pages) {
			if (currentPageSum + page > maxPages) {
				studentsRequired++;
				currentPageSum = page;

				if (studentsRequired > m) {
					return false;
				}
			} else {
				currentPageSum += page;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		AllocateMinimumNumberOfPages obj = new AllocateMinimumNumberOfPages();
		int[] arr = { 12, 34, 67, 90 };
		int k = 2;
		int minimumPages = obj.findMinimumPages(arr, k);
		System.out.println(minimumPages);
	}
}