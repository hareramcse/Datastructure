package com.hs.bst;

import com.hs.tree.Node;

public class SearchInBST {
	public boolean search(Node root, int data) {
		if (root == null)
			return false;

		if (root.data == data)
			return true;
		
		if (data < root.data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}
}
