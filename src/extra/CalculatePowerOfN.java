package extra;

public class CalculatePowerOfN {

	public static void main(String[] args) {
		int x = 2;
		int n = 8;
		
		System.out.println(" Power using linear solution : " +powerOfNLinear(x,n));
		
		System.out.println(" Power using divide & conquer : " + powerOfNDivideConquer(x, n));
	}

	//O(n)
	private static int powerOfNLinear(int x, int n) {
		int product = 1;
		for(int i = 1; i <= n; i++){
			product *= x;
		}
		
		return product;
	}
	
	/*
	 * log(n)
	 * 
	 * 2^8 = 2^4 * 2^4
	 * 2^4 = 2^2 * 2^2
	 * 2^2 = 2^1 * 2^1
	 * 
	 * 				
	 * 	 	    2^8
	 *         /   \
	 *      2^4	    2^4
	 *      / \     / \
	 *    2^2 2^2  2^2 2^2
	 *   /  \ /  \ / \ / \
	 * 2^1.................
	 * 
	 *   
	 */
	
	private static int powerOfNDivideConquer(int x, int n){
		int temp = 1;
		if(n == 0){
			return 1; 
		}
		temp = powerOfNDivideConquer(x, n/2);
		if(n % 2 == 0){
			return temp * temp;					//2^4 * 2^4
		}else{
			return x * temp *temp;				//2 * 2^4 * 2^4
		}
	}
}
