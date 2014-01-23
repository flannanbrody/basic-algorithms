package tree;


/*
 * You are given a function printKDistanceNodes which takes in a root node of a binary tree, a start node and an 
 * integer K. Complete the function to print the value of all the nodes (one-per-line) which are a K distance 
 * from the given start node in sorted order. Distance can be upwards or downwards.
 * 
 * 	 		 12
 *         /   \
 *       6		 18
 *      / \     / \
 *     3   9   15   21
 *        / \
 *       7   11
 *           /
 *          10
 * 
 *  For TreeNode 9....and k = 1 you have 7, 11 and 6
 */
public class TreeNode_K_Distance_From_TreeNode {

	public static void main(String[] args) {

		TreeNode<Integer> bst = new TreeNode<Integer>(12);
		bst.left = new TreeNode<Integer>(6);
		bst.right = new TreeNode<Integer>(18);
		bst.left.left = new TreeNode<Integer>(3);
		bst.left.right = new TreeNode<Integer>(9);
		bst.left.right.left = new TreeNode<Integer>(7);
		bst.left.right.right = new TreeNode<Integer>(11);
		bst.left.right.right.left = new TreeNode<Integer>(10);

		bst.right.left = new TreeNode<Integer>(15);
		bst.right.right = new TreeNode<Integer>(21);

		System.out.println("k distance apart "
				+ printNodeAtK(bst, bst.left.right, 1, false));
	}

	private static class TreeNode<T> {

		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}

		private TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private static int printNodeAtK(TreeNode<Integer> root,
			TreeNode<Integer> start, int k, boolean found) {
		if (root != null) {
			if (k == 0 && found) {
				System.out.println(root.value);
			}
			if (root == start || found == true) {
				int leftd = printNodeAtK(root.left, start, k - 1, true);
				int rightd = printNodeAtK(root.right, start, k - 1, true);
				return 1;
			} else {
				int leftd = printNodeAtK(root.left, start, k, false);
				int rightd = printNodeAtK(root.right, start, k, false);
				if (leftd == k || rightd == k) {
					System.out.println(root.value);
				}
				if (leftd != -1 && leftd > rightd) {
					return leftd + 1;
				} else if (rightd != -1 && rightd > leftd) {
					return rightd + 1;
				} else {
					return -1;
				}
			}

		}
		return -1;
	}
}
