package extra;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 shows the first 11 ugly numbers. By convention, 1 is included.
 Write a program to find and print the 150'th ugly number.

 Approach:
 Start with num=1
 now multiple 1 with 2, 3 and 5 and store the results in min heap if the result is not already there.
 now remove the root of the min-heap and output it then multiply the removed root with 2, 3 and 5 and store the result in 
 min-heap if not already present.
 repeat it n number of times, in the above case 150 times.
 */

public class UglyNumbers {

	public static void main(String[] args) {
		UglyNumbers un = new UglyNumbers();
		un.calculateUglyNumbers();
	}

	public void calculateUglyNumbers() {
		Comparator<Integer> comparator = new IntegerComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1500, comparator);
		int count = 1;
		int N = 150;
		pq.add(1);

		System.out.println("ugly numbers are: ");
		while (count <= N) {
			int i = pq.remove();

			if (!pq.contains(i * 2)) {
				pq.add(i * 2);
			}
			if (!pq.contains(i * 3)) {
				pq.add(i * 3);
			}
			if (!pq.contains(i * 5)) {
				pq.add(i * 5);
			}
			count += 1;

			System.out.print(i + " ");
		}
		System.out.println();
	}

	public class IntegerComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 < o2) {
				return -1;
			}
			if (o1 > o2) {
				return 1;
			}
			return 0;
		}
	}
}
