package extra;

import java.util.LinkedList;
import java.util.Queue;

/* 
 Give an ancestor array where a[i][j] = 1 if i is ancestor of j, build the binary tree from the array 

 A non-recursive algorithm implementation in O(n2) 
 */
class Main {
	public static void main(String[] args) throws java.lang.Exception {
		/*
		 * 0 / \ 1 2 / 3 / 4
		 */
		int[][] mtx = { { 0, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };
		Node root = buildBinaryTreeFromAncestor(mtx);
	}

	public static Node buildBinaryTreeFromAncestor(int[][] ancsMtx) {
		// acnCount represents number of ancestors i'th node has.
		int[] acnCount = new int[ancsMtx.length];
		int rootIdx = -1;
		// First count number of 1's for each column. The column having zero 1's
		// is the root node.
		// Later the one's count is used below to identify whether a node is
		// immediate child or not. - O(n2)
		for (int i = 0; i < ancsMtx.length; i++) {
			int colCount = 0;
			for (int j = 0; j < ancsMtx.length; j++) {
				colCount += ancsMtx[j][i];
			}
			acnCount[i] = colCount;
			if (colCount == 0) {
				rootIdx = i;
			}
		}

		// nodes keep a queue of child nodes which are yet to be processed
		Queue<Node> nodes = new LinkedList<Node>();
		Node root = new Node(rootIdx);
		nodes.offer(root);
		// Dummy nodes are added to at the end of processing of each level of
		// nodes
		// While dequeueing if dummy node is found, then we simply increment the
		// current level
		nodes.offer(new DummyNode());
		int curLevel = 1;
		// Iterates through the queue till its empty - While loop will run for
		// max of N times and within each loop its N times - so O(n2)
		while (!nodes.isEmpty()) {
			Node curNode = nodes.poll();
			// If its a dummy node, then just incrment the level and continue
			// with the next iteration of the loop
			if (curNode instanceof DummyNode) {
				curLevel++;
				continue;
			}
			for (int i = 0; i < ancsMtx.length; i++) {
				// For immediate childs, the curNode.data will be ancestor of i,
				// i.e. the matrix [curNode.data][i] should be one
				// and number of ancestors of i'th column node should be equal
				// to current level
				boolean isImmediateChild = ancsMtx[curNode.data][i] == 1
						&& acnCount[i] == curLevel;
				if (isImmediateChild) {
					Node nd = new Node(i);
					nodes.offer(nd);
					// First add the node to left, if its already occupied, add
					// it as right child
					if (curNode.left == null) {
						curNode.left = nd;
					} else {
						curNode.right = nd;
					}
				}
			}
			// We are adding dummy node at the end representing end of a level
			nodes.offer(new DummyNode());
		}
		return root;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return data + "";
	}
}

class DummyNode extends Node {
}
