package tree;

import java.util.Stack;

class Traversal_InOrder_PreOrder_NoRecursion {
	/*
	 * 	 		 4
	 *         /   \
	 *       2		 6
	 *      / \     / \
	 *     1   3   5   7
	 * 
	 */
	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		System.out.println("In order using recursion: ");
		bst.inOrder();
		System.out.println("\nIn order without recursion: ");
		bst.inOrderNoRecursion();
		System.out.println("\nPreorder using recursion: ");
		bst.preOrder();
		System.out.println("\nPreorder without recursion: ");
		bst.preorderNoRecursion();
		System.out.println("\nPostorder using recursion: ");
		bst.postOrder();
		System.out.println("\nPostorder without recursion: ");
		//bst.postorderNoRecursion();
		bst.postorder2();
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

		public void inOrder() {
			if (this != null) {
				if (left != null)
					left.inOrder();
				System.out.print(value + ", ");
				if (right != null)
					right.inOrder();
			}
		}

		// now implement a non-recursive inorder traversal method
		public void inOrderNoRecursion() {
			// firstly we need a support stack
			Stack<TreeNode<T>> myStack = new Stack<>();
			// now we start processing the tree
			// we also need a current focus to know where we are
			TreeNode<T> current = this;

			// the criteria to decide when we stop the loop is when current
			// points to null and no nodes in stack
			while (current != null || !myStack.isEmpty()) {
				// firstly if current is not null, we push current to stack and
				// shift focus to its left sub-tree
				if (current != null) {
					myStack.push(current);
					current = current.left;
				} else{// we need pop out nodes from the stack and at that time
					   // we shift focus to its right sub-tree
					current = myStack.pop();
					System.out.print(current.value + ", ");// print out as
															// visiting it
					current = current.right;
				}
			}
		}

		public void preOrder() {
			if (this != null) {
				System.out.print(value + ", ");
				if (left != null)
					left.preOrder();
				if (right != null)
					right.preOrder();
			}
		}

		// now to implement the non-recursive preorder method
		public void preorderNoRecursion() {
			// similar as the non-recursive inorder traversal we need a stack
			// and current focus pointer
			Stack<TreeNode<T>> myStack = new Stack<>();
			TreeNode<T> current = this;
			// also we have the same criterial to decide when the loop stops
			while (current != null || !myStack.isEmpty()) {
				// firstly we keep print out each value, store its right
				// sub-tree to stack and shift focus to left sub-tree
				if (current != null) {
					System.out.print(current.value + ", ");
					myStack.push(current.right);
					current = current.left;
				} else{// t==null
					current = myStack.pop();
				}
			}
		}
		
		public void postOrder() {
			if (this != null) {
				if (left != null)
					left.postOrder();
				if (right != null)
					right.postOrder();
				System.out.print(value + ", ");
			}
		}
		
		private void postorder2() {
			Stack<TreeNode<T>> myStack = new Stack<>();
			TreeNode<T> current = this;
			myStack.push(current);

			while (!myStack.isEmpty()) {
				  TreeNode<T> next = myStack.peek();

			    if (next.right == current || next.left == current ||
			        (next.left == null && next.right == null)) {
			    	myStack.pop();
			      System.out.println(next.value);
			      current = next;
			    }
			    else {
			      if (next.right != null) {
			    	  myStack.push(next.right);
			      }
			      if (next.left != null) {
			    	  myStack.push(next.left);
			      }
			    }
			  }
			}
	}
}