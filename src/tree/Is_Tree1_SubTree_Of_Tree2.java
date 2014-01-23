package tree;
/*
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 * 
 */
public class Is_Tree1_SubTree_Of_Tree2 {
	public static void main(String args[]) {
		
		TreeNode<Integer> bigTree = new TreeNode<Integer>(4);
		bigTree.left = new TreeNode<Integer>(2);
		bigTree.right = new TreeNode<Integer>(6);
		bigTree.left.left = new TreeNode<Integer>(1);
		bigTree.left.right = new TreeNode<Integer>(3);
		bigTree.right.left = new TreeNode<Integer>(5);
		bigTree.right.right = new TreeNode<Integer>(7);
		
		TreeNode<Integer> smallTree = new TreeNode<Integer>(2);
		smallTree.left = new TreeNode<Integer>(1);   //true
		//smallTree.left = new TreeNode<Integer>(6); //false

		System.out.println(contains(bigTree, smallTree));
	}
	
	private static class TreeNode<T> {
		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}
		
	}
    
	public static boolean contains(TreeNode<Integer> bigTree, TreeNode<Integer> smallTree) {
		if (smallTree == null)
			return true; // The empty tree is always a subtree
		return subTree(bigTree, smallTree);
	}

	public static boolean subTree(TreeNode<Integer> bigTree, TreeNode<Integer> smallTree) {
		if (bigTree == null)
			return false; // the big tree is empty
		if (bigTree.value == smallTree.value) { //now we need check if both trees' roots are the same
			if (matchTree(bigTree, smallTree)) //then we need check if both t1 and t2's subtree are same
				return true; //we found one if roots are same are all children trees are same
		}
		return subTree(bigTree.left, smallTree) || subTree(bigTree.right, smallTree);//other wise, we need go to the t1's left or right sub-tree to continue the equality finding
	}

	public static boolean matchTree(TreeNode<Integer> bigTree, TreeNode<Integer> smallTree) {
		if (bigTree == null && smallTree == null)
			return true; // nothing left in the subtree
		if (bigTree == null || smallTree == null)
			return false; // one of the two tree is not empty while the other is empty
		if (bigTree.value != smallTree.value)
			return false;
		return matchTree(bigTree.left, smallTree.left) || matchTree(bigTree.right, smallTree.right); //notice it is OR not AND
	}
}
