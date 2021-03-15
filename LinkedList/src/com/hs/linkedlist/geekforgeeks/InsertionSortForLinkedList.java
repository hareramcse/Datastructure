package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class InsertionSortForLinkedList {
	Node head;
	Node sorted;

	// function to sort a singly linked list using insertion sort
	private void insertionSort(Node headref) {
		// Initialize sorted linked list
		sorted = null;
		Node current = headref;
		// Traverse the given linked list and insert every node to sorted
		while (current != null) {
			Node next = current.next;
			sortedInsert(current);
			current = next;
		}
		head = sorted;
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
	
	private void push(int val) {
		Node newnode = new Node(val);
		newnode.next = head;
		head = newnode;
	}

	private void printlist(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		InsertionSortForLinkedList list = new InsertionSortForLinkedList();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		list.insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);
	}
}