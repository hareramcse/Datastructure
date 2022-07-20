package com.hs.linkedlist;

import com.hs.basic.Node;

class FindLengthOfLoop {
	// count number of nodes in the loop
	public int countNodesInLoop(Node head) {
		Node slow = head;
		Node fast = head;

		boolean loopExist = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExist = true;
				break;
			}
		}

		int count = 0;
		if (loopExist) {
			count = 1;
			Node temp = slow;
			while (temp.next != slow) {
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		FindLengthOfLoop list = new FindLengthOfLoop();
		
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = new Node(80);

		// Creating a loop for testing
		head.next.next.next.next.next.next.next = head.next.next;

		System.out.println(list.countNodesInLoop(head));
	}
}