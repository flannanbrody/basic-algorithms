package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import linkedList.SinglyLinkedList.Node;

public class Delete_Duplicate_Unsorted_SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println("Before: " + list);
		list.insertAt(5, new Integer(99));
		
		System.out.println("Remove duplicates unsorted Linked List");
		list.insertAt(5, new Integer(99));
		System.out.println(list);
		deleteDups(list.getFirst());
		System.out.println(list);

		System.out.println("After:  " + list);
	}

	//method 1
    public static void deleteDups( Node<Integer> head){
        Map<Integer, Boolean> map =new HashMap<Integer, Boolean>();
        Node<Integer> current = null;
        //nth node is not null
        while(head!=null){
          //have duplicate
              if(map.containsKey(head.item)){ //skip duplicate
            	  current.next=head.next;
              }else{
              //put the element into hashtable
              map.put((Integer) head.item,true);
              //move to the next element
              current=head;
              }
        //iterate
        head=head.next;
        }
     }
    
    //method 2
	public static void removeDuplication(Node<Integer> head) {
		Node<Integer> cur = null;
		Set<Integer> encountered = new HashSet<>();

		while (head != null) {
			encountered.add(head.item);
			cur = head;
			while (cur.next != null) {
				if (encountered.contains(cur.next.item)) {
					cur.next = (Node<Integer>) cur.next.next;
				} else {
					break;
				}
			}
			head = cur.next;
		}
	}
}
