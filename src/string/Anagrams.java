package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] s = {"cat", "act", "dog", "god", "xxx", "xxxx"};
		System.out.println(anagrams(s));

	}

	public static ArrayList<String> anagrams(String[] strs) {
		Map<String, ArrayList<String>> map = new HashMap<>();

		ArrayList<String> result = new ArrayList<>();

		if (strs.length < 2)
			return result;

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			char array[] = s.toCharArray();
			Arrays.sort(array);
			String t = new String(array);
			if (!map.containsKey(t)) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				map.put(t, list);
			} else {
				map.get(t).add(s);
			}
		}

		for (String str : map.keySet()) {
			if (map.get(str).size() > 1) {
				for (String v : map.get(str)) {
					result.add(v);
				}
			}
		}
		return result;

	}
}
