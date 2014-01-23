package tree;
/*
 * 	 		 4			= 4 (Odd)
 *         /   \
 *       2		 6		= 8 (Even)
 *      / \     / \
 *     1   3   5   7	= 16 (Odd)
 *                  \
 *                   8  = 8 (Even)
 *     
 *     (Odd) - (Even) = difference
 *     (16 + 4) - (8 + 8) = 4
 * 
 */

public class Sum_Difference_Between_Odd_Even_Levels {
    
    public static void main(String[] args)
    {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		bst.right.right.right = new TreeNode<Integer>(8);
		
        System.out.println(diffLevels(bst));
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
	
    // Function calculating the difference
    public static int diffLevels(TreeNode<Integer> root)
    {
        if (root == null){
            return 0;
        }
       // Subtracting the value from root and difference from its right and left..
        int left = diffLevels(root.left);
        int right = diffLevels(root.right);
        return root.value - left - right;
    }
}