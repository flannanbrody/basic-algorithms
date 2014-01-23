package tree;

import java.util.LinkedList;
import java.util.Queue;


/*
 * Might be a bug
 * 
 *  Non-Symmetrical tree / Symmetrical tree
 * 	 		 4					  1
 *         /   \			   /    \
 *       2		 6		      2      2
 *      / \     / \			/  \    /  \
 *     1   3   5   7	   3    4  4    3  
 * 
 * Means to reverse all the pointers like at the beginning root points to children..
 * The function should reverse pointers such that children point to root... 
 */
public class Is_Tree_Sysmetrical {

	public static void main(String[] args) {

		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		TreeNode<Integer> sysmetricalBst = new TreeNode<Integer>(1);
		sysmetricalBst.left = new TreeNode<Integer>(2);
		sysmetricalBst.right = new TreeNode<Integer>(2);
		sysmetricalBst.left.left = new TreeNode<Integer>(3);
		sysmetricalBst.left.right = new TreeNode<Integer>(4);
		sysmetricalBst.right.left = new TreeNode<Integer>(4);
		sysmetricalBst.right.right = new TreeNode<Integer>(3);
		
		System.out.println("Is tree sysmetrical :" + isSymmetric(bst));
		System.out.println("Is tree sysmetrical :" + isSymmetric(sysmetricalBst));
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

    public static boolean isSymmetric(TreeNode<Integer> root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null || root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        Queue<TreeNode<Integer>> left = new LinkedList<>();
        Queue<TreeNode<Integer>> right= new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode<Integer> leftChild = left.poll();
            TreeNode<Integer> rightChild= right.poll();
            if(leftChild.value == rightChild.value){
                if(leftChild.left == null && rightChild.right != null || leftChild.left != null && rightChild.right == null) return false;
                if(leftChild.right == null && rightChild.left != null || leftChild.right != null && rightChild.left == null) return false;

                if(leftChild.left != null)left.add(leftChild.left);
                if(leftChild.right != null)left.add(leftChild.right);
                if(rightChild.right!=null)right.add(rightChild.right);
                if(rightChild.left!=null)right.add(rightChild.left);
            }else {
                return false;
            }
        }
        if(left.size() + right.size() > 0) return false;
        else return true;
    }
}
