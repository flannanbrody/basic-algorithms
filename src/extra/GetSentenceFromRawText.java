package extra;

import java.util.HashMap;
import java.util.Stack;

/*
 String [] tokens = {"from", "waterloo", "hi", "am", "as", "stud", "yes", "i", "a", "student"};
 String text = "iamastudentfromwaterloo";


 Lets create a hashtable named tokenMap which will contain all the token of tokens array.

 We will also have 2 stacks, lets say indexStack to keep track of starting index of all the matched tokens in text 
 (this will become clear below .. keep on reading :)) And another stack resultStack which will store all the tokens 
 of the final expected sentence.

 We will also have a StringBuffer sb which will keep track of substring from text which would be a candinate token 
 (we will verify that by checking in hashtable tokenMap)

 Now,
 We will read one character at a time from "text"
 StringBuffer sb = "i";
 Our start index = 0
 Lets push index onto indextStack
 sb = "i" is present in the hashtable tokenMap, so now we have following
 indexStack = 0 -> null
 resultStack = "i" -> null

 we now reset sb = "";
 Next we see sb = "a"
 "a" is in tokenMap so now we have following
 indexStack = 1 -> 0 -> null;
 resultStack = "a" -> "i" -> null

 Now things get interesting as we keep on reading the characters from text and appending to sb but the string is not 
 there in hashtable tokenMap like sb = "mastudent" ...So we need to decide to backtrack in such case (logic can be if 
 sb length goes beyond max length of any of the given tokens in tokens array)

 So when we backtrack we pop the stacks and reset StringBuffer sb
 indexStack = 0 -> null
 resultStack = "i" -> null
 sb = "";

 now again we start appending characters to sb till sb has a match in tokenMap HashTable

 We keep repeating the above steps till we have constructed our sentence or till we decide its NOT possible to do so.
 */
public class GetSentenceFromRawText {
	public static HashMap<String, Boolean> tokenMap = new HashMap<String, Boolean>();
	public static Integer MAX_TOKEN_LEN = 0;

	public static void main(String[] args) {

		String[] tokens = { "from", "waterloo", "hi", "am", "as", "stud",
				"yes", "i", "a", "student" };
		String text = "iamastudentfromwaterloo";

		initTokenMap(tokens);
		String sentence = getSentence(text);
		System.out.println("Max Token Length: " + MAX_TOKEN_LEN);
		System.out.println("Sentence is: " + sentence);
	}

	public static String getSentence(String text) {
		if (null == text) {
			return text;
		}

		int textLen = text.length();

		int index = 0;
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		int resultLen = 0;
		int start = 0;
		Stack<Integer> indexStack = new Stack<>();
		Stack<String> resultStack = new Stack<>();
		while (index < textLen) {
			sb.append(text.charAt(index));

			if (tokenMap.containsKey(sb.toString())) {
				if (flag) {
					resultStack.push(sb.toString());
					resultLen += sb.length();
					indexStack.push(start);
					start = index + 1;
					sb = new StringBuffer();
				} else {
					flag = true;
				}
			}
			++index;

			if ((sb.length() > MAX_TOKEN_LEN)
					|| ((index == textLen) && (resultLen < textLen))) {
				index = indexStack.pop();
				resultStack.pop();
				sb = new StringBuffer();
				flag = false;
			}
		}
		return printResultStack(resultStack);
	}

	public static String printResultStack(Stack<String> stack) {
		if (null == stack || stack.isEmpty()) {
			return null;
		}
		Stack<String> resultStack = new Stack<>();
		while (!stack.isEmpty()) {
			resultStack.push(stack.pop());
		}
		StringBuffer sb = new StringBuffer();

		while (!resultStack.isEmpty()) {
			sb.append(resultStack.pop() + " ");
		}
		// System.out.println("Result: " + sb.toString());
		return sb.toString();
	}

	public static void initTokenMap(String[] tokens) {
		if (null == tokens) {
			return;
		}
		int len = tokens.length;

		for (int i = 0; i < len; i++) {
			tokenMap.put(tokens[i], true);
			if (tokens[i].length() > MAX_TOKEN_LEN) {
				MAX_TOKEN_LEN = tokens[i].length();
			}
		}
	}
}
