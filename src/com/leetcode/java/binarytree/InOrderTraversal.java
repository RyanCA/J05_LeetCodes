package com.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InOrderTraversal {
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     if(root != null){
	    	 if(root.left != null){
	    		 this.recursiverTravesal(root.left, list);
	    	 }
	    	 list.add(root.val);
	    	 if(root.right != null){
	    		 this.recursiverTravesal(root.right, list);
	    	 }
	     }
	     return list;
	     
	 }
	 
	 private void recursiverTravesal(TreeNode node, List list){
		 if(node != null){
	    	 if(node.left != null){
	    		 this.recursiverTravesal(node.left, list);
	    	 }
	    	 list.add(node.val);
	    	 if(node.right != null){
	    		 this.recursiverTravesal(node.right, list);
	    	 }
	     }
	 }
	 
 	/**
 	 *                           7
 	 *                         /   \
 	 *                        5     4
 	 *                       /     /
 	 *                      3     6
 	 *                       \
 	 *                        2
 	 */
	 /*
	 public static void main(String args[]){
		 TreeNode root = new TreeNode(7);
		 root.left = new TreeNode(5);
		 root.left.left = new TreeNode(3);
		 root.left.left.right = new TreeNode(2);
		 root.right = new TreeNode(4);
		 root.right.left = new TreeNode(6);
		 
		 InOrderTraversal inOrderTraversal = new InOrderTraversal();
		 
		 List<Integer> list = inOrderTraversal.inorderTraversal(root);
		 
		 for(Integer temp : list){
			 System.out.println(temp);//Expect result: 3-2-5-7-6-4
		 }
		 
	 }
	 */
	 

}

/*
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}
*/
