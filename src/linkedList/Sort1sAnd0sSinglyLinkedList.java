package linkedList;


public class Sort1sAnd0sSinglyLinkedList {
	
	/*
	 * UnSorted : 0 1 2 2 1 0 
	 * Sorted :   0 0 1 1 2 2 
	 */
	public static void main(String args[]) {
		LinkedListNode<Integer> linkedList = new LinkedListNode<Integer>(0, null);
		linkedList.addNodeAtEnd(1);
		linkedList.addNodeAtEnd(2);
		linkedList.addNodeAtEnd(2);
		linkedList.addNodeAtEnd(1);
		linkedList.addNodeAtEnd(0);

		System.out.print("UnSorted : ");
		linkedList.print();
		sort(linkedList);
		System.out.println();
		System.out.print("Sorted :   ");
		linkedList.print();
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

	public static void sort(LinkedListNode<Integer> linkedList) {
		LinkedListNode<Integer> one, two, temp;
		for (one = linkedList; one != null; one = one.next) {
			for (two = linkedList; two != null; two = two.next) {
				if (one.value <= two.value) {
					temp = new LinkedListNode<Integer>(one.value);
					one.value = two.value;
					two.value = temp.value;
				}
			}

		}
	}
}