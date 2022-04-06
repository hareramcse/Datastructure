package com.hs.heap;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;

	public LinkedList() {
		this.head = null;
	}

	void insertAtBeginning(int key) {
		Node node = new Node(key);
		node.next = head;
		head = node;
	}

	void printList() {
		Node node = head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}

class MinHeap {
	int capacity;
	Node arr[];
	int size;

	public MinHeap(Node[] arr) {
		this.capacity = arr.length;
		this.size = this.capacity;
		this.arr = arr;
		buildMinHeap();
	}

	void swap(Node[] arr, int i, int j) {
		Node temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	int left(int i) {
		return 2 * i + 1;
	}

	int right(int i) {
		return 2 * i + 2;
	}

	Node getMin() {
		if (size <= 0) {
			System.out.println("Heap underflow");
			return null;
		}
		return arr[0];
	}

	Node extractMin() {
		if (size <= 0) {
			System.out.println("Heap underflow");
			return null;
		}
		if (size == 1) {
			size--;
			return arr[0];
		}

		Node root = arr[0];
		arr[0] = arr[size - 1];
		size--;
		minHeapify(0);

		return root;
	}

	void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l < size && arr[l].data < arr[smallest].data)
			smallest = l;
		if (r < size && arr[r].data < arr[smallest].data)
			smallest = r;
		if (smallest != i) {
			swap(arr, i, smallest);
			minHeapify(smallest);
		}
	}

	void buildMinHeap() {
		int n = arr.length;
		for (int i = (n / 2) - 1; i >= 0; i--)
			minHeapify(i);
	}

	void replaceMin(Node root) {
		arr[0] = root;
		minHeapify(0);
	}

	void printMinHeap() {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i].data + " ");
		System.out.println();
	}
}

class SortNumberStoredOnDiffMachines {

	private void mergeKSortedArrays(LinkedList[] lists) {
		Node[] hArr = new Node[lists.length];

		for (int i = 0; i < lists.length; i++)
			hArr[i] = lists[i].head;

		MinHeap mh = new MinHeap(hArr);

		while (mh.size > 0) {
			Node root = mh.getMin();

			System.out.print(root.data + " ");

			if (root.next != null)
				mh.arr[0] = root.next;
			else {
				mh.arr[0] = mh.arr[mh.size - 1];
				mh.size--;
			}

			mh.minHeapify(0);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortNumberStoredOnDiffMachines array = new SortNumberStoredOnDiffMachines();
		int N = 3;
		LinkedList[] lists = new LinkedList[N];

		for (int i = 0; i < N; i++)
			lists[i] = new LinkedList();

		lists[0].insertAtBeginning(50);
		lists[0].insertAtBeginning(40);
		lists[0].insertAtBeginning(30);

		lists[1].insertAtBeginning(45);
		lists[1].insertAtBeginning(35);

		lists[2].insertAtBeginning(100);
		lists[2].insertAtBeginning(80);
		lists[2].insertAtBeginning(70);
		lists[2].insertAtBeginning(60);
		lists[2].insertAtBeginning(10);

		System.out.println("Numers on different machines:");
		for (int i = 0; i < N; i++)
			lists[i].printList();

		System.out.println();
		array.mergeKSortedArrays(lists);
	}
}