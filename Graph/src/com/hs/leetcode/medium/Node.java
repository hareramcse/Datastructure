package com.hs.leetcode.medium;

import java.util.List;

public class Node {
	public int val;
	public List<Node> neighbors;

	public Node(int val, List<Node> neighbors) {
		this.val = val;
		this.neighbors = neighbors;
	}
}
