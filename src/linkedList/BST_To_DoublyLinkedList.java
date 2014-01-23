package linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST_To_DoublyLinkedList {

	public BST_To_DoublyLinkedList() {

	}

	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked
	 * list, given only access to that node.
	 */
	public static void main(String[] args) {
		BST_To_DoublyLinkedList d = new BST_To_DoublyLinkedList();
		BST<String, Integer> st = d.new BST<String, Integer>();
		String[] a = { "F", "B", "G", "A", "D", "I", "C", "E", "H" };
		for (int i = 0; i < a.length; i++) {
			String key = a[i];
			st.put(key, i);
		}

		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
		System.out.print("InOrder Traversal: ");
		for (String t1 : st.inOrder()) {
			System.out.print(t1 + " " + st.get(t1));
			doublyLinkedList.insertAtFirst(t1);
		}
		System.out.println();
		System.out.println("DoublyLinkedList output : " + doublyLinkedList.toString());
	}

	public class BST<Key extends Comparable<Key>, Value> {
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

		// return number of key-value pairs in BST
		public int size() {
			return size(root);
		}

		// return number of key-value pairs in BST rooted at x
		private int size(Node x) {
			if (x == null)
				return 0;
			else
				return x.N;
		}

		// return value associated with the given key, or null if no such key
		// exists
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

		/***********************************************************************
		 * Insert key-value pair into BST If key already exists, update with new
		 * value
		 ***********************************************************************/
		public void put(Key key, Value val) {
			if (val == null) {
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

		private Iterable<Key> inOrder(Node x, Queue<Key> keys) {
			if (x != null) {
				inOrder(x.left, keys);
				keys.enqueue(x.key);
				inOrder(x.right, keys);
			}
			return keys;
		}

		public Iterable<Key> inOrder() {
			Queue<Key> keys = new Queue<>();
			return inOrder(root, keys);
		}

	}

	public class Queue<Item> implements Iterable<Item> {
		private int N; // number of elements on queue
		private Node first; // beginning of queue
		private Node last; // end of queue

		// helper linked list class
		private class Node {
			private Item item;
			private Node next;
		}

		/**
		 * Create an empty queue.
		 */
		public Queue() {
			first = null;
			last = null;
			N = 0;
		}

		/**
		 * Is the queue empty?
		 */
		public boolean isEmpty() {
			return first == null;
		}

		/**
		 * Return the number of items in the queue.
		 */
		public int size() {
			return N;
		}

		/**
		 * Add the item to the queue.
		 */
		public void enqueue(Item item) {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			if (isEmpty())
				first = last;
			else
				oldlast.next = last;
			N++;
		}

		/**
		 * Remove and return the item on the queue least recently added.
		 * 
		 * @throws java.util.NoSuchElementException
		 *             if queue is empty.
		 */
		public Item dequeue() {
			if (isEmpty())
				throw new NoSuchElementException("Queue underflow");
			Item item = first.item;
			first = first.next;
			N--;
			if (isEmpty())
				last = null; // to avoid loitering
			return item;
		}

		/**
		 * Return an iterator that iterates over the items on the queue in FIFO
		 * order.
		 */
		public Iterator<Item> iterator() {
			return new ListIterator();
		}

		// an iterator, doesn't implement remove() since it's optional
		private class ListIterator implements Iterator<Item> {
			private Node current = first;

			public boolean hasNext() {
				return current != null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public Item next() {
				if (!hasNext())
					throw new NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			}
		}
	}

}
