package extra;

import java.util.HashMap;

/*
 Reorder 1st string based on 2nd string.
 eg: (tractor,car)


 output: carrtto or carrott or carrtot. The order of letters not in common doesn't matter.


 Approach:
 1. go through each character of string "car" and create a HashMap<Character, Integer> charMap. 
 Character is for each character in the string "car" and Integer is for the index of the corresponding character.
 HashMap will look like this:
 c => 0
 a => 1
 r => 2


 2. Now go through each character for "tractor" and separate out the characters present in charMap and rest of the stuff.
 first char is "t" which is not there in charMap, so append it in rbuff = "t".


 "r" is present in charMap with index 2, so append it in another hashMap<Integer, StringBuffer> smap, where integer is the index of "r" and StringBuffer will store the characters of index "2" - since "r" may be repeated in first string ie "tractor".
 smap looks like now:
 2 => "r"


 "a" is present in charMap with index 1, so store it in the smap
 smap looks like now:
 2 => "r"
 1 => "a"


 "c" is present in the charMap with index 0, so store it in the smap.
 smap:
 2 => "r"
 1 => "a"
 0 => "c"


 "t" is not present in charMap so append it to rbuff.
 rbuff is now:
 "tt"


 "o" is not present in charMap, so append it to the rbuff.
 rbuff = "tto"


 "r" is present in the charMap with index 2, so store it in the smap.
 smap:
 2 => "rr"
 1 => "a"
 0 => "c"


 Now itererator through all the keys in smap in increasing order and append to result string.
 result = "carr".
 append rbuff="tto" to result string.
 now we have the final answer as:
 "carrtto";


 code input/output:
 First String: tractor
 Second String: car
 Reordered String: carrtto
 */
public class Reorder {

	public static void main(String[] args) {
		String first = "tractor";
		String second = "car";
		reorderStrings(first, second);
		System.out.println("First String: " + first);
		System.out.println("Second String: " + second);
		System.out
				.println("Reordered String: " + reorderStrings(first, second));
	}

	public static String reorderStrings(String first, String second) {
		if (null == first || null == second) {
			return first;
		}

		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int slen = second.length();
		for (int i = 0; i < slen; i++) {
			charMap.put(second.charAt(i), i);
		}

		HashMap<Integer, StringBuffer> smap = new HashMap<Integer, StringBuffer>();
		StringBuffer rbuff = new StringBuffer();

		int flen = first.length();
		for (int i = 0; i < flen; i++) {
			char ch = first.charAt(i);
			Integer index = charMap.get(ch);
			if (null != index) {
				StringBuffer sb = smap.get(index);
				if (null == sb) {
					sb = new StringBuffer();
				}
				sb.append(ch);
				smap.put(index, sb);
			} else {
				rbuff.append(ch);
			}
		}
		// System.out.println(rbuff.toString());
		// System.out.println(smap.toString());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < slen; i++) {
			sb.append(smap.get(i));
		}
		sb.append(rbuff.toString());

		return sb.toString();

	}

}
