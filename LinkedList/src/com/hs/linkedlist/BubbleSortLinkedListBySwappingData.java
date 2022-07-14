package com.hs.linkedlist;

import com.hs.basic.LinkedListUtil;
import com.hs.basic.Node;

public class BubbleSortLinkedListBySwappingData {

	private void swap(Node ptr1, Node ptr2) {
		int tmp = ptr2.data;
		ptr2.data = ptr1.data;
		ptr1.data = tmp;
	}

	private int length(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	private void bubbleSort(Node head) {
		int size = length(head);
		for (int i = 0; i < size - 1; i++) {
			Node currentNode = head;
			Node nextNode = head.next;
			for (int j = 0; j < size - i - 1; j++) {
				if (currentNode.data > nextNode.data) {
					swap(currentNode, nextNode);
				}
				currentNode = nextNode;
				nextNode = nextNode.next;
			}
		}
	}

	public static void main(String[] args) {
		BubbleSortLinkedListBySwappingData list = new BubbleSortLinkedListBySwappingData();
		Node head = LinkedListUtil.addLast(null, 10);
		head = LinkedListUtil.addLast(head, 20);
		head = LinkedListUtil.addLast(head, 4);
		head = LinkedListUtil.addLast(head, 3);
		head = LinkedListUtil.addLast(head, 30);
		head = LinkedListUtil.addLast(head, 25);
		System.out.println("Linked List before Sorting..");
		LinkedListUtil.printLinkedList(head);
		list.bubbleSort(head);
		System.out.println("\nLinkedList After sorting");
		LinkedListUtil.printLinkedList(head);
	}

}
