package com.hs.bst;

import java.util.HashSet;
import java.util.Set;

public class FindPairSumEqualToKInBST {

	private boolean findpairUtil(Node root, int sum, Set<Integer> set) {
		if (root == null)
			return false;

		if (findpairUtil(root.left, sum, set))
			return true;

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is found " + (sum - root.data) + ", " + root.data);
			return true;
		} else
			set.add(root.data);

		return findpairUtil(root.right, sum, set);
	}

	private void findPair(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		if (!findpairUtil(root, sum, set))
			System.out.println();
	}

	public static void main(String[] args) {
		FindPairSumEqualToKInBST tree = new FindPairSumEqualToKInBST();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		tree.findPair(root, 60);
	}
}