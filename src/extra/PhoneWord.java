package extra;


import java.util.ArrayList;
import java.util.List;

/**
 * I Find all possible words for given phone number.
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class PhoneWord {

  public static void main(String[] args) {
    int[] phoneNumber = {7,2,3,2};
    printAllPhoneWords(phoneNumber, 0, new StringBuilder());
  }

  public static void printAllPhoneWords(int[] phoneNumber, int position, StringBuilder sb){
    if(phoneNumber.length == position){
      System.out.println(sb);
    }else{
      int currentNumber = phoneNumber[position];
      List<Character> possibleChars = getLetter(currentNumber);
      for(Character c: possibleChars){
        sb.append(c);
        printAllPhoneWords(phoneNumber, position + 1, sb);
        sb.setLength(sb.length() -1);
      }
    }
  }
  private static List<Character> getLetter(int number) {
    List<Character> possibleChars = new ArrayList<Character>(4);
    switch (number) {
      case 1:
      case 0:
        possibleChars.add(Character.forDigit(number, 10));
        break;
      case 2:
        possibleChars.add('A');
        possibleChars.add('B');
        possibleChars.add('C');
        break;
      case 3:
        possibleChars.add('D');
        possibleChars.add('E');
        possibleChars.add('F');
        break;
      case 4:
        possibleChars.add('G');
        possibleChars.add('H');
        possibleChars.add('I');
        break;
      case 5:
        possibleChars.add('J');
        possibleChars.add('K');
        possibleChars.add('L');
        break;
      case 6:
        possibleChars.add('M');
        possibleChars.add('N');
        possibleChars.add('O');
        break;
      case 7:
        possibleChars.add('P');
        possibleChars.add('Q');
        possibleChars.add('R');
        possibleChars.add('S');
        break;
      case 8:
        possibleChars.add('T');
        possibleChars.add('U');
        possibleChars.add('V');
        break;
      case 9:
        possibleChars.add('W');
        possibleChars.add('X');
        possibleChars.add('Y');
        possibleChars.add('Z');
        break;
    }
    return possibleChars;
  }
}
