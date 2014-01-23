package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Dont_Use_Longest_Increasing_Sequence {

	public static void main(String[] args) {
        int[] a1 = new int[]{16, 18, 7, 8, 9, 10, 13, 0, 1, 2, 0, 9, 13, 14};
        System.out.println(Arrays.toString(a1));
        
        ArrayList<Integer> lis = LIS(a1);
        System.out.println("Longest Increasing Sequence: " + lis.toString());
        
        // a1 = new int[]{ 0, 1, 2, 0, 3,};
        System.out.println(Arrays.toString(a1));
        int max = LIS1(a1);
        System.out.println("Longest Increasing Sequence 2: " + max);

	}
	
    // longest increasing sequence
    public static ArrayList<Integer> LIS(int[] a) {

        LinkedList<Integer> trackLargestIndex = new LinkedList<Integer>();
        int[] path = new int[a.length];

        trackLargestIndex.add(0);
        path[0] = 0;

        for (int i = 1; i < a.length; ++i) {

            if (a[trackLargestIndex.getLast()] <= a[i]) {
                path[i] = trackLargestIndex.getLast(); // record the index of previous smaller element
                trackLargestIndex.add(i);  // record the index of the largest element
            } else {
                int s, e;
                for (s = 0, e = trackLargestIndex.size() - 1; s < e; ) {

                    int m = (e + s) / 2;

                    if (a[trackLargestIndex.get(m)] <= a[i])
                        s = m + 1;
                    else
                        e = m;

                }
                if (a[i] < a[trackLargestIndex.get(s)]) {
                    trackLargestIndex.set(s, i);
                    if (s > 0)
                        path[i] = trackLargestIndex.get(s - 1);
                    else
                        path[i] = 0;
                }
            }
        }

        int index = trackLargestIndex.getLast();
        ArrayList<Integer> lis = new ArrayList<Integer>();
        for (int n = 0; n < trackLargestIndex.size(); ++n) {
            lis.add(0, a[index]);
            index = path[index];
        }

        return lis;
    }

    public static int LIS1(int[] a) {
        int max = 1;
        int[] trackTable = new int[a.length + 1]; // initial all 0 ; track index of the length of sequence
        trackTable[1] = 0;        // 0 is the index  of the smallest length 1.

        for (int i = 1; i < a.length; ++i) {

            if (a[i] < a[trackTable[1]])
                trackTable[1] = i;
            else if (a[i] >= a[trackTable[max]]) {
                trackTable[max + 1] = i;
                max++;

            } else { // smallest < a[i] < largest
                int s = 1;
                int e = max;
                while (s < e) {
                    int m = (e + s) / 2;
                    if (a[trackTable[m]] <= a[i])
                        s = m + 1;
                    else
                        e = m;
                }
                trackTable[s] = i;
            }

        }
        return max;
    }

}
