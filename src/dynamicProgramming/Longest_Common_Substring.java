package dynamicProgramming;

public class Longest_Common_Substring {

	/**
	 * http://techieme.in/techieme/dynamic-programming-longest-common-subsequence/
	 * 
	 * Let m and n be the lengths of first and second strings respectively.
	 * 
	 * A simple solution is to one by one consider all substrings of first
	 * string and for every substring check if it is a substring in second
	 * string. Keep track of the maximum length substring. There will be O(m^2)
	 * substrings and we can find whether a string is subsring on another string
	 * in O(n) time (See this). So overall time complexity of this method would
	 * be O(n * m2)
	 * 
	 * Dynamic Programming can be used to find the longest common substring in
	 * O(m*n) time. The idea is to find length of the longest common suffix for
	 * all substrings of both strings and store these lengths in a table.
	 * 
	   The longest common suffix has following optimal substructure property
		   LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
		                        0  Otherwise (if X[m-1] != Y[n-1])
		                        
		                        LCSubStr(X, Y, m, n)  = Max(LCSuff(X, Y, m-1, n), //this is X
		                        							LCSuff(X, Y, m, n-1)) //this is Y
		
		The maximum length Longest Common Suffix is the longest common substring.
		   LCSubStr(X, Y, m, n)  = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m
		                                                     and 1 <= j <= n
		                                                     
		                                                     
	  Brute for is to check every subsequence of x[1....m] to see if it is also a subsequence of y[1...n]
	  
	  Optimal substructure....an optimal solution to a problem (instance) contains optimal solution to a subproblem   
	  
	  LCS(X, Y, i, j)
	  if X[i] = Y[j]
	  	then c[i,j] <-- LCS(X, Y, i-1, j-1) + 1
	  	else c[i,j] <-- max{LCS(X, Y, i-1, j),
	  						LCS(X, Y, i, j-1)}
	  
	  Time = O(mn), Space = O(mn)
	  						
	  Worst case algorithm evaluates two subproblems with only one parameter decremented....either LCS if match you drop
	  char in both strings and add 1, because that's the match.....or drop char from X...or Y
	  
	  Memorization....store in table
	  		A  B  C  B  D  A  B
	     0  0  0  0  0  0  0  0
	   B 0  0  1  1  1  1  1  1
	   D 0  0  1  1  1  2  2  2
	   C 0  0  1  2  2  2  2  2
	   A 0  1  1  2  2  2  3  3
	   B 0  1  2  2  3  3  3  4
	   A 0  1  2  2  3  3  4  4
	   
	     BDAB, BCBA, BCAB
	 */
	public static void main(String[] args) {
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		System.out.println("Recursion: " + lcs(s1, s2));
		System.out.println();
		System.out.println("Dynamic Programming: " + lcsDP(s1, s2));
	}
	
	//Recursive...
	public static String lcs(String a, String b){
	    int aLen = a.length();
	    int bLen = b.length();
	    if(aLen == 0 || bLen == 0){
	        return "";
	    }else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
	        return lcs(a.substring(0,aLen-1),b.substring(0,bLen-1))
	            + a.charAt(aLen-1);
	    }else{
	        String x = lcs(a, b.substring(0,bLen-1));
	        String y = lcs(a.substring(0,aLen-1), b);
	        return (x.length() > y.length()) ? x : y;
	    }
	}
	
	//Dynamic Programming
	public static String lcsDP(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
	}

}
