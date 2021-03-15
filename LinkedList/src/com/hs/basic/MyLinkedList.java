package com.hs.basic;

public class MyLinkedList {

	private Node head = null;

	private void addBefore(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		} else {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
	}

	private void addAtIndex(int index, int data) {
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

	public void addLast(int data) {
		Node temp = head;
		if (temp == null) {
			head = new Node(data);
			return;
		} else {
			Node newNode = new Node(data);
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	private void deleteHead() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			head = head.next;
		}
	}

	private void deleteAtIndex(int index) {
		if (index > 0) {
			if (head == null) {
				System.out.println("list is empty");
			} else if(index == 0){
				head = head.next;
			}else {
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
	}

	/*private void deleteMid(int index) {
		Node tmp = head;
		int count = 0;
		while (tmp.next != null) {
			count++;
			if (count == index)
				break;
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
	}
*/
	private void deleteLast() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			Node temp = head;
			Node t = null;
			while (temp.next != null) {
				t = temp;
				temp = temp.next;
			}
			t.next = null;
		}
	}

	private void reverseByIterativeMethod() {
		if (head == null) {
			System.out.println("list is empty");
			return;
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
	}

	private Node reverseByRecursion(Node node) {
		if (node.next == null) {
			head = node;
			return head;
		}
		if(head.next == null) {
			return head;
		}
		Node returnedNode = reverseByRecursion(node.next);
		Node temp = node.next;
		temp.next = node;
		node.next = null;
		return returnedNode;
	}

	private void printData() {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is Empty");
			return;
		} else {
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addBefore(10);
		list.addBefore(20);
		list.addBefore(30);
		list.printData();
		list.addAtIndex(1, 40);
		System.out.println("list after adding data at 1st index");
		list.printData();
		list.addAtIndex(2, 50);
		System.out.println("list after adding data at 2st index");
		list.printData();
		list.addLast(60);
		System.out.println("list after adding data at last of the list");
		list.printData();
		list.deleteHead();
		System.out.println("list after deleting the head data");
		list.printData();
		list.deleteAtIndex(2);
		System.out.println("list after deleting the 2nd index");
		list.printData();
		list.deleteLast();
		System.out.println("list after deleting the last index");
		list.printData();
		list.addLast(80);
		System.out.println("adding data at last of the list");
		list.printData();
		list.reverseByIterativeMethod();
		System.out.println("list after reversing by iterative method");
		list.printData();
		list.reverseByRecursion(list.head);
		System.out.println("list after reversing by recursion method");
		list.printData();
	}
}