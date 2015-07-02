package com.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LevelOrderTravesal {
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> list = addTreeNodeToList(root);
    	
    	for(List<Integer> sublist : list ){
    		System.out.println("######");
    		for(Integer ite : sublist){
    			System.out.println(ite!=null?ite:null);
    		}
    		
    	}
    	return list;
    	
    	
    }
    
    /**
     * To better encapsulate the algorithm of addTreeNodeToList(TreeNode node, int level, List<List<Integer>> list)
     * Add below new method to hide the level and list details.
     * 
     */
    public List<List<Integer>> addTreeNodeToList(TreeNode node){
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	this.addTreeNodeToList(node, 0, list);
    	return list;
    }
    
    /**
     * The top level start with 0, and add one in each level down
     * The key of the algorithm is to use List<List<Integer>> data structure 
     */
    
    private void addTreeNodeToList(TreeNode node, int level, List<List<Integer>> list){
    	
    	if(node == null){
    		return;
    	}
    	
    	if(list.size()==level){
    		list.add(new ArrayList<Integer>());
    	}
    	
    	((ArrayList<Integer>) (list.get(level))).add(node!=null?node.val:null);
    	
    	//Left node and right node both are not null
    	if((node.left != null && node.right != null)
    			|| (node.left != null && node.right == null)//Only left node is not null
    			|| (node.right != null && node.left == null)){//Only right node is not null
    		level++;
    		this.addTreeNodeToList(node.left, level, list);
    		this.addTreeNodeToList(node.right, level, list);
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
    
    
    public static void main(String args[]){

    	 TreeNode root = new TreeNode(7);
		 root.left = new TreeNode(5);
		 root.left.left = new TreeNode(3);
		 root.left.left.right = new TreeNode(2);
		 root.right = new TreeNode(4);
		 root.right.left = new TreeNode(6);
		 
		 LevelOrderTravesal levelOrderTravesal = new LevelOrderTravesal();
		 
		 levelOrderTravesal.levelOrder(root);
		 
    }
    

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

