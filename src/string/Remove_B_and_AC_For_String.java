package string;

public class Remove_B_and_AC_For_String {

	/**
	 * 
	 * The two conditions are:
		1. Filtering of all ‘b’ and ‘ac’ should be in single pass
		2. No extra space allowed.

		NOT IMPLEMENTED BELOW.....
		The approach is to use two index variables i and j. We move forward in string using ‘i’ and add characters using 
		index j except ‘b’ and ‘ac’. The trick here is how to track ‘a’ before ‘c’. An interesting approach is to use a 
		two state machine. The state is maintained to TWO when previous character is ‘a’, otherwise state is ONE.
		1) If state is ONE, then do NOT copy the current character to output if one of the following conditions is true
			…a) Current character is ‘b’ (We need to remove ‘b’)
			…b) Current character is ‘a’ (Next character may be ‘c’)
		2) If state is TWO and current character is not ‘c’, we first need to make sure that we copy the previous character 
		   ‘a’. Then we check the current character, if current character is not ‘b’ and not ‘a’, then we copy it to output.
	 */
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("acbac");
		replace(s);
		System.out.println();
		StringBuilder s1 = new StringBuilder("aaac");
		replace(s1);
		System.out.println();
		StringBuilder s2 = new StringBuilder("ababac");
		replace(s2);
		System.out.println();
		StringBuilder s3 = new StringBuilder("bbbbd");
		replace(s3);
	}

	public static void replace(StringBuilder s) {

		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (i < len - 1 && s.charAt(i) == 'a' && s.charAt(i + 1) == 'c') {
				s.deleteCharAt(i);
				s.deleteCharAt(i);
				//i += 1; ....I commented this out on 10/17/2013
				len -= 2;
				continue;
			}

			if (s.charAt(i) == 'b') {
				s.deleteCharAt(i);
				if (i > 1)
					i -= 2;
				else
					i -= 1;
				len -= 1;
			}
		}
		System.out.print(s);
	}
}
