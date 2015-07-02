package com.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * }
 */

public class PostOrderTraversal {
	
	 public List<Integer> postorderTraversal(TreeNode root) {
	     ArrayList<Integer> list = new ArrayList<Integer>();
	     if(root != null){
	    	 
	    	 if(root.left != null){
	    		 this.recursiverTravesal(root.left, list);
	    	 }
	    	 if(root.right != null){
	    		 this.recursiverTravesal(root.right, list);
	    	 }
	    	 list.add(root.val);
	     }
	     return list;
	     
	 }
	 
	 private void recursiverTravesal(TreeNode node, List list){
		 if(node != null){
			
	    	 if(node.left != null){
	    		 this.recursiverTravesal(node.left, list);
	    	 }
	    	
	    	 if(node.right != null){
	    		 this.recursiverTravesal(node.right, list);
	    	 }
	    	 list.add(node.val);
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
		 
		 PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		 
		 List<Integer> list = postOrderTraversal.postorderTraversal(root);
		 
		 for(Integer temp : list){
			 System.out.println(temp);//Expect result: 2-3-5-6-4-7
		 }
		 
	 }
	 */
	 

}

//class TreeNode {
//	int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { 
//    	val = x; 
//    }
//}
