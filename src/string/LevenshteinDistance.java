package string;

/**
 * The Levenshtein distance between two strings is defined as the minimum number
 * of edits needed to transform one string into the other, with the allowable
 * edit operations being insertion, deletion, or substitution of a single
 * character. For example, the Levenshtein distance between "kitten" and
 * "sitting" is 3, since the following three edits change one into the other,
 * and there is no way to do it with fewer than three edits: 
 * 		kitten sitten (substitution of 'k' with 's') 
 * 		sitten sittin (substitution of 'e' with 'i')
 * 		sittin sitting (insert 'g' at the end).
 */
public class LevenshteinDistance {

	public static void main(String[] args) {
		System.out.println("Distance is " + computeLevenshteinDistance("kitten", "sitting"));
		System.out.println("Distance is " + computeLevenshteinDistance("rosettacode", "raisethysword"));
	}


	public static int computeLevenshteinDistance(CharSequence str1,
			CharSequence str2) {
		int[][] distance = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= str2.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++)
				distance[i][j] = minimum(
						distance[i - 1][j] + 1,
						distance[i][j - 1] + 1,
						distance[i - 1][j - 1]
								+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
										: 1));

		return distance[str1.length()][str2.length()];
	}
	
	private static int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}