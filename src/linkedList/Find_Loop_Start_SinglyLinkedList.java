package linkedList;



/*
 * Given a circular linked list, implement an algorithm which returns node at the 
 * beginning of the loop 
 * DEFINITION 
 * Circular linked list: A (corrupt) linked list in which a node???s next pointer 
 * points to an earlier node, so as to make a loop in the linked list 
 * EXAMPLE
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 */
public class Find_Loop_Start_SinglyLinkedList {

	public static void main(String args[]){
		LinkedListNode<String> firstNode = new LinkedListNode<String>("A", null);
		firstNode.addNodeAtEnd("B");
		firstNode.addNodeAtEnd("C");
		firstNode.addNodeAtEnd("D");
		firstNode.addNodeAtEnd("E");
		firstNode.addNodeAtEnd("F");
		firstNode.addNodeAtEnd("G");
		firstNode.next.next = firstNode; // loop is at third node  after A,B,
		
		findLoopStart(firstNode).print();
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
		
		public void print() {
			if(this==null)
				return;
			//otherwise, we copy the current head reference, iterate the list until we meet the head
			LinkedListNode<E> current = this;
			do{
				System.out.print(current.value+",");
				current = current.next;
			} while(current!=this);
			System.out.println();//add a new line for formatting
		}
	}
	
	public static LinkedListNode<String> findLoopStart(LinkedListNode<String> head){
		LinkedListNode<String> p1 = head;
		LinkedListNode<String> p2 = head;
		
		do{
			p1 = p1.next;
			p2 = p2.next.next;
		}while(p1 != p2);
		
		if(p2 == null)
			return null;
		
		p1 = head;
		
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
}
