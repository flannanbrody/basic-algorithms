package string;

import java.util.StringTokenizer;

public class String_Reverse {
	public static void main(String args[]){
		String s = "this is a demo test!";
		String word = "hello";
		System.out.println(reverse(s));
		
		reverseLetterInWord(word);
		reverseALineOFText(s);
		reverseStringBuilder(s);
	}
	
	//"this is a demo test!" --> !tset omed a si siht
	public static String reverse(String input){
		char[] data = input.toCharArray();
		int i = 0;
		int j = data.length - 1;
		char temp;
		
		while(i < j){
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			i++;
			j--;
		}
		
		String s = new String(data);
		return s;
	}
	
	//hello --> olleh
	public static void reverseLetterInWord(String word){
		StringBuilder reverse = new StringBuilder();
		char temp[] = word.toCharArray();
		int len = word.length();
		for(int i = len - 1; i >= 0; i--){
			reverse.append(temp[i]);
		}
		System.out.println("Reversing letters in " + word + " is : " + reverse.toString());
	}
	
	//"this is a demo test!" --> test! demo a is this 
	public static void reverseALineOFText(String strLine){
		StringTokenizer tokenizer = new StringTokenizer(strLine, " ");
		String stringReversedLine = "";
		while(tokenizer.hasMoreTokens()){
			stringReversedLine = tokenizer.nextToken() + " " + stringReversedLine;
		}
		System.out.println("Reversed line is : " + stringReversedLine);
	}
	
	//"this is a demo test!" --> siht si a omed !tset 
	public static void reverseStringBuilder(String word){
		for(String part: word.split(" ")){
			System.out.print(new StringBuilder(part).reverse().toString());
			System.out.print(" ");
		}
	}
}