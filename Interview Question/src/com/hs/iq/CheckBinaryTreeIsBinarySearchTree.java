package com.hs.iq;

class Node{
	int data;
	Node left;
	Node right;
	Node next;
	
	Node(int data){
		this.data=data;
	}
}
public class CheckBinaryTreeIsBinarySearchTree {
	
    public static Node current=null;
	
	public void insert(int data){
		current=insert(current, data);
	}
	
	private Node insert(Node root,int data){
		if(root==null){
			root=new Node(data);
		}else{
			if(data<root.data){
				root.left=insert(root.left,data);
			}else{
				root.right=insert(root.right, data);
			}
		}
		return root;
	}

	private boolean isSubtreeLesserThanRootElement(Node root,int data){
		if(root==null){
			return true;
		}else{
			if(root.data<data && isSubtreeLesserThanRootElement(root.left, data) 
					&& isSubtreeLesserThanRootElement(root.right, data)){
				return true;
			}else{
				return false;
			}
		}
	}
	private boolean isSubtreeGreaterThanRootElement(Node root, int data){
		if(root==null){
			return true;
		}else{
			if(root.data>data && isSubtreeGreaterThanRootElement(root.left, data) 
					&& isSubtreeGreaterThanRootElement(root.right, data)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	// 1st way( O(n2))
	private boolean isBST1stWay(Node root){
		if(root==null){
			return true;
		}else{
			if(isSubtreeLesserThanRootElement(root.left, root.data)
					&& isSubtreeGreaterThanRootElement(root.right, root.data)
					&& isBST1stWay(root.left)
					&& isBST1stWay(root.right)){
				return true;
			}else{
				return false;
			}
				
		}
	}
	
	//METHOD 2 (Correct but not efficient)
	public boolean isBST2ndWay(Node root){ 
	  if (root == null) 
	    return true; 
	     
	  /* false if the min of the left is > than root */
	  if (root.left!=null && findMinInBST(root.left) > root.data) 
	    return false; 
	     
	  /* false if the max of the right is < than root */
	  if (root.right!=null && findMaxInBST(root.right) < root.data) 
	    return false; 
	   
	  /* false if, recursively, the left or right is not a BST */
	  if (!isBST2ndWay(root.left) || !isBST2ndWay(root.right)) 
	    return false; 
	     
	  /* passing all that, it means it's a BST */
	  return true; 
	} 
	
	public int findMinInBST(Node root){
		Node current=root;
		if(current==null){
			return -1;
		}
		while(current.left != null){
			current=current.left;
		}
		return current.data;
	}
	
	public int findMaxInBST(Node root){
		Node current=root;
		if(current==null){
			return -1;
		}
		while(current.right != null){
			current=current.right;
		}
		return current.data;
	}
	
	// best way (O(n)
	public boolean isBST3rdWay(Node root,int minValue,int maxValue){
		if(root==null){
			return true;
		}else{
			if(root.data>minValue 
			         && root.data<maxValue
			         && isBST3rdWay(root.left, minValue, root.data)
			         && isBST3rdWay(root.right, root.data, maxValue)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		CheckBinaryTreeIsBinarySearchTree cbtsst=new CheckBinaryTreeIsBinarySearchTree();
		System.out.println(cbtsst.isBST3rdWay(current, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(cbtsst.isBST1stWay(current));
		System.out.println(cbtsst.isBST2ndWay(current));
	}
}
