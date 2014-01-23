package tree;


/*
 * Might be a bug
 * 
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 * 
 * Means to reverse all the pointers like at the beginning root points to children..
 * The function should reverse pointers such that children point to root... 
 */
public class Reverse_Tree_Pointers {

	public static void main(String[] args) {

		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		reverseNodePointers(bst, bst);
		// System.out.println("Reversing pointers in BST? "+
		// reverseNodePointers(bst, bst));
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

	private static void reverseNodePointers(TreeNode<Integer> node,
			TreeNode<Integer> parent) {
		if (node == null)
			return;
		TreeNode<Integer> leftNode = node.left; // temp child pointer since the
												// node's pointer will be
												// changed.
		TreeNode<Integer> rightNode = node.right; // temp child pointer since
													// the node's pointer will
													// be changed.
		node.left = parent;
		node.right = parent;
		reverseNodePointers(leftNode, node);
		reverseNodePointers(rightNode, node);
		System.out.println("Node value is " + node.value);
	}
}
