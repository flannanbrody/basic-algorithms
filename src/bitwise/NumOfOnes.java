package bitwise;

public class NumOfOnes {

    public int numOfOnes(int n){
            int count = 0;
            while(n!=0){
            if((n & 1) ==1){
                    count++;
            }
            n >>=1;
            }
            return count;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
            // TODO Auto-generated method stub
            NumOfOnes result = new NumOfOnes();
            System.out.print(result.numOfOnes(10));
    }

}
