package extra;

import java.util.Stack;

/*
 *  palindrome like 0 -> 1 -> 2 ->1 - > 0
 *  
 *  We want to detect linked lists where the front half of the list is the reverse of the second half. How would we 
 *  do that? By reversing the front half of the list. A stack can accomplish this.
 */

public class Is_LinkedList_Palindrome {
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;			
		}
		
		/* Has odd number of elements, so skip the middle */
		if (fast != null) { 
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop().intValue();
			System.out.println(slow.data + " " + top);
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		//nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
	
	public static class LinkedListNode {
		public LinkedListNode next;
		public LinkedListNode prev;
		public LinkedListNode last;
		public int data;
		public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
			data = d;
			setNext(n);
			setPrevious(p);
		}
		
		public void setNext(LinkedListNode n) {
			next = n;
			if (this == last) {
				last = n;
			}
			if (n != null && n.prev != this) {
				n.setPrevious(this);
			}
		}
		
		public void setPrevious(LinkedListNode p) {
			prev = p;
			if (p != null && p.next != this) {
				p.setNext(this);
			}
		}	
		
		public String printForward() {
			if (next != null) {
				return data + "->" + next.printForward();
			} else {
				return ((Integer) data).toString();
			}
		}
		
		public LinkedListNode clone() {
			LinkedListNode next2 = null;
			if (next != null) {
				next2 = next.clone();
			}
			LinkedListNode head2 = new LinkedListNode(data, next2, null);
			return head2;
		}
	}


}