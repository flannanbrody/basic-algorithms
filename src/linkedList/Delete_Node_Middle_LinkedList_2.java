package linkedList;

import linkedList.SinglyLinkedList.Node;

public class Delete_Node_Middle_LinkedList_2 {

	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
	 */
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println("Before: " + list);
		
		deleteNode(list.first.next.next.next);
		System.out.println("After: " + list);
	}
	
	public static boolean deleteNode(Node<Integer> n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node<Integer> next = n.next;
		n.item = next.item;
		n.next = next.next;
		return true;
	}

}
