package com.hackerrank.basics;

import java.util.*;
class TreeNode {
	int data;
	TreeNode next;
	TreeNode(int d){
        data=d;
        next=null;
    }
	
}
class MoreLinkedList {
    	public static TreeNode removeDuplicates(TreeNode head) {
	    // Empty list case:
	    if (head == null) {
		return head;
	    }

	    TreeNode current = head;
	    while (current.next != null) {
		// If data is equal, reset the next pointer
		if (current.data == (current.next).data) {
		    current.next = (current.next).next;
		} else {
		    // If data is not equal, go
		    // to the next element
		    current = current.next;
		}
	    }

	    return head;
	}
    public static TreeNode insert(TreeNode head, int data)
     {
        TreeNode p=new TreeNode(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            TreeNode start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(TreeNode head)
        {
              TreeNode start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
    public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              TreeNode head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
}
