package sedgewick;
/*************************************************************************
 *  Compilation:  javac FixedCapacityStackOfStrings.java
 *  Execution:    java FixedCapacityStackOfStrings
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java FixedCapacityStackOfStrings 5 < tobe.txt 
 *  to be not that or be
 *
 *  Remark:  bare-bones implementation. Does not do repeated
 *  doubling or null out empty array entries to avoid loitering.
 *
 *************************************************************************/

import java.util.Iterator;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
    }

    public boolean isEmpty()            {  return (N == 0);                  }
    public boolean isFull()             {  return (N == a.length);           }
    public void push(String item)       {  a[N++] = item;                    }
    public String pop()                 {  return a[--N];                    }
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<String> {
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public String next()     { return a[i--]; }
        public void remove()      { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt("10");
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        String[] a = {"S", "O", "R", "T", "-", "E", "X", "-", "A", "M", "P", "-", "L", "E"};
        for(int i = 0; i < a.length; i++) {
            String item = a[i];
            if (!item.equals("-")) stack.push(item); 
            else if (stack.isEmpty())  System.out.println("BAD INPUT"); 
            else                       System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // print what's left on the stack
        System.out.println("Left on stack: ");
        for (String s : stack) {
        	System.out.println(s + " ");
        }
        System.out.println();
    } 
} 


