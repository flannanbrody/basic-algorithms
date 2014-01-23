package tree;

//Not working properly

public class Remove_All_Nodes_Which_Dont_Sum_To_k {
	
	public static void main(String[] args){

	    int k =45;
	    int sum = 0;
	    
	    BST<Integer, Integer> bst = new BST<>();
	    bst.put(8, 8);
	    bst.put(4, 4);
	    bst.put(13, 13);
	    bst.put(9, 9);
	    bst.put(15, 15);
	    bst.put(14, 14);
	    bst.put(2, 2);
	    bst.put(12, 12);
	    bst.put(5, 5);
	    bst.put(1, 1);
	    bst.put(6, 6);
	    bst.put(3, 3);
	    bst.put(10, 10);
	    bst.put(11, 11);
	    bst.put(7, 7);
/*	    bst.put(1, 1);
	    bst.put(2, 2);
	    bst.put(3, 3);
	    bst.put(4, 4);
	    bst.put(5, 5);
	    bst.put(6, 6);
	    bst.put(7, 7);
	    bst.put(8, 8);
	    bst.put(9, 9);
	    bst.put(10, 10);
	    bst.put(11, 11);
	    bst.put(12, 12);
	    bst.put(13, 13);
	    bst.put(14, 14);
	    bst.put(15, 15);*/

	    System.out.printf("Tree before truncation\n");
	    bst.print(bst.root);
	 
	    bst.root = bst.pruneUtil(bst.root, k, sum); // k is 45
	 
	    System.out.printf("\n\nTree after truncation\n");
	    bst.print(bst.root);	    
	    
	}
	
	public static class BST<Key extends Comparable<Key>, Value> {
		private Node root; // root of BST

		private class Node {
			private Key key; // sorted by key
			private Value val; // associated data
			private Node left, right; // left and right subtrees
			private int N; // number of nodes in subtree

			public Node(Key key, Value val, int N) {
				this.key = key;
				this.val = val;
				this.N = N;
			}
		}
		
		private int size(Node x){
			if(x == null){
				return 0;
			}else{
				return x.N;
			}
		}
		
		public Value get(Key key) {
			return get(root, key);
		}

		private Value get(Node x, Key key) {
			if (x == null)
				return null;
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				return get(x.left, key);
			else if (cmp > 0)
				return get(x.right, key);
			else
				return x.val;
		}
		
		public void put(Key key, Value val) {
			if (val == null) {
				delete(key);
				return;
			}
			root = put(root, key, val);
		}

		private Node put(Node x, Key key, Value val) {
			if (x == null)
				return new Node(key, val, 1);
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x.left = put(x.left, key, val);
			else if (cmp > 0)
				x.right = put(x.right, key, val);
			else
				x.val = val;
			x.N = 1 + size(x.left) + size(x.right);
			return x;
		}
		
		private Node min(Node x){
			if(x.left == null){
				return x;
			}else{
				return min(x.left);
			}
		}
		
		public void deleteMin() {
			root = deleteMin(root);
		}

		private Node deleteMin(Node x) {
			if (x.left == null)
				return x.right;
			x.left = deleteMin(x.left);
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		
		private Node delete(Key key){
			return delete(root, key);
		}

		private Node delete(Node x, Key key) {
			if (x == null)
				return null;
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x.left = delete(x.left, key);
			else if (cmp > 0)
				x.right = delete(x.right, key);
			else {
				if (x.right == null)
					return x.left;
				if (x.left == null)
					return x.right;
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		
		/* Main function which truncates the binary tree. */
		public  Node pruneUtil(Node root, int k, int sum)
		{
		    // Base Case
		    if (root == null)  return null;
		 
		    // Initialize left and right sums as sum from root to
		    // this node (including this node)
		    int value = (Integer) root.val;
		    int lsum = sum + value;
		    int rsum = lsum;
		 
		    // Recursively prune left and right subtrees
		    root.left = pruneUtil(root.left, k, lsum);
		    root.right = pruneUtil(root.right, k, rsum);
		 
		    // Get the maximum of left and right sums
		    sum = Math.max(lsum, rsum);
		 
		    // If maximum is smaller than k, then this node
		    // must be deleted
		    if (sum < k){
		    	System.out.println();
		        System.out.println("the sum is: " + sum);
		        System.out.println("the k is : " + k);
		        System.out.println("root.key is " + root.key);
		        System.out.println();
		        delete(root.key);
		        root = null;
		    }
		 
		    return root;
		}
		
		// print the tree in LVR (Inorder traversal) way.
		public void print(Node root)
		{
		    if (root != null)
		    {
		        print(root.left);
		        System.out.printf("%d ",root.val);
		        print(root.right);
		    }
		}
	}
}
