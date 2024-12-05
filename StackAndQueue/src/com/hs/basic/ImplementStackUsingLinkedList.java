package com.hs.basic;

import java.util.LinkedList;

public class ImplementStackUsingLinkedList {
	LinkedList<Integer> ll = new LinkedList<>();

	// add head element
	private void push(int data) {
		ll.addFirst(data);
	}

	// delete head element
	private int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return ll.removeFirst();
	}

	private int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		}
		return ll.peek();
	}

	private boolean isEmpty() {
		return ll.isEmpty();
	}

	private void printData() {
		for(Integer i : ll) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		ImplementStackUsingLinkedList myStackList = new ImplementStackUsingLinkedList();
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