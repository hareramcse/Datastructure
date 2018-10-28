package com.hs.bst;

public class FindNextHighestElement {
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

	private void printDataInOrder(Node root) {
		if (root == null) {
			return;
		} else {
			printDataInOrder(root.left);
			System.out.println(root.data);
			printDataInOrder(root.right);
		}
	}

	private Node searchNextHighestElement(int data) {
		return search(root, data);
	}

	private Node findNode(Node root, int data) {
		if (root == null) {
			return root;
		} else if (root.data == data) {
			return root;
		} else if (data < root.data) {
			return findNode(root.left, data);
		} else {
			return findNode(root.right, data);
		}
	}

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

	private Node search(Node root, int data) {
		Node current = findNode(root, data);
		if (current == null) {
			return null;
		}
		if (current.right != null) {
			return findMinInBST(current.right);
		} else {
			Node successor = null;
			Node ancestor = root;
			while (ancestor != current) {
				if (current.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}

	public static void main(String[] args) {
		FindNextHighestElement bst = new FindNextHighestElement();
		bst.insert(6);
		bst.insert(11);
		bst.insert(9);
		bst.insert(3);
		bst.insert(14);

		bst.printDataInOrder(root);

		System.out.print("Next highest element of 3 is ");
		System.out.println(bst.searchNextHighestElement(3).data);

		System.out.println();
	}
}
