package com.hs.bst;

import com.hs.tree.Node;

public class ConstructBSTFromPreorder {
	public Node bstFromPreorder(int[] arr) {
		// new int[] { 0 } is nothing but pointer to the array element
		return bstFromPreorder(arr, Integer.MAX_VALUE, new int[] { 0 });
	}

	public Node bstFromPreorder(int[] arr, int bound, int[] i) {
		if (i[0] == arr.length || arr[i[0]] > bound)
			return null;
		
		Node root = new Node(arr[i[0]++]);
		root.left = bstFromPreorder(arr, root.data, i);
		root.right = bstFromPreorder(arr, bound, i);
		return root;
	}
}
