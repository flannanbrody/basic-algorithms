package tree;

/*
 * Write a function to detect if two trees are isomorphic. Two trees are called isomorphic if one of them 
 * can be obtained from other by a series of flips, i.e. by swapping left and right children of a number 
 * of nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.

 			1					1
          /   \				  /   \
        2		3            3     2
       / \     / 			  \   /  \
      4   5   6   			   6 4    5 
  		 / \						 / \
		7   8						8   7

 For example, following two trees are isomorphic with following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
 ISomorphicTrees

 We simultaneously traverse both trees. Let the current internal nodes of two trees being traversed be n1 and n2 
 respectively. There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
 1) Data of n1 and n2 is same.
 2) One of the following two is true for children of n1 and n2
 ……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2.
 ……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.
 */
public class AreTwoTreesIsomorphic {

	public static void main(String[] args) {

		TreeNode<Integer> bst = new TreeNode<Integer>(1);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(3);
		bst.left.left = new TreeNode<Integer>(4);
		bst.left.right = new TreeNode<Integer>(5);
		bst.right.left = new TreeNode<Integer>(6);
		bst.left.right.left = new TreeNode<Integer>(7);
		bst.left.right.right = new TreeNode<Integer>(8);

		TreeNode<Integer> anotherBst = new TreeNode<Integer>(1);
		anotherBst.left = new TreeNode<Integer>(3);
		anotherBst.right = new TreeNode<Integer>(2);
		anotherBst.right.left = new TreeNode<Integer>(4);
		anotherBst.right.right = new TreeNode<Integer>(5);
		anotherBst.right.right.left = new TreeNode<Integer>(8);
		anotherBst.right.right.right = new TreeNode<Integer>(7);

		if (isIsomorphic(bst, anotherBst) == true)
			System.out.println("Yes");
		else
			System.out.println("Yes");
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

	/* Given a binary tree, print its nodes in reverse level order */
	private static boolean isIsomorphic(TreeNode<Integer> n1,
			TreeNode<Integer> n2) {
		// Both roots are NULL, trees isomorphic by definition
		if (n1 == null && n2 == null)
			return true;

		// Exactly one of the n1 and n2 is NULL, trees not isomorphic
		if (n1 == null || n2 == null)
			return false;

		if (n1.value != n2.value)
			return false;

		// There are two possible cases for n1 and n2 to be isomorphic
		// Case 1: The subtrees rooted at these nodes have NOT been "Flipped".
		// Both of these subtrees have to be isomorphic, hence the &&
		// Case 2: The subtrees rooted at these nodes have been "Flipped"
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right,
				n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right,
						n2.left));
	}
}
