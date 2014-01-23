package extra;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string of numbers and a number of multiplication operators, 
   what is the highest number one can calculate? You must use all operators
   You cannot rearrange the string. You can only use the multiplication operators to calculate a number.

   E.g. String = "312" , 1 multiplication operator

   You can do 3*12 = 36 or 31*2= 62. The latter obviously being the right answer.
 */
public class BiggestNumberMultiply {

	private static class NumberSplit {
		String[] numbers;
		long result;

		NumberSplit(String[] numbers) {
			this.numbers = numbers.clone();
			result = 1;
			for (String n : numbers) {
				result *= Integer.parseInt(n);
			}
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (String n : numbers) {
				sb.append(n).append("*");
			}
			sb.replace(sb.length() - 1, sb.length(), "=").append(result);
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		String numbers = "312";
		int numMults = 1;

		int numSplits = numMults;

		List<NumberSplit> splits = new ArrayList<NumberSplit>();
		splitNumbersRecursive(splits, new String[numSplits + 1], numbers,
				numSplits);
		NumberSplit maxSplit = splits.get(0);
		for (NumberSplit ns : splits) {
			System.out.println(ns);
			if (ns.result > maxSplit.result) {
				maxSplit = ns;
			}
		}
		System.out.println("The maximum is " + maxSplit);
	}

	private static void splitNumbersRecursive(List<NumberSplit> list,
			String[] splits, String numbers, int numSplits) {
		if (numSplits == 0) {
			splits[splits.length - 1] = numbers;
			return;
		}
		for (int i = 1; i <= numbers.length() - numSplits; i++) {
			splits[splits.length - numSplits - 1] = numbers.substring(0, i);
			splitNumbersRecursive(list, splits, numbers.substring(i),
					numSplits - 1);
			list.add(new NumberSplit(splits));
		}
	}
}
