package linkedList;


class Interweave_A_LinkedList{
	/*
	 * Before: 1 2 3 4 5 6 7 
	 * After: 1 7 2 6 3 5 4 
	 */
	public static void main(String[] args){	
		Node<Integer> firstNode = new Node<Integer>(1, null);
		firstNode.addNodeAtEnd(2);
		firstNode.addNodeAtEnd(3);
		firstNode.addNodeAtEnd(4);
		firstNode.addNodeAtEnd(5);
		firstNode.addNodeAtEnd(6);
		firstNode.addNodeAtEnd(7);
		firstNode.print();//expect 1,2,3,4,5,6,7
		interweave(firstNode);
		firstNode.print();//expect 1,7,2,6,3,5,4
	}
	
	public static class Node<E> {
		public E value;
		public Node<E> next;
		
		public Node(E value, Node<E> next){
			this.value = value;
			this.next = next;
		}
		
		public Node(E value){
			this.value = value;
		}
		
		public void addNodeAtEnd(E value) {
			Node<E> firstNode = this;
			while (firstNode.next != null){
				firstNode = firstNode.next;
			}
			firstNode.next = new Node<E>(value);
		}
		
		public void print(){
			Node<E> current = this;
			while(current != null){
				System.out.print(current.value + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	public static void interweave(Node<Integer> linkedList)
	{
		Node<Integer> midNode = findMid(linkedList);
		//now reverse 2nd half
		Node<Integer> secondhalf = reverse(midNode.next);
		Node<Integer> firsthalf = linkedList;
		//do not forget to update mid.next==null
		midNode.next = null;//otherwise we are duplicating L1 and L2
		linkedList = merge(firsthalf, secondhalf);
	}

	//as the key method for interweaving the linked list involves three steps
	//1. find the mid point
	//2. reverse the 2nd half of list
	//3. merge them in place
	//we are going to define all three supporting methods before declaring the main interweave method

	//first method, to find mid point of array in linear time
	//the trick is using two pointers (fast/slow) until fast meets the null
	private static Node<Integer> findMid(Node<Integer> linkedList)
	{
		Node<Integer> fast = linkedList;//two steps per move
		Node<Integer> slow = linkedList;//one step per move
		while(fast!=null && fast.next!=null && slow!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	//2nd support method, to reverse the list
	private static Node<Integer> reverse(Node<Integer> linkedList)
	{
		//firstly judge if null or one-node list
		if(linkedList == null || linkedList.next == null)
			return linkedList;
		//otherwise, do it in a recursive manner
		Node<Integer> nextReverse = reverse(linkedList.next);
		linkedList.next.next = linkedList; //L.next is tail of reversed remaining, thus the next can point to L
		linkedList.next = null;//do not forget update L's next
		return nextReverse;
	}

	//so the 3rd method is to merge two lists into one, by picking one from each other
	private static Node<Integer> merge(Node<Integer> firstHalf, Node<Integer> secondHalf)
	{
		//however, one assumption is that the length of L1>L2, because of our mid algorithm
		Node<Integer> merged = new Node<Integer>(0);//its next is the resulting merged list
		Node<Integer> current = merged;//current points where we are at the time of merging
		int turn = 1;//we define a turn to know which list element to be merged per loop cycle
		while(firstHalf != null && secondHalf != null){
			if(turn == 1)//pick from L1
			{
				current.next = firstHalf;
				firstHalf = firstHalf.next;//update L1's index to right
				turn = 2;//next loop we pick from L2
			}
			else//pick from L2
			{
				current.next = secondHalf;
				secondHalf = secondHalf.next;//update L1's index to right
				turn = 1;//back to L1 next cycle
			}
			current = current.next;//update the current pointer
		}
		//as we said L1's length may be longer than L2 considering size of array
		if(firstHalf!=null)//we merge the remaining L1 to our current.next
			current.next = firstHalf;

		return merged.next;
	}
}
