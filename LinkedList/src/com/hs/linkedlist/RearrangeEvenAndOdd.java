package com.hs.linkedlist;

public class RearrangeEvenAndOdd {
	
	// Function to rearrange the odd and even nodes
	private static Node rearrange(Node head) {
		// Step 1: Segregate even and odd nodes
		// Step 2: Split odd and even lists
		// Step 3: Merge even list into odd list
		Node even;
		Node temp, prev_temp;
		Node i, j, k, l, ptr = null;

		// Step 1: Segregate Odd and Even Nodes
		temp = (head).next;
		prev_temp = head;

		while (temp != null) {

			// Backup next pointer of temp
			Node x = temp.next;

			// If temp is odd move the node
			// to beginning of list
			if (temp.data % 2 != 0) {
				prev_temp.next = x;
				temp.next = (head);
				(head) = temp;
			} else {
				prev_temp = temp;
			}

			// Advance Temp Pointer
			temp = x;
		}

		// Step 2
		// Split the List into Odd and even
		temp = (head).next;
		prev_temp = (head);

		while (temp != null && temp.data % 2 != 0) {
			prev_temp = temp;
			temp = temp.next;
		}

		even = temp;

		// End the odd List (Make last node null)
		prev_temp.next = null;

		// Step 3:
		// Merge Even List into odd
		i = head;
		j = even;

		while (j != null && i != null) {

			// While both lists are not
			// exhausted Backup next
			// pointers of i and j
			k = i.next;
			l = j.next;

			i.next = j;
			j.next = k;

			// ptr points to the latest node added
			ptr = j;

			// Advance i and j pointers
			i = k;
			j = l;
		}

		if (i == null) {

			// Odd list exhausts before even,
			// append remainder of even list to odd.
			ptr.next = j;
		}

		// The case where even list exhausts before
		// odd list is automatically handled since we
		// merge the even list into the odd list
		return head;
	}
	
	private static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static Node insertBeg(Node head, int val) {
		Node temp = new Node(val);
		temp.next = head;
		head = temp;
		return head;
	}

	// Driver Code
	public static void main(String args[]) {
		Node head = new Node(8);
		head = insertBeg(head, 7);
		head = insertBeg(head, 6);
		head = insertBeg(head, 3);
		head = insertBeg(head, 5);
		head = insertBeg(head, 1);
		head = insertBeg(head, 2);
		head = insertBeg(head, 10);

		System.out.println("Linked List:");
		printList(head);
		System.out.println("Rearranged List");
		head = rearrange(head);
		printList(head);
	}
}