package string;

import java.util.Arrays;

public class Longest_Repeated_String {

	public static void main(String[] args) {
        String s1 = "aaadbscddddedeee";
        System.out.println("s1: " + s1);
        String lrs = LRS(s1);
        System.out.println("LRS: " + lrs);
        String lrs1 = LRS1(s1);
        System.out.println("LRS1: " + lrs1);
	}

    // longest repeated string
    public static String LRS(String str) {
        StringBuilder sb = new StringBuilder();
        String s = "";     // it is a holder for LRS
        char[] chars = str.toCharArray();
        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                sb.append(chars[i]);
            } else {
                if (sb.length() > s.length()) {
                    s = sb.toString();
                }
                sb = new StringBuilder();
                sb.append(chars[i]);
            }
        }
        return s;

    }

    public static String LRS1(String st) {
        char[] chars = st.toCharArray();
        int i = 0, start = 0, end = 0, j = i;
        while (i < chars.length) {

            if (j - i >= end - start) {
            	start = i;
            	end = j;
            }

            i = j;

            for (j = i; j < chars.length; j++) {
                if (chars[i] != chars[j]) break;
            }
        }
        char[] lrs = Arrays.copyOfRange(chars, start, end);
        return new String(lrs);
    }

}
