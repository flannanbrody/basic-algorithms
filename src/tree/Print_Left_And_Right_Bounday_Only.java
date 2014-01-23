package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Approach:
	1. Keep track of each level of the binary tree using a marker node.
	2. while doing a level order traversal of the binary tree if we hit the marker node, then if the queue is non-empty then 
	   insert the head of node in the leftViewList.
	3. if the current node that we pulled out of queue is not marker, but its next node is marker then put the current node 
	   in the rightViewList.

  	 		4
          /   \
        2		 6
       / \     / \
      1   3   5   7
	
		printing inorder: 1 2 3 4 5 6 7 
		Printing left View: 4 2 1 
		Printing right view: 4 6 7 
		   

In the end print the left and right view lists.
 */
public class Print_Left_And_Right_Bounday_Only {

	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		
		System.out.println("printing inorder: ");
		printBST(bst);
		System.out.println();
		printLeftNRightViewOfBT(bst);

	}

	private static class TreeNode<T> {

		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return " " + value;
		}
	}

	public static void printLeftNRightViewOfBT(TreeNode<Integer> node) {
		if (null == node) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		TreeNode<Integer> marker = new TreeNode<>(null);
		queue.add(node);   // null
		queue.add(marker); //[ 4,  null]

		// boolean wasMarker = false;
		ArrayList<TreeNode<Integer>> leftViewList = new ArrayList<>();
		ArrayList<TreeNode<Integer>> rightViewList = new ArrayList<>();
		leftViewList.add(node);
		// rightViewList.add(node);
		while (!queue.isEmpty()) {
			TreeNode<Integer> currentNode = queue.remove(); //1st iteration currentNode = 4, 2nd iteration currentNode is null, 3rd iteration currentNode is 2
															//4th iteration currentNode = 6, 5th iteration currentNode = null
			if (currentNode.equals(marker)) {
				if (!queue.isEmpty()) {
					leftViewList.add(queue.peek()); //2nd iteration [ 4,  2], 5th iteration [ 4,  2,  1]
					queue.add(marker); 				//2nd iteration [ 2,  6,  null], 5th iteration [ 1,  3,  5,  7,  null]
				}
			}
			if (!queue.isEmpty() && queue.peek().equals(marker)) {
				rightViewList.add(currentNode);
			}
			if (currentNode.left != null) {
				queue.add(currentNode.left);  //first iteration = [ null,  2] , 3rd iteration = [ 6,  null,  1]
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right); //first iteration = [ null,  2,  6], 3rd iteration = [ 6,  null,  1,  3]
			}
		}
		Iterator<TreeNode<Integer>> itLeft = leftViewList.iterator();
		System.out.println("Printing left View: ");
		while (itLeft.hasNext()) {
			System.out.print(itLeft.next().value + " ");
		}
		System.out.println();

		System.out.println("Printing right view: ");
		Iterator<TreeNode<Integer>> itRight = rightViewList.iterator();
		while (itRight.hasNext()) {
			System.out.print(itRight.next().value + " ");
		}
		System.out.println();
	}

	public static void printBST(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			printBST(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			printBST(node.right);
		}
	}
}
