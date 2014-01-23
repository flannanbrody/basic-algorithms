package general;

import java.util.LinkedList;
import java.util.Queue;

/*************************************************************************
 * Compilation: javac Josephus.java Execution: java Josephus M N Dependencies:
 * Queue.java
 * 
 * Solves the Josephus problem.
 * 
 * There are people standing in a circle waiting to be executed. The counting
 * out begins at some point in the circle and proceeds around the circle in a
 * fixed direction. In each step, a certain number of people are skipped and the
 * next person is executed. The elimination proceeds around the circle (which is
 * becoming smaller and smaller as the executed people are removed), until only
 * the last person remains, who is given freedom.
 * 
 * % java Josephus 5 9 5 1 7 4 3 6 9 2 8
 * 
 *************************************************************************/

public class Josephus {
	public static void main(String[] args) {
		int M = Integer.parseInt("5");
		int N = Integer.parseInt("9");

		// initialize the queue
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++)
			q.add(i);

		while (!q.isEmpty()) {
			for (int i = 0; i < M - 1; i++)
				q.add(q.remove());
			System.out.print(q.remove() + " ");
		}
		System.out.println();
	}
}
