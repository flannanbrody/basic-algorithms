package general;

class GCD{
    public static void main(String[] args)
    {
        System.out.println("GCD Calculation"); // Display the string.
        System.out.println("GCD of 60 & 24 is: " + calculateGCD(60,24));
        System.out.println("GCD of 31415 & 14142 is: " + calculateGCD(31415,14142));
    }

    public static int calculateGCD(int m, int n)
        {
                // Computes GCD by Euclid's Algorithm
                // Input : Two non negative, non zero integers m & n
                // Output : GCD of m & n
                while(n!=0)
                {
                        if(m % n == 0)
                                return n;
                        else
                                return calculateGCD(n ,m % n);
                }
                return 0;
        }
}
