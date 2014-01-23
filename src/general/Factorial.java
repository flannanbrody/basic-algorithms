package general;

/*************************************************************************
 *  Compilation:  javac Factorial.java
 *  Execution:    java Factorial N
 *
 *  Reads in a command-line argument N, and prints N! = 1 * 2 * ... * N
 *  to standard output.
 *
 *  % java Factorial 0
 *  1
 *
 *  % java Factorial 1
 *  1
 *
 *  % java Factorial 5
 *  120
 *
 *  % java Factorial 12
 *  479001600
 *
 *  % java Factorial 20
 *  2432902008176640000
 *
 *  % java Factorial -10
 *  java.lang.RuntimeException: Underflow error in factorial
 *
 *  % java Factorial 21
 *  java.lang.RuntimeException: Overflow error in factorial
 *
 *
 *  Remarks
 *  -------
 *   - Would overflow a long if N > 20
 *   - Need to use extended precision arithmetic to handle bigger factorials
 *   
 *   factorial(5) 
	   factorial(4) 
	      factorial(3) 
	         factorial(2) 
	            factorial(1) 
	               return 1 
	            return 2*1 = 2 
	         return 3*2 = 6 
	      return 4*6 = 24 
	   return 5*24 = 120
 *
 *************************************************************************/

public class Factorial {

    public static void main(String[] args) {
        long N = Long.parseLong("5");
        System.out.println(factorial(N));
        
        displayFactorial();
    }
    
    // return n!
    // precondition: n >= 0 and n <= 20
    public static long factorial(long n) {
        if      (n <  0) throw new RuntimeException("Underflow error in factorial");
        else if (n > 20) throw new RuntimeException("Overflow error in factorial");
        else if (n == 0) return 1;
        else             return n * factorial(n-1);
    }
    
    public static long factorial2(long number){
    	if(number <= 1){
    		return 1;
    	}else{
    		return number * factorial(number - 1);
    	}
    }
    
    public static void displayFactorial(){
    	for(int counter = 0; counter <= 10;counter++){
    		System.out.printf("%d! = %d\n", counter, factorial2(counter));
    	}
    }

}
