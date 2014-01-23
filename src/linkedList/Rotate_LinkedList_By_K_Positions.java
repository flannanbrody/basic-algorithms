package linkedList;


class Rotate_LinkedList_By_K_Positions{
	//let's create a test case
	public static void main(String[] args)
	{
		Node<Integer> firstNode = new Node<Integer>(1, null);
		firstNode.addNodeAtEnd(2);
		firstNode.addNodeAtEnd(3);
		firstNode.addNodeAtEnd(4);
		firstNode.addNodeAtEnd(5);
		firstNode.addNodeAtEnd(6);
		firstNode.addNodeAtEnd(7);
		
		firstNode.print();
		
		firstNode = RotateN(firstNode, 2);//let's rotate by 2, thus we expect 3,4,5,1,2
		firstNode.print();//let's verify it!
		firstNode = RotateN(firstNode, 2);//let's rotate by 2, thus we expect 5,1,2,3,4
		firstNode.print();//let's verify it!
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

	public static Node<Integer> RotateN(Node<Integer> linkedList, int k)//linkedList is the original list and k is number of rotates
	{
		//we need some variables to keep track of
		//1. the head of final list, or k+1th node
		//2. we need a current visiting node to keep track of visiting status all the time
		Node<Integer> current = linkedList;//we start from linkedList head
		Node<Integer> newStart;
		//firstly we try to find the tail of kth value
		while(k > 1){//notice we use 1 instead of 0
			current = current.next;
			k--;
		}
		//now the current points to kth value, and the new list's head is its next!
		newStart = current.next;
		//also as the currentNode is the final tail, we need to set its next to null
		current.next = null;
		//next we proceed from the newStart until end (tail of original list) and set the next of tail to linkedList!!!
		current = newStart;//we update our current by one step further
		while(current.next!=null)
			current = current.next;
		//now we come to the tail of original List, current keeps track of it
		current.next = linkedList;//linkedList is the head of original List!
		//finally we return the list starting from newStart
		return newStart;
	}
}

