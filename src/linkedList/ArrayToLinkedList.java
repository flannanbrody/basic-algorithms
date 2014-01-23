package linkedList;

import java.util.ArrayList;
import java.util.List;

public class ArrayToLinkedList {

	public static void main(String[] args) {
		// Generate linked list with 19->20->3->70->4->5
		List<Integer> n = new ArrayList<Integer>();
		n.add(19);
		n.add(20);
		n.add(3);
		n.add(70);
		n.add(4);
		n.add(5);
		Node<Integer> formed = generateLinkedList(n);
		formed.print();
		deleteNode(formed.next.next.next);
		formed.print();

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
		
		public void print(){
			Node<E> current = this;
			while(current != null){
				System.out.print(current.value + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	private static Node<Integer> generateLinkedList(List<Integer> n) {
		Node<Integer> end = null;
		for (int i = n.size() - 1; i >= 0; i--) {
			end = new Node<Integer>(n.get(i), end);
		}
		return end;
	}

	private static void deleteNode(Node<Integer> m) {
		m.value = m.next.value;
		m.next = m.next.next;
	}
}
