package com.hs.bst;

public class CheckIfGivenSortedSubSequenceExistInBST {
	// A wrapper over seqExistUtil. It returns true if seq[0..n-1] exists in tree.
	private boolean seqExist(Node root, int seq[], int n) {
		// Initialize index in seq[]
		int index = 0;

		// Do an inorder traversal and find if all elements of seq[] were present
		seqExistUtil(root, seq, index);

		// index would become n if all elements of seq[] were present
		return (index == n);
	}

	private void seqExistUtil(Node root, int seq[], int index) {
		if (root == null)
			return;

		// We traverse left subtree first in Inorder
		seqExistUtil(root.left, seq, index);

		// If current node matches with se[index] then move forward in sub-sequence
		if (root.data == seq[index])
			index++;

		// We traverse left subtree in the end in Inorder
		seqExistUtil(root.right, seq, index);
	}

	public static void main(String[] args) {
		CheckIfGivenSortedSubSequenceExistInBST tree = new CheckIfGivenSortedSubSequenceExistInBST();
		Node root = new Node(8);
		root.right = new Node(10);
		root.left = new Node(3);
		root.left.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);
		root.right.right = new Node(14);
		root.right.left = new Node(13);

		int seq[] = { 4, 6, 8, 14 };

		System.out.println(tree.seqExist(root, seq, seq.length));
	}
}
