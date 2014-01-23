package string;

import java.util.Arrays;

public class Dont_Use_Longest_Common_String {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "aaadbscddddedee";
        String s2 = "ddaacddddess";
        System.out.println("s2: " + s2);
        String lcs = LCS(s1, s2);
        System.out.println("LCS: " + lcs);

        String lcs1 = LCS1(s1, s2);
        System.out.println("LCS1: " + lcs1);
	}

	// longest common string
	public static String LCS(String x, String y) {
		int N = x.length();
		int M = y.length();
		String[] suffixes = new String[M + N];
		for (int i = 0; i < N; i++) {
			suffixes[i] = x.substring(i);
		}
		for (int i = 0; i < M; i++) {
			suffixes[N + i] = y.substring(i);
		}
		Arrays.sort(suffixes);

		String lrs = "";
		for (int i = 0; i < suffixes.length - 1; i++) {
			String lcps = LCP(suffixes[i], suffixes[i + 1]);
			if (lcps.length() > lrs.length())
				lrs = lcps;
		}
		return lrs;
	}

	// back-track
	public static String LCS1(String x, String y) {
		int[][] lcs = new int[x.length()][y.length()]; // all 0

		int max = 0;
		int end = 0;

		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < y.length(); j++) {
				if (x.charAt(i) == y.charAt(j)) {
					if (i == 0 || j == 0)
						lcs[i][j] = 1;
					else
						lcs[i][j] = lcs[i - 1][j - 1] + 1;

					if (lcs[i][j] > max) {
						max = lcs[i][j];
						end = i;
					}

				}

			}
		}

		return x.substring(end - max + 1, end + 1);

	}
	
    // longest common prefix
    public static String LCP(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.substring(0, i);
        }
        return s1;
    }

}
