package extra;

public class AddTwoLargeNumbers {

	public static void main(String[] args) {
		addTwoLargeNumbers("9999", "99146");

		addTwoLargeNumbers("111111111111111", "444444444444444");

	}

	private static void  addTwoLargeNumbers(String number1, String number2){
		int min = number1.length() < number2.length() ? number1.length() : number2.length();
		int max = number1.length() < number2.length() ? number2.length() : number1.length();
		
		int[] number1Array = new int[max];
		int[] number2Array = new int[max];
		
		System.out.println("max is " + max + ", min is " + min);
		
		/*
		 * Store the string in int[] array
		 * In a[0] I store the LSD (least significant digit)
		 */
		for(int i = 0; i < number1.length(); i++){
			number1Array[i] = number1.charAt(number1.length() - 1 - i) -48;
		}
		
		System.out.println(number1);
		
		for(int i = 0; i < number2.length(); i++){
			number2Array[i] = number2.charAt(number2.length() - 1 - i) -48;
		}
		
		System.out.println(number2);
		
		int carry = 0;
		
		int[] sum = new int[max+1];
		
		for(int k = 0; k < max; k++){
			sum[k] = (number1Array[k] + number2Array[k] + carry) % 10;
			if(number1Array[k] + number2Array[k] + carry >= 10){
				carry = 1;
			}else{
				carry = 0;
			}
		}
		
		sum[max] = carry;
		System.out.println("\n");
		for(int j = max; j >= 0; j--){
			System.out.printf("%d ", sum[j]);
		}
	}
}
