package tree;

import java.util.Stack;
/*
 * 	 		 7
 *         /   \
 *       3		 8
 *      / \       \
 *     2   5       9
 *    /   / \		\
 *   1   4   6		 11
 *   				 /
 *   				10
 *   
 *   It prints out this zigzag result...Odd level is left --> right / Even level is right --> left
 *   
 *      7 
 *   	8 3 
 * 		2 5 9 
 * 		11 6 4 1 
 * 		10 
 */
public class Print_ZigZag_Order {
    public static void main(String args[]){
        
		TreeNode<Integer> bst = new TreeNode<Integer>(7);
		bst.left = new TreeNode<Integer>(3);
		bst.right = new TreeNode<Integer>(8);
		bst.left.left = new TreeNode<Integer>(2);
		bst.left.left.left = new TreeNode<Integer>(1);
		bst.left.right = new TreeNode<Integer>(5);
		bst.left.right.right = new TreeNode<Integer>(6);
		bst.left.right.left = new TreeNode<Integer>(4);
		bst.right.right = new TreeNode<Integer>(9);
		bst.right.right.right = new TreeNode<Integer>(11);
		//bst.right.right.right.right = new TreeNode<Integer>(11);
		bst.right.right.right.left = new TreeNode<Integer>(10);
        
        printZigZagOrder(bst, false);
    }
    
	static class TreeNode<T> {

		private T value;
		private TreeNode<T> left;
		private TreeNode<T> right;

		private TreeNode(T value) {
			this.value = value;
		}
	}
    
    public static void printZigZagOrder(TreeNode<Integer> root, boolean leftToRight){
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        Stack<TreeNode<Integer>> s2 = new Stack<>();
        Stack<TreeNode<Integer>> tmp;
        s1.add(root);
        while(!s1.isEmpty()){
            TreeNode<Integer> treeNode = s1.pop();
            System.out.print(treeNode.value + " ");
           
            
            if(!leftToRight){
                if(treeNode.left != null){
                    s2.push(treeNode.left);
                }
                if(treeNode.right != null){
                    s2.push(treeNode.right);
                }
            }else{
                if(treeNode.right != null){
                    s2.push(treeNode.right);
                }
                if(treeNode.left != null){
                    s2.push(treeNode.left);
                }
            }
       
            if(s1.isEmpty()){
                leftToRight = !leftToRight;
                System.out.println();
                tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
        }
    }
}
