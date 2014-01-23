package tree;


public class Create_DoublyLinkedList_From_BST_2 {

	public static void main(String[] args) {

		TreeNode<Integer> root = new TreeNode<Integer>(10);
		root.left = new TreeNode<Integer>(9);
		root.right = new TreeNode<Integer>(8);
		root.left.left = new TreeNode<Integer>(7);
		root.left.right = new TreeNode<Integer>(6);
		root.right.left = new TreeNode<Integer>(5);
		root.right.right = new TreeNode<Integer>(4);
		root.left.left.left = new TreeNode<Integer>(3);
		root.left.right.right = new TreeNode<Integer>(2);
		root.right.left.left = new TreeNode<Integer>(1);

		TreeNode<Integer>[] headAndTail = toDoublyLinkedList(root);

		// First element in the array is head of the linked list
		TreeNode<Integer> head = headAndTail[0];
		while (head != null) {
			System.out.println(head.value);
			head = head.right;
		}

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

	private static TreeNode<Integer>[] toDoublyLinkedList(TreeNode<Integer> root) {
		if (null == root) {
			return null;
		}
		TreeNode<Integer>[] currentHeadAndTail = (TreeNode<Integer>[]) new TreeNode[2];
		// Get head and tail of the left subtree
		TreeNode<Integer>[] leftHeadAndTail = toDoublyLinkedList(root.left);
		if (null == leftHeadAndTail) {
			currentHeadAndTail[0] = root;
		} else {
			// Head of left subtree is the left of current node
			root.left = leftHeadAndTail[1];
			root.left.right = root;
			// The new tail is the tail of the left subtree
			currentHeadAndTail[0] = leftHeadAndTail[0];
		}
		// Get head and tail of the left subtree
		TreeNode<Integer>[] rightHeadAndTail = toDoublyLinkedList(root.right);
		if (null == rightHeadAndTail) {
			currentHeadAndTail[1] = root;
		} else {
			// Tail of right subtree is right of current node
			root.right = rightHeadAndTail[0];
			root.right.left = root;
			// The new head is head of the right subtree
			currentHeadAndTail[1] = rightHeadAndTail[1];
		}
		return currentHeadAndTail;
	}

}
