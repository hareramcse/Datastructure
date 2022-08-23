package com.hs.other;

import com.hs.basic.ListNode;

class FindLengthOfLoop {
	public int countListNodesInLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

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
			ListNode temp = slow;
			while (temp.next != slow) {
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		FindLengthOfLoop list = new FindLengthOfLoop();
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		head.next.next.next.next.next.next = new ListNode(70);
		head.next.next.next.next.next.next.next = new ListNode(80);

		// Creating a loop for testing
		head.next.next.next.next.next.next.next = head.next.next;
		System.out.println(list.countListNodesInLoop(head));
	}
}