package com.hs.btree;

public class BTree {
	private Node root; // root of the tree.
	private int t = 3; // value of parameter t.

	// Just shift elements as we do in InsertSort.
	private void insertData(Node node, int data) {
		int index = node.size;
		for (int i = node.size - 1; i > -1; i--) {
			if (data <= node.data[i]) {
				node.data[i + 1] = node.data[i];
				index = i;
			} else {
				break;
			}
		}
		node.data[index] = data;
		node.size++;
	}

	// function to split the node if it is completely filled. i.e node.data.size ==
	// 2*t-1
	private Node splitNode(Node node, int key) {
		System.out.println("Splitting Node...");
		int mid = node.size / 2;
		Node node1 = new Node(t);
		Node node2 = new Node(t);
		Node parent = node.parent;

		for (int i = 0; i < mid; i++) {
			node1.data[i] = node.data[i];
			node1.children[i] = node.children[i];
			node1.size++;
		}
		node1.children[mid] = node.children[mid];

		int j = 0;
		for (int i = mid + 1; i < node.size; i++) {
			node2.data[j] = node.data[i];
			node2.children[j] = node.children[i];
			node2.size++;
			j++;
		}
		node2.children[mid] = node.children[node.size];

		node1.leaf = node.leaf;
		node2.leaf = node.leaf;

		if (parent == null) {
			int temp = node.data[mid];
			node.data = new int[2 * t - 1];
			node.data[0] = temp;
			node.size = 1;
			node.leaf = false;
			node.children[0] = node1;
			node.children[1] = node2;
			node1.parent = node;
			node2.parent = node;
			if (key > temp) {
				return node2;
			}
			return node1;
		}

		int index = parent.size;
		int data = node.data[mid];
		for (int i = parent.size - 1; i > -1; i--) {
			if (data < parent.data[i]) {
				parent.data[i + 1] = parent.data[i];
				parent.children[i + 2] = parent.children[i + 1];
				index = i;
			} else {
				break;
			}
		}

		parent.data[index] = data;
		parent.children[index] = node1;
		parent.children[index + 1] = node2;
		parent.size++;
		node1.parent = parent;
		node2.parent = parent;
		if (key > data) {
			return node2;
		}
		return node1;
	}

	// function to add new data values in the Tree.
	private void add(int data) {
		System.out.println("\nInserting Data : " + data);
		if (root == null) {
			Node node = new Node(t);
			insertData(node, data);
			root = node;
			return;
		}

		Node temp = root;
		while (!temp.leaf || (temp.size == 2 * t - 1 && temp.children[0] == null)) {
			if (temp.size == 2 * t - 1) {
				temp = splitNode(temp, data);
				continue;
			}
			if (data < temp.data[0]) {
				temp = temp.children[0];
				continue;
			}
			if (data > temp.data[temp.size - 1]) {
				temp = temp.children[temp.size];
				continue;
			}
			for (int i = 1; i < temp.size; i++) {
				if (data < temp.data[i]) {
					temp = temp.children[i];
					break;
				}
			}
		}
		insertData(temp, data);
	}

	// level indicates the level at which the node is
	private void display(Node node, int level) {
		if (node == null) {
			return;
		}
		System.out.print("Level : " + level + " " + "Data : ");
		for (int i = 0; i < node.size; i++) {
			System.out.print(node.data[i] + " ");
		}
		System.out.println();
		if (node.leaf) {
			return;
		}
		for (int i = 0; i < node.size + 1; i++) {
			display(node.children[i], level + 1);
		}
	}

	public static void main(String[] args) {
		BTree btree = new BTree();
		btree.add(10);
		btree.display(btree.root, 1);

		btree.add(20);
		btree.display(btree.root, 1);

		btree.add(5);
		btree.display(btree.root, 1);

		btree.add(1);
		btree.display(btree.root, 1);

		btree.add(30);
		btree.display(btree.root, 1);

		btree.add(15);
		btree.display(btree.root, 1);

		btree.add(25);
		btree.display(btree.root, 1);

		btree.add(26);
		btree.display(btree.root, 1);

		btree.add(27);
		btree.display(btree.root, 1);

		btree.add(28);
		btree.display(btree.root, 1);

		btree.add(29);
		btree.display(btree.root, 1);

		btree.add(24);
		btree.display(btree.root, 1);

		btree.add(31);
		btree.display(btree.root, 1);

		btree.add(40);
		btree.display(btree.root, 1);

		btree.add(41);
		btree.display(btree.root, 1);

		btree.add(42);
		btree.display(btree.root, 1);

		btree.add(43);
		btree.display(btree.root, 1);

		btree.add(44);
		btree.display(btree.root, 1);

		btree.add(45);
		btree.display(btree.root, 1);

		btree.add(46);
		btree.display(btree.root, 1);
	}
}