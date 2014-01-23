package general;

/*************************************************************************
 *  Compilation:  javac Recursion.java
 *  Execution:    java Recursion N
 *
 *  Some recursive functions for you to trace through.
 * 
 *  % java Recursion 0
 *  0 
 * 
 * 
 * 
 *  % java Recursion 1
 *  0 1 
 *  1 1 
 *
 *  1 1
 *
 *  % java Recursion 5
 *  2 0 1 4 3 5 
 *  5 3 1 1 3 2 2 5 
 *  3 2 5 2 4 3 2 
 *  2 2 5 3 1 1 3 5
 *  
 *************************************************************************/

public class Recursion {

	//2 0 1 4 3 5 
    public static void mystery1(int a, int b) {
        if (a <= b) {
            int m = (a + b) / 2;
            System.out.print(m + " ");
            mystery1(a, m-1);
            mystery1(m+1, b);
        }
    }

    //5 3 1 1 3 2 2 5 
    public static void mystery2(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            mystery2(n-2);
            mystery2(n-3);
            System.out.print(n + " ");
        }
    }

    //3 2 5 2 4 3 2 
    public static void mystery3(int n) {
        if (n == 0 || n == 1) return;
        mystery3(n-2);
        System.out.print(n + " ");
        mystery3(n-1);
    }

    //2 2 5 3 1 1 3 5 
    public static String mystery4(int n) {
        if (n <= 0) return "";
        return mystery4(n-3) + n + " " + mystery4(n-2) + n + " ";
    }



    public static void main(String[] args) {
        int N = Integer.parseInt("5");
        mystery1(0, N);
        System.out.println();
        mystery2(N);
        System.out.println();
        mystery3(N);
        System.out.println();
        System.out.println(mystery4(N));

    }

}