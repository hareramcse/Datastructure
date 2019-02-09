package com.hs.random;

import java.util.ArrayList;
import java.util.List;

class PrintAllPathFromRoot {

	public void PrintAllPossiblePath(Node root,List<Node> nodelist){
	    if(root != null){
	            nodelist.add(root);
	            
	            if(root.left != null){
	                PrintAllPossiblePath(root.left,nodelist);
	            }if(root.right != null){
	                PrintAllPossiblePath(root.right,nodelist);
	            }else if(root.left == null && root.right == null){

		            for(int i=0;i<nodelist.size();i++){
		                System.out.print(" "+nodelist.get(i).data);
		            }
	                System.out.println();
	            }
	            
	            nodelist.remove(root);
	    }
	}

	 //Driver program to test mirror() 
	public static void main(String[] args) {

		PrintAllPathFromRoot tree = new PrintAllPathFromRoot();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		List<Node> list=new ArrayList<Node>();
		//Print all root-to-leaf paths of the input tree 
		tree.PrintAllPossiblePath(root,list);

	}
}
