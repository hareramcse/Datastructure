package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

// 21. Merge Two Sorted Lists Leetcode
public class MergeTwoSortedList {

	public Node mergeTwoLists(Node list1, Node list2) {
		Node result = new Node();
		return mergeTwoListsUtil(list1, list2, result);
	}

	private Node mergeTwoListsUtil(Node list1, Node list2, Node result) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.data > list2.data) {
			result = list2;
			result.next = mergeTwoListsUtil(list1, list2.next, result);
		} else {
			result = list1;
			result.next = mergeTwoListsUtil(list1.next, list2, result);
		}
		return result;
	}

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();

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

		Node mergeTwoList = list.mergeTwoLists(head1, head2);
		LinkedListUtil.printLinkedList(mergeTwoList);
	}
}