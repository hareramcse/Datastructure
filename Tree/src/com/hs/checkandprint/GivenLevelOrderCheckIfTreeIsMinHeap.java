package com.hs.checkandprint;

import java.io.IOException;

/* We need to check whether each non-leaf node (parent) satisfies the heap property. For 
 * this, we check whether each parent (at index i) is smaller than its children 
 * (at indices 2*i+1 and 2*i+2, if the parent has two children). If only one child,
 * we only check the parent against index 2*i+1.
 * */
public class GivenLevelOrderCheckIfTreeIsMinHeap {
	// Returns true if given level order traversal is Min Heap.
	private static boolean isMinHeap(int[] level) {
		int n = level.length - 1;

		// First non leaf node is at index (n/2-1).
		// Check whether each parent is greater than child
		for (int i = (n / 2 - 1); i >= 0; i--) {
			// Left child will be at index 2*i+1
			// Right child will be at index 2*i+2
			if (level[i] > level[2 * i + 1])
				return false;

			if (2 * i + 2 < n) {
				// If parent is greater than right child
				if (level[i] > level[2 * i + 2])
					return false;
			}
		}
		return true;
	}

	// Driver code
	public static void main(String[] args) throws IOException {
		// Level order traversal
		int[] level = new int[] { 10, 15, 14, 25, 30 };

		if (isMinHeap(level))
			System.out.println("True");
		else
			System.out.println("False");
	}
}
