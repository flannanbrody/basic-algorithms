package tree;


/*
 * 	 		 8
 *         /   \
 *       4		 12
 *      / \     / \
 *     2   6   10   14
 *     		  /       \
 *           9         15
 *                       \
 *                        16
 * 
 */
public class Find_Height_Of_Deepest_Odd_Level_Node{

    public static void main(String[] args){
		TreeNode<Integer> bst = new TreeNode<Integer>(8);
		bst.left = new TreeNode<Integer>(4);
		bst.right = new TreeNode<Integer>(12);
		bst.left.left = new TreeNode<Integer>(2);
		bst.left.right = new TreeNode<Integer>(6);
		bst.right.left = new TreeNode<Integer>(10);
		bst.right.left.left = new TreeNode<Integer>(9);
		bst.right.right = new TreeNode<Integer>(14);
		bst.right.right.right = new TreeNode<Integer>(15);
		bst.right.right.right.right = new TreeNode<Integer>(16);
		
        printTree(bst);
        System.out.println("Height " + maxOddLeafHeight(bst, 1));
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

    private static int maxOddLeafHeight(TreeNode<Integer> node, int height){
        if (node.right == null && node.left == null){
            return height % 2 == 0 ? 0 : height;
        }

        int leftHeight = node.left != null ? maxOddLeafHeight(node.left, height + 1) : 0;
        int rightHeight = node.right != null ? maxOddLeafHeight(node.right, height + 1) : 0;

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    private static void printTree(TreeNode<Integer> node){
        if (node != null){
        	printTree(node.left);
            System.out.print(node.value + " ");
            printTree(node.right);
        }
    }
}