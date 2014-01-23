package stackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

/*
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in O(1) time.
 * 
 * Two Stacks, the second keeps track of the min's
 */
class StackWithMin{
	
    public static void main(String args[]){
        StackWithMin stack = new StackWithMin();
        stack.push(7);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        
    }
    
    private Stack<Integer> s1, s2;
    
    public StackWithMin(){
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>(); //keeps track of min's
    }
    
    public void push(int data){
        if(s2.empty())
            s2.push(data);
        /*
         * important to use <= instead of <. think about we have duplicates of min elements
         * eg min = 1;
         * if we use <, we will delete the only 1 from s2 when we just delete one 1 from s1.
         * however, the min should still be 1.
         * 
         * if we use <:
         * s1: 22211  
         * s2: 21   
         * we delete a 1, s2 will become : s2 = 2, wrong! 
         */
        else if(data <= s2.peek()){
            s2.push(data);
        }
        
        s1.push(data);
    }
    
    public int pop(){
        if(s1.empty())
            throw new EmptyStackException();
        int result = s1.pop();
        
        if(min() == result)
            s2.pop();
        
        return result;
    }
    
    public int min(){
        if(s2.empty())
            throw new EmptyStackException();
        return s2.peek();
    }
}
