package linkedList;

/*
 * Solution O(n)
 * 1. Scan both lists to find the difference of lengths
 * 2. Skip the first several nodes in either list to make the remaining lists the same length.
 * 3. Scan in the same place and return when same node is found.
 */
class Intersection_Two_LinkedLists {
	
	//let's create a test case
	public static void main(String[] args)
	{
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<Integer>(10, null);
		firstLinkedList.addNodeAtEnd(11);				  //this list is 10>11
		
		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<Integer>(1, null);
		secondLinkedList.addNodeAtEnd(2);
		secondLinkedList.addNodeAtEnd(3);                  //first list starts with 1>2>3
		secondLinkedList.addNodeAtEnd(firstLinkedList);    //this list is 1>2>3>10>11

		LinkedListNode<Integer> thirdLinkedList = new LinkedListNode<Integer>(7);
		thirdLinkedList.addNodeAtEnd(8);                  
		thirdLinkedList.addNodeAtEnd(firstLinkedList);   //so the length is 7>8>10>11


		secondLinkedList.print();
		thirdLinkedList.print();
		System.out.println("Intersection of two lists starts from " + Intersection(secondLinkedList, thirdLinkedList).value);

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
		
		public void addNodeAtEnd(LinkedListNode<E> linkedListNode) {
			LinkedListNode<E> firstNode = this;
			while (firstNode.next != null){
				firstNode = firstNode.next;
			}
			firstNode.next = linkedListNode;
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
	
	public static LinkedListNode<Integer> Intersection(LinkedListNode<Integer> firstLinkedList, LinkedListNode<Integer> secondLinkedList)
	{
		//the first step is to find the diff of lengths of two lists
		int firstLinkedListLength = 0;
		int secondLinkedListLength = 0;
		LinkedListNode<Integer> currentFocus = firstLinkedList;//cur is the pointer used to keep track of current focus node
		while(currentFocus != null)
		{
			firstLinkedListLength++;
			currentFocus = currentFocus.next;
		}
		//after the previous loop, aLength records the length of list a
		currentFocus = secondLinkedList;//we copy the code with slight modification to get length of list b
		while(currentFocus != null)
		{
			secondLinkedListLength++;
			currentFocus = currentFocus.next;
		}
		//all right we get list a and b's lengths, next we do some node skipping if the lengths are not equal
		if(firstLinkedListLength > secondLinkedListLength){//there are more nodes in List a
			for(int i=0; i < firstLinkedListLength - secondLinkedListLength; i++){
				firstLinkedList = firstLinkedList.next;
			}
		}//after this scope of code for cases that list a is longer than b, 
		//we skipped the necessary nodes to make the remaining a and b equal length
		else if(secondLinkedListLength>firstLinkedListLength){//do the same for list b if length b larger than a
			for(int i=0; i < secondLinkedListLength - firstLinkedListLength; i++)
				secondLinkedList = secondLinkedList.next;
		}
		//now we are pretty sure the remaining a and b are equal length 
		//(check our slide example, we will skip the first node in list a
		while(firstLinkedList != secondLinkedList && firstLinkedList != null && secondLinkedList != null)//make sure these two lists are not null
		{
			firstLinkedList = firstLinkedList.next;
			secondLinkedList = secondLinkedList.next;//we keep the same pace by scanning both lists to its next together
		}
		//after that loop, a=b and it is the value we are searching for!
		return firstLinkedList;//the point is where a=b and that's the intersection point!
	}
}


