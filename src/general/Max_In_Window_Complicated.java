package general;

import java.util.Deque;
import java.util.LinkedList;
 
public class Max_In_Window_Complicated {
    public static void main(String args[]){
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7, 8};
        int b[] = slidingWindowMaximum(arr, 3);
        for(int i = 0; i< b.length ; i++){
            System.out.print(b[i]+ " ");
        }
    }
    
    public static int[] slidingWindowMaximum(int arr[], int w){
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] b = new int[arr.length - w + 1];
        
        for(int i = 0; i < w; i++){
            while(deque.size() != 0 && arr[deque.peekLast()] < arr[i])
                deque.removeLast();
            deque.addLast(i);
        }
        
        for(int i = w; i< arr.length; i++){
            b[i - w] = arr[deque.peekFirst()];
            if(deque.peekFirst() <= i -w)
                deque.removeFirst();
            while(deque.size() != 0 && arr[deque.peekLast()] < arr[i])
                deque.removeLast();
            deque.addLast(i);
        }
        b[arr.length - w] = arr[deque.peekFirst()];
        return b;
        
    }
}
