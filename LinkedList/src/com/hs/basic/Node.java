package com.hs.basic;

public class Node {
	public int data;
	public Node next;
	
	public Node() {
		
	}
	
	public Node(int data){
		this.data=data;
		this.next=null;
	}
	
	public Node(String value){
		this.next=null;
	}
}
