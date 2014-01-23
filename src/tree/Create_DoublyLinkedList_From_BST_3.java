package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Method 1 (Simple)
 * Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be 
 * constructed.
 * 	1) Get the Middle of the linked list and make it root.
	2) Recursively do same for left half and right half.
	       a) Get the middle of left half and make it left child of the root
	          created in step 1.
	       b) Get the middle of right half and make it right child of the
	          root created in step 1.
	
	Time complexity: O(nLogn) where n is the number of nodes in Linked List.
 * 
 * Method 2 (Tricky) 
 * The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to 
 * insert nodes in BST in the same order as the appear in Doubly Linked List, so that the tree can be constructed in O(n) 
 * time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, 
 * we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we assign middle 
 * node to root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with 
 * root. While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate 
 * pointer in each recursive call. Following is C implementation of method 2. The main code which creates Balanced BST is 
 * highlighted.
 * 
 * Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL). The left and right pointers in nodes are to be used 
 * as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the 
 * given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
 * 
 * I came across this interview during one of my interviews. A similar problem is discussed in this post. The problem here is simpler as 
 * we don’t need to create circular DLL, but a simple DLL. The idea behind its solution is quite simple and straight.

	1. If left subtree exists, process the left subtree
	…..1.a) Recursively convert the left subtree to DLL.
	…..1.b) Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
	…..1.c) Make inorder predecessor as previous of root and root as next of inorder predecessor.
	2. If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
	…..2.a) Recursively convert the right subtree to DLL.
	…..2.b) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
	…..2.c) Make inorder successor as next of root and root as previous of inorder successor.
	3. Find the leftmost node and return it (the leftmost node is always head of converted DLL).
 */
public class Create_DoublyLinkedList_From_BST_3 {

	private static class Node {
		private int data;
		private Node left, right;

		public Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString(){
			return "value : " + data;
		}
	}

	public static Node ConvertToDoubly(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return null;
		q.add(root);      //[value : 1]
		Node start = root;
		Node leftNode = null;
		Node current = null;
		while (q.peek() != null) {
			if (q.peek().left != null) {
				q.add(q.peek().left);     //[value : 1, value : 2]
			}
			if (q.peek().right != null) {
				q.add(q.peek().right);    //[value : 1, value : 2, value : 3]
			}
			leftNode = current;
			current = q.poll();
			current.left = leftNode;
			current.right = q.peek();
		}
		return start;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.data + " - ");
			head = head.right;
		}
	}

	public static void main(String[] args) {
		Node b = new Node(1);
		b.left = new Node(2);
		b.right = new Node(3);
		b.left.left = new Node(4);
		b.left.right = new Node(5);
		b.right.left = new Node(6);
		Node head = ConvertToDoubly(b);
		printList(head);
	}
}
