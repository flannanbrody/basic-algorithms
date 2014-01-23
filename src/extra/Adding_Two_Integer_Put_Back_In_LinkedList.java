package extra;

public class Adding_Two_Integer_Put_Back_In_LinkedList {

	/*
	 * Given two numbers represented by two linked lists, write a function that returns sum list. The sum list is linked list 
	 * representation of addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use 
	 * explicit extra space (Hint: Use Recursion).

	 Example

	 Input:
	 First List: 5->6->3  // represents number 563
	 Second List: 8->4->2 //  represents number 842
	 Output
	 Resultant list: 1->4->0->5  // represents number 1405
	 We have discussed a solution here which is for linked lists where least significant digit is first node of lists and 
	 most significant digit is last node. In this problem, most significant node is first node and least significant digit is 
	 last node and we are not allowed to modify the lists. Recursion is used here to calculate sum from right to left.

	 Following are the steps.
	 1) Calculate sizes of given two linked lists.
	 2) If sizes are same, then calculate sum using recursion. Hold all nodes in recursion call stack till the rightmost node, 
	    calculate sum of rightmost nodes and forward carry to left side.
	 3) If size is not same, then follow below steps:
		 ….a) Calculate difference of sizes of two linked lists. Let the difference be diff
		 ….b) Move diff nodes ahead in the bigger linked list. Now use step 2 to calculate sum of smaller list and right sub-list 
		      (of same size) of larger list. Also, store the carry of this sum.
		 ….c) Calculate sum of the carry (calculated in previous step) with the remaining left sub-list of larger list. Nodes of 
		      this sum are added at the beginning of sum list obtained previous step.
	 */
		private static int length(LinkedListNode l) {
			if (l == null) {
				return 0;
			} else {
				return 1 + length(l.next);
			}
		}

		private static PartialSum addListsHelper(LinkedListNode l1,
				LinkedListNode l2) {
			if (l1 == null && l2 == null) {
				PartialSum sum = new PartialSum();
				return sum;
			}
			PartialSum sum = addListsHelper(l1.next, l2.next);
			int val = sum.carry + l1.data + l2.data;
			LinkedListNode full_result = insertBefore(sum.sum, val % 10);
			sum.sum = full_result;
			sum.carry = val / 10;
			return sum;
		}

		private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
			int len1 = length(l1);
			int len2 = length(l2);
			if (len1 < len2) {
				l1 = padList(l1, len2 - len1);
			} else {
				l2 = padList(l2, len1 - len2);
			}
			PartialSum sum = addListsHelper(l1, l2);
			if (sum.carry == 0) {
				return sum.sum;
			} else {
				LinkedListNode result = insertBefore(sum.sum, sum.carry);
				return result;
			}
		}

		private static LinkedListNode padList(LinkedListNode l, int padding) {
			LinkedListNode head = l;
			for (int i = 0; i < padding; i++) {
				LinkedListNode n = new LinkedListNode(0, null, null);
				head.prev = n;
				n.next = head;
				head = n;
			}
			return head;
		}

		private static LinkedListNode insertBefore(LinkedListNode list, int data) {
			LinkedListNode node = new LinkedListNode(data, null, null);
			if (list != null) {
				list.prev = node;
				node.next = list;
			}
			return node;
		}

		public static int linkedListToInt(LinkedListNode node) {
			int value = 0;
			while (node != null) {
				value = value * 10 + node.data;
				node = node.next;
			}
			return value;
		}

		public static void main(String[] args) {
			LinkedListNode lA1 = new LinkedListNode(3, null, null);
			LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
			LinkedListNode lA3 = new LinkedListNode(5, null, lA2);

			LinkedListNode lB1 = new LinkedListNode(5, null, null);
			LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
			LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

			LinkedListNode list3 = addLists(lA1, lB1);

			System.out.println("  " + lA1.printForward());
			System.out.println("+ " + lB1.printForward());
			System.out.println("= " + list3.printForward());

			int l1 = linkedListToInt(lA1);
			int l2 = linkedListToInt(lB1);
			int l3 = linkedListToInt(list3);

			System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
			System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
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
		
		public static class PartialSum {
			public LinkedListNode sum = null;
			public int carry = 0;
		}

	}

