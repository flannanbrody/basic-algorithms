package sedgewick;

/*************************************************************************
 *  Compilation:  javac LinkedStackOfStrings.java
 *  Execution:    java LinkedStackOfStrings
 *
 *  A stack of strings, implemented using a linked list.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java LinkedStackOfStrings < tobe.txt 
 *  to be not that or be
 *  
 *************************************************************************/

import java.util.NoSuchElementException;

public class LinkedStackOfStrings {
    private int N;          // size of the stack
    private Node first;     // top of stack

    // helper Node class
    private static class Node {
        private String item;
        private Node next;
    }

    // is the stack empty?
    public boolean isEmpty() { return first == null; }

    // number of elements on the stack
    public int size() { return N; }


    // add an element to the stack
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }


    // test client
    public static void main(String[] args) {
        LinkedStackOfStrings s = new LinkedStackOfStrings();
        String[] a = {"S", "O", "R", "T", "-", "E", "X", "A", "M", "P", "L", "E"};
        for(int i = 0; i < a.length; i++) {
            String item = a[i];
            if (!item.equals("-")) s.push(item); 
            else if (s.isEmpty())  System.out.println("BAD INPUT"); 
            else                   System.out.print(s.pop());
        } 
    } 


}
