package string;

/*
 * Binary search
 * 
 * Given a sorted array of strings which is interspersed with empty strings, 
 * write a meth- od to find the location of a given string.
    Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] 
    will return 4 
    Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] 
    will return -1
 */
 
public class Find_String_In_Array {
    public static void main(String args[]){
        String s[] = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(s, "ball"));
        System.out.println(findString(s, "ballcar"));
        System.out.println(findString(s, "car"));
        System.out.println(findString(s, ""));
    }
    
    public static int findString(String[] a, String x){
        if(a.length == 0 || x == null)
            return -1;
        if(x == ""){
            for(int i = 0 ; i < a.length; i++){
                if(a[i] == "")
                    return i;
            }
            return -1;
        }
        return findString(a, x, 0, a.length - 1);
    }
    
    public static int findString(String[] a, String x, int low, int high){
        while(low <= high){
            while(low <= high && a[high] == ""){
                high--;
            }
            while(low <= high && a[low] == ""){
                low++;
            }
            
            int mid = (low + high) / 2;
            
            while(a[mid] == ""){
                mid++;
            }
            if(a[mid].compareTo(x) == 0){
                return mid;
            }else if (a[mid].compareTo(x) < 0){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}