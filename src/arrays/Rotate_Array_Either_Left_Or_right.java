package arrays;

public class Rotate_Array_Either_Left_Or_right {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 8, 11, 14, 17, 20 };
		int shift = 2;
		System.out.println("Origional list");
		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
		rotateRight(a, shift);
		System.out.println("Right rotation with shift " + shift);
		for (int i : a) {
			System.out.print(" " + i);
		}
		System.out.println();
		rotateLeft(a, shift);
		System.out.println("Left rotation with shift " + shift);
		for (int i : a) {
			System.out.print(" " + i);
		}

	}

	public static void rotateRight(int[] array, int amount) {
		int N = array.length - 1;
		for (int j = 0; j < amount; j++) {
			int a = array[N];
			int i;
			for (i = N; i > 0; i--){
				array[i] = array[i - 1];  //bump everything down.. we hold onto a[N] = 20...then insert at beginning ...[1, 3, 5, 7, 8, 11, 14, 17, 17]
			}
			array[i] = a;
		}
	}

	public static void rotateLeft(int[] array, int amount) {
		int N = array.length - 1;
		for (int j = 0; j < amount; j++) {
			int a = array[0];
			int i;
			for (i = 0; i < N; i++)
				array[i] = array[i + 1];
			array[i] = a;
		}
	}

}
