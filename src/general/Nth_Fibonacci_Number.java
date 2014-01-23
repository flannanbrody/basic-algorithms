package general;

public class Nth_Fibonacci_Number {

    public static void main(String args[]){
        System.out.println(getFibonacci(45));
    }
    
    public static int getFibonacci(int n){
        int fib[] = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < fib.length ; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n-1];
    }

}
