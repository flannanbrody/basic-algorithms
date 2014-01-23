package string;
/*
 * Assume you have a method isSubstring which checks if one word is a substring of 
 * another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using 
 * only one call to isSubstring (i e , ???waterbottle??? is a rotation of ???erbottlewat???) 
 */
public class Is_SubString {

	public static void main(String args[]){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(isSubString(s1, s2));
		System.out.println(isSubString(s1 + s1, s2));
		
	}
	
	public static boolean isSubString(String s1, String s2){
		int i;
		i = s1.indexOf(s2);
		return i >= 0;	
	}

}
