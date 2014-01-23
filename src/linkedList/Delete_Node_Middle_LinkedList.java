package linkedList;
/*
 * 	Implement an algorithm to delete a node in the middle of a single linked list, given
	only access to that node.
	EXAMPLE
	Input: the node c from the linked list a->b->c->d->e
	Result: nothing is returned, but the new linked list looks like a->b->d->e 
	
	LinkedList is 1 -->2 -->3 -->4 -->5 -->6 -->7 -->null
 */
public class Delete_Node_Middle_LinkedList {

	public static void main(String args[]){
		LinkedListNode<Integer> firstNode = new LinkedListNode<Integer>(1, null);
		firstNode.addNodeAtEnd(2);
		firstNode.addNodeAtEnd(3);
		firstNode.addNodeAtEnd(4);
		firstNode.addNodeAtEnd(5);
		firstNode.addNodeAtEnd(6);
		firstNode.addNodeAtEnd(7);
		
		firstNode.print();
		delete(firstNode.next.next);
		firstNode.print();
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
	
	/*
	 * The solution to this is to simply copy the data from the next node into 
	 * this node and then delete the next node.
	 */
	public static boolean delete(LinkedListNode<Integer> node){
		if(node == null || node.next == null)
			return false;
		LinkedListNode<Integer> next = node.next;
		node.value = next.value;
		node.next = next.next;
		return true;
	}
}
