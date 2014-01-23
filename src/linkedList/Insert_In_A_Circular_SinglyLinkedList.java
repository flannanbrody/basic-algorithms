package linkedList;

public class Insert_In_A_Circular_SinglyLinkedList {
	public static void main(String[] args) {
		LinkedListNode<Integer> circularLinkedList = new LinkedListNode<Integer>(1, null);// expect 1
		circularLinkedList.addNodeAtEnd(3);
		circularLinkedList.addNodeAtEnd(5);
		circularLinkedList.addNodeAtEnd(circularLinkedList);
		circularLinkedList.print(); // so expect list is 1>3>5
		
		insert(circularLinkedList, 2);
		circularLinkedList.print(); // expect 1>2>3>5

		insert(circularLinkedList, 0);
		circularLinkedList.print(); // expect 0>1>2>3>5

		insert(circularLinkedList, 6);
		circularLinkedList.print(); // expect 0>1>2>3>5>6
	}

	public static class LinkedListNode<E> {
		public E value;
		public LinkedListNode<E> next;

		public LinkedListNode(E value, LinkedListNode<E> next) {
			this.value = value;
			this.next = next;
		}

		public LinkedListNode(E value) {
			this.value = value;
		}

		public void addNodeAtEnd(E value) {
			LinkedListNode<E> firstNode = this;
			while (firstNode.next != null) {
				firstNode = firstNode.next;
			}
			firstNode.next = new LinkedListNode<E>(value);
		}

		public void addNodeAtEnd(LinkedListNode<E> linkedListNode) {
			LinkedListNode<E> firstNode = this;
			while (firstNode.next != null) {
				firstNode = firstNode.next;
			}
			firstNode.next = linkedListNode;
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

	//firstly, please notice the return type must be a List type, otherwise for Null case, it cannot successfully create the adding function!
	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> circularLinkedList, int n) {
		//firstly if it is null
		if(circularLinkedList == null) {
			return new LinkedListNode<Integer>(n);
		} else if(circularLinkedList.next == circularLinkedList) { //only one element
			//add this node
			circularLinkedList.next = new LinkedListNode<Integer>(n);
			circularLinkedList.next.next = circularLinkedList;//the next's next reference points back to the head so forms a cycle
			return circularLinkedList.value < n ? circularLinkedList : circularLinkedList.next; //we check value and return the smaller one as head
		} else if(n < circularLinkedList.value) { //if it is the smallest element!
			//find tail and append!
			LinkedListNode<Integer> current = circularLinkedList;
			while(current.next != circularLinkedList)
				current = current.next;
			current.next = new LinkedListNode<Integer>(n);//add it after the tail
			current.next.next = circularLinkedList;//set the appended node's next to original header
			return current.next;//because this is smallest value! And that's another reason we return List other than void
		}
		//otherwise, we either find a position when node.value < n and node.next.value > n or node.next==head (largest)
		LinkedListNode<Integer> current = circularLinkedList;
		while(current.next!=circularLinkedList && current.next.value<=n) {
			current = current.next;
		}
		LinkedListNode<Integer> currentNext = current.next;
		current.next = new LinkedListNode<Integer>(n);
		current.next.next = currentNext;//notice we made a copy of original next and assign it here
		return circularLinkedList;//return header position is unchanged!
	}
}
