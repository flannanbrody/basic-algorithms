package general;

import java.util.TreeMap;

/**
 * You can do it in O(N*Log(W)), where N is the size of your array, and W is the
 * size of the sliding window.
 * 
 * Use a binary tree to store the first W numbers. For the following N-W steps,
 * get the max value from the tree for your output, add the element at the
 * current position i to the tree, and remove the element at i-W from the tree.
 * These operations are all O(Log(W)), for the overall timing of O(N*Log(W))
 */
public class Max_In_Window_Simple {
	public static void main(String[] args) {
		int[] data = new int[] { 1, 3, -1, -3, 5, 3, 6, 7, 8 };
		int W = 3;
		maxInWindow(data, W);
	}

	public static void maxInWindow(int[] data, int windowSize) {
		TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
		//Add the first 3 values
		for (int i = 0; i != windowSize; i++) {
			if (counts.containsKey(data[i])) {
				counts.put(data[i], counts.get(data[i]) + 1);
			} else {
				counts.put(data[i], 1);
			}
		}
		for (int i = windowSize; i != data.length; i++) {
			//print max 
			Integer max = counts.lastKey();
			System.out.println(max);
			//remove first one
			int tmp = counts.get(data[i - windowSize]) - 1;
			if (tmp != 0) {
				counts.put(data[i - windowSize], tmp);
			} else {
				counts.remove(data[i - windowSize]);
			}
			//add the next one
			if (counts.containsKey(data[i])) {
				counts.put(data[i], counts.get(data[i]) + 1);
			} else {
				counts.put(data[i], 1);
			}
		}
		System.out.println(counts.lastKey());
	}
}
