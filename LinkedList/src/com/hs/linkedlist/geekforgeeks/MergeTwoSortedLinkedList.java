package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

class MergeTwoSortedLinkedList {
	Node head;

	// merge two sorted linkedlist
	Node sortedMerge(Node node1, Node node2) {

		// if both the nodes are null
		if (node1 == null && node2 == null) {
			return null;
		}

		// resultant node
		Node res = null;

		// if both of them have nodes present traverse them
		while (node1 != null && node2 != null) {

			// Now compare both nodes current data
			if (node1.data <= node2.data) {
				Node temp = node1.next;
				node1.next = res;
				res = node1;
				node1 = temp;
			} else {
				Node temp = node2.next;
				node2.next = res;
				res = node2;
				node2 = temp;
			}
		}

		// If second list reached end, but first list has
		// nodes. Add remaining nodes of first list at the
		// front of result list
		while (node1 != null) {
			Node temp = node1.next;
			node1.next = res;
			res = node1;
			node1 = temp;
		}

		// If first list reached end, but second list has
		// node. Add remaining nodes of first list at the
		// front of result list
		while (node2 != null) {
			Node temp = node2.next;
			node2.next = res;
			res = node2;
			node2 = temp;
		}

		return res;

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
		llist2.addToTheLast(new Node(40));
		llist2.addToTheLast(new Node(50));
		llist2.addToTheLast(new Node(60));

		llist1.head = obj.sortedMerge(llist1.head, llist2.head);
		llist1.printList();
	}
}