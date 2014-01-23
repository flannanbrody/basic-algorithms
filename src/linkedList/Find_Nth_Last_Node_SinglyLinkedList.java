package linkedList;

import linkedList.SinglyLinkedList.Node;
public class Find_Nth_Last_Node_SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println("Before: " + list);
		
		// Implement an algorithm to find the kth to last element of a singlyLinkedList.
		System.out.println(" nthToLast value is " + nthToLast(list.first, 4).item);

	}

	public static Node<Integer> nthToLast(Node<Integer> first, int n) {
		Node<Integer> p1 = first;
		Node<Integer> p2 = first;

		if (n <= 0)
			return null;

		// Move p2 n nodes into the list. Keep n1 in the same position.
		for (int i = 0; i < n - 1; i++) {
			if (p2 == null) {
				return null; // Error: list is too small.
			}
			p2 = p2.next;
		}
		if (p2 == null) { // Another error check.
			return null;
		}

		// Move them at the same pace. When p2 hits the end,
		// p1 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	//Another approach
	public static int nthToLastValue(Node<Integer> first, int n) {
		if (n == 0 || first == null) {
			return 0;
		}
		int k = nthToLastValue(first.next, n) + 1;
		if (k == n) {
			System.out.println(n + "th to last node is " + first.item);
		}
		return k;
	}

}
