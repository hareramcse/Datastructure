package com.hs.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.hs.tree.Node;


// The logic for top view and bottom view is exactly same. 
// Just use map.putIfAbsent(line,node.val) for Top view and map.put(line,node.val) for Bottom view. 
// In top view we put on the map only once because all other nodes on lower level are hidden. 
// In bottom view we replace because we got another node on lower node that hides the upper node.
public class BottomViewOfBinaryTree {

	public List<Integer> printBottomView(Node root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int hd = pair.hd;
			Node tempNode = pair.node;
			map.put(hd, tempNode.data);
				
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

	public static void main(String[] args) {
		BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		List<Integer> list = tree.printBottomView(root);
		System.out.println(list);
	}
}