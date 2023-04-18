package com.hs.seelater;

import java.util.HashMap;
import java.util.Map;

import com.hs.tree.Node;

public class ConstrcutFromInorderAndPostOrder {
	public Node buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; ++i)
			map.put(inorder[i], i);

		return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	private Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
			Map<Integer, Integer> map) {
		if (ps > pe || is > ie)
			return null;

		Node root = new Node(postorder[pe]);
		int ri = map.get(postorder[pe]);

		Node leftchild = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, map);
		Node rightchild = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, map);
		root.left = leftchild;
		root.right = rightchild;

		return root;
	}
}
