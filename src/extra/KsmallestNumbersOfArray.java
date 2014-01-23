package extra;
import java.util.LinkedList;
import java.util.Queue;
//Implement a method which return the nth smallest number of a given array most efficient way
public class KsmallestNumbersOfArray {

        KsmallestNumbersOfArray() { }

        void ksmallestnumbersofarray (int[] input, int k) {
                if ( k >= input.length) {
                        print(input);
                } else {
                        Queue<Integer> n_holder = new LinkedList<Integer>();
                        for( int i = 0; i < k; i++) {
                                n_holder.add(input[i]);
                        }
                        int count = 0;
                        while (!n_holder.isEmpty()) {
                                for ( int j = k; j < input.length; j++) {
                                        if (n_holder.peek() < input[j] && count != k) {
                                                System.out.println(n_holder.remove());
                                                count++;
                                        } else {
                                                n_holder.remove();
                                                n_holder.add(input[j]);
                                        }
                                        }
                                if( count == k) { 
                                        break; 
                                }
                        }
                }
        }

        private void print(int[] input) {
                for( int i = 0; i < input.length; i++) {
                        System.out.println(input[i]);
                }
        }
        public static void main(String[] args) {
                KsmallestNumbersOfArray newsearch = new KsmallestNumbersOfArray();
                int[] myarray = new int[] { 2, 5, 9, 3, 0};
                newsearch.ksmallestnumbersofarray(myarray, 3);
        }

}
