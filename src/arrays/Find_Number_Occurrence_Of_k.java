package arrays;

public class Find_Number_Occurrence_Of_k {

	// Binary search
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6,
				6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 8, 9 };
		// note, to invoke the method from main method, specify the startIndex=0
		// and endIndex = length-1
		System.out.println("Occurance of num 2 is " + getOccurrence(2, numbers, 0, numbers.length - 1));
		System.out.println("Occurance of num 6 is "+ getOccurrence(6, numbers, 0, numbers.length - 1));
	}

	// we define start and end indexes for recursive calls in future invocation
	public static int getOccurrence(int k, int[] numbers, int startIndex, int endIndex) {
		// firstly check if we need proceed by comparing start/end index
		// this is usually the first step for writing a recursive method to
		// determine when to stop
		if (endIndex < startIndex)
			return 0;
		// now before we use binary search similar strategy, we check the
		// sub-array to determine if we need do so
		if (numbers[startIndex] > k)// which means even smallest value is larger  than k
			return 0;
		if (numbers[endIndex] < k)// which means largest element is smaller than k
			return 0;
		if (numbers[startIndex] == k && numbers[endIndex] == k)// if all elements are k
			return endIndex - startIndex + 1;

		// now we have a sub-array which may possibily contain some ks
		int midInd = startIndex + (endIndex - startIndex) / 2;
		if (numbers[midInd] == k)
			return 1 + getOccurrence(k, numbers, startIndex, midInd - 1)
					+ getOccurrence(k, numbers, midInd + 1, endIndex);
		else if (numbers[midInd] > k)// only smaller half may contain k
			return getOccurrence(k, numbers, startIndex, midInd - 1);
		else
			// only bigger half may contain k
			return getOccurrence(k, numbers, midInd + 1, endIndex);
	}
}
