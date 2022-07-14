package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class BubbleSortLinkedListBySwappingNode {

	private Node bubbleSort(Node head) {
		if (head == null) {
			return null;
		}
		/* First push the larger items down */
		if (head.next != null && head.data > head.next.data) {
			head = swap(head, head.next);
		}
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

	// Driver program to test above functions
	public static void main(String[] args) {
		BubbleSortLinkedListBySwappingNode list = new BubbleSortLinkedListBySwappingNode();
		Node head = LinkedListUtil.addLast(null, 10);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 30);
		head = LinkedListUtil.addLast(head, 25);
		System.out.println("Linked List before Sorting..");
		LinkedListUtil.printLinkedList(head);
		head = list.bubbleSort(head);
		System.out.println("\nLinkedList After sorting");
		LinkedListUtil.printLinkedList(head);
	}
}