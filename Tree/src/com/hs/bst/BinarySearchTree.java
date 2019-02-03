package com.hs.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	public static Node root = null;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	private boolean search(int data) {
		return search(root, data);
	}

	private boolean search(Node root, int data) {
		if (root == null) {
			return false;
		} else if (root.data == data) {
			return true;
		} else if (data < root.data) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}

	private void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) {
		// tree is empty
		if (root == null) {
			return null;
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			// if data is equal to node data, means this node we need to delete
			// case 1, node with no child
			if (root.left == null && root.right == null) {
				root = null;
			}
			// case 2, node with only one child
			else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
			// case 3, node with 2 child
			else {
				/*
				 * root.data=findMinInBST(root.right); // it will also work commented
				 * findMinInBST root.right=delete(root.right, findMinInBST(root.right));
				 */
				Node temp = findMinInBST(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}

	// min value comes left to root so we traverse left to root
	private Node findMinInBST(Node root) {
		Node temp = root;
		if (temp == null) {
			return temp;
		}
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	// as max value comes right to the root, so we traverse right nodes
	public int findMaxInBST(Node root) {
		Node temp = root;
		if (temp == null) {
			return -1;
		}
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}

	// max no of edges from root to leaf node
	private int findHeightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = findHeightOfTree(root.left);
			int rightHeight = findHeightOfTree(root.right);
			if (leftHeight < rightHeight) {
				return rightHeight + 1;
			} else {
				return leftHeight + 1;
			}
		}
	}

	// preorder traveral (root,left,right)
	private void printDataPreOrder(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.println(root.data);
			printDataPreOrder(root.left);
			printDataPreOrder(root.right);
		}
	}

	// inorder traversal(left,root,right)
	private void printDataInOrder(Node root) {
		if (root == null) {
			return;
		} else {
			printDataInOrder(root.left);
			System.out.println(root.data);
			printDataInOrder(root.right);
		}
	}

	// post order traversal(left,right,root)
	private void printDataPostOrder(Node root) {
		if (root == null) {
			return;
		} else {
			printDataPostOrder(root.left);
			printDataPostOrder(root.right);
			System.out.println(root.data);
		}
	}

	// level order traversal, it traverse level by level
	public void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(6);
		bst.insert(11);
		bst.insert(9);
		bst.insert(3);
		bst.insert(14);
		bst.printDataInOrder(root);
		System.out.println("data found ? " + bst.search(5));
		System.out.println("min element in the tree is " + bst.findMinInBST(root).data);
		System.out.println("max element in the tree is " + bst.findMaxInBST(root));
		System.out.println("height of the tree is " + bst.findHeightOfTree(root));
		bst.delete(11);
		bst.printDataPreOrder(root);
		System.out.println("Print data by level order traversal");
		bst.levelOrderTraversal(root);
		System.out.println("print data in post order");
		bst.printDataPostOrder(root);
	}
}