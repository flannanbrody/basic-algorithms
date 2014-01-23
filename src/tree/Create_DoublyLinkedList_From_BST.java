package tree;

/*
 TreeList main methods:
 -join() -- utility to connect two list nodes
 -append() -- utility to append two lists
 -treeToList() -- the core recursive function


 Method 1 (Simple)
 Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.

 1) Get the Middle of the linked list and make it root.
 2) Recursively do same for left half and right half.
 a) Get the middle of left half and make it left child of the root
 created in step 1.
 b) Get the middle of right half and make it right child of the
 root created in step 1.

 Time complexity: O(nLogn) where n is the number of nodes in Linked List.

 Method 2 (Tricky) 
 The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to 
 insert nodes in BST in the same order as the appear in Linked List, so that the tree can be constructed in O(n) time 
 complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we 
 take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we link the left subtree 
 with root. Finally, we recursively construct the right subtree and link it with root.
 
 While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in 
 each recursive call.Following is java implementation of method 2.
 */
public class Create_DoublyLinkedList_From_BST {

	// Demonstrate tree->list with the list 1..5
	public static void main(String[] args) {
		TreeNode<Integer> bst = new TreeNode<Integer>(4);
		bst.left = new TreeNode<Integer>(2);
		bst.right = new TreeNode<Integer>(6);
		bst.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(3);
		bst.right.left = new TreeNode<Integer>(5);
		bst.right.right = new TreeNode<Integer>(7);

		System.out.println("tree:");
		printTree(bst); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		TreeNode<Integer> head = treeToList(bst);
		printList(head); // 1 2 3 4 5 yay!
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
	
	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a circular doubly linked list which is returned.
	 */
	private static TreeNode<Integer> treeToList(TreeNode<Integer> root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		TreeNode<Integer> aList = treeToList(root.left);
		TreeNode<Integer> bList = treeToList(root.right);

		// Make the single root node into a list length-1 in preparation for the appending
		root.left = root;
		root.right = root;

		// At this point we have three lists, and it's just a matter of appending them together in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}
	
	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static TreeNode<Integer> append(TreeNode<Integer> firstTreeNodeList, TreeNode<Integer> secondTreeNodeList) {
		// if either is null, return the other
		if (firstTreeNodeList == null)
			return (secondTreeNodeList);
		if (secondTreeNodeList == null)
			return (firstTreeNodeList);

		// find the last node in each using the .previous pointer
		TreeNode<Integer> firstTreeNodeLastLink = firstTreeNodeList.left;
		TreeNode<Integer> secondTreeNodeLastLink = secondTreeNodeList.left;

		// join the two together to make it connected and circular
		join(firstTreeNodeLastLink, secondTreeNodeList);
		join(secondTreeNodeLastLink, firstTreeNodeList);

		return (firstTreeNodeList);
	}

	/*
	 * helper function -- given two list nodes, join them together so the second
	 * immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(TreeNode<Integer> treeNode, TreeNode<Integer> successor) {
		treeNode.right = successor;
		successor.left = treeNode;
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	private static void printTree(TreeNode<Integer> root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(Integer.toString(root.value) + " ");
		printTree(root.right);
	}

	// Do a traversal of the list and print it out
	private static void printList(TreeNode<Integer> head) {
		TreeNode<Integer> current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.value) + " ");
			current = current.right;
			if (current == head)
				break;
		}

		System.out.println();
	}
}
