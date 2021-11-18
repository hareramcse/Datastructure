package com.hs.misc;

import java.util.LinkedList;
import java.util.Queue;

public class LargestNodeAtEachLevel {

	private void largestValueInEachLevel(Node root) {
		// if tree is empty
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<Node>();
		int nodeCount, max;

		// push root to the queue 'q'
		q.add(root);

		while (true) {
			// node count for the current level
			nodeCount = q.size();

			// if true then all the nodes of the tree have been traversed
			if (nodeCount == 0)
				break;

			// maximum element for the current level
			max = Integer.MIN_VALUE;

			while (nodeCount != 0) {

				// get the front element from 'q'
				Node front = q.poll();

				// if true, then update 'max'
				if (max < front.data)
					max = front.data;

				// if left child exists
				if (front.left != null)
					q.add(front.left);

				// if right child exists
				if (front.right != null)
					q.add(front.right);
				nodeCount--;
			}

			// print maximum element of current level
			System.out.println(max + " ");
		}
	}

	public static void main(String[] args) {
		LargestNodeAtEachLevel tree = new LargestNodeAtEachLevel();
		Node root = null;
		root = new Node(4);
		root.left = new Node(9);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(7);

		tree.largestValueInEachLevel(root);
	}
}
