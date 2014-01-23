package extra;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Given a valid sentence without any spaces between the words and a dictionary of valid english words, find the individual words in the sentence. For example, "therearesome" -> "there are so me" "somewordshiden" -> "so me words hi den"
 Solution

 We start scanning the sentence from left. As we find a valid word we need to check whether the rest of the sentence can make valid words or not. Because in some situations the first found word from left side can leave a remaining portion which is not further separable. So in that case we should come back and leave the current found word and keep on searching for the next word. And this process is recursive because to find out whether the right portion is separable or not, we need the same logic. So we will use recursion and backtracking to solve this problem. To keep track of the found words we will use a stack. Whenever the right portion of the string does not make valid words, we pop the top string from stack and continue finding.
 */
public class SeparateWordsInSentence {
	public static void main(String[] args) {
		String sentence = "therearesomewordshiddenhere";
		String[] dictionary = { "the", "a", "i", "here", "so", "hid", "there",
				"are", "some", "word", "words", "hid", "hi", "hidden", "he",
				"here", "her", "rear", "me", "den" };
		String[] words = getSeparatedWords(sentence, dictionary);
		for (String word : words)
			System.out.println(word);

	}

	private static String[] getSeparatedWords(String sentence,
			String[] dictionary) {
		Set<String> validWords = new HashSet<String>();
		for (String validWord : dictionary)
			validWords.add(validWord);
		Stack<String> words = new Stack<String>();
		if (isSeparable(sentence, validWords, 0, words)) {
			return words.toArray(new String[] {});
		}
		return null;
	}

	private static boolean isSeparable(String sentence, Set<String> validWords,
			int startIndex, Stack<String> foundWords) {
		if (startIndex == sentence.length())
			return true;
		boolean hasWord = false;
		for (int i = startIndex + 1; i <= sentence.length(); ++i) {
			String currentSubstring = sentence.substring(startIndex, i);
			if (validWords.contains(currentSubstring)) {
				foundWords.push(currentSubstring);
				if (isSeparable(sentence, validWords, i, foundWords)) {
					hasWord = true;
					break;
				}
				foundWords.pop();
			}
		}
		if (!hasWord)
			return false;
		return true;
	}
}
