package string;

/*************************************************************************
 *  Compilation:  javac PermutationsK.java
 *  Execution:    java PermutationsK N k
 *  
 *  Enumerates all permutations of size k chosen from N elements.
 *  
 *  Modify Permutations.java to PermutationsK.java so that 
 *  it takes two command-line arguments n and k, and prints out all P(n, k) = n! / (n-k)!
 *  permutations that contain exactly k of the n elements. Below is the desired output 
 *  when k = 2 and n = 4. You need not print them out in any particular order.
 *
 *  % java PermutationsK 4 2 | sort
 *  ab
 *  ac
 *  ad
 *  ba 
 *  bc
 *  bd
 *  ca
 *  cb
 *  cd
 *  da
 *  db 
 *  dc 
 *
 *  Limitations
 *  -----------
 *    *  Assumes N <= 52
 *    
	  n = 5, r = 3, i = 0    [a, b, c, d, e]  --> [e, b, c, d, a]
		 n = 4, r = 2, i = 0    [e, b, c, d, a] --> [d, b, c, e, a]
		 	n = 3, r = 1, i = 0    [d, b, c, e, a] --> [c, b, d, e, a]	
				n = 2, r = 0, i = 0							dea		// r = 0 so print and return r goes back r = 1
	 
			first iteration of inner loop (i++)…moves around first three char's
		 	n = 3, r = 1, i = 0    [c, b, d, e, a] --> [d, b, c, e, a]
			n = 3, r = 1, i = 1    [d, b, c, e, a] --> [d, c, b, e, a]
				n = 2, r = 0, i = 1							bea
	
			n = 3, r = 1, i = 1    [d, c, b, e, a] --> [d, b, c, e, a]
			n = 3, r = 1, i = 2    [d, b, c, e, a] --> [d, b, c, e, a]             //we swap c with c so no change
				n = 3, r = 0 i = 2  							cea
														
			n = 3, r = 1, i = 2    [d, b, c, e, a] --> [d, b, c, e, a]			//we swap c with c so no change
			Inner loop ends
	
		n = 4, r = 2, i = 0    [d, b, c, e, a] --> [e, b, c, d, a]
		n = 4, r = 2, i = 1    [e, b, c, d, a] --> [e, d, c, b, a]
			n = 3, r = 1, i = 0    [e, d, c, b, a] --> [c, d, e, b, a]
				n = 3, r = 0 i = 0  							eba
	
			n = 3, r = 1, i = 0    [c, d, e, b, a] --> [e, d, c, b, a]
			n = 3, r = 1, i = 1    [e, d, c, b, a] --> [e, c, d, b, a]
				n = 3, r = 0 i = 1  							dba
	
			n = 3, r = 1, i = 1    [e, c, d, b, a] --> [e, d, c, b, a]
			n = 3, r = 1, i = 2    [e, d, c, b, a] --> [e, d, c, b, a]          //no change
				n = 3, r = 0 i = 2  							cba
	
			n = 3, r = 1, i = 2    [e, d, c, b, a] --> [e, d, c, b, a]          // no change
		n = 4, r = 2, i = 1    [e, d, c, b, a] --> [e, b, c, d, a]
		n = 4, r = 2, i = 2    [e, b, c, d, a] --> [e, b, d, c, a]
			n = 3, r = 1, i = 0    [e, b, d, c, a] --> [d, b, e, c, a]
				n = 2, r = 0 i = 0  							eca
 *
 *************************************************************************/

public class Print_All_Permutations_Size_K_In_String_Size_N {

    // sample client
    public static void main(String[] args) {
        int N = Integer.parseInt("5");
        int k = Integer.parseInt("3");
        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /*
         * It puts the first N char into char[]a ...N=5 a={a, b, c, d, e}
         */
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = elements.charAt(i);
        enumerate(a, a.length, k);
    }

    /*
     * 
     */
    private static void enumerate(char[] a, int n, int r) {
		//firstly define when the recursion stops
		//case 1, the currentSize equals K, Current combination is ready to be printed
        if (r == 0) {
            for (int i = n; i < a.length; i++)
                System.out.print(a[i]);
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);			//swap first index with n-1, so each swap happens with n-1 elements. i stays in same place but n moves L <-- R
            enumerate(a, n-1, r-1);
            swap(a, i, n-1);			//swap happens as i moves L --> R in each iteration and n moves L <-- R
         }
    }  

    // helper function that swaps a[i] and a[j]
    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
