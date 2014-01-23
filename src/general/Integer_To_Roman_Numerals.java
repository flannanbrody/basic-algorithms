package general;

import java.util.LinkedHashMap;
import java.util.Map;

public class Integer_To_Roman_Numerals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i < 256; i++) {
			System.out.println("i=" + i + " -> " + RomanNumerals(i));
			System.out.println("Roman to Integer" + romanConvert("CCLIV"));
		}
	}

	public static String RomanNumerals(int Int) {
		LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
		roman_numerals.put("M", 1000);
		roman_numerals.put("CM", 900);
		roman_numerals.put("D", 500);
		roman_numerals.put("CD", 400);
		roman_numerals.put("C", 100);
		roman_numerals.put("XC", 90);
		roman_numerals.put("L", 50);
		roman_numerals.put("XL", 40);
		roman_numerals.put("X", 10);
		roman_numerals.put("IX", 9);
		roman_numerals.put("V", 5);
		roman_numerals.put("IV", 4);
		roman_numerals.put("I", 1);
		String res = "";
		for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) {
			int matches = Int / entry.getValue();
			res += repeat(entry.getKey(), matches);
			Int = Int % entry.getValue();
		}
		return res;
	}

	public static String repeat(String s, int n) {
		if (s == null) {
			return null;
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static int romanConvert(String roman) {
		int decimal = 0;

		String romanNumeral = roman.toUpperCase();
		for (int x = 0; x < romanNumeral.length(); x++) {
			char convertToDecimal = roman.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal += 1000;
				break;

			case 'D':
				decimal += 500;
				break;

			case 'C':
				decimal += 100;
				break;

			case 'L':
				decimal += 50;
				break;

			case 'X':
				decimal += 10;
				break;

			case 'V':
				decimal += 5;
				break;

			case 'I':
				decimal += 1;
				break;
			}
		}
		if (romanNumeral.contains("IV")) {
			decimal -= 2;
		}
		if (romanNumeral.contains("IX")) {
			decimal -= 2;
		}
		if (romanNumeral.contains("XL")) {
			decimal -= 10;
		}
		if (romanNumeral.contains("XC")) {
			decimal -= 10;
		}
		if (romanNumeral.contains("CD")) {
			decimal -= 100;
		}
		if (romanNumeral.contains("CM")) {
			decimal -= 100;
		}
		return decimal;
	}
}
