package games;

/*************************************************************************
 *  Compilation:  javac Queens2.java
 *  Execution:    java Queens2 N
 *  
 *  Solve the N queens problem by enumerating all N! permutations,
 *  pruning off useless branches. Solves N = 30 in a reasonable amount
 *  of time.
 *
 *  % java Queens2 3
 *
 *  % java Queens2 4
 *  * * Q * 
 *  Q * * * 
 *  * * * Q 
 *  * Q * * 
 *
 *************************************************************************/


public class Queens2 {

   /***********************************************************************
    * Print out N-by-N placement of queens in ASCII.
    ***********************************************************************/
    public static void printQueens(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i] == j) System.out.print("Q ");
                else           System.out.print("* ");
            }
            System.out.println();
        }  
        System.out.println();
    }

   /***********************************************************************
    * Solve the N queens problem by brute force.
    ***********************************************************************/
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




    // try all n! permutations, but prune useless ones
    public static void enumerate(int[] a, boolean[] diag1, boolean[] diag2, int n) {
        int N = a.length;

        // found one, so print out and stop
        if (n == 0) {
            printQueens(a);
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            int k = n-1;

            // if placement of new queen is ok, then enumerate
            if (!diag1[k + a[k]] && !diag2[N + k - a[k]]) {
                diag1[k + a[k]] = true;
                diag2[N + k - a[k]] = true;
                enumerate(a, diag1, diag2, n-1);
                diag1[k + a[k]] = false;
                diag2[N + k - a[k]] = false;
            }
            swap(a, i, n-1);
        }
    }  


    public static void main(String[] args) {
        int N = Integer.parseInt("5");
        int[] a         = new int[N];         // a[i] = row of queen in ith column
        boolean[] diag1 = new boolean[2*N];   // is ith top diagonal occupied?
        boolean[] diag2 = new boolean[2*N];   // is ith bottom diagonal occupied?
        for (int i = 0; i < N; i++)
            a[i] = i;
        enumerate(a, diag1, diag2, N);
    }

}
