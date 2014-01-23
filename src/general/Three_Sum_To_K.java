package general;

import java.util.Random;

/*************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum < input.txt
 *                java N Generator | java ThreeSum
 *
 *  A program with cubic running time. Read in N integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  % java ThreeSum < 8ints.txt 
 *  4
 *  30 -30 0
 *  30 -20 -10
 *  -30 -10 40
 *  -10 0 10
 *
 *  % java ThreeSum < 1Kints.txt
 *  0
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *  Sample data files
 *  -----------------
 *  http://www.cs.princeton.edu/introcs/41analysis/8ints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/1Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/2Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/4Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/8Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/16Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/32Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/64Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/128Kints.txt
 *
 *  Use the program Generator.java to generate additional data files.
 *
 *************************************************************************/

public class Three_Sum_To_K {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 10
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 10) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    } 

    public static void main(String[] args)  { 
    	Random random = new Random();
        int N = 10; 
        int[] a = {2, 4, 6, 7, -3, -5, -2, -1, 2, 1, -3}; 
//        for (int i = 0; i < N; i++) {
//            a[i] = random.nextInt(N - i);
//        }
        
        printAll(a);

        int cnt = count(a);
        System.out.println(cnt);
    } 
} 
