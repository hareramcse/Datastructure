package com.hs.leetcode.easy;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

public class MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		return mergeTwoListsUtil(list1, list2, result);
	}

	private ListNode mergeTwoListsUtil(ListNode list1, ListNode list2, ListNode result) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			result = list1;
			result.next = mergeTwoListsUtil(list1.next, list2, result);
		} else {
			result = list2;
			result.next = mergeTwoListsUtil(list1, list2.next, result);
		}
		return result;
	}

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();

		ListNode head1 = LinkedListUtil.addLast(null, 10);
		head1 = LinkedListUtil.addLast(head1, 20);
		head1 = LinkedListUtil.addLast(head1, 30);
		head1 = LinkedListUtil.addLast(head1, 40);

		ListNode head2 = LinkedListUtil.addLast(null, 35);
		head2 = LinkedListUtil.addLast(head2, 45);
		head2 = LinkedListUtil.addLast(head2, 50);
		head2 = LinkedListUtil.addLast(head2, 60);
		head2 = LinkedListUtil.addLast(head2, 70);
		head2 = LinkedListUtil.addLast(head2, 80);
		head2 = LinkedListUtil.addLast(head2, 90);

		ListNode mergeTwoList = list.mergeTwoLists(head1, head2);
		LinkedListUtil.printLinkedList(mergeTwoList);
	}
}