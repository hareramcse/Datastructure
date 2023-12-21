package com.hs.bst;

import com.hs.tree.Node;

public class ConstructBSTFromPreorder {
	public Node bstFromPreorder(int[] arr) {
		// new int[] { 0 } is nothing but pointer to the array element
		return bstFromPreorder(arr, Integer.MAX_VALUE, new int[] { 0 });
	}

	public Node bstFromPreorder(int[] arr, int bound, int[] ptr) {
		if (ptr[0] == arr.length || arr[ptr[0]] > bound)
			return null;
		
		Node root = new Node(arr[ptr[0]++]);
		root.left = bstFromPreorder(arr, root.data, ptr);
		root.right = bstFromPreorder(arr, bound, ptr);
		return root;
	}
}
