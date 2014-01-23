package arrays;

/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer 
 * at the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * Merging from the end.
 */
public class Merge_Two_Array_No_Extra_Space {
    public static void main(String args[]){
        int a[] = new int[100];
        int b[] = {3,5,7,9,11,13,15,16,88,99};
        for(int i = 0; i < 40; i++){
            a[i] = 2 * i;
        }
        merge(a, b, 40, b.length); //last 2 parameters are sizes of both arrays
        
        for(int i = 0; i < 40 + b.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    
    // m is the number of elements in a
    // n is the number of elements in b
    public static void merge(int a[], int b[], int m, int n){
        int last = m + n - 1; // index of last element in the "new" array
        int i = m - 1;      // index of last element in a
        int j = n - 1;      // index of last element in b
        
        while(i >=0 && j >= 0){
            if(a[i] > b[j]){
                a[last--] = a[i--];
            }else{
                a[last--] = b[j--];
            }
        }
        /*
         * we don't need to consider when j ==0 and i > 0
         * the reason is that all remaing elements in a[] are
         * already there;
         */
        while(j >= 0){
            a[last--] = b[j--];
        }
    }
}
