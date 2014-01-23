package tree;

/*
 Consider a coding system for alphabets to integers where a is represented as 1, b as 2, .. z as 26. Given an array of 
 digits (1 to 9) as input, write a function that prints all valid interpretations of input array.
	
	Examples
	
	Input: {1, 1}
	Output: ("aa", 'k") 
	[2 interpretations: aa(1, 1), k(11)]
	
	Input: {1, 2, 1}
	Output: ("aba", "au", "la") 
	[3 interpretations: aba(1,2,1), au(1,21), la(12,1)]
	
	Input: {9, 1, 8}
	Output: {"iah", "ir"} 
	[2 interpretations: iah(9,1,8), ir(9,18)]
	Please note we cannot change order of array. That means {1,2,1} cannot become {2,1,1}
	On first look it looks like a problem of permutation/combination. But on closer look you will figure out that this is an 
	interesting tree problem.The idea here is string can take at-most two paths:
	1. Process single digit
	2. Process two digits
	That means we can use binary tree here. Processing with single digit will be left child and two digits will be right child. 
	If value two digits is greater than 26 then our right child will be null as we don???t have alphabet for greater than 26.
	
	Lets understand with an example .Array a = {1,2,1}. Below diagram shows that how our tree grows.
	
	                           {1,2,1}            Codes used in tree
	                       /             \               "a" --> 1
	                      /               \              "b" --> 2 
	                  "a"{2,1}            "l"{1}         "l" --> 12
	                 /        \          /     \
	                /          \        /       \
	            "ab"{1}        "au"    "la"      null
	             /    \
	            /      \
	         "aba"      null
	Braces {} contain array still pending for processing. Note that with every level, our array size decreases. If you will see 
	carefully, it is not hard to find that tree height is always n (array size)
	How to print all strings (interpretations)? Output strings are leaf node of tree. i.e for {1,2,1}, output is {aba au la}....all the leafs
	We can conclude that there are mainly two steps to print all interpretations of given integer array.
	
	Step 1: Create a binary tree with all possible interpretations in leaf nodes.
	
	Step 2: Print all leaf nodes from the binary tree created in step 1.
	
	Following is Java implementation of above algorithm.
 */
import java.util.Arrays;

public class Int_Array_To_All_String_Interpretations_Of_Digits {

	private static final String[] alphabet = { "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "v", "z" };

	public static void main(String args[]) {

		// aacd(1,1,3,4) amd(1,13,4) kcd(11,3,4)
		// Note : 1,1,34 is not valid as we don't have values corresponding
		// to 34 in alphabet
		int[] inputArray = { 1, 1, 3, 4 };
		printAllInterpretations(inputArray);

		// aaa(1,1,1) ak(1,11) ka(11,1)
		int[] inputArray2 = { 1, 1, 1 };
		printAllInterpretations(inputArray2);

		// bf(2,6) z(26)
		int[] inputArray3 = { 2, 6 };
		printAllInterpretations(inputArray3);

		// ab(1,2), l(12)
		int[] inputArray4 = { 1, 2 };
		printAllInterpretations(inputArray4);

		// a(1,0} j(10)
		int[] inputArray5 = { 1, 0 };
		printAllInterpretations(inputArray5);

		// "" empty string output as array is empty
		int[] inputArray6 = {};
		printAllInterpretations(inputArray6);

		// abba abu ava lba lu
		int[] inputArray7 = { 1, 2, 2, 1 };
		printAllInterpretations(inputArray7);
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
	
	// The main function that prints all interpretations of array
	private static void printAllInterpretations(int[] arr) {

		// Step 1: Create Tree
		TreeNode<String> root = createTree(0, "", arr);

		// Step 2: Print Leaf nodes
		printleaf(root);

		System.out.println(); // Print new line
	}

	// Method to create a binary tree which stores all interpretations
	// of arr[] in lead nodes
	private static TreeNode<String> createTree(int data, String s, int[] arr) {

		// Invalid input as alphabets maps from 1 to 26
		if (data > 26)
			return null;

		// Parent String + String for this node
		String dataToStr = s + alphabet[data];
		TreeNode<String> root = new TreeNode<String>(dataToStr);

		// if arr.length is 0 means we are done
		if (arr.length != 0) {
			data = arr[0];

			// new array will be from index 1 to end as we are consuming first index with this node
			int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);

			// left child
			root.left = createTree(data, dataToStr, newArr);

			// right child will be null if size of array is 0 or 1
			if (arr.length > 1) {
				data = arr[0] * 10 + arr[1];

				// new array will be from index 2 to end as we are consuming first two index with this node
				newArr = Arrays.copyOfRange(arr, 2, arr.length);
				root.right = createTree(data, dataToStr, newArr);
			}
		}
		return root;
	}

	// To print out leaf nodes
	private static void printleaf(TreeNode<String> root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.print(root.value + "  ");

		printleaf(root.left);
		printleaf(root.right);
	}
}