package string;

import java.util.ArrayList;
import java.util.List;

/*
 [1ab, a1b, ab1]
 [12ab, 1a2b, 1ab2, a12b, a1b2, ab12]
 [12abc, 1a2bc, 1ab2c, 1abc2, a12bc, a1b2c, a1bc2, ab12c, ab1c2, abc12]
 [1234ab, 123a4b, 123ab4, 12a34b, 12a3b4, 12ab34, 1a234b, 1a23b4, 1a2b34, 1ab234, a1234b, a123b4, a12b34, a1b234, ab1234]
 */
public class Interleave_Two_Strings {

    public static void main(String[] args) {
        //System.out.println(interleave("", ""));
        //System.out.println(interleave("a", ""));
        //System.out.println(interleave("", "1"));
        //System.out.println(interleave("a", "1"));
        System.out.println(interleave("ab", "1"));
        System.out.println(interleave("ab", "12"));
        System.out.println(interleave("abc", "12"));
        System.out.println(interleave("ab", "1234"));
    }
    
    /**
     * Returns a list containing all possible interleavings of two strings.
     * The order of the characters within the strings is preserved.
     */
    public static List<String> interleave(String s, String t) {
        List<String> result = new ArrayList<String>();
        if (t.isEmpty()) {
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                	/*
                	 * For interleave("ab", "1") its 3 loops
                	 *  1. "" + 1 + ab, 
                	 *  2. a + 1 + b, 
                	 *  3. ab + 1 + ""
                	 */
                    result.add(left + c + u); 
                }
            }
        }
        return result;
    }
}
