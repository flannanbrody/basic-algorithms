package linkedList;

import linkedList.SinglyLinkedList.Node;

public class Swap_Nth_Beginning_And_End_SinglyLinkedList {

	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked
	 * list, given only access to that node.
	 */
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println("Before: " + list);
		swapNthBeginningAndEnd(list, 4);
		System.out.println("After:  " + list);
	}

	public static void swapNthBeginningAndEnd(SinglyLinkedList<Integer> list, int k) {
		if (list.first == null || k <= 0) {
			System.out.println("not valid input");
		}

		Node<Integer> slowStart = list.first;
		Node<Integer> fastStart = list.first;
		int count = 0;

		// Move fastStart n nodes into the list. Keep slowStart in the same position.
		for (int i = 0; i < k - 1; i++) {
			if (fastStart == null) {
				System.out.println("reached end");
			}
			fastStart = fastStart.next;
		}

		// Move them at the same pace. When fastStart hits the end, slowStart will be at the right element.
		while (fastStart.next != null) {
			slowStart = slowStart.next;
			fastStart = fastStart.next;
			count++;
		}

		Node<Integer> tempNthBeginning = list.getNodeAt(k);
		list.removeAt(k);
		Node<Integer> tempNthEnd = list.getNodeAt(count);
		list.insertAt(count, (Integer) tempNthBeginning.item);
		list.removeAt(count + 1);
		list.insertAt(k, (Integer) tempNthEnd.item);
		
	}
}
