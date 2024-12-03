package com.hs.medium;

import com.hs.easy.LinkedListUtil;
import com.hs.easy.ListNode;

public class MergeSortForLinkedList {
	public ListNode mergeSort(ListNode head) {
		// Base case: if head is null, or there is only one node
		if (head == null || head.next == null) {
			return head;
		}

		// Get the middle of the list
		ListNode middle = getMiddle(head);
		ListNode nextOfMiddle = middle.next;

		// Split the list into two halves
		middle.next = null;

		// Apply mergeSort on the left list
		ListNode left = mergeSort(head);

		// Apply mergeSort on the right list
		ListNode right = mergeSort(nextOfMiddle);

		// Merge the left and right lists
		ListNode sortedlist = merge(left, right);
		return sortedlist;
	}

	private ListNode getMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		// Move fast by two steps and slow by one step
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; // slow will point to the first middle node in an even-length list
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;

		if (head2 == null)
			return head1;

		if (head1.val <= head2.val) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}

	public static void main(String[] args) {
		MergeSortForLinkedList list = new MergeSortForLinkedList();
		ListNode head = LinkedListUtil.addLast(null, 15);
		head = LinkedListUtil.addLast(head, 10);
		head = LinkedListUtil.addLast(head, 5);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 2);
		head = LinkedListUtil.addLast(head, 25);

		System.out.println("Linked List without sorting is :");
		LinkedListUtil.printLinkedList(head);

		head = list.mergeSort(head);
		System.out.print("\nSorted Linked List is: \n");
		LinkedListUtil.printLinkedList(head);
	}
}