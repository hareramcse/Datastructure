package com.hs.doublilinkedlist.geekforgeeks;

public class InsertNodeInSortedDoublyLinkedList {
	Node head;
	public static Node insert(Node head, int data) {
		if(head == null){
	        Node newNode = new Node(data);
	        return newNode;
	    }
	    Node node = head;
	    while(node != null){
	        if (node.data >= data){
	            Node newNode = new Node(data);
	            newNode.prev = node.prev;
	            newNode.next = node;
	            node.prev = newNode;
	            if (newNode.prev == null){
	                return newNode;
	            }
	            else {
	            	newNode.prev.next = newNode;
	                return head;
	            }
	        }
	        if (node.next == null){
	            Node newNode = new Node(data);
	            newNode.prev = node;
	            newNode.next = null;
	            node.next = newNode;
	            break;
	        }
	        node = node.next;
	    }
	    return head;
	}
	
	public static void main(String[] args) {
		
	}
}
