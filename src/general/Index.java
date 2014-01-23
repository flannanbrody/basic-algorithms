package general;

/*************************************************************************
 *  Compilation:  javac Index.java
 *  Execution:    java Index i j < input.txt
 *  Dependencies: BST.java Queue.java StdIn.java StdOut.java
 *  Data files:   http://www.cs.princeton.edu/introcs/44st/TaleOfTwoCities.java
 *
 *  Create an index of all words in the given input file such that
 *  the word has length >= i and occurs >= j times.
 *
 *  % java Index 9 30 < TaleOfTwoCities.txt 
 *  confidence: 2794 23064 25031 34249 47907 48268 48577 ... 
 *  courtyard: 11885 12062 17303 17451 32404 32522 38663 ... 
 *  evremonde: 86211 90791 90798 90802 90814 90822 90856 ... 
 *  expression: 3777 5575 6574 7116 7195 8509 8928 15015 ... 
 *  gentleman: 2521 5290 5337 5698 6235 6301 6326 6338 ... 
 *  influence: 27809 36881 43141 43150 48308 54049 54067 ... 
 *  monseigneur: 85 90 36587 36590 36611 36636 36643 ... 
 *  prisoners: 1012 20729 20770 21240 22123 22209 22590 ... 
 *  something: 3406 3765 9283 13234 13239 15245 20257 ... 
 *  sometimes: 4514 4530 4548 6082 20731 33883 34239 ... 
 *  vengeance: 56041 63943 67705 79351 79941 79945 80225 ...
 *
 *************************************************************************/

public class Index {
/*    public static void main(String[] args) {
        int minLength     = Integer.parseInt(args[0]);    // min length of word
        int minOccurrence = Integer.parseInt(args[1]);    // min number of occurrences

        // read in the words from stdin
        String[] words = StdIn.readAll().split("\\s+");

        // build symbol table of words and locations
        BST<String, Queue<Integer>> st = new BST<String, Queue<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() < minLength) continue;
            if (!st.contains(s)) {
                st.put(s, new Queue<Integer>());
            }
            Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }
        for (String s : st) { 
            Queue<Integer> q = st.get(s);
            if (q.length() >= minOccurrence) {
                StdOut.println(s + ": " + q);
            }
        } 
    } */
	
	/*************************************************************************
	 *  Compilation:  javac Lookup.java
	 *  Execution:    java Lookup file.csv keyField valField
	 *  Dependencies: BST.java In.java StdIn.java
	 *  Data files:   http://www.cs.princeton.edu/introcs/44st/amino.csv
	 *                http://www.cs.princeton.edu/introcs/44st/ip.csv
	 *                http://www.cs.princeton.edu/introcs/44st/DJIA.csv
	 *  
	 *  Reads in a set of key-value pairs from a two-column CSV file
	 *  specified on the command line; then, reads in keys from standard
	 *  input and prints out corresponding values.
	 * 
	 *  % java Lookup amino.csv 0 3      % java Lookup ip.csv 0 1 
	 *  TTA                              www.google.com 
	 *  Leucine                          216.239.41.99 
	 *  ABC                               
	 *  Not found                        % java Lookup ip.csv 1 0 
	 *  TCT                              216.239.41.99 
	 *  Serine                           www.google.com 
	 *                                 
	 *  % java Lookup amino.csv 3 0      java Lookup DJIA.csv 0 1 
	 *  Glycine                          29-Oct-29 
	 *  GGG                              252.38 
	 *                                   20-Oct-87 
	 *                                   1738.74
	 *
	 *************************************************************************/

/*	public class Lookup {
	    public static void main(String[] args) {
	        In in = new In(args[0]);
	        int keyField = Integer.parseInt(args[1]);
	        int valField = Integer.parseInt(args[2]);
	        String[] database = in.readAll().split("\n");
	        StdRandom.shuffle(database);
	        BST<String, String> st = new BST<String, String>();
	        for (int i = 0; i < database.length; i++) {
	            String[] tokens = database[i].split(",");
	            String key = tokens[keyField];
	            String val = tokens[valField];
	            st.put(key, val);
	        }

	        while (!StdIn.isEmpty()) {
	            String s = StdIn.readString();
	            if (st.contains(s)) StdOut.println(st.get(s));
	            else                StdOut.println("Not found");
	        }
	    }
	}*/
}
