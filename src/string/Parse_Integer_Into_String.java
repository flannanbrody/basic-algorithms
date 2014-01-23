package string;

public class Parse_Integer_Into_String {

	/**
	 * In the ascii table, characters from '0' to '9' are contiguous. So, if you
	 * know that tmp.charAt(i) will return a character between 0 and 9, then
	 * subracting 0 will return the offset from zero, that is, the digit that
	 * that character represents.
	 * 
	 * char is an integer type that maps our letters to numbers a computer can
	 * understand (see an ascii chart). A string is just an array of characters.
	 * Since the digits are contiguous in ascii representation, '1' - '0' = 49 -
	 * 48 = 1, '2' - '0' = 50 - 48 = 2, etc.
	 */
	public static void main(String[] args) {
		String s = "12345";
		System.out.println(parseInteger(s));

	}
	
	//Math.pow ...Returns the value of the first argument raised to the power of the second argument. 
	public static  int parseInteger(String s){
		String tmp = s;
		int result = 0;
		for (int i = 0; i < tmp.length(); i++) {
			char digit = (char) (tmp.charAt(i) - '0');
			result += (digit * Math.pow(10, (tmp.length() - i - 1)));

		}

		return result;
	}

}
