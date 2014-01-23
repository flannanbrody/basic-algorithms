package general;

import java.util.Arrays;
import java.util.ArrayList;

public class Three_Sum_To_Zero {
	public static void main(String args[]) {
		int arr[] = { -7, 8, 9, 2, -3, -5, 3, 2, 5, 1, 2, -4 };
		System.out.println(getThreeSum(arr));
	}

	public static ArrayList<ArrayList<Integer>> getThreeSum(int[] num) {
		Arrays.sort(num);
		if (num.length < 3) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int k = 0; k <= num.length - 3; k++) {
			int i = k + 1;
			int j = num.length - 1;
			while (i < j) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[k]);
					list.add(num[i]);
					list.add(num[j]);
					result.add(list);
					i++;
					j--;

				} else if (sum < 0) {
					i++;
				} else {
					j--;
				}
			}
		}
		return result;

	}
}
