package string;


/*************************************************************************
 *  Compilation:  javac Subsequence.java
 *  Execution:    java Subsequence s k
 *
 *  Print out all subsequences of the string s of length k.
 *
 *  % java Subsequence abcd 3
 *  abc
 *  abd
 *  acd
 *  bcd
 *
 *  % java Subsequence abcc 3
 *  abc
 *  abc
 *  acc
 *  bcc
 *  
 *  % java Subsequence abcc 4
 *  abcd
 *
 *************************************************************************/

public class Print_All_Permutations_Size_K_In_String { 

    public static void main(String[] args) { 
        String s = "abcd";
        int k = Integer.parseInt("3");
        print("", s, k);
    }
    
    public static void print(String prefix, String remaining, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        if (remaining.length() == 0) return;
        print(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        print(prefix, remaining.substring(1), k);
    }
}
