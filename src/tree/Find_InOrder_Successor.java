package tree;

/*
 * Populate InOrder Successor for all nodes
 * Given a Binary Tree, write a function to populate next pointer for all nodes. 
 * The next pointer for every node should be set to point to InOrder successor.
 * 
 * Perform inOrder traversal which gives elements in a sorted order and use binary search to find the element and obviously 
 * the next element is the (greatest)successor and previous element is the (smallest) successor
 * 
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 * 
 */

import java.util.*;

public class Find_InOrder_Successor {

	public static void main(String... s) {		
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		
		inorder(bst);
		findSuccessor(5);
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
	
	static List<Integer> nodes = new ArrayList<Integer>();

	public static void inorder(TreeNode<Integer> tree) {
		if (tree != null) {
			inorder(tree.left);
			nodes.add(tree.value);
			inorder(tree.right);
		}
	}
	
	public static void findSuccessor(int n) {
		if (nodes.contains(n)) {
			int temp = binarySearch(nodes, n);
			System.out.println("Success " + nodes.get(temp + 1));
		} else
			System.out.println("Does not exsist");
	}

    public static int binarySearch(List<Integer> a, int key ) {
        int lo = 0;
        int hi = a.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a.get(mid)) hi = mid - 1;
            else if (key > a.get(mid)) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}