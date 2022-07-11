package com.hs.bst;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.hs.tree.Node;

public class ConvertBinaryTreeToBinarySearchTree {

	// converts a binary tree to BST by maintaining its original structure
	public void convertToBST(Node root) {
		// traverse the binary tree and store its keys in a set
		Set<Integer> set = new TreeSet<>();
		extractValues(root, set);

		// put back keys present in the set to their correct order in the BST
		Iterator<Integer> it = set.iterator();
		convertToBST(root, it);
	}

	// Function to traverse the binary tree and store its values in a set
	private void extractValues(Node root, Set<Integer> set) {
		if (root == null) {
			return;
		}
		extractValues(root.left, set);
		set.add(root.data);
		extractValues(root.right, set);
	}

	// put values back into a set in their correct order in the BST
	private void convertToBST(Node root, Iterator<Integer> it) {
		if (root == null) {
			return;
		}
		convertToBST(root.left, it);
		root.data = it.next();
		convertToBST(root.right, it);
	}

	private void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		ConvertBinaryTreeToBinarySearchTree tree = new ConvertBinaryTreeToBinarySearchTree();
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(10);
		root.left.right = new Node(2);
		root.right.left = new Node(4);
		root.right.right = new Node(6);
		tree.convertToBST(root);
		tree.inorder(root);
	}
}