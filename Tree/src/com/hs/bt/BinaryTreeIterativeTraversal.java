package com.hs.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hs.tree.Node;

public class BinaryTreeIterativeTraversal {
	private List<Integer> printPreorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node topNode = stack.pop();
			result.add(topNode.data);
			
			if (topNode.right != null)
				stack.push(topNode.right);
			
			if (topNode.left != null)
				stack.push(topNode.left);
		}
		return result;
	}

	private List<Integer> printInorder(Node root) {
		List<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				root = stack.pop();
				result.add(root.data);
				root = root.right;
			}
		}
		return result;
	}

	private List<Integer> printPostorder(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			
			if (root.left != null)
				s1.push(root.left);
			
			if (root.right != null)
				s1.push(root.right);
		}
		while (!s2.isEmpty()) {
			result.add(s2.pop().data);
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreeIterativeTraversal tree = new BinaryTreeIterativeTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		List<Integer> printPreorder = tree.printPreorder(root);
		System.out.println(printPreorder);

		System.out.println("\nInorder traversal of binary tree is ");
		List<Integer> printInorder = tree.printInorder(root);
		System.out.println(printInorder);

		System.out.println("\nPostorder traversal of binary tree is ");
		List<Integer> printPostorder = tree.printPostorder(root);
		System.out.println(printPostorder);
	}
}