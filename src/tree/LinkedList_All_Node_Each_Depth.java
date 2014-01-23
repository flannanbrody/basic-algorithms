package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

	/*
	 * Given a binary search tree, design an algorithm which creates a linked list of all the
	 * nodes at each depth (e.g, if you have a tree with depth D, you'll have D linked lists).
	 * 
	 * 	 		 4
	 *         /   \
	 *       2		 6
	 *      / \     / \
	 *     1   3   5   7
	 *     
	 *     Result: [[ 4], [ 2,  6], [ 1,  3,  5,  7]]
	 */
	 
	public class LinkedList_All_Node_Each_Depth {
		public static void main(String args[]){
			TreeNode<Integer> bst = new TreeNode<Integer>(4);
			bst.left = new TreeNode<Integer>(2);
			bst.right = new TreeNode<Integer>(6);
			bst.left.left = new TreeNode<Integer>(1);
			bst.left.right = new TreeNode<Integer>(3);
			bst.right.left = new TreeNode<Integer>(5);
			bst.right.right = new TreeNode<Integer>(7);
			
			ArrayList<LinkedList<TreeNode<Integer>>> result = findLevelLinkedList(bst);
			System.out.println(result);
			System.out.println();
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
		
		public static ArrayList<LinkedList<TreeNode<Integer>>> findLevelLinkedList(TreeNode<Integer> root){			
			int level = 0;
			ArrayList<LinkedList<TreeNode<Integer>>> result = new ArrayList<>();
			LinkedList<TreeNode<Integer>> list = new LinkedList<>();
			list.add(root);
			result.add(list);
			
			while(true){
				list = new LinkedList<TreeNode<Integer>>();
				for(int i = 0; i < result.get(level).size(); i++){
					TreeNode<Integer> node = result.get(level).get(i);
					if(node.left != null)
						list.add(node.left);
					if(node.right != null)
						list.add(node.right);
				}
				if(list.size() > 0){
					result.add(list); // or  result.add(level+1, list)
					level++;
				}
				else
					break;
			}
			
			return result;
		}
	}
