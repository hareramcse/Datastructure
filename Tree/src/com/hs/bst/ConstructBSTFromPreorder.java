package com.hs.bst;

import com.hs.tree.Node;

public class ConstructBSTFromPreorder {
	public Node bstFromPreorder(int[] A) {
		return bstFromPreorder(A, Integer.MAX_VALUE, new int[] { 0 });
	}

	public Node bstFromPreorder(int[] A, int bound, int[] i) {
		if (i[0] == A.length || A[i[0]] > bound)
			return null;
		Node root = new Node(A[i[0]++]);
		root.left = bstFromPreorder(A, root.data, i);
		root.right = bstFromPreorder(A, bound, i);
		return root;
	}
}
