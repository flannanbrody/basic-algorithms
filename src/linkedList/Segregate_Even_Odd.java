package linkedList;

public class Segregate_Even_Odd {

	/*
	 * Before: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 * After: 2 4 6 8 10 12 14 16 1 3 5 7 9 11 13 15 
	 */
	public static void main(String[] args) {

		LinkedListNode<Integer> linkedList = new LinkedListNode<Integer>(1, null);
		linkedList.addNodeAtEnd(2);
		linkedList.addNodeAtEnd(3);
		linkedList.addNodeAtEnd(4);
		linkedList.addNodeAtEnd(5);
		linkedList.addNodeAtEnd(6);
		linkedList.addNodeAtEnd(7);
		linkedList.addNodeAtEnd(8);
		linkedList.addNodeAtEnd(9);
		linkedList.addNodeAtEnd(10);
		linkedList.addNodeAtEnd(11);
		linkedList.addNodeAtEnd(12);
		linkedList.addNodeAtEnd(13);
		linkedList.addNodeAtEnd(14);
		linkedList.addNodeAtEnd(15);
		linkedList.addNodeAtEnd(16);

		linkedList.print();
		System.out.println();
		segregateEvenOdd(linkedList).print();

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

	public static LinkedListNode<Integer> segregateEvenOdd(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> headEven = null;
		LinkedListNode<Integer> tailEven = null;
		
		LinkedListNode<Integer> headOdd = null;
		LinkedListNode<Integer> tailOdd = null;
		LinkedListNode<Integer> current = head;

		while (current != null) {

			while (current != null && current.value % 2 != 0) {
				if (headOdd == null)
					headOdd = current;
				tailOdd = current;
				current = current.next;
			}

			if (tailEven != null)
				tailEven.next = current;

			while (current != null && current.value % 2 == 0) {
				if (headEven == null)
					headEven = current;
				tailEven = current;
				current = current.next;
			}

			if (tailOdd != null)
				tailOdd.next = current;

		}
		if (headEven != null) {
			tailEven.next = headOdd;
			return headEven;
		} else
			return headOdd;

	}
}
