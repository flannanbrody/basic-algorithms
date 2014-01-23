package tree;

import java.util.ArrayList;

/*
 * 	 		 7
 *         /   \
 *       3		-8
 *      / \       \
 *    -2   -5       9
 *    /    / \       \
 *   1   -4   6	      11
 *   				 /
 *   			  -10
 *   
 *   Result: 7 --> 3 --> -2
 *   Result: 7 --> -8 --> 9
 *     
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum up to that value. Note that it can be any path in the tree
 * it does not have to start at the root.
 */
 
public class Paths_Sum_Up_To_Value {
	public static void main(String args[]){
		TreeNode<Integer> bst = new TreeNode<Integer>(7);
		bst.left = new TreeNode<Integer>(3);
		bst.right = new TreeNode<Integer>(-8);
		bst.left.left = new TreeNode<Integer>(-2);
		bst.left.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(-5);
		bst.left.right.left = new TreeNode<Integer>(-4);
		bst.left.right.right = new TreeNode<Integer>(6);
		bst.right.right = new TreeNode<Integer>(9);
		bst.right.right.right = new TreeNode<Integer>(-11);
		bst.right.right.right.left = new TreeNode<Integer>(-10);
		
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		findSum(bst, 8, buffer, 0);
	}
	
	static class TreeNode<T> {

		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}
	}

	public static void findSum(TreeNode<Integer> start, int sum, ArrayList<Integer> buffer, int level){
		if(start == null)
			return ;
		int tmp = sum;
		buffer.add((Integer) start.value);
		for(int i = level; i > -1; i--){ 
			tmp -= buffer.get(i);		//as we move down the tree were subtracting the path from the sum, until we reach 0, then print it.	
			if(tmp == 0)
				print(buffer, i, level);
															
		}
		
		ArrayList<Integer> leftBuffer = (ArrayList<Integer>)buffer.clone();
		ArrayList<Integer> rightBuffer = (ArrayList<Integer>)buffer.clone();
		
		findSum(start.left, sum, leftBuffer, level + 1);
		findSum(start.right, sum, rightBuffer, level + 1);
	}
	
	public static void print(ArrayList<Integer> buffer, int startLevel, int endLevel){
		for(int i = startLevel ; i < endLevel ; i++){
			System.out.print(buffer.get(i) + " --> ");
		}
		System.out.print(buffer.get(endLevel));
		System.out.println();
	}
	
}