package com.hs.linkedlist;

public class BubbleSortLinkedListBySwappingData {
	Node head;

	private void swap(Node ptr1, Node ptr2) {
		int tmp = ptr2.data;
		ptr2.data = ptr1.data;
		ptr1.data = tmp;
	}
	
	private int length(Node head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	

	private void bubbleSort(Node head) {
		int size = length(head);
		for (int i = 0; i < size-1; i++) {
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
		BubbleSortLinkedListBySwappingData list = new BubbleSortLinkedListBySwappingData();
		list.push(5);
		list.push(20);
		list.push(4);
		list.push(3);
		list.push(30);
		list.push(10);
		System.out.println("Linked List before Sorting..");
		list.printlist(list.head);
		list.bubbleSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);
	}

}
