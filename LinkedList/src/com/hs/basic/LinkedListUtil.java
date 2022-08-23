package com.hs.basic;

public class LinkedListUtil {
	public static ListNode addBefore(ListNode head, int data) {
		if (head == null) {
			head = new ListNode(data);
		} else {
			ListNode newListNode = new ListNode(data);
			newListNode.next = head;
			head = newListNode;
		}
		return head;
	}

	public static void addAtIndex(ListNode head, int index, int data) {
		if (index > 0) {
			if (head == null) {
				head = new ListNode(data);
				return;
			} else {
				ListNode newListNode = new ListNode(data);
				ListNode temp = head;
				int count = 0;
				while (true) {
					count++;
					if (count == index) {
						break;
					} else {
						temp = temp.next;
					}
				}
				newListNode.next = temp.next;
				temp.next = newListNode;
			}
		} else {
			System.out.println("index cant be -ve");
		}
	}

	public static ListNode addLast(ListNode head, int data) {
		ListNode temp = head;
		if (temp == null) {
			head = new ListNode(data);
		} else {
			ListNode newListNode = new ListNode(data);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newListNode;
		}
		return head;
	}

	public static ListNode deleteHead(ListNode head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			head = head.next;
		}
		return head;
	}

	public static ListNode deleteAtIndex(ListNode head, int index) {
		if (index > 0) {
			if (head == null) {
				System.out.println("list is empty");
			} else if (index == 0) {
				head = head.next;
			} else {
				ListNode temp = head;
				ListNode t = null;
				int count = 0;
				while (count != index) {
					t = temp;
					temp = temp.next;
					count++;
				}
				t.next = temp.next;
			}
		} else {
			System.out.println("index cant be -ve");
		}
		return head;
	}

	public static ListNode deleteLast(ListNode head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			ListNode temp = head;
			ListNode t = null;
			while (temp.next != null) {
				t = temp;
				temp = temp.next;
			}
			t.next = null;
		}
		return head;
	}

	public static ListNode reverseByIterativeMethod(ListNode head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			ListNode current = null, previous = null, nextListNode = null;
			current = head;
			while (current != null) {
				nextListNode = current.next;
				current.next = previous;
				previous = current;
				current = nextListNode;
			}
			head = previous;
		}
		return head;
	}

	public static ListNode reverseByRecursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverseList = reverseByRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return reverseList;
	}

	public static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void printLinkedList(ListNode head) {
		ListNode temp = head;
		if (temp == null) {
			System.out.println("List is Empty");
			return;
		} else {
			while (temp != null) {
				System.out.print(temp.val + " -> ");
				temp = temp.next;
			}
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		ListNode head = LinkedListUtil.addBefore(null, 10);
		head = LinkedListUtil.addBefore(head, 20);
		head = LinkedListUtil.addBefore(head, 30);
		LinkedListUtil.printLinkedList(head);
		LinkedListUtil.addAtIndex(head, 1, 40);
		System.out.println("list after adding data at 1st index");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.addLast(head, 60);
		System.out.println("list after adding data at last of the list");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.deleteHead(head);
		System.out.println("list after deleting the head data");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.deleteAtIndex(head, 2);
		System.out.println("list after deleting the 2nd index");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.deleteLast(head);
		System.out.println("list after deleting the last index");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.addLast(head, 80);
		System.out.println("adding data at last of the list");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.reverseByIterativeMethod(head);
		System.out.println("list after reversing by iterative method");
		LinkedListUtil.printLinkedList(head);
		head = LinkedListUtil.reverseByRecursion(head);
		System.out.println("list after reversing by recursion method");
		LinkedListUtil.printLinkedList(head);
	}
}