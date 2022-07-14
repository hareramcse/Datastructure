package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class InsertionSortForLinkedList {
	Node sorted;

	// function to sort a singly linked list using insertion sort
	private Node insertionSort(Node head) {
		// Initialize sorted linked list
		Node current = head;
		// Traverse the given linked list and insert every node to sorted
		while (current != null) {
			Node next = current.next;
			sortedInsert(current);
			current = next;
		}
		head = sorted;
		return head;
	}

	/*
	 * function to insert a new_node in a list. Note that this function expects a
	 * pointer to head_ref as this can modify the head of the input linked list
	 * (similar to push())
	 */
	private void sortedInsert(Node newnode) {
		/* Special case for the head end */
		if (sorted == null || sorted.data >= newnode.data) {
			newnode.next = sorted;
			sorted = newnode;
		} else {
			Node current = sorted;
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.data < newnode.data) {
				current = current.next;
			}
			newnode.next = current.next;
			current.next = newnode;
		}
	}

	public static void main(String[] args) {
		InsertionSortForLinkedList list = new InsertionSortForLinkedList();
		Node head = LinkedListUtil.addLast(null, 5);
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