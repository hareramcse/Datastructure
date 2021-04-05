package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class MergeSortForLinkedList {

	private Node sortedMerge(Node head1, Node head2) {
		Node result = null;
		/* Base cases */
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		/* Pick either a or b, and recur */
		if (head1.data <= head2.data) {
			result = head1;
			result.next = sortedMerge(head1.next, head2);
		} else {
			result = head2;
			result.next = sortedMerge(head1, head2.next);
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
		Node slow = head;
		Node fast = head.next;

		// Move fast by two and slow by one
		// Finally slow will point to middle node
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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