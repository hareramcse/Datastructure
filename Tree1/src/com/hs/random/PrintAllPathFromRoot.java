package com.hs.random;

import java.util.ArrayList;
import java.util.List;

class PrintAllPathFromRoot {

	static Node root;

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

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		List<Node> list=new ArrayList<Node>();
		//Print all root-to-leaf paths of the input tree 
		tree.PrintAllPossiblePath(root,list);

	}
}
