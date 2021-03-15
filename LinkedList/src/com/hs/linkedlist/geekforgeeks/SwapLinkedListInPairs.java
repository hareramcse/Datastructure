package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class SwapLinkedListInPairs {
	Node head;

	private void swapNodes(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			current = current.next.next;
		}
	}

	private void push(int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		head = new_Node;
	}

	private void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
	}

	public static void main(String[] args) {
		SwapLinkedListInPairs llist = new SwapLinkedListInPairs();
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.print("Linked list before calling swapNodes()");
		System.out.println();
		llist.printList();

		llist.swapNodes(llist.head);
		System.out.println();
		llist.printList();
	}
}
