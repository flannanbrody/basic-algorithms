package linkedList;

import linkedList.SinglyLinkedList.Node;
/*
 * Before: 0 1 2 3 4 5 6 7 8 9 
 * After:  1 0 3 2 5 4 7 6 8 9 
 */
public class Pairwise_Swap_SinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			list.insertAtLast(i);
		System.out.println("Before: " + list);
           
		Node<Integer> firstPointer = list.first;
		Node<Integer> secondPointer = list.first.next;
		Node<Integer> thirdPointer = null;

        while(secondPointer.next != null)
        {
            firstPointer.next = secondPointer.next;
            secondPointer.next = firstPointer;

            if (thirdPointer != null){
                thirdPointer.next = secondPointer;
            }

            if(firstPointer == list.first){
            	list.first = secondPointer;
            }

            thirdPointer = firstPointer;
            firstPointer = firstPointer.next;
            secondPointer = firstPointer.next;

            if(secondPointer == null)
            {
                break;
            }
        }
        
		System.out.println("After:  " + list);
	}
	

}