package string;

/*
 * Method 1 ( Brute Force ) 
	 The simple approach is to check each substring whether the substring is a palindrome or not. We can run three loops, 
	 the outer two loops pick all substrings one by one by fixing the corner characters, the inner loop checks whether the 
	 picked substring is palindrome or not.
	
	 Time complexity: O ( n^3 )
	 Auxiliary complexity: O ( 1 )
	
  Method 2 ( Dynamic Programming ) 
	 The time complexity can be reduced by storing results of subproblems. We maintain a 
	 boolean table[n][n] that is filled in bottom up manner. The value of table[i][j] is true, if the substring is 
	 palindrome, otherwise false. To calculate table[i][j], we first check the value of table[i+1][j-1], if the value is 
	 true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
 */

//Result is  abcdefedcba
public class Longest_Palindromic_SubString {

	static String str = "geeksforrofsekabcdefedcba";

	public static void main(String[] args) {
		String result = longestPalindrome(str);
		System.out.println(" " + result);

	}

	public static String longestPalindrome(String s) {
		int length = s.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			String ps = getPalindrome(s, i, i); //check if midpoint is single character 'abcba'
			if (ps.length() > result.length()) {
				result = ps;
			}
			ps = getPalindrome(s, i, i + 1); //check is mid point if same character 'abccba'
			if (ps.length() > result.length()) {
				result = ps;
			}
		}
		return result;
	}

	private static String getPalindrome(String s, int l, int r) {
		/*
		 * If s.charAt(l) == s.charAt(r).....l goes <-- way from center character c and r goes -->...and 
		 * they if s.charAt(c - 1) == s.charAt(c + 1)
		 */
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--; 
			r++;
		}
		return s.substring(l + 1, r);
	}
}
