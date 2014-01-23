package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 *     
 *     Result: MaxSum of the Path is : 17....The Path is : 4 -> 6 -> 7 -> null
 */

public class Max_Sum_From_Root_To_Leaf_Path {
	private static int maxSum = -1;
	private static List<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		printRootPathWithMaxSum(bst);
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
	
	public static void printRootPathWithMaxSum(TreeNode<Integer> root) {
		List<Integer> path = new ArrayList<>();
		printRootPathWithMaxSum(root, path);
		System.out.println("MaxSum of the Path is : " + maxSum);
		System.out.println("The Path is : ");
		printPath(result, 0);
	}
	
	private static void printRootPathWithMaxSum(TreeNode<Integer> node, List<Integer> path) {
		if (node != null) {
			path.add(node.value);
		} else {
			return;
		}
		if (node.left == null && node.right == null) {
			int sum = findSumOfPath(path);
			if (sum > maxSum) {
				maxSum = sum;
				result.clear();
				result.addAll(path);
			}
		}
		printRootPathWithMaxSum(node.left, path);
		printRootPathWithMaxSum(node.right, path);
		path.remove(node.value);
	}
	
	private static int findSumOfPath(List<Integer> path) {
		int sum = 0;
		for (int i = 0; i < path.size(); i++) {
			sum += path.get(i);
		}
		return sum;
	}
	
	private static void printPath(List<Integer> path, int start) {
		for (int i = start; i < path.size(); i++) {
			System.out.print(path.get(i) + " -> ");
		}
		System.out.println();
	}
}