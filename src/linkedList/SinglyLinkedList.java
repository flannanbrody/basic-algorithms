package linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements Iterable<E> {
	private int N; // number of elements in bag
	Node<E> first; // beginning of SinglyLinkedList
	Node<E> last; // end of SinglyLinkedList

	// helper linked list class
	public static class Node<T> {
		T item;
		Node<T> next;

		public Node() {
		}

		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}

	public SinglyLinkedList() {
		first = new Node<E>();
		last = new Node<E>();
		N = 0;
		assert check();
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Node<E> getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException {
		if (nodePos > N || nodePos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node<E> x = first;
		for (int numberOfNodes = 1; numberOfNodes < nodePos; x = x.next) {
			numberOfNodes++;
		}
		return x;
	}

	public Node<E> getFirst() {
		return getNodeAt(0);
	}

	public Node<E> getLast() {
		return getNodeAt(N);
	}

	public void insertAtFirst(E item) {
		Node<E> oldfirst = first;
		first = new Node<E>();
		first.item = item;
		first.next = oldfirst;
		N++;
		assert check();
	}

	public void insertAtLast(E item) {
		Node<E> oldlast = last;
		last = new Node<E>();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
		assert check();
	}

	public void insertAt(int position, E item) {
		if (position == 0) {
			insertAtFirst(item);
		} else if (position == N - 1) {
			insertAtLast(item);
		} else {
			Node<E> tempNode = (Node<E>) getNodeAt(position - 1);
			Node<E> newNode = new Node<E>();
			newNode.item = item;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			N++;
		}
	}

	public E removeAtFirst() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E item = first.item;
		first = first.next;
		N--;
		if (isEmpty())
			last = null; // to avoid loitering
		assert check();
		return item;
	}

	public E removeAtLast() {
		if (isEmpty())
			throw new NoSuchElementException("SinglyLinkedList underflow");
		Node<E> newLast = getNodeAt(N - 1);
		System.out.println("newLast " + newLast.item);
		E item = newLast.next.item;
		newLast.next = null;

		N--;
		assert check();
		return item;
	}

	public E removeAt(int position) {
		if (position == 0) {
			return removeAtFirst();
		} else if (position == N - 1) {
			return removeAtLast();
		} else {
			Node<E> tempNode = getNodeAt(position - 1);
			E item = tempNode.next.item;
			tempNode.next = tempNode.next.next;
			N--;
			return item;
		}
	}

	// check internal invariants
	private boolean check() {
		if (N == 0) {
			if (first != null)
				return false;
		} else if (N == 1) {
			if (first == null)
				return false;
			if (first.next != null)
				return false;
		} else {
			if (first.next == null)
				return false;
		}

		// check internal consistency of instance variable N
		int numberOfNodes = 0;
		for (Node<E> x = first; x != null; x = x.next) {
			numberOfNodes++;
		}
		if (numberOfNodes != N)
			return false;

		return true;
	}

	public Node<E> reverse(Node<E> first) {
		if (first == null || first.next == null)
			return first;
		Node<E> nextItem = first.next;
		first.next = null;
		Node<E> reverseTheRest = reverse(nextItem);
		nextItem.next = first;
		return reverseTheRest;
	}
	
	public SinglyLinkedList<E> simpleReverse(SinglyLinkedList<E> linkedList){
		SinglyLinkedList<E> reversedLsit = new SinglyLinkedList<E>();
		Node<E> tmp = linkedList.first;
		while(tmp != null){
			reversedLsit.insertAtFirst(tmp.item);
			tmp = tmp.next;
		}
		
		return reversedLsit;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (E item : this)
			s.append(item + " ");
		return s.toString();
	}

	public boolean hasLoop(Node<E> first) {
		if (first == null) // list does not exist..so no loop either.
			return false;
		Node<E> slow, fast; // create two references.
		slow = fast = first; // make both refer to the start of the list.
		while (true) {
			slow = slow.next; // 1 hop.
			if (fast.next != null){
				fast = fast.next.next; // 2 hops.
			}else{
				return false; // next node null => no loop.
			}
			if (slow == null || fast == null){ // if either hits null..no loop.
				return false;
			}
			if (slow == fast){ // if the two ever meet...we must have a loop.
				return true;
			}
		}
	}

	public Iterator<E> iterator() {
		return new SinglyListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class SinglyListIterator implements Iterator<E> {
		private Node<E> current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println(list);

		System.out.println(" Get a Node at position 5 is "
				+ list.getNodeAt(5).item);

		list.insertAt(5, new Integer(99));
		System.out.println(list);

		System.out.println("Get the first item " + list.getFirst().item);

		System.out.println("Get the last item " + list.getLast().item);

		System.out.println("Remove the first item " + list.removeAtFirst());
		System.out.println(list);

		System.out.println("Remove the last item " + list.removeAtLast());
		System.out.println(list);

		System.out.println("Remove at position 5 " + list.removeAt(6));
		System.out.println(list);

		list.first = list.reverse(list.first);
		System.out.println(list);
		
		System.out.println("Simple reverse method");
		System.out.println(list.simpleReverse(list));
		
		// Check if there's a loop
		System.out.println("Check for a loop " + list.hasLoop(list.getFirst()));
		list.getLast().next = list.getFirst();
		System.out.println("Check for a loop " + list.hasLoop(list.getFirst()));

	}

	public void insertAtLast(SinglyLinkedList<Integer> integerlist) {
		// TODO Auto-generated method stub

	}
}