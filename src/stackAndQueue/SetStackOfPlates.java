package stackAndQueue;

import java.util.ArrayList;
/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack 
 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks, and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
 * behave identically to a single stack (that is, pop() should return the same values as 
 * it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific
 * sub-stack.  
 */
public class SetStackOfPlates {
	ArrayList<DoubleLinkedStack> stacks = new ArrayList<DoubleLinkedStack>();
	
	public static void main(String args[]){
		SetStackOfPlates ss = new SetStackOfPlates();
		for(int i = 0; i <66; i++){
			ss.push(i);
		}
		ss.printAll();
		ss.popAt(6);
		ss.printAll();
		ss.popAt(3);
		ss.printAll();
		ss.pop();
		ss.printAll();
		
	}

	
	public void push(int v){
		DoubleLinkedStack stack = getLastStack();
		if(stack != null && !stack.isAtCapacity()){
			stack.push(v);
		}
			
		else{
			stack = new DoubleLinkedStack(10);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop(){
		DoubleLinkedStack stack = getLastStack();
		int result = stack.pop();
		if(stack.isEmpty())
			stacks.remove(stacks.size() - 1);
		return result;
	}
	
	public DoubleLinkedStack getLastStack(){
		if(stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public int popAt(int index){
		return leftShift(index, true);
	}
	/*
	 * recusion   
	 */
	public int leftShift(int index,  boolean removeTop){
		DoubleLinkedStack stack = stacks.get(index);
		
		int removed_item;
		if(removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		
		if(stack.isEmpty())
			stacks.remove(index);
		else if (stacks.size() > index + 1){
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
	public void printAll(){
		int i;
		for(i = 0; i < stacks.size(); i++)
			stacks.get(i).print();
		System.out.println();
	}
	
	public class DoubleLinkedStack {
		
		class Node{
			int value;
			Node below, above;
			public Node(int v){
				value = v;
				below = null;
				above = null;
			}
		}
		
		private int capacity;
		public int size = 0;
		public Node top, bottom;
		
		public DoubleLinkedStack(int capacity){
			this.capacity = capacity;
		}
		
		public boolean isAtCapacity(){
			return size == capacity;
		}
		
		public void join(Node above, Node below){
			if(above != null)
				above.below = below;
			if(below != null)
				below.above = above;
		}
		
		public boolean push(int v){
			if(size >= capacity)
				return false;
			size++;
			Node n = new Node(v);
			
			if(size == 1){
				bottom = n;
				top = n;
			}else{
				join(n, top);
				top = n;
			}
			return true;
		}
		
		public int peep(){
			return top.value;
		}
		
		public int pop(){
			Node t = top;
			top = top.below;
			if(top !=null)
				top.above = null;
			
			size--;
			return t.value;
		}
		
		public boolean isEmpty(){
			return size == 0;
		}
		
		public int removeBottom(){
			Node b = bottom;
			bottom = bottom.above;
			if(bottom != null)
				bottom.below = null;
			size--;
			return b.value;
		}
		
		public void print(){
			Node tmp = bottom;
			while(tmp != null){
				System.out.printf("%3d", tmp.value);
				tmp = tmp.above;
			}
			System.out.println();
		}
	}

}
