package com.hs.basic;

public class LinkedListUtil {

	public static Node addBefore(Node head, int data) {
		if (head == null) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	public static void addAtIndex(Node head, int index, int data) {
		if (index > 0) {
			if (head == null) {
				head = new Node(data);
				return;
			} else {
				Node newNode = new Node(data);
				Node temp = head;
				int count = 0;
				while (true) {
					count++;
					if (count == index) {
						break;
					} else {
						temp = temp.next;
					}
				}
				newNode.next = temp.next;
				temp.next = newNode;
			}
		} else {
			System.out.println("index cant be -ve");
		}
	}

	public static Node addLast(Node head, int data) {
		Node temp = head;
		if (temp == null) {
			head = new Node(data);
		} else {
			Node newNode = new Node(data);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return head;
	}

	public static Node deleteHead(Node head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			head = head.next;
		}
		return head;
	}

	public static Node deleteAtIndex(Node head, int index) {
		if (index > 0) {
			if (head == null) {
				System.out.println("list is empty");
			} else if (index == 0) {
				head = head.next;
			} else {
				Node temp = head;
				Node t = null;
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

	public static Node deleteLast(Node head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			Node temp = head;
			Node t = null;
			while (temp.next != null) {
				t = temp;
				temp = temp.next;
			}
			t.next = null;
		}
		return head;
	}

	public static Node reverseByIterativeMethod(Node head) {
		if (head == null) {
			System.out.println("list is empty");
		} else {
			Node current = null, previous = null, nextNode = null;
			current = head;
			while (current != null) {
				nextNode = current.next;
				current.next = previous;
				previous = current;
				current = nextNode;
			}
			head = previous;
		}
		return head;
	}

	public static Node reverseByRecursion(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node reverseList = reverseByRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return reverseList;
	}

	public static Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void printLinkedList(Node head) {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is Empty");
			return;
		} else {
			while (temp != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		Node head = LinkedListUtil.addBefore(null, 10);
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