package tree;
/*
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 * 
 */
public class Verify_BinaryTree_Is_BST {
	
	public static void main(String[] args)
	{
		
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		//bst.right.left = new TreeNode<Integer>(7);//test a false case
		bst.right.right = new TreeNode<Integer>(7);
		
		System.out.println("My tree is BST? "+IfBST(bst, Integer.MIN_VALUE, Integer.MAX_VALUE));
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
	
	/*
	 * Notice, the key of our algorithm is to keep track of the reasonable range for current focus node and its sub-trees
	 * So we need small and large as two range index values
	 */
	public static boolean IfBST(TreeNode<Integer> tree, int small, int large)
	{
		//firstly, check if Tree is a valid tree node or null
		if(tree == null)
			return true;//if no elements we return true
		//now check if the current tree node is within (small, large)
		if(tree.value > small && tree.value < large){
			//The following code could be simplified!
			return IfBST(tree.left, small, tree.value)&&IfBST(tree.right, tree.value, large);
		}
		else
			return false;//as the current node finds inappropriate node, return false immediately
	}
}
