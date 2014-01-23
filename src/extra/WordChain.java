package extra;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/*
 * 
 Write a program that accepts start and end words and, using words from the dictionary, builds a word chain between them. 
 For added programming fun, return the shortest word chain that solves each puzzle. For example, path from "lead" to "gold" 
 is four steps (lead, load, goad, gold). Turning "ruby" into "code" takes six steps (ruby, rubs, robs, rods, rode, code), 
 while turning "code" into "ruby" (again in six steps).

 Approach:
 let the starting word be "S" and the ending word be "E".
 load the dictionary in a list.
 Put "S" in a Queue.
 parentMap.put("S","null");

 While (!Queue.isEmpty()) {
 word "U" = Queue.remove();
 if ("U" is visited) then continue;
 now starting from "U" do a breadth first traversal, ie, iterate through the dictionary and push all the words "V" which 
 are 1 letter apart from "U" and update their parent as "U". 
 parentMap.put("V","U");
 if ("V" == "E") { PrintWordChain("V"); }
 mark "U" as visited.
 }


 PrintWordChain("V") {
 String T = "";
 while ((T = parentMap.get("V")) != null) {
 print T;
 V = T;
 }
 }


 Dictionary taken as input:
 http://www.scrabble.org.au/words/fours.htm 


 Code input:
 LEAD GOLD


 Code output:
 Max length of word chain: 12
 GOLD GELD YELD TELD MELD MEND FEND FEED HEED DEED LEED LEAD 
 Length of shortest word chain: 4
 GOLD GOAD LOAD LEAD 
 Printing all the word chains: 
 GOLD GOAD LOAD LEAD 
 GOLD GELD YELD TELD MELD MEND FEND FEED HEED DEED LEED LEAD 
 GOLD HOLD HILD HIED HAED HEED DEED LEED LEAD 




 Code input:
 RUBY CODE


 Code Output:
 Max length of word chain: 11
 CODE COTE CITE CETE CATE CARE CAKE CUKE CUBE RUBE RUBY 
 Length of shortest word chain: 5
 CODE RODE RUDE RUBE RUBY 
 Printing all the word chains: 
 CODE RODE RUDE RUBE RUBY 
 CODE COKE CAKE CUKE CUBE RUBE RUBY 
 CODE CORE CIRE CERE CARE CAKE CUKE CUBE RUBE RUBY 
 CODE COTE CITE CETE CATE CARE CAKE CUKE CUBE RUBE RUBY 
 CODE LODE RODE RUDE RUBE RUBY 
 CODE MODE LODE RODE RUDE RUBE RUBY 
 CODE BODE MODE LODE RODE RUDE RUBE RUBY 
 */
public class WordChain {
	private static List<String> wordList = new ArrayList<String>();
	private static Map<String, Integer> visitMap = new HashMap<String, Integer>();
	private static Queue<String> activeQ = new LinkedList<String>();
	private static Map<String, String> parentMap = new HashMap<String, String>();
	private static Map<Integer, Stack<String>> wordChainMap = new HashMap<Integer, Stack<String>>();
	private static Integer wordChainCount = 0;
	private static int shortestWordChain = Integer.MAX_VALUE;
	private static int longestWordChain = Integer.MIN_VALUE;
	private static int longestChainIndex = 0;
	private static int shortestChainIndex = 0;

	public static void main(String[] args) {
		readWordFile();
		// printWordList();
		String[] inputWords = readInput();
		wordChainFinder(inputWords);
		System.out.println();
		printWordChains();
	}

	public static void wordChainFinder(String[] words) {
		if (words == null) {
			return;
		}
		String start = words[0];
		String end = words[1];

		activeQ.add(start);
		while (!activeQ.isEmpty()) {
			String first = activeQ.remove();
			if (visitMap.containsKey(first)) {
				continue;
			}
			Iterator<String> it = wordList.iterator();
			while (it.hasNext()) {
				String second = it.next();
				if (!visitMap.containsKey(second)) {
					boolean isPath = isOneLetterApart(first, second);
					if (isPath) {
						// System.out.println(second);
						activeQ.add(second);
						parentMap.put(second, first);
						if (second.compareTo(end) == 0) {
							storeValidWordChain(second);
						}
					}
				}
			}
			visitMap.put(first, 1);
		}

	}

	private static void storeValidWordChain(String target) {
		++wordChainCount;
		Stack<String> stack = new Stack<String>();
		String word = "";
		// System.out.print(target + " ");
		stack.push(target);
		while ((word = parentMap.get(target)) != null) {
			// System.out.print(word + " ");
			target = word;
			stack.push(target);
		}
		// System.out.println();
		int chainLength = stack.size();
		if (chainLength > longestWordChain) {
			longestWordChain = chainLength;
			longestChainIndex = wordChainCount;
		}
		if (chainLength < shortestWordChain) {
			shortestWordChain = chainLength;
			shortestChainIndex = wordChainCount;
		}
		wordChainMap.put(wordChainCount, stack);
	}

	public static void printWordChains() {
		// System.out.println(wordChainMap.toString());
		System.out.println("Max length of word chain: " + longestWordChain);
		Stack<String> stack = wordChainMap.get(longestChainIndex);
		printStack(stack);
		System.out.println("Length of shortest word chain: "
				+ shortestWordChain);
		stack = wordChainMap.get(shortestChainIndex);
		printStack(stack);

		System.out.println("Printing all the word chains: ");
		Iterator mapIter = wordChainMap.entrySet().iterator();
		while (mapIter.hasNext()) {
			Map.Entry<Integer, Stack<String>> pair = (Map.Entry<Integer, Stack<String>>) mapIter
					.next();
			stack = pair.getValue();
			printStack(stack);
		}
	}

	private static void printStack(Stack<String> stack) {
		if (null == stack) {
			return;
		}
		Iterator<String> it = stack.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	private static boolean isOneLetterApart(String first, String second) {
		int len = first.length();
		int diff = 0;
		for (int i = 0; i < len; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				++diff;
			}
		}
		return (diff == 1) ? true : false;
	}

	public static String[] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] inputStrs = br.readLine().split(" ");
			return inputStrs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void readWordFile() {
		try {
			FileInputStream fileStream = new FileInputStream(
					"FourLetterWords.txt");
			DataInputStream in = new DataInputStream(fileStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String sline = "";
			while ((sline = br.readLine()) != null) {
				String[] sArr = sline.split(" ");
				int len = sArr.length;
				for (int i = 0; i < len; i++) {
					wordList.add(sArr[i]);
				}
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	public static void printWordList() {
		Iterator<String> it = wordList.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}
