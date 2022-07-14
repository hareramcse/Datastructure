package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeTwoSortedListInto3rdSortedList {

	private Node mergeTwoList(Node head1, Node head2, Node result) {

		while (head1 != null && head2 != null) {
			if (head1.data > head2.data) {
				result = LinkedListUtil.addLast(result, head2.data);
				head2 = head2.next;
			}

			if (head1.data < head2.data) {
				result = LinkedListUtil.addLast(result, head1.data);
				head1 = head1.next;
			}
		}

		while (head1 != null) {
			result = LinkedListUtil.addLast(result, head1.data);
			head1 = head1.next;
		}

		while (head2 != null) {
			result = LinkedListUtil.addLast(result, head2.data);
			head2 = head2.next;
		}

		return result.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedListInto3rdSortedList list = new MergeTwoSortedListInto3rdSortedList();
		Node head1 = LinkedListUtil.addLast(null, 10);
		head1 = LinkedListUtil.addLast(head1, 20);
		head1 = LinkedListUtil.addLast(head1, 30);
		head1 = LinkedListUtil.addLast(head1, 40);

		Node head2 = LinkedListUtil.addLast(null, 35);
		head2 = LinkedListUtil.addLast(head2, 45);
		head2 = LinkedListUtil.addLast(head2, 50);
		head2 = LinkedListUtil.addLast(head2, 60);
		head2 = LinkedListUtil.addLast(head2, 70);
		head2 = LinkedListUtil.addLast(head2, 80);
		head2 = LinkedListUtil.addLast(head2, 90);

		Node result = new Node();

		Node head = list.mergeTwoList(head1, head2, result);
		LinkedListUtil.printLinkedList(head);
	}
}
