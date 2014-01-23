package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run_Length_Encoding {
	
	public static void main(String[] args) {
		String example = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		System.out.println(encode(example));
		System.out.println(decode("3W1B1W1B1W1B1W1B1W1B1W1B1W1B"));
	}
	
	public static String encode(String source) {
		StringBuilder dest = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;
			while (i + 1 < source.length() && source.charAt(i) == source.charAt(i + 1)) {
				runLength++;
				i++;
			}
			dest.append(runLength);
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}

	public static String decode(String source) {
		StringBuffer dest = new StringBuffer();
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			int number = Integer.parseInt(matcher.group());
			matcher.find();
			while (number-- != 0) {
				dest.append(matcher.group());
			}
		}
		return dest.toString();
	}
}
