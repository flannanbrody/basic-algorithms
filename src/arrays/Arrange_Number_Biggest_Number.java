package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Arrange_Number_Biggest_Number {

	/**
	 * sorted array: 
	 * 60 
	 * 548 
	 * 546 
	 * 54 
	 * 
	 * BiggestNumber: 6054854654
	 */
	public static void main(String[] args) {
		Integer numbers[] = new Integer[] { new Integer(54), 546, 60, 548 };
/*		List<Integer> numbers = new ArrayList<>();
		numbers.add(new Integer(54));
		numbers.add(new Integer(546));
		numbers.add(new Integer(60));
		numbers.add(new Integer(548));*/
		
		for (int i : numbers) {
			System.out.println(i);
		}

		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer arg1, Integer arg2) {
				Integer i1 = arg1;
				Integer i2 =  arg2;
				String st1 = String.valueOf(i1).concat(String.valueOf(i2));
				String st2 = String.valueOf(i2).concat(String.valueOf(i1));
				System.out.println("st1= " + st1 + " st2 = " + st2);
				if (Integer.parseInt(st1) > Integer.parseInt(st2))
					return -1;
				return 1;
			}
		};

		Arrays.sort(numbers, comparator);
		System.out.println("sorted array: ");
		for (int i : numbers) {
			System.out.println(i);
		}
		System.out.println("BiggestNumber: ");
		for (int i : numbers) {
			System.out.print(i);
		}
	}

}
