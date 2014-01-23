package bitwise;

public class BitwiseOperations {

	  public static void main(String args[]) {
	    int n = 8;
	    int n1 = 4;

	    // LEFT shift - n * (2 pow k)
	    System.out.printf("8 << 2 is %d.\n", n << 2);

	    // RIGHT shift - n / (2 pow k)
	    System.out.printf("8 >> 2 is %d.\n", n >> 2);

	    // unsinged RIGHT shift - n / (2 pow k)
	    System.out.printf("-8 >>> 2 is %d.\n", -n >>> 2);

	    // AND  - 
	    System.out.printf("8 & 2 is %d.\n", n & n1);

	    // OR  - 
	    System.out.printf("8 | 2 is %d.\n", n | n1);

	    // XOR  - 
	    System.out.printf("8 ^ 2 is %d.\n", n ^ n1);

	    // ~  - 
	    System.out.printf("~8 is %d.\n", ~n);



	  }
	}
