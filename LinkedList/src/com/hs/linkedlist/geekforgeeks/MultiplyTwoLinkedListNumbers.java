package com.hs.linkedlist.geekforgeeks;

import com.hs.basic.Node;

public class MultiplyTwoLinkedListNumbers {
	// Function to insert a node at the
	// beginning of the Linked List
	private Node push(Node head_ref, int new_data) {
		// allocate node
		Node new_node = new Node(new_data);

		// link the old list off the new node
		new_node.next = (head_ref);

		// move the head to point to the new node
		(head_ref) = new_node;
		return head_ref;
	}

	// Multiply contents of two linked lists
	private long multiplyTwoLists(Node first, Node second) {
		int num1 = 0, num2 = 0;

		// Generate numbers from linked lists
		while (first != null || second != null) {
			if (first != null) {
				num1 = num1 * 10 + first.data;
				first = first.next;
			}
			if (second != null) {
				num2 = num2 * 10 + second.data;
				second = second.next;
			}
		}

		// Return multiplication of
		// two numbers
		return num1 * num2;
	}

	// A utility function to print a linked list
	private void printList(Node node) {
		while (node != null) {
			System.out.printf("%d", node.data);
			if (node.next != null)
				System.out.printf("->");
			node = node.next;
		}
		System.out.printf("\n");
	}

	// Driver code
	public static void main(String args[]) {
		MultiplyTwoLinkedListNumbers list = new MultiplyTwoLinkedListNumbers();
		Node first = null;
		Node second = null;

		// create first list 9.4.6
		first = list.push(first, 6);
		first = list.push(first, 4);
		first = list.push(first, 9);
		System.out.printf("First List is: ");
		list.printList(first);

		// create second list 8.4
		second = list.push(second, 4);
		second = list.push(second, 8);
		System.out.printf("Second List is: ");
		list.printList(second);

		// Multiply the two lists and see result
		System.out.printf("Result is: ");
		System.out.println(list.multiplyTwoLists(first, second));
	}
}