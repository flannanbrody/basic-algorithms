package general;

/**
 * Given a Tuple for eg. (a, b, c)..
 * Output : (*, *, *), (*, *, c), (*, b, *), (*, b, c), (a, *, *), (a, *, c), (a, b, *), (a, b, c)
 */
public class TupleSubstitute {

	public static void main(String[] args) {
		String[] tuple = {"a","b","c"};
        for (int i=0; i<powerN(2,tuple.length); i++) {
            String b = toBinary(i, tuple.length);
            System.out.print("(");
            for (int j=0; j<b.length(); j++) {
                if (b.substring(j,j+1).equals("1"))System.out.print(" "+tuple[j]+" ");
                else System.out.print(" * ");
            }
            System.out.print(") ");
        }
	}
	

    private static String toBinary(int base, int length) {
        String b = Integer.toBinaryString(base);
        for (int i = b.length(); i < length; i++) {
            b = "0"+b;
        }
        return b;
    }

    private static int powerN(int base, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= base;
        }
        return result;
    }

}
