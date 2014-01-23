package linkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * Method 2 (Use Merge Sort)
	In this method, algorithms for Union and Intersection are very similar. First we sort the given lists, then we traverse the sorted lists to get union and intersection.
	Following are the steps to be followed to get union and intersection lists.
	
	1) Sort the first Linked List using merge sort. This step takes O(mLogm) time.
	2) Sort the second Linked List using merge sort. This step takes O(nLogn) time.
	3) Linearly scan both sorted lists to get the union and intersection. This step takes O(m + n) time. This step can be implemented using the same algorithm as sorted arrays 
	   algorithm discussed here.
	
	Time complexity of this method is O(mLogm + nLogn) which is better than method 1???s time complexity.
	
	
	IMPLEMENTED BELOW
   Method 3 (Use Hashing)
	Union (list1, list2)
	Initialize the result list as NULL and create an empty hash table. Traverse both lists one by one, for each element being visited, lookup the element in hash table. If the element is 
	not present, then insert the element to result list. If the element is present, then ignore it.
	
	Intersection (list1, list2)
	Initialize the result list as NULL and create an empty hash table. Traverse list1. For each element being visited in list1, insert the element in hash table. Traverse list2, for 
	each element being visited in list2, look the element in hash table. If the element is present, then insert the element to result list. If the element is not present, then ignore it.
	
	Both of the above methods assume that there are no duplicates.
 */
public class Union_Intersection_SinglyLinkedList {

	public static void main(String asd[]) {
		LinkedListNode<Integer> firstLinkedList = new LinkedListNode<Integer>(22, null);
		firstLinkedList.addNodeAtEnd(2);
		firstLinkedList.addNodeAtEnd(15);
		firstLinkedList.addNodeAtEnd(22);
		firstLinkedList.addNodeAtEnd(11);
		firstLinkedList.addNodeAtEnd(19);
		firstLinkedList.addNodeAtEnd(25);
		firstLinkedList.addNodeAtEnd(12);
		firstLinkedList.addNodeAtEnd(98);

		System.out.print("First List :           ");
		firstLinkedList.print();

		LinkedListNode<Integer> secondLinkedList = new LinkedListNode<Integer>(11, null);
		secondLinkedList.addNodeAtEnd(99);
		secondLinkedList.addNodeAtEnd(22);
		secondLinkedList.addNodeAtEnd(15);
		secondLinkedList.addNodeAtEnd(19);
		secondLinkedList.addNodeAtEnd(12);
		secondLinkedList.addNodeAtEnd(98);
		secondLinkedList.addNodeAtEnd(22);
		secondLinkedList.addNodeAtEnd(16);
		secondLinkedList.addNodeAtEnd(17);

		System.out.print("Second List :          ");
		secondLinkedList.print();

		LinkedListNode<Integer> union = unionOfTwoLists(firstLinkedList, secondLinkedList);

		System.out.print("Union of List :        ");
		union.print();

		LinkedListNode<Integer> intersect = intersectionOfTwoLists(firstLinkedList, secondLinkedList);

		System.out.print("Intersection of List : ");
		intersect.print();
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
	
	public static LinkedListNode<Integer> unionOfTwoLists(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
		Map<Integer, LinkedListNode<Integer>> commons = new HashMap<>();
		LinkedListNode<Integer> union = null;

		while (a != null) {
			if (union == null) {
				union = new LinkedListNode<Integer>(a.value);
				commons.put(a.value, null);
			}

			if (!commons.containsKey(a.value) && union != null) {
				commons.put(a.value, null);
				union.addNodeAtEnd(a.value);
			}
			a = a.next;
		}

		while (b != null) {
			if (union == null) {
				union = new LinkedListNode<Integer>(b.value);
				commons.put(b.value, null);
			}

			if (!commons.containsKey(b.value) && union != null) {
				commons.put(b.value, null);
				union.addNodeAtEnd(b.value);
			}
			b = b.next;
		}
		return union;
	}

	public static LinkedListNode<Integer> intersectionOfTwoLists(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
		Map<Integer, LinkedListNode<Integer>> commons = new HashMap<>();
		LinkedListNode<Integer> intersect = null;
		
		while (a != null) {
			if (!commons.containsKey(a.value))
				commons.put(a.value, null);
			a = a.next;
		}
		while (b != null) {
			if (commons.containsKey(b.value)) {
				if (intersect != null)
					intersect.addNodeAtEnd(b.value);
				else
					intersect = new LinkedListNode<Integer>(b.value);

				commons.remove(b.value);
			}
			b = b.next;
		}

		return intersect;
	}
}