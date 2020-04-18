package com.hs.linkedlist;

public class GetNodeDataFromTail {

	private static int getNode(Node head, int positionFromTail) {
		Node temp = head;
        int counter = 0;
        while(head != null){
            head = head.next;
            if(counter < positionFromTail){
                counter++;
            }else{
                temp = temp.next;
            }
        }
        return temp.data;
	}

	private static int getNodeSecondWay(Node head, int n) {
		int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        count = count - n;
        while(--count > 0){
            head = head.next;
        }
        return head.data;
	}
	
	private static int getNodeThirdWay(Node head, int positionFromTail) {
        Node main_ptr = head; 
        Node ref_ptr = head; 
  
        int count = 0; 
        if (head != null) { 
            while (count < positionFromTail) { 
                if (ref_ptr == null) { 
                    System.out.println(positionFromTail + " is greater than the no "
                                       + " of nodes in the list"); 
                    return -1; 
                } 
                ref_ptr = ref_ptr.next; 
                count++; 
            } 
            while (ref_ptr != null) { 
                main_ptr = main_ptr.next; 
                ref_ptr = ref_ptr.next; 
            } 
            return main_ptr.data; 
        }else{
            return -1;
        } 
    }
	
	public static void main(String[] args) {
		Node head = new Node(20);
		head.next = new Node(10);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		
		int data = getNode(head, 3);
		System.out.println(data);
		System.out.println(getNodeSecondWay(head, 3));
	}
}
