package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeSortForLinkedList {

	private Node sortedMerge(Node a, Node b) {
		Node result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;

	}

	private Node mergeSort(Node head) {
		// Base case : if head is null
		if (head == null || head.next == null) {
			return head;
		}

		// get the middle of the list
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;

		// set the next of middle node to null
		middle.next = null;

		// Apply mergeSort on left list
		Node left = mergeSort(head);

		// Apply mergeSort on right list
		Node right = mergeSort(nextOfMiddle);

		// Merge the left and right lists
		Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	private Node getMiddle(Node head) {
		// Base case
		if (head == null) {
			return head;
		}
		Node slowptr = head;
		Node fastptr = head.next;

		// Move fastptr by two and slow ptr by one
		// Finally slowptr will point to middle node
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
		}
		return slowptr;
	}

	public static void main(String[] args) {

		MergeSortForLinkedList list = new MergeSortForLinkedList();
		Node head = LinkedListUtil.addLast(null, 15);
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