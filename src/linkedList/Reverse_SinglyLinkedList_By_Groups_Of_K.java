package linkedList;


/*
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

	Example:
	Inputs: 1->2->3->4->5->6->7->8->NULL and k = 3
	Output: 3->2->1->6->5->4->8->7->NULL.
	
	Inputs: 1->2->3->4->5->6->7->8->NULL and k = 5
	Output: 5->4->3->2->1->8->7->6->NULL.
	
	Algorithm: reverse(head, k)
	1) Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. Let the pointer to the next node be next and pointer to the previous node be prev.
	2) head->next = reverse(next, k)  //Recursively call for rest of the list and link the two sub-lists 
	3) return prev  //prev becomes the new head of the list
 *
 */
class Reverse_SinglyLinkedList_By_Groups_Of_K {
	public static void main(String args[]) {
		Node<Integer> firstNode = new Node<Integer>(1, null);
		firstNode.addNodeAtEnd(2);
		firstNode.addNodeAtEnd(3);
		firstNode.addNodeAtEnd(4);
		firstNode.addNodeAtEnd(5);
		firstNode.addNodeAtEnd(6);
		firstNode.addNodeAtEnd(7);
		firstNode.addNodeAtEnd(8);

		firstNode.print();
		firstNode = reverse(firstNode, 3);
		firstNode.print();
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
	 * Recursive Reversal of a group of k elements
	 * 1. Reverse the first sub-list of k element and keep track of next and previous nodes
	 * 2. head.next = reverse(next,k ) - recursively call this function on sub-groups
	 * 3. return prev - prev becomes new next
	 */
	private static Node<Integer> reverse(Node<Integer> node, int k) {
		Node<Integer> current = node;
		Node<Integer> next = node, prev = null;
		int count = 0;
		// reverse first k elements
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		// next is now pointer to k+1th node. Recursively call reverse
		// for the list starting from that point
		if (next != null) {
			node.next = reverse(next, k);
		}
		// prev is the new head
		return prev;
	}
}
