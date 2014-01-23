package tree;

import java.util.ArrayList;
import java.util.List;
public class Get_All_InOrders_BinaryTrees_From_PreOrder_Array {
	public static void main(String[] args) {
		/*
		 * now we test our code, we know from our slides that {1,2,3} preset has in total 5 different Binary trees thus 
		 * have 5 different in-order ways!
		 
		 					 1				  1				   		 1				       1					1
	         				/		         /                     /   \                    \                    \
	        			   2                2                     2     3                    2                    2
	       				  /                  \                                               /                      \
	      				 3                    3                                             3                        3

               Inorder  { 3, 2, 1}         { 2, 3, 1}            { 2, 1, 3}             { 1, 3, 2}             { 1, 2, 3}

		 */
		int[] preOrder = {1,2,3};
		List<TreeNode<Integer>> allTrees = getAllTrees(preOrder, 0, preOrder.length-1);
		
		for(TreeNode<Integer> binaryTree: allTrees)
			binaryTree.printInOrder();
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
		
		public void printInOrder() {
			inOrderTraversal(this);
			System.out.println();
		}
		private void inOrderTraversal(TreeNode<T> root) {
			if(root==null) return;
			inOrderTraversal(root.left);
			System.out.print(root.value);
			inOrderTraversal(root.right);
		}
	}
	
	/*
	 * Now we come to think about the key method basically we want choose first value as root and split remaining element into two 
	 * however, even those splited elements can form MULTIPLE sub-trees, therefore we need a data structure to store all the 
	 * possible Binary trees
	 * 
	 * start and end index are used to know the focus window in the preorder array!
	 */
	private static List<TreeNode<Integer>> getAllTrees(int[] preorder, int start, int end) {
		//we firstly define a return data structure
		List<TreeNode<Integer>> returnTrees = new ArrayList<>();
		//Base case for recursive method
		if(start > end || start < 0 || end >= preorder.length) {
			returnTrees.add(null);//there can be no trees, return null
			return returnTrees;
		}
		if(start==end) {//only one element
			returnTrees.add(new TreeNode<Integer>(preorder[start]));
			return returnTrees;
		}
		//otherwise,it's the key part, split!
		//notice i starts from -1?! So that means left child can be NULL
		for(int i=-1; i<end-start; i++) {
			//call the recursive part, notice startIndex is incremented by 1, and endIndex for left child is controlled by i
			List<TreeNode<Integer>> leftChildren = getAllTrees(preorder, start+1, start+1+i);
			List<TreeNode<Integer>> rightChildren = getAllTrees(preorder, start+1+i+1, end);//right child is the remaining part!
			//now we have to go through a nested loop to assign each left/right to root!
			for(TreeNode<Integer> eachLeft: leftChildren) {
				for(TreeNode<Integer> eachRight: rightChildren) {
					TreeNode<Integer> tempRoot = new TreeNode<Integer>(preorder[start]);//everytime we make a copy of root
					tempRoot.left = eachLeft;
					tempRoot.right = eachRight;
					//do not forget to add to our return LIST!
					returnTrees.add(tempRoot);
				}
			}
		}
		//and finally do not forget to return the returnTrees list
		return returnTrees;
	}
}
