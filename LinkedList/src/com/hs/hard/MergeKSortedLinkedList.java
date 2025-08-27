package com.hs.hard;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

// we can use priorityQ as well, we should use pq if list size is huge
public class MergeKSortedLinkedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		return mergeKListsHelper(lists, 0, lists.length - 1);
	}

	private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}

		int mid = start + (end - start) / 2;
		ListNode left = mergeKListsHelper(lists, start, mid);
		ListNode right = mergeKListsHelper(lists, mid + 1, end);

		return merge(left, right);
	}

	private ListNode merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;

		if (list2 == null)
			return list1;

		if (list1.val < list2.val) {
			list1.next = merge(list1.next, list2);
			return list1;
		} else {
			list2.next = merge(list1, list2.next);
			return list2;
		}
	}

	public static void main(String args[]) {
		MergeKSortedLinkedList list = new MergeKSortedLinkedList();
		int k = 3;

		ListNode arr[] = new ListNode[k];

		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(3);
		arr[0].next.next = new ListNode(5);
		arr[0].next.next.next = new ListNode(7);

		arr[1] = new ListNode(2);
		arr[1].next = new ListNode(4);
		arr[1].next.next = new ListNode(6);
		arr[1].next.next.next = new ListNode(8);

		arr[2] = new ListNode(0);
		arr[2].next = new ListNode(9);
		arr[2].next.next = new ListNode(10);
		arr[2].next.next.next = new ListNode(11);

		// Merge all lists
		ListNode head = list.mergeKLists(arr);
		LinkedListUtil.printLinkedList(head);
	}
}