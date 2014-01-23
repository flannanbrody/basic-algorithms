package general;

import java.util.Hashtable;

public class Frequency_Of_Word_In_Book {
	public static Hashtable<String, Integer> setupDictionary(String[] book) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (word.trim() != "") {
				if (!table.containsKey(word)) {
					table.put(word, 0);
				}
				table.put(word, table.get(word) + 1);
			}
		}
		return table;
	}
	public static int getFrequency(Hashtable<String, Integer> table, String word) {
		if (table == null || word == null) {
			return -1;
		}
		word = word.toLowerCase();
		if (table.containsKey(word)) {
			return table.get(word);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String[] wordlist = getLongTextBlobAsStringList();
		Hashtable<String, Integer> dictionary = setupDictionary(wordlist);
		
		String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
		for (String word : words) {
			System.out.println(word + ": " + getFrequency(dictionary, word));
		}
	}
	
	public static String[] getLongTextBlobAsStringList() {
		return getLongTextBlob().split(" ");
	}
	
	public static String getLongTextBlob() {
		String book = "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit. " +
		"Soon Lara spotted other landmarks—an outcropping of limestone beside the path that had a silhouette like a man’s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight." +
		"Lara had been back and forth along the river path many times in her short life. Her people had not created the path—it had always been there, like the river—but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara’s people were salt traders, and their livelihood took them on a continual journey. ";
		String book_mod = book.replace('.', ' ').replace(',', ' ').replace('-', ' ');
		return book_mod;
	}
	
}
