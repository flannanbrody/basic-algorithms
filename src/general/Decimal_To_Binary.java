package general;

	/*
	 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary 
	 * representation. If the number can not be represented accurately in binary, print ???ERROR???
	 */
	public class Decimal_To_Binary {
		public static void main(String args[]){
			System.out.println(PrintBinaryOfDecimal("3.875"));
			System.out.println(PrintBinaryOfDecimal("13.5"));
			System.out.println(PrintBinaryOfDecimal(".5"));
		}
		
		public static String PrintBinaryOfDecimal(String input){
			
			if(input.indexOf('.') == -1){  // input is a integer
				int num = Integer.parseInt(input);
				String int_String = "";
				
				while(num > 0){
					int r = num % 2;
					num >>= 1;        // num????????????????????????????????????????????????
					int_String = r + int_String;
				}
	 
				return int_String;
				
			}else{
				//???????????????'.'	
				int intPart;
				if(input.indexOf('.') == 0) //?????????".5",".25"??????????????????intPart
					intPart = 0;
				else
					intPart = Integer.parseInt(input.substring(0, input.indexOf('.')));
				
				//???????????????????????????????????????'.'?????????????????????????????????
				double decPart = Double.parseDouble(input.substring(input.indexOf('.'), 
						input.length()));
				
				String int_String = "";
				while(intPart > 0){
					int r = intPart % 2;
					intPart >>= 1;
					int_String = r + int_String;
				}
				
				StringBuilder dec_String = new StringBuilder();
				
				while(decPart > 0){
					if(dec_String.length() > 32)
						return "ERROR";
					
					double r = decPart * 2;
					
					if(r >= 1){
						dec_String.append(1);
						decPart = r - 1;
					}else{
						dec_String.append(0);
						decPart = r;
					}
				}
				return int_String + "." + dec_String.toString();
			}
		}
	}