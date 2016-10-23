/*
Tree Traversal
A traversal of some binary tree, , is an algorithm that iterates through each node in  exactly  time.
InOrder Traversal
An inorder traversal of tree  is a recursive algorithm that follows the left subtree; once there are no more left subtrees to process, we process the right subtree. The elements are processed in left-root-right order. The basic algorithm is as follows:
inOrder(t) {
    if(t is not empty) {
        inOrder( left subtree of t )
        process t's root element
        inOrder( right subtree of t )
    } 
} 
An inorder traversal of a binary search tree will process the tree's elements in ascending order.
PostOrder Traversal
A postorder traversal of tree  is a recursive algorithm that follows the left and right subtrees before processing the root element. The elements are processed in left-right-root order. The basic algorithm is as follows:
postOrder(t) {
    if(t is not empty) {
        postOrder( left subtree of t )
        postOrder( right subtree of t )
        process t's root element
    } 
} 
PreOrder Traversal (DFS)
A preorder traversal of tree  is a recursive algorithm that processes the root and then performs preorder traversals of the left and right subtrees. The elements are processed root-left-right order. The basic algorithm is as follows:
preOrder(t) {
    if(t is not empty) {
        process t's root element
        preOrder( left subtree of t )
        preOrder( right subtree of t )
    } 
} 
Because a preorder traversal goes as deeply to the left as possible, it's also known as a depth-first-search or DFS.
Level-Order Traversal (BFS)
A level-order traversal of tree  is a recursive algorithm that processes the root, followed by the children of the root (from left to right), followed by the grandchildren of the root (from left to right), etc. The basic algorithm shown below uses a queue of references to binary trees to keep track of the subtrees at each level:
levelOrder(BinaryTree t) {
    if(t is not empty) {
        // enqueue current root
        queue.enqueue(t)
        
        // while there are nodes to process
        while( queue is not empty ) {
            // dequeue next node
            BinaryTree tree = queue.dequeue();
            
            process tree's root;
            
            // enqueue child elements from next level in order
            if( tree has non-empty left subtree ) {
                queue.enqueue( left subtree of t )
            }
            if( tree has non-empty right subtree ) {
                queue.enqueue( right subtree of t )
            }
        }
    } 
} 
Because a preorder traversal goes level-by-level, it's also known as a breadth-first-search (BFS).
Example
BinaryTree.png
The binary tree above has the following traversals:
InOrder: 1 2 3 4 5 6 7
PostOrder: 1 3 2 5 7 6 4
PreOrder: 4 2 1 3 6 5 7
Level-Order: 4 2 6 1 3 5 7
*/

import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{
    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        if(root != null) queue.add(root) ;

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(current.data+" ");
            if (current.left!=null) queue.add(current.left);
            if (current.right!=null) queue.add(current.right);
        }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
