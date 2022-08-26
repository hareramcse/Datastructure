package com.hs.basic;

import java.util.HashSet;
import java.util.Set;

// 653. Two Sum IV - Input is a BST Leetcode
public class FindPairSumEqualToK {
	public boolean findPair(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		return findPairUtil(root, sum, set);
	}

	private boolean findPairUtil(Node root, int sum, Set<Integer> set) {
		if (root == null)
			return false;

		if (set.contains(sum - root.data))
			return true;
		else
			set.add(root.data);

		return findPairUtil(root.left, sum, set) || findPairUtil(root.right, sum, set);
	}

	public static void main(String[] args) {
		FindPairSumEqualToK tree = new FindPairSumEqualToK();
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right = new Node(70);
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		boolean found = tree.findPair(root, 80);
		System.out.println(found);
	}
}