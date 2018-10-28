package com.hs.array.orderstatistics;

//Asked in: Amazon,Paytm,Walmart labs
public class MaximumSumSuchThatNoTwoElementAreAdjacent {

	int FindMaxSum(int arr[], int n) {
		//Max sum including the previous element
		int incl = arr[0];
		
		//Max sum excluding the previous element.
		int excl = 0;

		for (int i = 1; i < n; i++) {
			/* current max excluding i */
			int excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		MaximumSumSuchThatNoTwoElementAreAdjacent sum = new MaximumSumSuchThatNoTwoElementAreAdjacent();
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		System.out.println(sum.FindMaxSum(arr, arr.length));
	}
}
