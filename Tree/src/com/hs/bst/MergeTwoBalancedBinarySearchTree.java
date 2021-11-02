package com.hs.bst;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBalancedBinarySearchTree {

	// Utility function for inorder traversal of the tree
	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// A Utility Method that stores inorder traversal of a tree
	private List<Integer> storeInorderUtil(Node node, List<Integer> list) {
		if (node == null)
			return list;

		// recur on the left child
		storeInorderUtil(node.left, list);

		// Adds data to the list
		list.add(node.data);

		// recur on the right child
		storeInorderUtil(node.right, list);

		return list;
	}

	// Method that stores inorder traversal of a tree
	private List<Integer> storeInorder(Node node) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = storeInorderUtil(node, list1);
		return list2;
	}

	// Method that merges two ArrayLists into one.
	List<Integer> merge(List<Integer> list1, List<Integer> list2, int m, int n) {
		// list3 will contain the merge of list1 and list2
		List<Integer> list3 = new ArrayList<>();
		int i = 0;
		int j = 0;

		// Traversing through both ArrayLists
		while (i < m && j < n) {
			// Smaller one goes into list3
			if (list1.get(i) < list2.get(j)) {
				list3.add(list1.get(i));
				i++;
			} else {
				list3.add(list2.get(j));
				j++;
			}
		}

		// Adds the remaining elements of list1 into list3
		while (i < m) {
			list3.add(list1.get(i));
			i++;
		}

		// Adds the remaining elements of list2 into list3
		while (j < n) {
			list3.add(list2.get(j));
			j++;
		}
		return list3;
	}

	// Method that converts an ArrayList to a BST
	Node ALtoBST(List<Integer> list, int start, int end) {
		// Base case
		if (start > end)
			return null;

		// Get the middle element and make it root
		int mid = (start + end) / 2;
		Node node = new Node(list.get(mid));

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		node.left = ALtoBST(list, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of root
		 */
		node.right = ALtoBST(list, mid + 1, end);

		return node;
	}

	// Method that merges two trees into a single one.
	Node mergeTrees(Node node1, Node node2) {
		// Stores Inorder of tree1 to list1
		List<Integer> list1 = storeInorder(node1);

		// Stores Inorder of tree2 to list2
		List<Integer> list2 = storeInorder(node2);

		// Merges both list1 and list2 into list3
		List<Integer> list3 = merge(list1, list2, list1.size(), list2.size());

		// Eventually converts the merged list into resultant BST
		Node node = ALtoBST(list3, 0, list3.size() - 1);
		return node;
	}

	// Driver function
	public static void main(String[] args) {
		MergeTwoBalancedBinarySearchTree tree = new MergeTwoBalancedBinarySearchTree();
		/*
		 * Creating following tree as First balanced BST 100 / \ 50 300 / \ 20 70
		 */

		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.right = new Node(300);
		root1.left.left = new Node(20);
		root1.left.right = new Node(70);

		/*
		 * Creating following tree as second balanced BST 80 / \ 40 120
		 */

		Node root2 = new Node(80);
		root2.left = new Node(40);
		root2.right = new Node(120);

		Node root = tree.mergeTrees(root1, root2);
		System.out.println("The Inorder traversal of the merged BST is: ");
		tree.inorder(root);
	}
}