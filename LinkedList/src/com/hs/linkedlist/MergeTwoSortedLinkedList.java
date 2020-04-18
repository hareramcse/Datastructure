package com.hs.linkedlist;

class MergeTwoSortedLinkedList {
	Node head;

	// merge two sorted linkedlist
	Node sortedMerge(Node a, Node b) {
		// a dummy first node to hang the result on
		Node dummyNode = new Node(0);

		Node tail = dummyNode;
		while (true) {
			if (a == null) {
				tail.next = b;
				break;
			}
			if (b == null) {
				tail.next = a;
				break;
			}

			// Compare the data of the two lists whichever lists' data is smaller, append it
			// into tail and advance the head to the next Node
			if (a.data <= b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		return dummyNode.next;
	}

	private void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	private void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Driver Code
	public static void main(String args[]) {
		/*
		 * Let us create two sorted linked lists to test the methods Created lists:
		 * llist1: 5->10->15, llist2: 2->3->20
		 */
		MergeTwoSortedLinkedList llist1 = new MergeTwoSortedLinkedList();
		MergeTwoSortedLinkedList llist2 = new MergeTwoSortedLinkedList();
		MergeTwoSortedLinkedList obj = new MergeTwoSortedLinkedList();

		// Node head1 = new Node(5);
		llist1.addToTheLast(new Node(5));
		llist1.addToTheLast(new Node(10));
		llist1.addToTheLast(new Node(15));

		// Node head2 = new Node(2);
		llist2.addToTheLast(new Node(2));
		llist2.addToTheLast(new Node(3));
		llist2.addToTheLast(new Node(20));

		llist1.head = obj.sortedMerge(llist1.head, llist2.head);
		llist1.printList();
	}
}