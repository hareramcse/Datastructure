package com.hs.linkedlist;

class FindMidElement {
	Node head;

	private void printMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println("The middle element is [" + slow.data + "] \n");
		}
	}

	private void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	private void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + "->");
			tnode = tnode.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		FindMidElement llist = new FindMidElement();
		for (int i = 5; i > 0; --i) {
			llist.push(i);
			llist.printList(llist.head);
			llist.printMiddle(llist.head);
		}
	}
}