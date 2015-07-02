package com.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *This class provide for solution for two leetcode cases
 * 
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaxMinDepthOfTree {
	
    public int maxDepth(TreeNode root) {
    	
    	if(root == null){
    		return 0;
    	}
    	int leftTreeDepth = 0;
    	int rightTreeDepth = 0;
    	int currentNodeDepth=0;
    	int maxDepth=0;
    	
    	currentNodeDepth++;
    	
    	if(root.left!=null){
    		leftTreeDepth = maxDepth(root.left);
    	}
    	
    	if(root.right!=null){
    		rightTreeDepth = maxDepth(root.right);
    	}
    	
    	if(leftTreeDepth>rightTreeDepth){
    		maxDepth=currentNodeDepth+leftTreeDepth;
    	}
    	else{
    		maxDepth=currentNodeDepth+rightTreeDepth;
    	}
    	return maxDepth;
    	
    	
    }
    
    public int minDepth(TreeNode root) {
    	
    	if(root == null){
    		return 0;
    	}
    	int leftTreeDepth = 0;
    	int rightTreeDepth = 0;
    	int currentNodeDepth=0;
    	int minDepth=0;
    	
    	currentNodeDepth++;
    	
    	if(root.left==null && root.right==null){
    		minDepth=currentNodeDepth;
    	}
    	
    	if(root.left != null && root.right==null){
    		leftTreeDepth = minDepth(root.left);
    		minDepth=currentNodeDepth+leftTreeDepth;
    	}
    	
    	if(root.left == null && root.right!=null){
    		rightTreeDepth = minDepth(root.right);
    		minDepth=currentNodeDepth+rightTreeDepth;
    	}
    	
    	
    	if(root.left != null && root.right!=null){
    		leftTreeDepth = minDepth(root.left);
    		rightTreeDepth = minDepth(root.right);
    		if(leftTreeDepth<rightTreeDepth){
    			minDepth=currentNodeDepth+leftTreeDepth;
    		}
    		else{
    			minDepth=currentNodeDepth+rightTreeDepth;
    		}
    		
    	}
    	

    	return minDepth;
        
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
		 
		 MaxMinDepthOfTree maxDepthOfTree = new MaxMinDepthOfTree();
		 
		 System.out.println("The maxium depth is:"+ maxDepthOfTree.maxDepth(root));
		 System.out.println("The minium depth is:"+ maxDepthOfTree.minDepth(root));
		 
    }
    */
    
    

    

}

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}





