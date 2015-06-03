package com.leetcode;

public class ReverseSinglyLinkedList {
	
	 public ListNode reverseList(ListNode head) {
		 

		 ListNode reverseList = head;
		 ListNode restList = null;
		 ListNode temp = null;
		 
		 if(head == null){
			 return reverseList;
		 }
		 
		 if(head.next != null){
			 restList = head.next;
			 temp = restList;
			 restList = restList.next;
			 temp.next = reverseList;
			 reverseList.next = null;
			 reverseList = temp;
			 temp = null;
			 while(restList != null){
				 temp = restList;
				 restList = restList.next;
				 temp.next = reverseList;
				 reverseList = temp;
				 temp = null;
			 }
		 }
		 
		
		 
		 return reverseList;
		 
	 }
	 
	 public void testReverseList(){
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		 ListNode n3 = new ListNode(3);
		 n1.next=n2;
		 n2.next=n3;
		 ListNode head = n1;
		 ListNode temp = head;
		 while(temp!=null){
			 System.out.println(temp.val);
			 temp = temp.next;
		 }
		 
		 head = this.reverseList(head);
		 temp = head;
		 while(temp!=null){
			 System.out.println(temp.val);
			 temp = temp.next;
		 }
	 }
	 
	 public static void main(String args[]){
		 new ReverseSinglyLinkedList().testReverseList();
	 }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	
     int val;
     
     ListNode next;
     
     ListNode(int x) { 
    	 val = x; 
     }
 }

