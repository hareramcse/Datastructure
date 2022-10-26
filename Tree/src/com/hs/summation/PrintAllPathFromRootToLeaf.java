package com.hs.summation;

import java.util.ArrayList;
import java.util.List;

import com.hs.tree.Node;

class PrintAllPathFromRootToLeaf {
	public List<String> binaryTreePaths(Node root) {
		List<String> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		binaryTreePathsUtil(root, path, result);
		return result;
	}

	private void binaryTreePathsUtil(Node root, List<String> path, List<String> result) {
		// base case
		if (root == null) {
			return;
		}

		// include the current node to the path
		path.add("" + root.data);

		// if a leaf node is found, print the path
		if (root.left == null && root.right == null) {
			String pathToAdd = String.join("->", path);
			result.add(pathToAdd);
		}

		// recur for the left and right subtree
		binaryTreePathsUtil(root.left, path, result);
		binaryTreePathsUtil(root.right, path, result);
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		PrintAllPathFromRootToLeaf tree = new PrintAllPathFromRootToLeaf();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.right.right = new Node(9);
		List<String> allPath = tree.binaryTreePaths(root);
		System.out.println("All path from root to leaf node are: " + allPath);
	}
}