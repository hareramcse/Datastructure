package com.hs.backtracking;

public class TugOfWar {

	private int minDiff;

	private void tugOfWar(int arr[]) {
		int n = arr.length;

		// the boolean array that contains the inclusion and exclusion of an element
		// in current set. The number excluded automatically form the other set
		boolean[] curr_elements = new boolean[n];

		// The inclusion/exclusion array for final solution
		boolean[] soln = new boolean[n];

		minDiff = Integer.MAX_VALUE;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			curr_elements[i] = soln[i] = false;
		}

		// Find the solution using recursive function TOWUtil()
		TOWUtil(arr, n, curr_elements, 0, soln, sum, 0, 0);

		// Print the solution
		System.out.print("The first subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.print("\nThe second subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == false)
				System.out.print(arr[i] + " ");
		}
	}

	// function that tries every possible solution by calling itself recursively
	private void TOWUtil(int arr[], int n, boolean currElements[], int noOfSelectedElements, boolean soln[], int sum,
			int currSum, int currPosition) {
		// checks whether the it is going out of bound
		if (currPosition == n)
			return;

		// checks that the numbers of elements left are not less than the number
		// of elements required to form the solution
		if ((n / 2 - noOfSelectedElements) > (n - currPosition))
			return;

		// consider the cases when current element is not included in the solution
		TOWUtil(arr, n, currElements, noOfSelectedElements, soln, sum, currSum, currPosition + 1);

		// add the current element to the solution
		noOfSelectedElements++;
		currSum = currSum + arr[currPosition];
		currElements[currPosition] = true;

		// checks if a solution is formed
		if (noOfSelectedElements == n / 2) {
			// checks if the solution formed is better than the best solution so far
			if (Math.abs(sum / 2 - currSum) < minDiff) {
				minDiff = Math.abs(sum / 2 - currSum);
				for (int i = 0; i < n; i++)
					soln[i] = currElements[i];
			}
		} else {
			// consider the cases where current element is included in the solution
			TOWUtil(arr, n, currElements, noOfSelectedElements, soln, sum, currSum, currPosition + 1);
		}

		// removes current element before returning to the caller of this function
		currElements[currPosition] = false;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		TugOfWar a = new TugOfWar();
		a.tugOfWar(arr);
	}

}