package linkedList;


/*
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
	(i) Pointer to next node in the main list (we call it next pointer in below code)
	(ii) Pointer to a linked list where this node is head (we call it down pointer in below code).
	All linked lists are sorted. See the following example
	
	   5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
       
       Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also 
       be sorted. For example, for the above input list, output list should be 
       5->7->8->10->19->20->22->28->30->35->40->45->50.

	   The idea is to use Merge() process of merge sort for linked lists. We use merge() to merge lists one by one. We 
	   recursively merge() the current list with already flattened list. The down pointer is used to link nodes of the 
	   flattened list.
 */
public class Flatten_LinkedList {	
	public static void main(String[] args) {		
		Node<Integer> firstNode = new Node<Integer>(5, null, null);
		firstNode.addNodeAtEnd(10);
		firstNode.addNodeAtEnd(19);
		firstNode.addNodeAtEnd(28);
		
		firstNode.addNodeAtDown(7);
		firstNode.down.addNodeAtDown(8);
		firstNode.down.down.addNodeAtDown(30);
		
		firstNode.next.addNodeAtDown(20);

		firstNode.next.next.addNodeAtDown(22);
		firstNode.next.next.down.addNodeAtDown(50);
		
		firstNode.next.next.next.addNodeAtDown(35);
		firstNode.next.next.next.down.addNodeAtDown(40);
		firstNode.next.next.next.down.down.addNodeAtDown(45);
		
		System.out.print("Before flatten : ");
		print(firstNode);
		Node<Integer> result = nonRecursiveFlatten(firstNode);
		System.out.println();
		System.out.print("After flatten : ");
		print(result);
	}
	
	public static class Node<E> {
		public E value;
		public Node<E> next;
		public Node<E> down;
		
		public Node(E value, Node<E> next, Node<E> down){
			this.value = value;
			this.next = next;
			this.down = down;
		}
		
		public Node(){
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
		
		public void addNodeAtDown(E value) {
			Node<E> firstNode = this;
			while (firstNode.down != null){
				firstNode = firstNode.down;
			}
			firstNode.down = new Node<E>(value);
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
	
	public static Node<Integer> nonRecursiveFlatten(Node<Integer> root) {
		Node<Integer> temp = root;
		Node<Integer> result = null;
		while (temp != null) {
			result = merge(temp, result);
			temp = temp.next;
		}
		return result;
	}

	private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
		Node<Integer> head = new Node<Integer>();
		Node<Integer> temp = head;
		while (a != null) {
				temp.down = a;
				temp = temp.down;
				a = a.down;
		}

		temp.down = (a == null) ? b : a;
		return head.down;
	}

	public static void print(Node<Integer> start) {
		while (start != null) {
			System.out.print(" " + start.value);
			start = start.down;
		}
	}
}