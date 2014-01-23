package linkedList;


public class Reverse_Linked_List {
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
		reverse(firstNode).print();
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

	/*
		 1 --> 2 --> 3
			reverse 2 --> 3
				reverse 3 
			reverseRemaining = 3   //currrent = remainingReverse…….we find tail of current
			//cur.next = linkedList
			//linkedList.next = null……..important…we only take the first item on linkedList
			current = 3 --> 2
	
		reverseRemaining = 3 --> 2  //currrent = remainingReverse…….we find tail of current
		//currrent.next = linkedList
		//linkedList.next = null….important
		currrent = 3 --> 2 --> 1

	 */
	public static Node<Integer> reverse(Node<Integer> linkedList)
	{
		//1. check if we need reverse or not, in case linkedList is empty or has only 1 element
		if(linkedList == null || linkedList.next == null)
			return linkedList;
		//2. now use the recursive way
		Node<Integer> remainingReverse = reverse(linkedList.next);
		
		//3. we need find the tail of the remainingReverse and update the tail as our beginning element
		Node<Integer> cur = remainingReverse;
		while(cur.next!=null)
			cur = cur.next;
		
		//now cur.next==null and this is the tail position
		cur.next = linkedList;//we assign our beginning element in original List to reversed List tail
		
		//Do not forget update our beginning element L's next to null
		linkedList.next = null;
		
		//Last step, return the reversed List
		return remainingReverse;
	}
}
