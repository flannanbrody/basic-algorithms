package general;

/*************************************************************************
 *  Compilation:  javac IntegerToBinary.java
 *  Execution:    java IntegerToBinary N
 *  
 *  Prints out the binary representation of N.
 *
 *  % java IntegerToBinary 8
 *  1000
 *
 *  % java IntegerToBinary 366
 *  101101110
 *
 *************************************************************************/

public class Integer_To_Binary {

   public static void convert(int n) {
      if (n == 0) return;
      convert(n / 2);
      System.out.print(n % 2);
   }

   public static void main(String[] args) {
      int N = Integer.parseInt("8");
      convert(N);
      System.out.println();
   }

}
