package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class MergeTwoSortedLinkedList {

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

	public static void main(String args[]) {
		MergeTwoSortedLinkedList list = new MergeTwoSortedLinkedList();

		Node head1 = LinkedListUtil.addLast(null, 5);
		head1 = LinkedListUtil.addLast(head1, 10);
		head1 = LinkedListUtil.addLast(head1, 15);

		Node head2 = LinkedListUtil.addLast(null, 2);
		head2 = LinkedListUtil.addLast(head2, 3);
		head2 = LinkedListUtil.addLast(head2, 20);
		head2 = LinkedListUtil.addLast(head2, 40);
		head2 = LinkedListUtil.addLast(head2, 50);
		head2 = LinkedListUtil.addLast(head2, 60);

		Node head = list.sortedMerge(head1, head2);
		LinkedListUtil.printLinkedList(head);
	}
}