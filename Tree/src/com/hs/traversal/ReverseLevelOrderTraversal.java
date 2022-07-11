package com.hs.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hs.tree.Node;

// 107. Binary Tree Level Order Traversal II Leetcode
class ReverseLevelOrderTraversal {

	// Given a binary tree, print its nodes in reverse level order
	public List<List<Integer>> reverseLevelOrderTraversal(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				Node tempNode = queue.poll();
				subList.add(tempNode.data);
                
				/* Enqueue left child */
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}		
                
                /* Enqueue right child */
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			list.add(subList);
		}
		Collections.reverse(list);
		return list;
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Level Order traversal of binary tree is :");
		List<List<Integer>> list = tree.reverseLevelOrderTraversal(root);
		System.out.println(list);
	}
}