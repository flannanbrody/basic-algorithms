package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * Write a method to sort an array of strings so that all the anagrams 
 * are next to each other.
 */
public class Anagrams_Array_Sort_Next_Each_Other {
    public static void main(String args[]){
        ArrayList<String> list = new ArrayList<String>();
        list.add("tom");
        list.add("8790");
        list.add("mot");
        list.add("0978");
        list.add("omt");
        list.add("tomcat");
        list.add("cattom");
        list.add("abc");
        list.add("9780");
        list.add("tomcat");
        list.add("978");
        list.add("897");
        anagramSort(list);
        System.out.println(list);
    }
    
    public static void anagramSort(ArrayList<String> list){
        //important!
        Collections.sort(list, new AnagramComparator());
    }
}
 
 
class AnagramComparator implements Comparator<String>{
    
    public int compare(String s1, String s2){
        return sort(s1).compareTo(sort(s2));
    }
    
    public static String sort(String s){
        char[] array = s.toCharArray();
        //important!
        Arrays.sort(array);
        String result = new String(array);
        return result;
        
    }
}