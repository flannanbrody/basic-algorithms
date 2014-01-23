package linkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
 * Using circular doublylinkedList...instead of dummy values for head and tail...
 * so dont' get nullpointerErrors.
 */
public class DoublyLinkedList<Item> implements Iterable<Item> {
	private int N; // number of elements in bag
	Node first; // beginning of SinglyLinkedList
	Node last; // end of SinglyLinkedList

	// helper linked list class
	public class Node {
		Item item;
		Node next;
		Node previous;

		public Node() {
		}

		public Node(Item item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
			first.next = last;
			last.previous = first;
		}
	}

	public DoublyLinkedList() {
		first = new Node();
		last = new Node();
		N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Node getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException {
		if (nodePos > N || nodePos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node x = first;
		for (int numberOfNodes = 1; numberOfNodes < nodePos; x = x.next) {
			numberOfNodes++;
		}
		return x;
	}

	public Node getFirst() {
		return getNodeAt(0);
	}

	public Node getLast() {
		return getNodeAt(N);
	}

	public void insertAtFirst(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.previous = last;
		oldfirst.previous = first;
		N++;
	}

	public void insertAtLast(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = first;
		last.previous = oldlast;
		oldlast.next = last;
		N++;
	}

	public void insertAt(int position, Item item) {
		if (position == 0) {
			insertAtFirst(item);
		} else if (position == N - 1) {
			insertAtLast(item);
		} else {
			Node tempNode = (Node) getNodeAt(position - 1);
			Node newNode = new Node();
			newNode.item = item;
			newNode.next = tempNode.next;
			newNode.previous = tempNode;
			tempNode.next = newNode;
			tempNode.next.previous = newNode;
			N++;
		}
	}

	public Item removeAtFirst() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Item item = first.item;
		first = first.next;
		first.previous = null;
		N--;
		if (isEmpty())
			last = null; // to avoid loitering
		return item;
	}

	public Item removeAtLast() {
		if (isEmpty())
			throw new NoSuchElementException("SinglyLinkedList underflow");
		Node newLast = getNodeAt(N - 1);
		Item item = newLast.next.item;
		newLast.next = null;

		N--;
		return item;
	}

	public Item removeAt(int position) {
		if (position == 0) {
			return removeAtFirst();
		} else if (position == N - 1) {
			return removeAtLast();
		} else {
			Node tempNode = getNodeAt(position - 1);
			Item item = tempNode.next.item;
			tempNode.next = tempNode.next.next;
			tempNode.next.next.previous = tempNode;
			N--;
			return item;
		}
	}

	public Node reverse(Node first) {
		if (first == null || first.next == null) {
			return first;
		}
		Node nextItem = first.next;
		first.next = null;
		Node reverseTheRest = reverse(nextItem);
		nextItem.next = first;
		return reverseTheRest;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	public ListIterator<Item> iterator() {
		return new DoublyLinkedListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class DoublyLinkedListIterator implements ListIterator<Item> {
		private Node current = first;
		private Node lastAccessed = null; // the last node to be returned by
		// prev() or next()
		// reset to null upon intervening
		// remove() or add()

		private int index = 0;

		public boolean hasNext() {
			return index < N;
		}

		public boolean hasPrevious() {
			return index > 0;
		}

		public int previousIndex() {
			return index - 1;
		}

		public int nextIndex() {
			return index;
		}

		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastAccessed = current;
			Item item = current.item;
			current = current.next;
			index++;
			return item;	
		}

		public Item previous() {
			if (!hasPrevious()){
				throw new NoSuchElementException();
			}
			current = current.previous;
			index--;
			lastAccessed = current;
			return current.item;
		}

		@Override
		public void set(Item item) {
			if (lastAccessed == null)
				throw new IllegalStateException();
			lastAccessed.item = item;	
		}
		
		public void remove() {
			if (lastAccessed == null)
				throw new IllegalStateException();
			Node x = lastAccessed.previous;
			Node y = lastAccessed.next;
			x.next = y;
			y.previous = x;
			N--;
			if (current == lastAccessed)
				current = y;
			else
				index--;
			lastAccessed = null;
		}

		@Override
		public void add(Item item) {
			Node x = current.previous;
			Node y = new Node();
			Node z = current;
			y.item = item;
			x.next = y;
			y.next = z;
			z.previous = y;
			y.previous = x;
			N++;
			index++;
			lastAccessed = null;
		}
	}

	public static void main(String[] args) {
		// add elements 1, ..., N
		System.out.println(10 + " random integers between 0 and 99");
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtFirst(i);
		System.out.println(list);
		System.out.println();

		ListIterator<Integer> iterator = list.iterator();

		// go forwards with next() and set()
		System.out.println("add 1 to each element via next() and set()");
		while (iterator.hasNext()) {
			int x = iterator.next();
			iterator.set(x + 1);
		}
		System.out.println(list);
		System.out.println();

		// go backwards with previous() and set()
		System.out
				.println("multiply each element by 3 via previous() and set()");
		while (iterator.hasPrevious()) {
			int x = iterator.previous();
			iterator.set(x + x + x);
		}
		System.out.println(list);
		System.out.println();

		// remove all elements that are multiples of 4 via next() and remove()
		System.out
				.println("remove elements that are a multiple of 4 via next() and remove()");
		while (iterator.hasNext()) {
			int x = iterator.next();
			if (x % 4 == 0)
				iterator.remove();
		}
		System.out.println(list);
		System.out.println();

		// remove all even elements via previous() and remove()
		System.out.println("remove elements that are even via previous() and remove()");
		while (iterator.hasPrevious()) {
			int x = iterator.previous();
			if (x % 2 == 0)
				iterator.remove();
		}
		System.out.println(list);
		System.out.println();

		// add elements via next() and add()
		System.out.println("add elements via next() and add()");
		while (iterator.hasNext()) {
			int x = iterator.next();
			iterator.add(x + 1);
		}
		System.out.println(list);
		System.out.println();

		// add elements via previous() and add()
		System.out.println("add elements via previous() and add()");
		while (iterator.hasPrevious()) {
			int x = iterator.previous();
			iterator.add(x * 10);
			iterator.previous();
		}
		System.out.println(list);
		System.out.println();
		
		
        int size  = 10;

        DoublyLinkedList<Integer> listReversed = new DoublyLinkedList<Integer>();
        for (int i = 0; i < size; i++)
        	listReversed.insertAtFirst(i);
        
        listReversed.insertAt(4, new Integer(99));
        System.out.println(listReversed);
        
        listReversed.first = list.reverse(listReversed.first);
        System.out.println("ReverseList is : " +listReversed);

	}
}