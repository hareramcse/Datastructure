package com.hs.basic;

public class StackUsingLinkedList {
	private int length;
	private Node head;

	// add head element
	private void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		length++;
	}

	// delete head element
	private int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		int result = head.data;
		head = head.next;
		length++;
		return result;
	}

	private int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return head.data;
	}

	private boolean isEmpty() {
		return length == 0;
	}

	private void printData() {
		if (head == null) {
			System.out.println("stack is empty");
			return;
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		StackUsingLinkedList myStackList = new StackUsingLinkedList();
		myStackList.push(10);
		myStackList.push(20);
		myStackList.push(30);
		myStackList.printData();
		myStackList.pop();
		System.out.println("after 1st pop ");
		myStackList.printData();
		System.out.println("top element is " + myStackList.peek());
	}
}
