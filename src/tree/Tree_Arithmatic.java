package tree;

import java.util.Stack;

/*
 * (12*3) + (4*5) = 56
 * 
 * 	 		 +
 *         /   \
 *       *		 *
 *      / \     / \
 *     12  3   4   5
 * 
 */
public class Tree_Arithmatic {
	static Stack<Integer> values = new Stack<>();
	
	public static void main(String[] args) {
		TreeNode<String> bst = new TreeNode<>("+");
		bst.left = new TreeNode<String>("*");
		bst.right = new TreeNode<String>("*");
		bst.left.left = new TreeNode<String>("12");
		bst.left.right = new TreeNode<String>("3");
		bst.right.left = new TreeNode<String>("4");
		bst.right.right = new TreeNode<String>("5");
		
		compute(bst);
		System.out.println("Result is " + values.pop());// expect 12*3+4*5 = 56
		System.out.println("Result (improved method) is " + computerWithoutstack(bst));
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
	}

	// method 2, top down without stack
	public static int computerWithoutstack(TreeNode<String> tree) {
		if (tree.left == null && tree.left == null) {
			return Integer.parseInt(tree.value);// must be number
		}
		int leftResult = computerWithoutstack(tree.left);
		int rightResult = computerWithoutstack(tree.right);
		return compute(tree.value.charAt(0), leftResult, rightResult);
	}

	// now it's time to run a postorder traversal of tree and compute results
	public static void compute(TreeNode<String> tree) {
		if (tree != null){// make sure it is necessary to go on
			compute(tree.left);
			compute(tree.right);
			// now process this node firstly as we discussed if it is a number, we push to stack
			if (!ifOperator(tree.value)) {
				values.push(Integer.parseInt(tree.value));// parse string to int and push to stack
			}else{// otherwise, pop operands from stack and compute and push back
				int b = values.pop();
				int a = values.pop();// notice the order of operands, stack is LIFO
				char op = tree.value.charAt(0);
				int tempResult = compute(op, a, b);
				values.push(tempResult);
			}
		}
	}

	// 2. define supporting methods the first support method is to judge if a string a number or operator
	private static boolean ifOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	// we also define a compute method to accept opeators and operands
	private static int compute(char op, int a, int b){
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}
		return -1;// usually we do not come here unless invalid input, we ignore error processing
	}
}
