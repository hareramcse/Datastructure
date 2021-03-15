package com.hs.linkedlist.madeeasy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeTwoSortedListInto3rdSortedList {

	private Node mergeTwoList(Node head1, Node head2, Node head) {
		Node list1 = head1;
		Node list2 = head2;

		while (list1 != null && list2 != null) {
			if (list1.data > list2.data) {
				head = LinkedListUtil.addLast(head, list2.data);
				list2 = list2.next;
			}

			if (list1.data < list2.data) {
				head = LinkedListUtil.addLast(head, list1.data);
				list1 = list1.next;
			}
		}

		while (list1 != null) {
			head = LinkedListUtil.addLast(head, list1.data);
			list1 = list1.next;
		}

		while (list2 != null) {
			head = LinkedListUtil.addLast(head, list2.data);
			list2 = list2.next;
		}

		return head;
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
