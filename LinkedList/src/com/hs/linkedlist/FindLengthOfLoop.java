package com.hs.linkedlist;

class FindLengthOfLoop {

	// Returns count of nodes present in loop.
	static int countNodes(Node node) {
		int res = 1;
		Node temp = node;
		while (temp.next != node) {
			res++;
			temp = temp.next;
		}
		return res;
	}

	/*
	 * This function detects and counts loop nodes in the list. If loop is not there
	 * in then returns 0
	 */
	static int countNodesinLoop(Node node) {
		Node slow = node, fast = node.next;

		while (fast != null && fast.next != null) {
			if (slow == fast)
				return countNodes(slow);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Return 0 to indecate that there is no loop */
		return 0;
	}

	static Node newNode(int key) {
		Node temp = new Node(key);

		return temp;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		Node head = newNode(1);
		head.next = newNode(2);
		head.next.next = newNode(3);
		head.next.next.next = newNode(4);
		head.next.next.next.next = newNode(5);

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next;

		System.out.println(countNodesinLoop(head));
	}
}