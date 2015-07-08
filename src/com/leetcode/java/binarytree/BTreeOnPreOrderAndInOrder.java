package com.leetcode.java.binarytree;

import java.util.Arrays;
import java.util.List;


/**
 * Time limit issue
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * The binary tree is not necessary to be a full binary tree. So does 
 * 
 * the case of inorder and postorder 
 * 
 * But in preorder and postorder case, the tree must be full binary tree. 
 * 
 * Otherwise, we can not construct it.
 * 
 * PreOrder [7, 5, 3, 2, 4, 6]
 * InOrder  [3, 2, 5, 7, 6, 4]
 * 
 * Tree:
 *                           7
 *                         /   \
 *                        5     4
 *                       /     /
 *                      3     6
 *                       \
 *                        2
 * Key:
 *                        
 * 1. The first element in PreOrder array can determine the root of a tree
 *    7 is the root element
 * 2. From InOrder array, you can determine that [3,2,5] is the left tree of 
 *    the root and [6, 4] is the right tree of the root
 * 3. [3, 2, 5], which appears first in PreOrder [7, 5, 3, 2, 4, 6], it would be 
 *    the left node of the root node - Node 5; so from InOrder array, we can 
 *    conclude that [3, 2] is the left tree of node 5.
 * 4. since 3 appear prior to 2 in PreOrder, so 3 is the left node of node 5. 
 *    And 2 can be determined is the right node of node 2 from InOrder Array.
 *    
 *    So far, left tree has been determined. we can use similar way to get the 
 *    right tree of the root node
 *    
 */


public class BTreeOnPreOrderAndInOrder {
	
	public static void main(String args[]){
		BTreeOnPreOrderAndInOrder bTreeOnPreOrderAndInOrder = new BTreeOnPreOrderAndInOrder();
		int[] preorder = {7, 5, 3, 2, 4, 6};
		int[] inorder = {3, 2, 5, 7, 6, 4};
		TreeNode root = bTreeOnPreOrderAndInOrder.buildTree(preorder, inorder);
		
		//Use other implement of InOrder tree travesal to do the test 
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
		 
		List<Integer> list = inOrderTraversal.inorderTraversal(root);
		 
		for(Integer temp : list){
			System.out.println(temp);//Expect result: 3-2-5-7-6-4
		}
		
		
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		if( preorder == null || inorder == null || preorder.length==0 || inorder.length==0 ){
			return null;
		}
		
		if(preorder.length != inorder.length){
			throw new IllegalArgumentException ("buildTree's parameters - preorder and inorder are not in same length");
		}
		
		TreeNode root = this.buildTree(preorder, inorder, preorder[0]);
		return root;
		
		
	        
	}
	
	private TreeNode buildTree(int[] preorder, int[] inorder, int preorderNode) {
		
		if( preorder == null || inorder == null){
			return null;
		}
		
//		if(preorder.length != inorder.length){
//			throw new IllegalArgumentException ("buildTree's parameters - preorder and inorder are not in same length");
//		}
		
		//1. Get the node from PreOrder array
        TreeNode node = new TreeNode(preorderNode);		
		
        //Find the left tree and right tree of the node from InOrder array
        int index = this.findArrayIndex(inorder, preorderNode);
        
        if(index-1 >= 0){//There is left tree of the node
        	 int [] leftTree = Arrays.copyOfRange(inorder, 0, index);//from:inclusive, to: exclusive
        	 int leftNodeValue = this.findFirstAppearedElement(preorder, leftTree);
        	 TreeNode leftNode = this.buildTree(preorder, leftTree, leftNodeValue);
        	 node.left = leftNode;
        }
        
        if((inorder.length-1 - (index+1)) >= 0){//There is right tree of the node
        	 int [] rightTree = Arrays.copyOfRange(inorder, index+1, inorder.length);//from:inclusive, to: exclusive
        	 int rightNodeValue = this.findFirstAppearedElement(preorder, rightTree);
        	 TreeNode rightNode = this.buildTree(preorder, rightTree, rightNodeValue);
        	 node.right = rightNode;
        }
        
        return node;
       
	}
	
	private int findFirstAppearedElement(int[] preOrder, int[] partInOrder){
		
		if(preOrder == null || partInOrder == null){
			   throw new IllegalArgumentException("findFirstAppearElement(int[] preOrder, int[] partInOrder): one of the parameter is null"); 
		}
		
		boolean isFound = false;
		int foundElem = 0;
		
		for(int firstLoopElem : preOrder){
			for(int secondLoopElem : partInOrder){
				if(firstLoopElem == secondLoopElem){
					isFound = true;
					foundElem = firstLoopElem;
					break;
				}
			}
		}
		
		if(isFound == true){
			return foundElem;
		}
		else{
			throw new IllegalArgumentException("findFirstAppearElement(int[] preOrder, int[] partInOrder): element can not be found"); 
		}
		
		
	}
	
	private int findArrayIndex(int array[], int item){
	   
		if(array == null){
		   throw new IllegalArgumentException("findIndex(int array[], int item): array is null"); 
	    }
	   
	   int index = -1;
	   int i = 0;
	   for(int temp : array){
		   if(temp == item){
			   index = i;
			   break;
		   }
		   i++;
	   }
	   
	   if(index == -1){
		   throw new IllegalArgumentException("findIndex(int array[], int item): item can not be found in array"); 
	   }
	   return index;
	}

}

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}
