package linkedList;


/*
 * 2 approaches
 *   -- two pointer to track is simpler: current->next and fast->next->next
 * 	 -- Using two additional variables to keep track of
 * 		1. The length of linked list
 * 		2. Current index in reveres order (last Nth)
 *   -- Using recursion to process length first then update current index
 *   -- Return when mid index is reached
 */
class Find_Middle_Of_LinkedList {

	public static void main(String[] args) {
		LinkedListNode<Integer> linkedList = new LinkedListNode<Integer>(1, null);
		linkedList.addNodeAtEnd(2);
		linkedList.addNodeAtEnd(3);
		linkedList.addNodeAtEnd(4);
		linkedList.addNodeAtEnd(5);
		linkedList.addNodeAtEnd(6);
		linkedList.addNodeAtEnd(7);
		
		findMiddleOfLinkedListRecursive(linkedList);
		findMiddleOfLinkedListIterative(linkedList);
	}
	
	public static class LinkedListNode<E> {
		public E value;
		public LinkedListNode<E> next;
		
		public LinkedListNode(E value, LinkedListNode<E> next){
			this.value = value;
			this.next = next;
		}
		
		public LinkedListNode(E value){
			this.value = value;
		}
		
		public void addNodeAtEnd(E value) {
			LinkedListNode<E> firstNode = this;
			while (firstNode.next != null){
				firstNode = firstNode.next;
			}
			firstNode.next = new LinkedListNode<E>(value);
		}
		
		public void print(){
			LinkedListNode<E> current = this;
			while(current != null){
				System.out.print(current.value + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	static int myListLength = 0;// this is to keep track of length
	static int currentReverseIndex = 0;// this is to keep track of index in reverse order

	/*
	 * Recursive
	 * notice, this method does not return the value, this is somehow similar as a traversal
	 */
	public static void findMiddleOfLinkedListRecursive(LinkedListNode<Integer> linkedList) {
		// firstly we proceed the length and do the recursion
		if (linkedList != null) {
			myListLength++;
			findMiddleOfLinkedListRecursive(linkedList.next);
			// after recursion, we can update the current index, and if you look at control flow, the next statement won't be first executed until we reach last node
			currentReverseIndex++;
		}
		// now we only need to decide if currentReverseIndex/myListLength=1/2
		if (currentReverseIndex * 2 == myListLength || currentReverseIndex * 2 == myListLength + 1)// myListLength can be even or odd
			System.out.println("Find mid point: " + linkedList.value);
	}
	
	//Iterative
	public static void findMiddleOfLinkedListIterative(LinkedListNode<Integer> linkedList){
		LinkedListNode<Integer> p1 = linkedList;
		LinkedListNode<Integer> p2 = linkedList;
		
		do{
			p1 = p1.next;
			p2 = p2.next.next;
		}while(p2.next != null);
				
		System.out.println("Middle node is " + p1.value);
	}
}
