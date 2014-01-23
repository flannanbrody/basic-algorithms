package tree;


/*
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 *     
 *     Result: Max sum is: 22 (3--> 2--> 4--> 6-->7 = 22)
 */

public class Print_Max_Sum_Path {

	public static void main(String... s) {		
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		//bst.right.right.right = new TreeNode<Integer>(8); //Test does path increase.
		
		System.out.println("Max sum is: " + maxPathSum(bst));
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

	public static class MyInt {

		private int value;

		public MyInt(int value) {
			this.value = value;
		}

	}

	public static int maxPathSum(TreeNode<Integer> root) {
		MyInt maxSum = new MyInt(Integer.MIN_VALUE);
		findMaxSum(root, maxSum);
		return maxSum.value;
	}

	public static int findMaxSum(TreeNode<Integer> root, MyInt maxSum) {
		if (root == null)
			return 0;
		int tempPathMaxSum = 0;
		int left = findMaxSum(root.left, maxSum);
		int right = findMaxSum(root.right, maxSum);
		tempPathMaxSum = Math.max(root.value, Math.max(root.value + left, root.value + right));
		maxSum.value = Math.max(maxSum.value, Math.max(root.value + left + right, tempPathMaxSum));
		return tempPathMaxSum;
	}

}
