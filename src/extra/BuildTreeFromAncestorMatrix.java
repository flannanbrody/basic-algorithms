package extra;

public class BuildTreeFromAncestorMatrix {

	/*
	 * Unsure if this works
	 * 
	 * A binary tree is represented in a array as the ancestor array, build the binary tree from this array.
	eg
			1
			|
		2		3
		|	
	  4	  5

	The array would be
		1	2	3	4	5
	1	x	1	1	1	1
	2	0	x	0	1	1
	3	0	0	x	0	0
	4	0	0	0	x	0
	5	0	0	0	0	x
	where if i isAncestor of j, a[i][j] would be set to 1
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		private TreeNode(TreeNode<T> left, TreeNode<T> right) {
			this.left = left;
			this.right = right;
		}
	}
	
	private static int [] columnCounts = null;
	private static int [] rowCounts = null;

	public static void createTreeFromAncestorMatrix(int [][] mat){
		initializeColumnRowCounts(mat, columnCounts, rowCounts);
		//Steps 
		// 1 : Find out the root first. Root will be the one who is ancestor of all the elements hence the row with all the onces except 1 will be root.
		// This will O(n2)
		int rootIndex = findRootIndex(mat);
		
		// 2 : Once root is found, create the tree recursively.
		TreeNode rootNode = getNode(mat, rootIndex);

		// 4 : Whatever is left is a parent matrix. Create a tree out of it by starting from the root and create nodes. Do it recursively.
	}

	public static void initializeColumnRowCounts(int [][]mat, int [] columnsCount, int[] rowCount){
		columnCounts = new int[mat.length];
		rowCounts = new int[mat.length];
		for(int i = 0; i< mat.length;i++){
			for(int j = 0; j< mat.length;j++){
				if(mat[i][j] ==1){
					rowCounts[i]++;
					columnsCount[j]++;
				}
			}
		}
	}

	/*For one node this will be O(n)
	For all the nodes taken together this will become O(n2)
	*/

	private static TreeNode getNode(int [][]mat, int ancestoryNodeIndex){
		/*Remove indirect children starts*/
		for(int j=0;j<mat.length;j++){
			if(mat[ancestoryNodeIndex][j] == 1 && columnCounts[j] > 1){
					mat[ancestoryNodeIndex][j] = 0;
					columnCounts[j]--;
					rowCounts[ancestoryNodeIndex]--;
			}
		}
		/*Remove indirect children ends*/
		
		/*Find left node and right node*/
		int leftIndex = -1;
		int rightIndex = -1;
		for(int j=0; j < mat.length;j++){
			if(mat[ancestoryNodeIndex][j] ==1) {
				if(leftIndex == -1 ){
					leftIndex = j;
				}else{
					rightIndex = j;
				}
			}
		}
		
		/*Create LeftNode*/
		TreeNode leftChild = null;
		if(leftIndex != -1){
			leftChild = getNode(mat, leftIndex);
		}
		
		/*Create rightNode*/
		TreeNode rightChild = null;
		if(rightIndex != -1){
			leftChild = getNode(mat, rightIndex);
		}
		
		return new TreeNode(leftChild, rightChild);
	}

	private static int findRootIndex(int [][]mat){
		for(int i = 0;i < mat.length; i++){
			int count = 0;
			for(int j = 0; j<mat.length; j++){
				count+= mat[i][j];
			}
			if(count == mat.length-1){
				return i;
			}
		}
		return 0;
	}

}
