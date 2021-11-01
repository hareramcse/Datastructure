package com.hs.checkandprint;

import java.util.HashSet;
import java.util.Set;

/*
 * A simple solution is to store inorder traversal of given binary tree in an array. 
 * Then check if array has duplicates or not. We can avoid the use of array and solve 
 * the problem in O(n) time. The idea is to use hashing. We traverse the given tree, 
 * for every node, we check if it already exists in hash table. If exists, we return 
 * true (found duplicate). If it does not exist, we insert into hash table.
 */
public class CheckIfTreeContainsDuplicateValue {

	// Function that used HashSet to find presence of duplicate nodes
	private static boolean checkDupUtil(Node root, Set<Integer> set) {
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

	// To check if tree has duplicates
	private static boolean checkDup(Node root) {
		Set<Integer> s = new HashSet<>();
		return checkDupUtil(root, s);
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		if (checkDup(root))
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}