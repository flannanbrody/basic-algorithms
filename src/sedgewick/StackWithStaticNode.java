package sedgewick;

/*************************************************************************
 *  Compilation:  javac StackWithStaticNode.java
 *  Execution:    java StackWithStaticNode < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item. This version uses a static nested class Node.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java StackWithStaticNode < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The <tt>StackWithStaticNode</tt> class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  All stack operations except iteration are constant time.
 *  <p>
 *  For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class StackWithStaticNode<Item> implements Iterable<Item> {
    private int N;                // size of the stack
    private Node<Item> first;     // top of stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

   /**
     * Create an empty stack.
     */
    public StackWithStaticNode() {
        first = null;
        N = 0;
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
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
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
       

   /**
     * Return an iterator to the stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator()  { return new ListIterator<Item>(first);  }

    // an iterator, doesn't implement remove() since it's optional
    private static class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


   /**
     * A test client.
     */
    
    public static void main(String[] args) {
    	StackWithStaticNode<String> s = new StackWithStaticNode<String>();
        String[] a = {"S", "O", "R", "T", "-", "E", "X", "-", "A", "M", "P", "-", "L", "E"};
        for(int i = 0; i < a.length; i++) {
            String item = a[i];
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) System.out.print(s.pop() + " ");
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}

