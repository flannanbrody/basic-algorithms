package tree;
/* 
 * 	 		 8
 *         /   \
 *       4		 12
 *      / \     / \
 *     2   5   10   14
 *    /     \
 *   1       6
 */
public class Find_Common_Ancestor {
    public static void main(String args[]){
		TreeNode<Integer> bst = new TreeNode<Integer>(8);
		bst.left = new TreeNode<Integer>(4);
		bst.right = new TreeNode<Integer>(12);
		bst.left.left = new TreeNode<Integer>(2);
		bst.left.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(5);
		bst.left.right.right = new TreeNode<Integer>(6);
		bst.right.left = new TreeNode<Integer>(10);
		bst.right.right = new TreeNode<Integer>(14);
        
        System.out.println(findCommonAncestor(bst, bst.left.left.left, bst.left.right.right)); //1 and 6's common ancestor is 4
        System.out.println(findCommonAncestor(bst, bst.left.left.left, bst.right.right));      //1 and 14's common ancestor is 8(root)
    }
    
	static class TreeNode<T> {

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
     
    public static TreeNode<Integer> findCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q){
        if(root == null){
            return null;
        }
        if(root.value == p.value || root.value == q.value){
            return root;
        }
        TreeNode<Integer> left = findCommonAncestor(root.left, p, q);
        TreeNode<Integer> right = findCommonAncestor(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }else{
            return left;
        }
    }
}
