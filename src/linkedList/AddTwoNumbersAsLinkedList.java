package linkedList;

/*
 * Broken...prints backwards
 * 
 * You have two numbers represented by a linked list, where each node contains a single digit. 
 * The digits are stored in reverse order, such that the 1s digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */
public class AddTwoNumbersAsLinkedList {
	public static void main(String args[]){
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<>(9, null);
		firstLinkedList.addNodeAtEnd(4);
		firstLinkedList.addNodeAtEnd(3);
		
		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<>(9, null);
		secondLinkedList.addNodeAtEnd(3);
		secondLinkedList.addNodeAtEnd(4);
		secondLinkedList.addNodeAtEnd(5);
	
		addTwoLists(firstLinkedList, secondLinkedList).print();
		int i = 5439 + 349;
		System.out.println(i);
	}
	
	public static class LinkedListNode<E> {
		public E value;
		public LinkedListNode<E> next;
		
		public LinkedListNode(E value, LinkedListNode<E> next){
			this.value = value;
			this.next = next;
		}
		
		public LinkedListNode(){
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
		
		public void addFirst(E value){
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
	
	public static LinkedListNode<Integer> addTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){
		LinkedListNode<Integer> h1 = l1;
		LinkedListNode<Integer> h2 = l2;

		LinkedListNode<Integer> result = new LinkedListNode<>();

		
		 while(h1 != null || h2 !=null){
			 if(h1 == null){
				 result.addFirst(h2.value);
				 h2 = h2.next;
			 }else if(h2 == null){
				 result.addFirst(h1.value);
				 h1 = h1.next;
			 }else{
				 int sum = h1.value + h2.value;
				 int digit = sum % 10;
				 int carry = sum / 10;
				 result.addFirst(digit);

				 if(carry > 0){
					 if(h1.next != null)
						 h1.next.value += carry;
					 else if(h2.next != null)
						 h2.next.value += carry;
					 else
						 result.addFirst(carry);
				 }
				 h1 = h1.next;
				 h2 = h2.next;
			 } 
		 }
		
		return result;
	}
}
