package tree;

/**
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   20
 *     				 \
 *     				  16
 *     
 *     Max : Result [nodes=7, maxBST=7], node 16 isn't part of it
 *     
 * Proposed solution to find the largest Binary Search Tree in a Binary Tree.
 * 
 * Proposed Solution: To find the largest BST in a tree there are different
 * options to traverse the tree: we could take an top-down approach or a
 * bottom-up.
 * 
 * The top-down approach require us to check at each node from the root if the
 * tree starting at that node is a BST. This makes us traverse multiple times
 * the tree to find the bst. Although it stops as soon as it find a BST because
 * it will be the largest. This solution has a time complexity of O(n^2) in
 * worst-case (degenerated tree into list) or O(nLogn) (balanced tree) where n
 * is the number of nodes in the tree.
 * 
 * THIS IS THE IMPLEMENTATION SHOWN BELOW
 * 
 * A better approach will be bottom-up where we check from the bottom of the
 * tree the nodes to check if the trees created are BST. This makes the
 * evaluation of a BST in O(1) for each node, although we still have to traverse
 * the tree completely, so this approach has a time complexity of O(n) (in fact
 * we have to traverse the tree twice because to get to the bottom nodes we must
 * traverse from the root and then again from the bottom to the top).Given the 
 * implementation is recursive, this has a space complexity of O(n).
 * 
 * Assumptions: - A null tree is not a BST. - A one node Tree is a BST (assuming
 * this, any not null tree will have at least one BST). - Although there can be
 * repeated nodes in the tree, the BST will not have repeated nodes (BST
 * definition). - Tree nodes will have non-null integer values. - Although
 * problem says that there are no two same-sized largest BSTs, if there were
 * any, it will return the leftmost one. - There are no "leaf" kind of nodes.
 * Although there are nodes that have left and right children null.
 * 
 */
public class Largest_BST_Inside_Binary_Tree {

	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(20); 
	    bst.right.right.right = new TreeNode<Integer>(16);

		System.out.println("Max : " + find(bst));
	}

	static class TreeNode<T> {

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

	public static Result find(TreeNode<Integer> node) {
		return find(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static Result find(TreeNode<Integer> node, int min, int max) {
		if (node == null){
			return new Result(0, 0);
		}
		boolean isBST = node.value > min && node.value < max;
		Result left = (Result) (isBST ? find(node.left, min, node.value) : find(node.left));
		Result right = (Result) (isBST ? find(node.right, node.value, max) : find(node.right));

		int total = 1 + left.nodes + right.nodes;
		return new Result(isBST ? total : 0, Math.max(total, Math.max(left.maxBST, right.maxBST)));
	}

	private static class Result {
		int nodes;
		int maxBST;

		public Result(int nodes, int maxBST) {
			this.nodes = nodes;
			this.maxBST = maxBST;
		}

		@Override
		public String toString() {
			return "Result [nodes=" + nodes + ", maxBST=" + maxBST + "]";
		}
	}
}
