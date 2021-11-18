package com.hs.checkandprint;

import java.util.HashSet;
import java.util.Set;

/*
 * The idea is to use hashing. We traverse the given tree, 
 * for every node, we check if it already exists in hash table. If exists, we return 
 * true (found duplicate). If it does not exist, we insert into hash table.
 */
// O(n)
public class CheckIfTreeContainsDuplicateValue {
	
	// To check if tree has duplicates
	private boolean checkDup(Node root) {
		Set<Integer> set = new HashSet<>();
		return checkDupUtil(root, set);
	}

	// Function that used HashSet to find presence of duplicate nodes
	private boolean checkDupUtil(Node root, Set<Integer> set) {
		// If tree is empty, there are no duplicates.
		if (root == null)
			return false;

		// If current node's data is already present.
		if (set.contains(root.data))
			return true;

		// Insert current node
		set.add(root.data);

		// Recursively check in left and right subtrees.
		return checkDupUtil(root.left, set) || checkDupUtil(root.right, set);
	}

	public static void main(String args[]) {
		CheckIfTreeContainsDuplicateValue tree = new CheckIfTreeContainsDuplicateValue();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		if (tree.checkDup(root))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}