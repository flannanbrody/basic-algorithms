package linkedList;

public class Find_Triplet_SinglyLinkedList {

	/*
	 * checkSum(firstLinkedList, secondLinkedList, thirdLinkedList, 101) = 6, 5,
	 * 90
	 */
	public static void main(String[] args) {
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<Integer>(12, null);
		firstLinkedList.addNodeAtEnd(6);
		firstLinkedList.addNodeAtEnd(29);

		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<Integer>(23, null);
		secondLinkedList.addNodeAtEnd(20);
		secondLinkedList.addNodeAtEnd(5);

		LinkedListNode<Integer> thirdLinkedList = new LinkedListNode<Integer>(90, null);
		thirdLinkedList.addNodeAtEnd(6);
		thirdLinkedList.addNodeAtEnd(59);

		checkSum(firstLinkedList, secondLinkedList, thirdLinkedList, 101);
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

	public static void checkSum(LinkedListNode<Integer> firstLinkedList,
			LinkedListNode<Integer> secondLinkedList,
			LinkedListNode<Integer> thirdLinkedList, int targetNumber) {
		boolean[] firstNumbers = new boolean[256];
		boolean found = false;
		int sum = 0, diff = 0;
		while (thirdLinkedList != null) {
			firstNumbers[thirdLinkedList.value] = true;
			thirdLinkedList = thirdLinkedList.next;
		}

		LinkedListNode<Integer> tempList = firstLinkedList;

		for (LinkedListNode<Integer> node = secondLinkedList; secondLinkedList != null; node = node.next) {
			while ((firstLinkedList != null)) {
				sum = 0;
				sum += node.value;
				if (firstLinkedList != null) {
					sum += firstLinkedList.value;
				}

				diff = targetNumber - sum;
				if ((diff > 0) && (firstNumbers[diff])) {
					if (firstLinkedList != null) {
						System.out.println(firstLinkedList.value);
					}

					System.out.println(node.value);
					System.out.println(diff);
					found = true;
					break;
				}
				if (firstLinkedList != null) {
					firstLinkedList = firstLinkedList.next;
				}
			}
			if (found) {
				break;
			} else {
				firstLinkedList = tempList;
			}
		}
	}
}
