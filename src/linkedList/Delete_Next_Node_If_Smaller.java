package linkedList;


/*
	 Method 1 (Simple)
		 Use two loops. In the outer loop, pick nodes of the linked list one by one. In the inner loop, check if there exist a node 
		 whose value is greater than the picked node. If there exists a node whose value is greater, then delete the picked node.
		 Time Complexity: O(n^2)
	
	 Method 2 (Use Reverse) 
		 1. Reverse the list.
		 2. Traverse the reversed list. Keep max till now. If next node < max, then delete the next node, otherwise max = next node.
		 3. Reverse the list again to retain the original order.
 */
public class Delete_Next_Node_If_Smaller {
	
	public static void main(String[] args) {
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<Integer>(10, null);
		firstLinkedList.addNodeAtEnd(20);
		firstLinkedList.addNodeAtEnd(30);
		firstLinkedList.addNodeAtEnd(40);
		firstLinkedList.addNodeAtEnd(50);
		firstLinkedList.addNodeAtEnd(60);
		firstLinkedList.addNodeAtEnd(70);
		
		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<Integer>(12, null);
		secondLinkedList.addNodeAtEnd(15);
		secondLinkedList.addNodeAtEnd(14);
		secondLinkedList.addNodeAtEnd(13);
		secondLinkedList.addNodeAtEnd(10);
		secondLinkedList.addNodeAtEnd(11);
		secondLinkedList.addNodeAtEnd(5);
		secondLinkedList.addNodeAtEnd(6);
		secondLinkedList.addNodeAtEnd(2);
		secondLinkedList.addNodeAtEnd(3);
		
		secondLinkedList.print();
		
		LinkedListNode<Integer> newLinkedList = decreasingList(secondLinkedList);
		System.out.println("Decreasing: ");
		newLinkedList.print();
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

	static LinkedListNode<Integer> decreasingList(LinkedListNode<Integer> linkedList) {
		if (linkedList == null) {
			return null;
		}
		LinkedListNode<Integer> rest = decreasingList(linkedList.next);
		if (rest != null && linkedList.value < rest.value) {
			return rest;
		}
		linkedList.next = rest;
		return linkedList;
	}
}
