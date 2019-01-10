package com.hs.linkedlist;

public class ReverseList {
	Node head=null;
	
	private void add(int data){
		if(head==null){
			head=new Node(data);
		}else{
			Node temp=head;
			Node newNodee=new Node(data);
			while(temp.next != null){
				temp=temp.next;
			}
			temp.next=newNodee;
		}
	} 
	
	private void reverse(Node node){
		if(head==null){
			return;
		}else{
			if(node.next ==null){
				head=node;
				return;
			}
			reverse(node.next);
			Node temp=node.next;
			temp.next=node;
			node.next=null;
		}
	}
	
	private void printData(){
		Node temp=head;
		while(temp !=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseList list = new ReverseList();
		list.add(10);
		list.add(20);
		list.add(3);
		list.add(5);
		list.add(2);
		System.out.println("actual list data");
		list.printData();
		list.reverse(list.head);
		System.out.println("list after reverse");
		list.printData();
	}
}