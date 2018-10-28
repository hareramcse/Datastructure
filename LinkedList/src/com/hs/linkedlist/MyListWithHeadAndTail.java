package com.hs.linkedlist;

public class MyListWithHeadAndTail {

	private Node head = null;
	private Node tail = null;

	private void addFirst(int data) {
		if (head == null && tail == null) {
			Node newNode = new Node(data);
			head = tail = newNode;
			return;
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
	}

	private void addLast(int data) {
		if (head == null && tail == null) {
			Node newNode = new Node(data);
			head = tail = newNode;
			return;
		} else {
			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
		}
	}

	private void printData() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
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
