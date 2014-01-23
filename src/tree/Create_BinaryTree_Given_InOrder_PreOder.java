package tree;

/*
 * 
	Given preorder traversal of a binary search tree, construct the BST.
	
	For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.
	
	     10
	   /   \
	  5     40
	 /  \      \
	1    7      50
	
	Method 1 ( O(n^2) time complexity )
	The first element of preorder traversal is always root. We first construct the root. Then we find the index of first 
	element which is greater than root. Let the index be i. The values between root and i will be part of left subtree, 
	and the values between i+1 and n-1 will be part of right subtree. Divide given pre[] at index i and recur for left 
	and right sub-trees.
	For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element 
	greater than 10, we find 40. So we know the structure of BST is as following.
	
	             10
	           /    \
	          /      \
	  {5, 1, 7}       {40, 50}
	  

 * A naive method is to first construct the tree, then use simple recursive method to print postorder traversal of the 
 * constructed tree.We can print postorder traversal without constructing the tree. The idea is, root is always the first 
 * item in preorder traversal and it must be the last item in postorder traversal. We first recursively print left 
 * subtree, then recursively print right subtree. Finally, print root. To find boundaries of left and right subtrees 
 * in pre[] and in[], we search root in in[], all elements before root in in[] are elements of left subtree and all 
 * elements after root are elements of right subtree. In pre[], all elements after index of root in in[] are elements 
 * of right subtree. And elements before index (including the element at index and excluding the first element) are 
 * elements of left subtree.
 * 
 * Extra Print Postorder traversal from given Inorder and Preorder traversals
 * 
 Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.
	
	Example:
	Input:
	Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
	Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
	
	Output:
	Postorder traversal is {4, 5, 2, 6, 3, 1}
	
	Traversals in the above example represents following tree
	
	         1
	      /     \   
	     2       3
	   /   \      \
	  4     5      6
	
	Solution:
	A naive method is to first construct the tree, then use simple recursive method to print postorder traversal of the constructed tree. 
	We can print postorder traversal without constructing the tree.
	The pre[0] is the root of the tree --> 1
	The in[] represents the tree as:
	
	{ { left-sub-tree } ;  root ;   { right-sub-tree } }
	
	So the index of the root at in[] is the length of the left sub-tree --> 3
	The (in[].length - rootIndex - 1) is the length of the right sub-tree --> 2
	The pre[] represents the tree as:
	
	{ root ;   { left-sub-tree } ;  { right-sub-tree } }
	
	Since we know the lengths of the sub-trees from steps #2 and #3, we can proceed recursively as follows:
	
	leftIn[] = in[ 0 .. (rootIndex-1) ] = { 4, 2, 5 }
	leftPre[] = pre[ 1 .. (rootIndex-2) ] = { 2, 4, 5 }
	
	rightIn[] = in[ (rootIndex+1) .. (length-1) ] = { 3, 6 }
	rightPre[] = pre[ (rootIndex+1) .. (length-1) ] = { 3, 6 }
	
	Recursion ends when the lengths of the in[] and pre[] become equal to 1.
 */
class Create_BinaryTree_Given_InOrder_PreOder 
{
	
	//now create a test case
	public static void main(String[] args)
	{

		/*
		 * 	 		 1
		 *         /   \
		 *       2		 3
		 *        \       \
		 *         4       5
		 * 
		 */

		int[] preOder = {1,2,3,4,5}; //first item in preOrder is always the root item
		int[] inOrder = {2,1,4,3,5}; // 2 ... 1(root) ..... 4, 3, 5 .....base on knowing where the root is from
									 // first item in preOrder....we then know how many items will be before the
									 // root and after the root.
		TreeNode<Integer> myTree = buildTree(preOder, 0, preOder.length-1, inOrder, 0, inOrder.length-1);
		//verify if it is the tree 
		System.out.print("in-order: ");
		myTree.Traversal_InOrder();
		System.out.print("\npre-order: ");
		myTree.Traversal_PreOrder();
	}
	
	static class TreeNode<T> {

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
		
		public void Traversal_InOrder() {
			if (this != null) {
				if (left != null)
					left.Traversal_InOrder();
				System.out.print(value + ",");
				if (right != null)
					right.Traversal_InOrder();
			}
		}

		public void Traversal_PreOrder() {
			if (this != null) {
				System.out.print(value + ",");
				if (left != null)
					left.Traversal_PreOrder();
				if (right != null)
					right.Traversal_PreOrder();
			}
		}
	}

	//now we create the method to construct the binary tree based on preOrder and inOrder traversal
	//notice this is a recursive call by picking root per step and reconstruct the sub trees
	//we need additional support index values to know where the sub tree indexes start and end
	public static TreeNode<Integer> buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
	{
		//firstly check if there is no element or only one element then immediately return
		if(preStart>preEnd)
			return null;
		if(preStart==preEnd)
			return new TreeNode<>(pre[preStart]);
		//otherwise, we use our defined strategy, as the first element in pre-order is the root
		//and we find the value in inorder array to determine how many 'left' elements in there and use
		//that to construct the left sub-tree, same for right-subtree

		int rootIndexInorder = 0;
		for(int i=inStart; i<=inEnd; i++)
		{
			if(in[i]==pre[preStart])//we find the first(root) of preorder array in the in-order array
			{
				rootIndexInorder = i;
				break;
			}
		}

		//now we know how many values in left-subTree
		int leftSubCount = rootIndexInorder - inStart;
		int rightSubCount = inEnd - rootIndexInorder;//same for right sub-tree

		//before that we need build our tree
		TreeNode<Integer> theTree = new TreeNode<>(pre[preStart]);

		//knowing the span we can construct the left sub-tree
		theTree.left = buildTree(pre, preStart+1, preStart+leftSubCount, in, inStart, inStart+leftSubCount-1);
		theTree.right = buildTree(pre, preStart+leftSubCount+1, preEnd, in, inStart+leftSubCount+1, inEnd);

		return theTree;
	}
}
