package extra;

public class Print_Values_The_Sum_Up_To {

	public static void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) {
			return;
		}
		
		/* Insert current node into path */
		path[level] = (int) node.value; 
		
		int t = 0;
		for (int i = level; i >= 0; i--){
			t += path[i];
			if (t == sum) {
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level + 1);
		findSum(node.right, sum, path, level + 1);
		
		/* Remove current node from path. Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
		path[level] = Integer.MIN_VALUE; 
	}
	
	public static int depth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}
	
	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}

	private static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		//root.right.right.right = new TreeNode(11); ....doesn't have too start at root.
		//root.right.right.right.right = new TreeNode(-2);...max path does work for this
		findSum(root, 8);
		
		System.out.println(maxPathSum(root, 0, 0));
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
	
	/* This method finds the max path from root too leaf...doesn't work for negative numbers*/
	public static int maxPathSum(TreeNode root, int sum, int max)
	{
	    if(root == null)
	     return max;
	    int newSum;
	    int newMax;
	    
	    if(sum<0)
	     newSum = (int) root.value;
	    else
	      newSum = (int) root.value + sum;
	    
	    int lMax,rMax;
	    if(newSum > max)
	       newMax = newSum;
	    else
	       newMax = max;
	     
	    lMax = maxPathSum(root.left, newSum, newMax);
	    rMax = maxPathSum(root.right,newSum, newMax);
	  
	    if(lMax > rMax)
	     return lMax;
	    else
	     return rMax;
	          
	}
}

