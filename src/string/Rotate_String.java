package string;

public class Rotate_String {

	public static void main(String[] args) {
        String s3 = "abcdefgh";
        System.out.println("s3: " + s3);
        int k = 3;
        String rs3 = rotateString(s3, k);
        System.out.println("rotate " + s3 + " in " + k + " : " + rs3);
	}
	
    public static String rotateString(String s, int k) {
        int n = s.length();
        /*
        String rs1 = reverse(s, 0, n - 1);
        String rs2 = reverse(rs1, 0, n-k-1);
        String rs3 = reverse(rs2, n-k, n - 1);
        */
        String rs1 = reverse(s, 0, k-1);
        String rs2 = reverse(rs1, k, n-1);
        String rs3 = reverse(rs2, 0, n - 1);

        return rs3;

    }
    
    public static String reverse(String st, int i, int j) {
        if (i < 0 || j > st.length())
            return st;
        char[] chars = st.toCharArray();
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }

}
