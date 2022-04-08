package com.hs.bst;

public class AllocateMinimumNoOfPages {
	private int findPages(int[] arr, int k) {
		int n = arr.length;
		int sum = 0;

		// return -1 if no. of books is less than no. of students
		if (n < k)
			return -1;

		// Count total number of pages
		for (int i = 0; i < n; i++)
			sum += arr[i];

		// initialize start as 0 pages and end as total pages
		int start = 0;
		int end = sum;
		int result = Integer.MAX_VALUE;

		// traverse until start <= end
		while (start <= end) {
			// check if it is possible to distribute
			// books by using mid is current minimum
			int mid = start + (end - start) / 2;
			if (isPossible(arr, n, k, mid)) {
				// update result to current distribution
				// as it's the best we have found till now.
				result = mid;

				// as we are finding minimum and books
				// are sorted so reduce end = mid -1
				// that means
				end = mid - 1;
			} else
				// if not possible means pages should be
				// increased so update start = mid + 1
				start = mid + 1;
		}

		// at-last return minimum no. of pages
		return result;
	}

	private boolean isPossible(int arr[], int n, int k, int curr_min) {
		int studentsRequired = 1;
		int curr_sum = 0;

		// iterate over all books
		for (int i = 0; i < n; i++) {
			// check if current number of pages are greater
			// than curr_min that means we will get the result
			// after mid no. of pages
			if (arr[i] > curr_min)
				return false;

			// count how many students are required
			// to distribute curr_min pages
			curr_sum = curr_sum + arr[i];
			if (curr_sum > curr_min) {
				// increment student count
				studentsRequired++;

				// update curr_sum
				curr_sum = arr[i];

				// if students required becomes greater
				// than given no. of students,return false
				if (studentsRequired > k)
					return false;
			}

			// else update curr_sum
			else
				curr_sum += arr[i];
		}
		return true;
	}

	public static void main(String[] args) {
		AllocateMinimumNoOfPages bst = new AllocateMinimumNoOfPages();
		// Number of pages in books
		int arr[] = { 12, 34, 67, 90 };
		int k = 2; // No. of students
		System.out.println("Minimum number of pages = " + bst.findPages(arr, k));
	}
}