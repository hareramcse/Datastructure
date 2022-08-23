package com.hs.basic;

public class MyListWithHeadAndTail {
	private ListNode head = null;
	private ListNode tail = null;

	private void addFirst(int data) {
		if (head == null && tail == null) {
			ListNode newListNode = new ListNode(data);
			head = tail = newListNode;
			return;
		} else {
			ListNode newListNode = new ListNode(data);
			newListNode.next = head;
			head = newListNode;
		}
	}

	private void addLast(int data) {
		if (head == null && tail == null) {
			ListNode newListNode = new ListNode(data);
			head = tail = newListNode;
			return;
		} else {
			ListNode newListNode = new ListNode(data);
			tail.next = newListNode;
			tail = newListNode;
		}
	}

	private void printData() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		MyListWithHeadAndTail myListWithHeadAndTail = new MyListWithHeadAndTail();
		System.out.println("inserting at begingin");
		myListWithHeadAndTail.addFirst(60);
		myListWithHeadAndTail.addFirst(70);
		myListWithHeadAndTail.printData();
		System.out.println("now add at last");
		myListWithHeadAndTail.addLast(10);
		myListWithHeadAndTail.addLast(20);
		myListWithHeadAndTail.addLast(30);
		myListWithHeadAndTail.printData();
	}
}
