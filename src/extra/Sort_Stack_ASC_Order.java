package extra;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sort_Stack_ASC_Order {

	static int c = 0;
	public static Stack<Integer> mergesort(Stack<Integer> inStack) {
		if (inStack.size() <= 1) {
			return inStack;
		}

		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (inStack.size() != 0) {
			count++;
			c++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}

		left = mergesort(left);
		right = mergesort(right);

		while (left.size() > 0 || right.size() > 0)
		{
			if (left.size() == 0)
			{
				inStack.push(right.pop());
			}
			else if (right.size() == 0)
			{
				inStack.push(left.pop());
			}
			else if (right.peek().compareTo(left.peek()) <= 0)
			{
				inStack.push(left.pop());
			}
			else
			{
				inStack.push(right.pop());
			}
		}

		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0)
		{
			c++;
			reverseStack.push(inStack.pop());
		}

		return reverseStack;
	}
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
		
	public static void main(String [] args) {
		for (int k = 1; k < 100; k++) {
			c = 0;
			Stack<Integer> s = new Stack<>();
			for (int i = 0; i < 10 * k; i++) {
				int r = AssortedMethods.randomIntInRange(0,  1000);
				s.push(r);
			}
			s = mergesort(s);
			int last = Integer.MAX_VALUE;
			while(!s.isEmpty()) {
				int curr = s.pop();
				if (curr > last) {
					System.out.println("Error: " + last + " " + curr);
				}
				last = curr;
			}
			System.out.println(c);
		}
	}
	
	public static class Stack<Item> implements Iterable<Item> {
	    private int N;          // size of the stack
	    private Node first;     // top of stack

	    // helper linked list class
	    private class Node {
	        private Item item;
	        private Node next;
	    }

	   /**
	     * Create an empty stack.
	     */
	    public Stack() {
	        first = null;
	        N = 0;
	        assert check();
	    }

	   /**
	     * Is the stack empty?
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	   /**
	     * Return the number of items in the stack.
	     */
	    public int size() {
	        return N;
	    }

	   /**
	     * Add the item to the stack.
	     */
	    public void push(Item item) {
	        Node oldfirst = first;
	        first = new Node();
	        first.item = item;
	        first.next = oldfirst;
	        N++;
	        assert check();
	    }

	   /**
	     * Delete and return the item most recently added to the stack.
	     * @throws java.util.NoSuchElementException if stack is empty.
	     */
	    public Item pop() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        Item item = first.item;        // save item to return
	        first = first.next;            // delete first node
	        N--;
	        assert check();
	        return item;                   // return the saved item
	    }


	   /**
	     * Return the item most recently added to the stack.
	     * @throws java.util.NoSuchElementException if stack is empty.
	     */
	    public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return first.item;
	    }

	   /**
	     * Return string representation.
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        for (Item item : this)
	            s.append(item + " ");
	        return s.toString();
	    }
	       

	    // check internal invariants
	    private boolean check() {
	        if (N == 0) {
	            if (first != null) return false;
	        }
	        else if (N == 1) {
	            if (first == null)      return false;
	            if (first.next != null) return false;
	        }
	        else {
	            if (first.next == null) return false;
	        }

	        // check internal consistency of instance variable N
	        int numberOfNodes = 0;
	        for (Node x = first; x != null; x = x.next) {
	            numberOfNodes++;
	        }
	        if (numberOfNodes != N) return false;

	        return true;
	    } 


	   /**
	     * Return an iterator to the stack that iterates through the items in LIFO order.
	     */
	    public Iterator<Item> iterator()  { return new ListIterator();  }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator implements Iterator<Item> {
	        private Node current = first;
	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Item next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Item item = current.item;
	            current = current.next; 
	            return item;
	        }
	    }
	}
}

