package com.hs.doublilinkedlist.geekforgeeks;

public class Node {
	int data;
	Node next;
	Node prev;// this is for doubly linked list only
	Node tail;
	
	Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
		this.tail=null;
	}
	
	Node(){
		
	}
}
