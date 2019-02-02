package com.hs.summation;

import java.util.Vector;

class SumOfAllNodeOfPerfectBinaryTree {

	// function to find sum of
	// all of the nodes of given
	// perfect binary tree
	static int sumNodes(int l) {
		// no of leaf nodes
		int leafNodeCount = (int) Math.pow(2, l - 1);

		// list of vector to store
		// nodes of all of the levels
		Vector<Vector<Integer>> vec = new Vector<Vector<Integer>>();

		// initilize
		for (int i = 1; i <= l; i++)
			vec.add(new Vector<Integer>());

		// store the nodes of last level
		// i.e., the leaf nodes
		for (int i = 1; i <= leafNodeCount; i++)
			vec.get(l - 1).add(i);

		// store nodes of rest of
		// the level by moving in
		// bottom-up manner
		for (int i = l - 2; i >= 0; i--) {
			int k = 0;

			// loop to claculate values
			// of parent nodes from the
			// children nodes of lower level
			while (k < vec.get(i + 1).size() - 1) {

				// store the value of parent
				// node as sum of children nodes
				vec.get(i).add(vec.get(i + 1).get(k) + vec.get(i + 1).get(k + 1));
				k += 2;
			}
		}

		int sum = 0;

		// traverse the list of vector
		// and calculate the sum
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < vec.get(i).size(); j++)
				sum += vec.get(i).get(j);
		}

		return sum;
	}

	// Driver Code
	public static void main(String args[]) {
		int l = 3;

		System.out.println(sumNodes(l));
	}
}