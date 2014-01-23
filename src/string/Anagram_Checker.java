package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Write a method to decide if two strings are anagrams or not.
 */
public class Anagram_Checker {
	public static void main(String args[]){
		String s1 = "algorithm";
		String s2 = "logarithm";
		System.out.println("Output is : " + areAnagrams(s1,s2) );
		
        String s = "Mary";
        String t = "Army";
        System.out.println(anagram(s, t));
        System.out.println(anagram("Aarmy", t));
		
		String a = "tomcat  as";
		String b = " tamcots a";
		System.out.println(test(a, b));
	}
	
	/*
	 * First Method -- Simple sort and check
	 */
	public static boolean areAnagrams(String s1, String s2) {
	    char[] ch1 = s1.toCharArray();
	    char[] ch2 = s2.toCharArray();
	    Arrays.sort(ch1);
	    Arrays.sort(ch2);
	    return Arrays.equals(ch1,ch2);
	}
	
	/*
	 * Second Method -- Frequency Maps O(n)
	 */
	
	public static boolean anagram(String s, String t) {
        // Strings of unequal lengths can't be anagrams
        if(s.length() != t.length()) {
            return false;
        }

        // They're anagrams if both produce the same 'frequency map'
        return frequencyMap(s).equals(frequencyMap(t));
    }

    // For example, returns `{b=3, c=1, a=2}` for the string "aabcbb"
    private static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str.toLowerCase().toCharArray()) {
            Integer frequency = map.get(c);
            map.put(c, frequency == null ? 1 : frequency+1);
        }
        return map;
    }
	
    /*
     * Third Method 
     */
	public static boolean test(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		int i;
		int record[] = new int[255];
		int unique = 0;
		int num_completed = 0;
		char cs1[] = s1.toCharArray();
		
		for(char c: cs1){
			if(record[c] == 0)
				unique++;
			record[c]++;
		}
		
		for(i = 0; i < s2.length(); i++){
			char t = s2.charAt(i);
			if(record[t] == 0)
				return false;
			record[t]--;
			
			if(record[t] == 0){
				num_completed++;
				if(num_completed == unique)
					//it's a match if s2 has been fully processed
					return i == s2.length()-1;
			}
		}
		return true;
	}
}
