package string;

import java.util.ArrayList;
//Result = [abcdef, bacdef, bcadef, bcdaef, bcdeaf, bcdefa, acbdef, .....];
public class Print_All_Permutations_String {

    public static void main(String args[]){
        System.out.print(getAllPermutations("abcdef"));
    }
    
    public static ArrayList<String> getAllPermutations(String input){
        if(input == null)
            return null;
        ArrayList<String> result = new ArrayList<String>();
        
        if(input.length() == 0){
            result.add("");
            return result;
        }
        
        char c = input.charAt(0);
        String remainder = input.substring(1);
        ArrayList<String> intermediate = getAllPermutations(remainder);
        /*
         * Toward the end intermediate has 2 items in it..{{bc},{cb}}...we the place 'a' at every position in both
         * eg, {'a'bc}, {b'a'c}, {bc'a'}....same for {'a'cb} {c'a'b} {cb'a'} == [abc, bac, bca, acb, cab, cba]
         */
        for(String s : intermediate){                
            for(int i = 0 ; i <= s.length(); i++){
                String r = insertCharAt(s, c, i);
                result.add(r);
            }
        }
        return result;
    }
    
    public static String insertCharAt(String s, char c, int index){
        String s1 = s.substring(0, index);
        String s2 = s.substring(index);
        return s1 + c + s2;
    }

}
