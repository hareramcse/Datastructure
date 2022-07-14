package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

class MergeTwoSortedLinkedListIterative {

	Node sortedMerge(Node head1, Node head2) {

		// if both the nodes are null
		if (head1 == null && head2 == null) {
			return null;
		}

		// resultant node
		Node res = null;

		// if both of them have nodes present traverse them
		while (head1 != null && head2 != null) {

			// Now compare both nodes current data
			if (head1.data <= head2.data) {
				Node temp = head1.next;
				head1.next = res;
				res = head1;
				head1 = temp;
			} else {
				Node temp = head2.next;
				head2.next = res;
				res = head2;
				head2 = temp;
			}
		}

		// If second list reached end, but first list has
		// nodes. Add remaining nodes of first list at the
		// front of result list
		while (head1 != null) {
			Node temp = head1.next;
			head1.next = res;
			res = head1;
			head1 = temp;
		}

		// If first list reached end, but second list has
		// node. Add remaining nodes of first list at the
		// front of result list
		while (head2 != null) {
			Node temp = head2.next;
			head2.next = res;
			res = head2;
			head2 = temp;
		}

		return res;

	}

	public static void main(String args[]) {
		MergeTwoSortedLinkedListIterative list = new MergeTwoSortedLinkedListIterative();

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