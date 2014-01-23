package tree;

import java.util.LinkedList;
import java.util.Queue;
/*
 *	 	 		 4
 *	           /   \
 *           2		 6
 *          / \     / \
 *         1   3   5   7
 *     	  /	     		 \	
 * 		 0		    	  8
 * 		/			       \
 * 	  -1					    9
 */
public class Print_A_Given_Tree_Level {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.left.left = new TreeNode<Integer>(0);
		bst.left.left.left.left = new TreeNode<Integer>(-1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		bst.right.right.right = new TreeNode<Integer>(8);
		bst.right.right.right.right = new TreeNode<Integer>(9);
		
		//Two different version...queue based and recursion.
		System.out.print("Queue-based method - 3rd Level is ");
		printTreeLevel(bst, 3);//let's try to print 3rd level with index 2 (start level 0)
		
		//Recursive
		System.out.print("\nRecursion method - 3rd Level is ");
		printTreeLevel(bst, 0, 3);//Notice to call this method, we need define an intial currentLevel=0
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

		@Override
		public String toString() {
			return "TreeNode [value=" + value + "]";
		}
	}
	
	//Queue-based method
	public static void printTreeLevel(TreeNode<Integer> tree, int desire)//no need to keep track current level for queue method
	{
		//firstly check if desire level is valid
		if(desire<0) return;
		//now define two queues, one to store tree nodes, the other for current levels
		Queue<TreeNode<Integer>> trees = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<Integer>();
		//start by pushing root node in the queue
		trees.add(tree);
		levels.add(0);//start level is 0
		//now define a loop to continue while the queue is not empty
		while(!trees.isEmpty())
		{
			TreeNode<Integer> temp = trees.poll();//poll method is same as the conceptual deque() method
			int currentLevel = levels.poll();//get the associated level
			if(temp==null){
				;//before proceeding if current tree node is null, stop
			}
			else if(currentLevel==desire)//we find a matched element in the tree
				System.out.print(temp.value+" ");
			else{//need continue to its child tree nodes
				trees.add(temp.left); 				
				trees.add(temp.right);
				
				levels.add(currentLevel+1);
				levels.add(currentLevel+1);
			}
		}
	}
	
	//Recursion
	public static void printTreeLevel(TreeNode<Integer> tree, int currentLevel, int desire)
	{
		//firstly check if currentLevel > desire or the current tree is empty, then return
		if(tree==null || currentLevel>desire)
			return;
		//now check if current==desire
		if(currentLevel==desire){
			System.out.print(tree.value+" ");
	    }else{
			//proceed to its left and right sub-trees
			printTreeLevel(tree.left, currentLevel+1, desire);//do not forget to update the current level
			printTreeLevel(tree.right, currentLevel+1, desire);//
		}
	}
}
