package tree;

import java.util.Stack;

/*
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 *     
 *     Ancestor's of 1 : [ 2,  4]
 *     Ancestor's of 2 : [ 4]
 *     Ancestor's of 3 : [ 2,  4]
 *     Ancestor's of 4 : []
 *     Ancestor's of 5 : [ 6,  4]
 *     Ancestor's of 6 : [ 4]
 *     Ancestor's of 7 : [ 6,  4]
 * 
 */

public class Print_All_Ancestors_Given_Node {

	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		for (int i = 1; i <= 7; i++) {
			Stack<TreeNode<Integer>>  ancestors = new Stack<TreeNode<Integer>>();
			getAncestors(bst, i, ancestors);
			System.out.println("Ancestor's of " + i + " : " + ancestors.toString());
		}
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

	public static void getAncestors(TreeNode<Integer> root, int key, Stack<TreeNode<Integer>> nodes) {
		if (isPresentInSubTree(root.left, key, nodes) || isPresentInSubTree(root.right, key, nodes)) {
			nodes.push(root);
		} else {
			if (!nodes.isEmpty()) {
				nodes.pop();
			}
		}
	}

	private static boolean isPresentInSubTree(TreeNode<Integer> node, int key, Stack<TreeNode<Integer>> nodes) {

		if (node == null)
			return false;
		if ((int) node.value == key) {
			return true;
		} else if (isPresentInSubTree(node.left, key, nodes) || isPresentInSubTree(node.right, key, nodes)) {
			nodes.push(node);
			return true;
		}
		return false;
	}
}
