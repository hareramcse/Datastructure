package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class MergeSortForLinkedList {
	Node head = null;

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

	private void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		MergeSortForLinkedList li = new MergeSortForLinkedList();
		/*
		 * Let us create a unsorted linked lists to test the functions Created lists
		 * shall be a: 2->3->20->5->10->15
		 */
		li.push(15);
		li.push(10);
		li.push(5);
		li.push(20);
		li.push(3);
		li.push(2);
		System.out.println("Linked List without sorting is :");
		li.printList(li.head);

		// Apply merge Sort
		li.head = li.mergeSort(li.head);
		System.out.print("\nSorted Linked List is: \n");
		li.printList(li.head);
	}
}