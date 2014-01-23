package dynamicProgramming;

/*
 * First, I'd check that the length of A and the length of B summed equal the length of C. Next, check if the first 
 * character of A is equal to the first character of C. If not, check if the first character of B is equal to the first 
 * character of C. Check the other characters starting with either A or B, depending on which of the two conditions above 
 * was true.
 */
class InterleavedString {

	public static void main(String[] args) {
		String A = "AB", B = "CD", C = "ACBD";
		System.out.println(isInterleaved(A, B, C));
	}

	public static boolean isInterleaved(String a, String b, String c) {
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		while (cIndex < c.length()) {
			if (aIndex < a.length()) {
				if (a.charAt(aIndex) != c.charAt(cIndex)) {
					return false;
				}
				cIndex++;
				aIndex++;
			}
			if (bIndex < b.length()) {
				if (b.charAt(bIndex) != c.charAt(cIndex)) {
					return false;
				}
				cIndex++;
				bIndex++;
			}
		}

		return true;
	}
}
