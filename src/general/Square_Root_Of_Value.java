package general;

public class Square_Root_Of_Value {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Square root of 25 is = " + sqrt(25));

	}

    public static int sqrt(int x) {

        long low = 0;
        long high = x;
        while(low <= high){
            long mid = low + (high - low) / 2;
            long result = mid * mid;
            if(result == x){
                return (int)mid;
            } else if(result > x){
                high = mid - 1;
            } else{
                
                low = mid + 1;
            }
        }
        return (int)high;    
    }
}
