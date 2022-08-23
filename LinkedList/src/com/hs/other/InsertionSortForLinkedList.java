package com.hs.other;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.ListNode;

// 147. Insertion Sort List Leetcode
public class InsertionSortForLinkedList {

	// function to sort a singly linked list using insertion sort
	public ListNode insertionSort(ListNode head) {
		ListNode dummy = new ListNode();
		ListNode current = head;

		while (current != null) {
			ListNode temp = current.next;
			ListNode prev = dummy;
			ListNode next = dummy.next;

			while (next != null) {
				if (next.val > current.val)
					break;
				prev = next;
				next = next.next;
			}

			current.next = next;
			prev.next = current;
			current = temp;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		InsertionSortForLinkedList list = new InsertionSortForLinkedList();
		ListNode head = LinkedListUtil.addLast(null, 5);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 30);
		head = LinkedListUtil.addLast(head, 10);
		System.out.println("Linked List before Sorting..");
		LinkedListUtil.printLinkedList(head);
		head = list.insertionSort(head);
		System.out.println("\nLinkedList After sorting");
		LinkedListUtil.printLinkedList(head);
	}
}