package arrays;

/**
 * 
 * 	Base case is print out then currentSize == R || startIndex==array.length
 * 
 * 	We use two recursion..
 * 	-- first one does all the perms including the first one
 * 	-- second recusrion does all perms excluding the first one, then excluding the first two etc...
 * 	
 * 
 * 
 * Doesn't handle duplicates.
 * 
 * We create a temporary array ‘used[]‘ which stores all outputs one by one.
 * The idea is to start from startIndex (index = 0) in data[], one by one
 * fix elements at this index and recur for remaining indexes. Let the input
 * array be {1, 2, 3, 4, 5} and r be 3. We first fix 1 at index 0 in data[],
 * then recur for remaining indexes, then we fix 2 at index 0 and recur.
 * Finally, we fix 3 and recur for remaining indexes. When number of
 * elements in data[] becomes equal to r (size of a combination), we print
 * data[].
 * 
 * 	Fix the first and recurse do all perms that include the first
 * 		1 2 3 
		1 2 4 
		1 2 5 
		
		1 3 4 
		1 3 5 
		
		1 4 5 
	
	fix the second and recurse all perms
		2 3 4 
		2 3 5 
		
		2 4 5 
	
	Last all perms of 3rd..
		3 4 5 
 */

public class Print_All_SubArrays_Size_K {
	public static void main(String[] args) {
		//now, let's create a test case
		int[] array = { 1, 2, 3, 4, 5 };
		boolean[] used = new boolean[array.length];
		PrintAllSizeKSubset(array, used, 0, 0, 3);
		//expect, 12,13,14,23,24,34!
	}
	//we need four supportive data for recursion
	//1. info whether each index is used
	//2. current focus index
	//3. current size
	//4. size K
	static void PrintAllSizeKSubset(int[] array, boolean[] used, int startIndex, int currentSize, int K) {
		//firstly define when the recursion stops
		//case 1, the currentSize equals K, Current combination is ready to be printed
		if(currentSize==K) {
			for(int i=0; i<array.length; i++) {
				if(used[i])
					System.out.print(array[i]+" ");
			}
			System.out.println();//add a new line
			return;//do not forget to stop the recursion!
		}
		//case 2, focusIndex exceeds array length
		if(startIndex==array.length)
			return;
		//now it's the key recursion step firstly we select this index 
		used[startIndex] = true;
		PrintAllSizeKSubset(array,used,startIndex+1,currentSize+1,K);//key is +1
		//or 2nd option is to not using this index
		used[startIndex] = false;
		PrintAllSizeKSubset(array,used,startIndex+1,currentSize,K);
		//please notice index is increamented no matter we select or not!
	}
	
}


/*

[false, false, false, false, false]
[true, false, false, false, false]
[true, true, false, false, false]
[true, true, true, false, false]
print 123

[true, true, false, false, false]
[true, true, false, true, false]
print 124

[true, true, false, false, false]
[true, true, false, false, true]
print 125

[true, true, false, false, false]
//startIndex==array.length so return

[true, false, false, false, false]
[true, false, true, false, false]
[true, false, true, true, false]
print 134

[true, false, true, false, false]
[true, false, true, false, true]
print 135

[true, false, true, false, false]
//startIndex==array.length so return

[true, false, false, false, false]
[true, false, false, true, false]
[true, false, false, true, true]
print 145

[true, false, false, true, false]
//startIndex==array.length so return

[true, false, false, false, false]
[true, false, false, false, true]
//startIndex==array.length so return

[true, false, false, false, false]
[false, false, false, false, false]

[false, true, false, false, false]

//first recursion
 array = [1, 2, 3, 4, 5], 
 used = [false, false, false, false, false], 
 startIndex = 0, 
 currentSize = 0, 
 k = 3
	
	we set used = [true, false, false, false, false] and recurse
	 	array = [1, 2, 3, 4, 5], 
 		used = [true, false, false, false, false], 
 		startIndex = 1, 
 		currentSize = 1, 
 		k = 3

		we set used = [true, true, false, false, false] and recurse
	 		array = [1, 2, 3, 4, 5], 
 			used = [true, true, false, false, false], 
 			startIndex = 2, 
 			currentSize = 2, 
 			k = 3

			we set used = [true, true, true, false, false] and recurse
	 			array = [1, 2, 3, 4, 5], 
 				used = [true, true, true, false, false], 
 				startIndex = 3, 
 				currentSize = 3, 
 				k = 3

				print 1 2 3 

			//Return from recursion
	 		array = [1, 2, 3, 4, 5], 
 			used = [true, true, false, false, false],      //set used[startIndex] = false and recurse
 			startIndex = 2, 
 			currentSize = 2, 
 			k = 3

					//Second recursion
	 				array = [1, 2, 3, 4, 5], 
 					used = [true, true, false, true, false],      
 					startIndex = 3, 
 					currentSize = 2, 
 					k = 3

	 					array = [1, 2, 3, 4, 5], 
 						used = [true, true, false, true, false],      
 						startIndex = 4, 
 						currentSize = 3, 
 						k = 3
	
						print 1 2 4

					//Return from recursion
	 				array = [1, 2, 3, 4, 5], 
 					used = [true, true, false, false, false],      //set used[startIndex] = false and recurse
 					startIndex = 3, 
 					currentSize = 2, 
 					k = 3

	 					array = [1, 2, 3, 4, 5], 
 						used = [true, true, false, false, true],      
 						startIndex = 4, 
 						currentSize = 2, 
 						k = 3

	 						array = [1, 2, 3, 4, 5], 
 							used = [true, true, false, false, true],      
 							startIndex = 5, 
 							currentSize = 3, 
 							k = 3
	
							print 1 2 5

						//Return from recursion
	 					array = [1, 2, 3, 4, 5], 
 						used = [true, true, false, false, false],      //set used[startIndex] = false and recurse
 						startIndex = 4, 
 						currentSize = 2, 
 						k = 3

							//case 2, focusIndex exceeds array length….so return
	 						array = [1, 2, 3, 4, 5], 
 							used = [true, true, false, false, false],      //set used[startIndex] = false and recurse
 							startIndex = 5, 
 							currentSize = 2, 
 							k = 3


			array = [1, 2, 3, 4, 5], 
 			used = [true, true, false, false, false], 
 			startIndex = 1, 
 			currentSize = 1, 
 			k = 3

			//set used[startIndex] = false 

			array = [1, 2, 3, 4, 5], 
 			used = [true, false, false, false, false], 
 			startIndex = 1, 
 			currentSize = 1, 
 			k = 3

				//recurse
				array = [1, 2, 3, 4, 5], 
 				used = [true, false, true, false, false],  //set used[startIndex] = false and recurse
 				startIndex = 2, 
 				currentSize = 1, 
 				k = 3

*/