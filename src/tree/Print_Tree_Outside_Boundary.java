package tree;


/*
 * Print outside boundary 4->2->1->3->5->8->7->6
 * 
 * 	 		 4
 *         /   \
 *       2		 6
 *      / \     / \
 *     1   3   5   7
 *     			  /
 *     			 8
 * 
 */

public class Print_Tree_Outside_Boundary {
	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);
		bst.right.right.left = new TreeNode<Integer>(8);
		
		System.out.println("Tree boundary is: ");
		getBoundaryTraversal(bst);
		System.out.println();
		System.out.println("Left and Right boundary only is: ");
		getLeftRightBoundaryOnly(bst);
	}

	private static class TreeNode<T> {

		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}
	}

	public static void getBoundaryTraversal(TreeNode<Integer> t) {
		System.out.print(t.value);
		traverseLeftBoundary(t.left);
		traverseLeafs(t);
		traverseRightBoundary(t.right);
	}
	
	public static void getLeftRightBoundaryOnly(TreeNode<Integer> t){
		System.out.print(t.value);
		traverseLeftBoundaryOnly(t.left);
		traverseRightBoundaryOnly(t.right);
	}

	public static void traverseLeafs(TreeNode<Integer> t) {
		if (t == null) {
			return;
		}
		if (t.left == null && t.right == null) {
			System.out.print("--> " + t.value);
			return;
		}
		traverseLeafs(t.left);
		traverseLeafs(t.right);
	}

	public static void traverseLeftBoundary(TreeNode<Integer> t) {
		if (t != null) {
			if (t.left != null) {
				System.out.print("--> " + t.value);
				traverseLeftBoundary(t.left);
			} else if (t.right != null) {
				System.out.print("--> " + t.value);
				traverseLeftBoundary(t.right);
			}
		}
	}

	public static void traverseRightBoundary(TreeNode<Integer> t) {
		if (t != null) {
			if (t.right != null) {
				traverseRightBoundary(t.right);
				System.out.print("--> " + t.value);
			} else if (t.left != null) {
				System.out.print("--> " + t.value);
				traverseRightBoundary(t.left);
			}
		}
	}
	
	//Outside boundary only
	public static void traverseLeftBoundaryOnly(TreeNode<Integer> t) {
		if (t != null) {
			if (t.left != null) {
				System.out.print("--> " + t.value);
				traverseLeftBoundaryOnly(t.left);
			} else if (t.right != null) {
				System.out.print("--> " + t.value);
				traverseLeftBoundaryOnly(t.right);
			}else if (t.left == null && t.right == null) {
				System.out.print("--> " + t.value);
				return;
			}
		}
	}

	public static void traverseRightBoundaryOnly(TreeNode<Integer> t) {
		if (t != null) {
			if (t.right != null) {
				System.out.print("--> " + t.value);
				traverseRightBoundaryOnly(t.right);
			} else if (t.left != null) {
				System.out.print("--> " + t.value);
				traverseRightBoundaryOnly(t.left);
			}else if (t.left == null && t.right == null) {
				System.out.print("--> " + t.value);
				return;
			}
		}
	}
}