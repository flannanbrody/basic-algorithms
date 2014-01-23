package string;

/*
 * Write a method to replace all spaces in a string with ???%20???
 */
public class Replace_Space_In_word {
	public static void main(String args[]){
		System.out.println(replaceSpace("this is a demo test! "));
	}
	
	public static String replaceSpace(String input){
		char s[] = input.toCharArray();
		int spaceCount = 0;
		int index = 0;
		
		for(int i = 0; i < s.length; i++)
			if(s[i] == ' ')
				spaceCount++;
		
		int newLength = s.length + 2 * spaceCount;
		char r[] = new char[newLength];
		
		for(int i = 0 ; i < s.length; i++){
			if(s[i] != ' ')
				r[index++] = s[i];
			else{
				r[index++] = '%';
				r[index++] = '2';
				r[index++] = '0';
			}
		}
		String result = new String(r);
		return result;
	}
}
