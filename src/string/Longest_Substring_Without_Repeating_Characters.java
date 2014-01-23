package string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substrings 
 * without repeating characters for ABDEFGABEF are BDEFGA and DEFGAB, with length 6. For BBBB the longest substring 
 * is B, with length 1. For GEEKSFORGEEKS, there are two longest substrings shown in the below diagrams, with length 7.
 * 
 * The desired time complexity is O(n) where n is the length of the string.

 Method 1 (Simple)
 We can consider all substrings one by one and check for each substring whether it contains all unique characters or not. 
 There will be n*(n+1)/2 substrings. Whether a substirng contains all unique characters or not can be checked in linear 
 time by scanning it from left to right and keeping a map of visited characters. Time complexity of this solution would 
 be O(n^3).

 Method 2 (Linear Time)
 Let us talk about the linear time solution now. This solution uses extra space to store the last indexes of already 
 visited characters. The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating 
 Character Substring (NRCS) seen so far. Let the maximum length be max_len. When we traverse the string, we also keep 
 track of length of the current NRCS using cur_len variable. For every new character, we look for it in already processed 
 part of the string (A temp array called visited[] is used for this purpose). If it is not present, then we increase 
 the cur_len by 1. If present, then there are two cases:

 a) The previous instance of character is not part of current NRCS (The NRCS which is under process). In this case, we need 
 to simply increase cur_len by 1.
 b) If the previous instance is part of the current NRCS, then our current NRCS changes. It becomes the substring staring 
 from the next character of previous instance to currently scanned character. We also need to compare cur_len and max_len, 
 before changing current NRCS (or changing cur_len).
 */
public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		System.out.println("Longest SubString without repeated characters is : " + uniqueSubstring("GEEKSFORGEEKS"));
		System.out.println("Length of longest substring :" + lengthOfLongestSubstring("GEEKSFORGEEKS"));
	}

	//Result = Longest SubString without repeated characters is : EKSFORG
	public static String uniqueSubstring(String input) {
		String maxSubstring = "";
		String value = "";
		LinkedHashMap<String, String> temp = new LinkedHashMap<>();
		for (int i = 0; i < input.length(); i++) {
			boolean check = temp.containsKey(Character.toString(input.charAt(i)));
			if (check == false) {
				temp.put(Character.toString(input.charAt(i)), Character.toString(input.charAt(i)));
				value = value + input.charAt(i);
			} else {
				if (maxSubstring.length() < value.length())
					maxSubstring = value;
				int j = 0;
				while (value.charAt(j) != input.charAt(i)) {
					temp.remove(Character.toString(value.charAt(j)));
					j++;
				}
				int k = value.indexOf(input.charAt(i));
				value = value.substring(k + 1) + input.charAt(i);
			}
		}
		return maxSubstring;
	}
		
	//Result = Length of longest substring :7
	private static int lengthOfLongestSubstring(String input) {
	      int maxLen = 0;
	      Set<Character> characters = new HashSet<>();
	      for (int i = 0; i < input.length(); i++) {
	         Character c = input.charAt(i);
	         if (characters.contains(c)) {
	            maxLen = Math.max(maxLen, characters.size());
	            characters.clear();
	         } else {
	            characters.add(c);
	         }
	      }
	      return maxLen;
	   }
}
