package tree;

	/* 
	* 	 	   100
	*         /   \
	*       50	  200
	*      / \     / \
	*     10  60  150 300
	* 
	*/
public class Find_Nearest_TreeNode_To_Search_Value {	
	
	public static void main(String[] args)
	{
		TreeNode<Integer> bst = new TreeNode<Integer>(100);
		bst.left = new TreeNode<Integer>(50);
		bst.right = new TreeNode<Integer>(200);
		bst.left.left = new TreeNode<Integer>(10);
		bst.left.right = new TreeNode<Integer>(60);
		bst.right.left = new TreeNode<Integer>(150);
		bst.right.right = new TreeNode<Integer>(300);

		System.out.println("Closest value in BST to 120 is "+ getNearestTreeNode(bst, 120));
		System.out.println("Closest value in BST to 80 is "+ getNearestTreeNode(bst, 80));
		System.out.println("Closest value in BST to 1000 is "+ getNearestTreeNode(bst, 1000));
		System.out.println("Closest value in BST to 0 is "+ getNearestTreeNode(bst, 0));
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

	//final method to declare, after we find the 'min diff' we return diff+searchValue as returned value
	public static int getNearestTreeNode(TreeNode<Integer> tree, int searchValue)
	{
		int minDiff = minDifference(tree, searchValue);
		return minDiff + searchValue;
	}

	//now come to define the key method
	public static int minDifference(TreeNode<Integer> tree, int searchValue)
	{
		//the key of finding 'closest value' is to find the minimal diff
		if(tree == null)//make sure it is not an empty tree
			return Integer.MAX_VALUE;
		//now check the value to determine which sub-direction to search for the 'minimal diff'
		if(tree.value < searchValue)//which means the closest value can only exist in root or some value in its right sub-tree
			return smallDiff(tree.value - searchValue, minDifference(tree.right, searchValue)); //notice we recursively call the method 
		else//can only exist in either root or its left subtree
			return smallDiff(tree.value - searchValue, minDifference(tree.left, searchValue));
	}


	//firstly define a supportive method to determine the smaller difference
	private static int smallDiff(int a, int b)
	{
		if(Math.abs(a)>Math.abs(b))
			return b;
		return a;
	}
}