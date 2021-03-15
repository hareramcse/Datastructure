package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class BubbleSortLinkedListBySwappingNode {
	Node head;

	private Node bubbleSort(Node head) {
		if (head == null)
			return null;
		/* First push the larger items down */
		if (head.next != null && head.data > head.next.data)
			head = swap(head, head.next);
		/* Always sort from second item on */
		head.next = bubbleSort(head.next);
		/* bubble smaller items up */
		if (head.next != null && head.data > head.next.data) {
			head = swap(head, head.next);
			head.next = bubbleSort(head.next);
		}
		return head;
	}

	private Node swap(Node a, Node b) {
		a.next = b.next;
		b.next = a;
		return b;
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
		BubbleSortLinkedListBySwappingNode list = new BubbleSortLinkedListBySwappingNode();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		list.push(10);
		list.push(15);
		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		Node head = list.bubbleSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(head);
	}
}