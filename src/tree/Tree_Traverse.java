package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_Traverse {
	/*
	 * 	 		 F
	 *         /   \
	 *       B		 G
	 *      / \       \
	 *     A   D       I
	 *        /	\     /
	 *     	 C	 E   H
	 * 
	 */
	public static void main(final String[] args) {
	
		TreeNode<String> bst = new TreeNode<>("F");
		bst.left = new TreeNode<String>("B");
		bst.right = new TreeNode<String>("G");
		bst.left.left = new TreeNode<String>("A");
		bst.left.right = new TreeNode<String>("D");
		bst.left.right.left = new TreeNode<String>("C");
		bst.left.right.right = new TreeNode<String>("E");
		bst.right.right = new TreeNode<String>("I");
		bst.right.right.left = new TreeNode<String>("H");

		bst.preOrder();
		System.out.println("preorder : ");
		bst.inOrder();
		System.out.println("inorder :");
		bst.postOrder();
		System.out.println("postorder :");
		bst.levelOrder();
		System.out.println("levelorder :");
		
		mirrorTree(bst);
		bst.levelOrder();
		System.out.println("Mirror levelorder :");
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
			return "TreeNode [value=" + value +  "]";
		}
		
		//Left, Root, Right
		public void inOrder() {
			if (this != null) {
				if (left != null)
					left.inOrder();
				System.out.print(value + ", ");
				if (right != null)
					right.inOrder();
			}
		}

		//Root, Left, Right
		public void preOrder() {
			if (this != null) {
				System.out.print(value + ", ");
				if (left != null)
					left.preOrder();
				if (right != null)
					right.preOrder();
			}
		}
		
		//Left, Right, Root
		public void postOrder() {
			if (this != null) {
				if (left != null)
					left.postOrder();
				if (right != null)
					right.postOrder();
				System.out.print(value + ", ");
			}
		}
		
		public void levelOrder() {
			Queue<TreeNode<?>> nodequeue = new LinkedList<>();
			if (this != null)
				nodequeue.add(this);
			while (!nodequeue.isEmpty()) {
				TreeNode<?> next = nodequeue.remove();
				System.out.print(next.value + " ");
				if (next.left != null) {
					nodequeue.add(next.left);
				}
				if (next.right != null) {
					nodequeue.add(next.right);
				}
			}
		}
	}
	
	public static void mirrorTree(TreeNode<String> node){
		if(node==null)return;
		TreeNode<String> temp=node.left;
		node.left=node.right;
		node.right=temp;
		mirrorTree(node.left);
		mirrorTree(node.right);


		}
}