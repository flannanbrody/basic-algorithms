package string;

import java.util.HashMap;
import java.util.Map;

public class Find_First_Non_Repeated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char my =  findFirstNonRepeated("twwwweety");
		System.out.println(my);
	}
	
	public static Character findFirstNonRepeated(String input) {
	    // create a new hashtable:
	    Map<Character, Object> hashChar = new HashMap<Character, Object>();

	    int j, strLength;
	    Character chr;
	    Object oneTime = new Object();
	    Object twoTimes = new Object();

	    strLength = input.length();

	    for (j = 0; j < strLength; j++) {
	        chr = new Character(input.charAt(j));
	        Object o = hashChar.get(chr);

	        /*
	         * if there is no entry for that particular character, then insert
	         * the oneTime flag:
	         */
	        if (o == null) {
	            hashChar.put(chr, oneTime);
	        }
	        /*

	  */
	        else if (o == oneTime) {
	            hashChar.put(chr, twoTimes);
	        }
	    }

	    /*
	     * go through hashtable and search for the first nonrepeated char:
	     */

	    int length = strLength;
	    for (j = 0; j < length; j++) {
	        chr = new Character(input.charAt(j));
	        Object c = null;
	        if (hashChar.get(chr) == oneTime)
	            return chr;
	    }
	    /*
	     * this only returns null if the loop above doesn't find a nonrepeated
	     * character in the hashtable
	     */
	    return null;

	}

}
