package tree;

import java.util.ArrayList;

/*
 * http://rawkam.wordpress.com/2010/03/29/build-tree-from-ancestor-matrix/
 * 
 A binary tree is represented in a array as the ancestor array, build the binary tree from this array. 
 eg 

 1 
 | 
 2----------------	--------------3 
 |	
 ------------------ 
 4	 5 

 The array would be 

 1	2	3	4	5 
 1	x	1	1	1	1 
 2	0	x	0	1	1 
 3	0	0	x	0	0 
 4	0	0	0	x	0 
 5	0	0	0	0	x 

 where if i isAncestor of j, a[i][j] would be set to 1
 */
public class Binary_Tree_From_Ancestor_Matrix {

	public static void main(String[] args) {

		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
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
}
