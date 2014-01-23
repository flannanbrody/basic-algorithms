package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordMash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>(Arrays.asList(
		        "A", "AFRICA", "AN", "LANE", "PAN", "PANT", "PLANET", "PLANT"
		));
		WordMash mash = new WordMash(dictionary);

		System.out.println(mash.mash("planet"));
		System.out.println(mash.mash("pant"));


		System.out.println(mash.mash("foo"));
		System.out.println(mash.mash("lane"));
		System.out.println(mash.mash("africa"));
	}

    private final Set<String> dictionary;

    public WordMash(Set<String> dictionary) {
        if (dictionary == null) throw new IllegalArgumentException("dictionary == null");
        this.dictionary = dictionary;
    }

    public List<String> mash(String word) {
        return recursiveMash(new ArrayList<String>(), word.toUpperCase());
    }

    private List<String> recursiveMash(ArrayList<String> wordStack, String proposedWord) {
        if (!dictionary.contains(proposedWord)) {
            return null;
        }
        wordStack.add(proposedWord);

        if (proposedWord.length() == 1) {
            return wordStack;
        }

        for (int i = 0; i < proposedWord.length(); i++) {
            String nextProposedWord = 
                proposedWord.substring(0, i) + proposedWord.substring(i + 1, proposedWord.length());    
            List<String> finalStack = recursiveMash(wordStack, nextProposedWord);
            if (finalStack != null) return finalStack;
        }

        return null;
    }
}
