package general;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		String string1 = "a string";
		set.add(string1);
		
		Iterator<String> iterator = set.iterator();

		while(iterator.hasNext()){
		  System.out.println("HashSet value is " + iterator.next());
		}
		
		System.out.println();
		for(String aString : set) {
		    System.out.println(aString);
		}
		
		
        HashSet<String> hs = new HashSet<String>();
        //add elements to HashSet
        hs.add("first");
        hs.add("second");
        hs.add("third");
        System.out.println(hs);
        System.out.println("Is HashSet empty? "+hs.isEmpty());
        hs.remove("third");
        System.out.println(hs);
        System.out.println("Size of the HashSet: "+hs.size());
        System.out.println("Does HashSet contains first element? "+hs.contains("first"));
        
        //How to copy Set content to another HashSet
        HashSet<String> subSet = new HashSet<String>();
        subSet.add("s1");
        subSet.add("s2");
        hs.addAll(subSet);
        System.out.println("HashSet content after adding another collection:");
        System.out.println(hs);
        
        //delete all elements
        hs.clear();
        System.out.println("Content After clear:");
        System.out.println(hs);
        
        //Copy hashSet too array
        //add elements to HashSet
        hs.add("first");
        hs.add("second");
        hs.add("third");
        System.out.println("HashSet content: ");
        System.out.println(hs);
        String[] strArr = new String[hs.size()];
        hs.toArray(strArr);
        System.out.println("Copied array content:");
        for(String str:strArr){
            System.out.println(str);
        }
        
        //How to compare two sets and retain elements which are same on both sets
        hs.add("first");
        hs.add("second");
        hs.add("third");
        hs.add("apple");
        hs.add("rat");
        System.out.println(hs);
        HashSet<String> subSet2 = new HashSet<String>();
        subSet2.add("rat");
        subSet2.add("second");
        subSet2.add("first");
        hs.retainAll(subSet);
        System.out.println("HashSet content:");
        System.out.println(hs);
        
        hs.remove(subSet2);
	}

}
