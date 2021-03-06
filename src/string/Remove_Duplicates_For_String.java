package string;

import java.util.Arrays;

/*
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * 
 */
public class Remove_Duplicates_For_String {

	public static void main(String args[]){
		String s = "111212aabbbccccddddddeeefffffggg";
		char[] input = s.toCharArray();
		char[] input2 = s.toCharArray();
		Arrays.sort(input);
		removeDup(input);
		System.out.println(input);
		System.out.println();
		removeDupInplace(input2);
		System.out.println(input2);
	}
	
	public static void removeDupInplace(char[] a) {
		if (a.length <= 1)
			return;

		int i = 0, j = 0;

		while (++i < a.length) {
			if (a[j] != a[i])
				a[++j] = a[i];
		}

		while (++j < a.length)
			a[j] = 0;

	}
	
	public static void removeDup(char[] data){
		int len = data.length;
		if(len < 2)
			return;
		int i,j;
		int tail = 1;
		
		for(i = 1; i < len; i++){
			for(j = 0; j < tail; j++){
				if(data[i] == data[j])
					break;
			}
			if(j == tail){
				data[tail] = data[i]; //[1, 2, 3, 4, 5, a, b, c, d, e, f, g, b, b, b, c, c, c, c, d, d, d, d, d, d, e, e, e, f, f, f, f, f, g, g, g]
				tail++;
			}
		}
		
		//Just clears all space after unique too the end..[1, 2, 3, 4, 5, a, b, c, d, e, f, g,  ,  ,  ,  ,  ,  ,  , d, d, d, d, d, d, e, .....]
		for(i = tail; i < len; i++)
			data[i] = '\0';      
	}

}
