package com.hs.hard;

import java.util.PriorityQueue;
import java.util.Queue;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class MergeKSortedLinkedList {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (ListNode head : lists) {
			while (head != null) {
				minHeap.add(head.val);
				head = head.next;
			}
		}

		ListNode dummy = new ListNode();
		ListNode head = dummy;
		while (!minHeap.isEmpty()) {
			head.next = new ListNode(minHeap.remove());
			head = head.next;
		}
		return dummy.next;
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