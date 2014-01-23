package linkedList;

public class Merge_Two_SinglyLinkedList {

	/**
	 * Output Merge : 1 2 3 4 5 6 7 8 9 10 å
	 */
	public static void main(String[] args) {
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<Integer>(1, null);
		firstLinkedList.addNodeAtEnd(3);
		firstLinkedList.addNodeAtEnd(5);
		firstLinkedList.addNodeAtEnd(7);
		firstLinkedList.addNodeAtEnd(9);
		firstLinkedList.addNodeAtEnd(11);
		firstLinkedList.addNodeAtEnd(13);
		firstLinkedList.addNodeAtEnd(15);

		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<Integer>(2, null);
		secondLinkedList.addNodeAtEnd(4);
		secondLinkedList.addNodeAtEnd(6);
		secondLinkedList.addNodeAtEnd(8);
		secondLinkedList.addNodeAtEnd(10);

		/*
		 * System.out.print("Recursive Merge : ");
		 * recursiveMerge(firstLinkedList, secondLinkedList).print();
		 * System.out.println();
		 */

		// Can only call one method or the other....both work
		System.out.print("Iterative Merge : ");
		iterativeMerge(firstLinkedList, secondLinkedList).print();

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

		public void print() {
			LinkedListNode<E> current = this;
			while (current != null) {
				System.out.print(current.value + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	// Recursion
	public static LinkedListNode<Integer> recursiveMerge(
			LinkedListNode<Integer> n1, LinkedListNode<Integer> n2) {
		LinkedListNode<Integer> result = null;

		if (n1 != null && n2 != null) {
			if (n1.value < n2.value) {
				result = n1;
				result.next = recursiveMerge(n1.next, n2);
			} else {
				result = n2;
				result.next = recursiveMerge(n1, n2.next);
			}
		} else if (n1 != null) {
			result = n1;
		} else if (n2 != null) {
			result = n2;
		}
		return result;
	}

	// Iterative
	public static LinkedListNode<Integer> iterativeMerge(
			LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		LinkedListNode<Integer> head;
		if (list1.value < list2.value) {
			head = list1;
		} else {
			head = list2;
			list2 = list1;
			list1 = head;
		}
		while (list1.next != null && list2 != null) {
			if (list1.next.value <= list2.value) {
				list1 = list1.next;
			} else {
				LinkedListNode<Integer> tmp = list1.next;
				list1.next = list2;
				list2 = tmp;
			}
		}
		if (list1.next == null)
			list1.next = list2;
		return head;
	}

	// Simpler Iterative
	public static LinkedListNode<Integer> SimpleIterativeMerge(
			LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		LinkedListNode<Integer> head = new LinkedListNode<Integer>(0);

		while (list1 != null && list2 != null) {
			if (list1.value < list2.value) {
				head.addNodeAtEnd(list1.value);
				list1 = list1.next;
			} else {
				head.addNodeAtEnd(list2.value);
				list2 = list2.next;
			}
		}

		while (list1 != null) {
			head.addNodeAtEnd(list1.value);
			list1 = list1.next;
		}

		while (list2 != null) {
			head.addNodeAtEnd(list2.value);
			list2 = list2.next;
		}
		return head;
	}

}
