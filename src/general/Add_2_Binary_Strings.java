package general;

public class Add_2_Binary_Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addBinary("10000", "1110")); //16 + 14 = 30 (11110)
	}

    public static String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int la = a.length();
        int lb = b.length();
        
        int max = Math.max(la, lb);
        
        StringBuilder sum = new StringBuilder("");
        int carry = 0;
        
        for(int i = 0; i < max; i++){
            int m = getBit(a, la - i - 1);
            int n = getBit(b, lb - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }
        
        if(carry == 1)
            sum.append("1");
        
        return sum.reverse().toString();
        
    }
    
    public static int getBit(String s, int index){
        if(index < 0 || index >= s.length())
            return 0;
        
        if(s.charAt(index) == '0')
            return 0;
        else
            return 1;
        
    }
}
