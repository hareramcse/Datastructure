package com.hs.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.hs.tree.Node;

class TopViewOfBinaryTree {
	public List<Integer> topView(Node root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int hd = pair.hd;
			Node tempNode = pair.node;
			if (map.get(hd) == null) {
				map.put(hd, tempNode.data);
			}
				
			if (tempNode.left != null) {
				queue.add(new Pair(tempNode.left, hd - 1));
			}
			
			if (tempNode.right != null) {
				queue.add(new Pair(tempNode.right, hd + 1));
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		System.out.println("Following are nodes in top view of Binary Tree");
		List<Integer> list = tree.topView(root);
		System.out.println(list);
	}
}