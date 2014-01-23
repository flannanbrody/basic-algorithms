package extra;

import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates_Linked_List {

/*	public static SinglyLinkedList<Integer> deleteDupsElements(SinglyLinkedList<Integer> singlyLinkedList) {
		Set<Integer> hashSet = new HashSet<>();
		SinglyLinkedList<Integer> output = new SinglyLinkedList<>();
		
		for (Node x = singlyLinkedList.first; x != null; x = x.next) {
			if (!hashSet.contains(x.item)) {
				hashSet.add((Integer) x.item);
			    output.insertAtLast((Integer) x.item);
			} 
		}
		return output;
	}

	public static void deleteDupsB(SinglyLinkedList<Integer> singlyLinkedList) {
		if (singlyLinkedList.first == null)
			return;

		Node current = singlyLinkedList.first;
		while (current != null) {
			 Remove all future nodes that have the same value 
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.item == current.item) {
					runner.next = (Node) runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.insertAtLast(i);
		}
		list.insertAt(1, new Integer(3));
		list.insertAt(1, new Integer(2));
		
		deleteDupsB(list);

		//SinglyLinkedList<Integer> newList = deleteDupsElements(list);

		System.out.println("removing duplicate" + list.toString());
	}
*/
}
