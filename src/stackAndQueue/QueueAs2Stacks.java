package stackAndQueue;

import java.util.Stack;
class QueueAs2Stacks 
{
	//We need two stacks to simulate a queue in First in first out manner
	Stack<Integer> S1 = new Stack<Integer>();//generic type is preferred!
	Stack<Integer> S2 = new Stack<Integer>();

	//now let's test our code
	public static void main(String[] args)
	{
		QueueAs2Stacks myQueue = new QueueAs2Stacks();
		myQueue.EnQueue(1);
		myQueue.EnQueue(2);
		myQueue.EnQueue(3);
		System.out.println(myQueue.DeQueue());
		myQueue.EnQueue(4);
		System.out.println(myQueue.DeQueue());
		myQueue.EnQueue(5);
		myQueue.EnQueue(6);
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());
		System.out.println(myQueue.DeQueue());//sorry forgot to include instance variable name
		//we expect all outputs following their incoming order 1,2,3,4,5,6
		System.out.println(myQueue.DeQueue());//we expect to output -1 as invalid
	}

	//now we implement first important method EnQueue
	public void EnQueue(int k)
	{
		//very simple, we accept all incoming values in first stack, keep the First in last out manner (FILO)
		S1.push(k);
	}

	//now they key method of retrieval, Dequeue method
	public int DeQueue()
	{
		//as we said we need dequeue from the 2nd stack, if it is empty, we need dump all values
		//from s1 to s2, thus all elements stored in FILO manner in S1 after reversing becoming FIFO
		if(S2.isEmpty()&&S1.isEmpty())//if no elements at all
			return -1;//let's assume in our case -1 means invalid, but practically this is wrong...
		else if(S2.isEmpty())//this is the key point, we need get all element in S1 and save to s2
		{
			while(!S1.isEmpty())
			{
				S2.push(S1.pop());//after that we should pushing all FILO values into FIFO order
			}
		}
		return S2.pop();
		//we will return S2.pop() anyway if there exist values in both/either array(s)
		//The code could be simplified a little
	}
}

/*

// Implement a MyQueue class which implements a queue using two stacks.
public class CarrerCup3_5 {
	public static void main(String args[]){
		MyQueue queue = new MyQueue();
		for(int i = 0; i < 10; i++)
			queue.add(i);
		
		for(int i = 0; i < 10; i++)
			System.out.println(queue.remove());
	}
}
 
class MyQueue{
	ArrayStack<Integer> s1;
	ArrayStack<Integer> s2;
	
	public MyQueue(){
		s1 = new ArrayStack<Integer>();
		s2 = new ArrayStack<Integer>();
	}
	
	public void add(int item){
		s1.push(item);
	}
	
	public int peep(){
		if(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.peek();
	}
	
	public int remove(){
		if(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		
		return s2.pop();
	}
}
*/

