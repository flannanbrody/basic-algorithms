package extra;

public class Partition_Linked_List_2 {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, 5);
		
		/* Print Result */
		System.out.println(h.printForward());
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
