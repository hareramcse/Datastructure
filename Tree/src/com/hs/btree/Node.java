package com.hs.btree;

public class Node {

	public int[] data; // array of data values.
	public Node[] children; // list of children of this node.
	public Node parent; // parent node.
	public int size; // number of data values filled.
	public boolean leaf; // true if this node is a leaf.

	// t is value which tells that min data values in a node should be (t-1) and max
	// values = (2*t-1) and number of children can be (2*t)
	public Node(int t) {
		this.data = new int[2 * t - 1];
		this.children = new Node[2 * t];
		this.parent = null;
		this.leaf = true;
	}

}
