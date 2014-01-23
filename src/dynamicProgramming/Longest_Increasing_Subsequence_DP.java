package dynamicProgramming;

/*
 * {2, 6, 4, 5, 1, 3}
 * #1:2 [2] [6]   [4]   [5]     [1] [3]
 * 
 * 			6>2
 * 
 * #2:6 [2] [2,6] [4]   [5]     [1] [3]
 * 
 * 				  4>2
 * 
 * #3:4 [2] [6]   [2,4] [5]     [1] [3]
 * 
 * 						5>4
 * 
 * #4:5 [2] [6]   [4]   [2,4,5] [1] [3]
 * 
 * 								1 is smaller
 * 
 * #5:1 [2] [6]   [4]   [5]     [1] [3]
 * 
 * 									3>2
 * 
 * #6:3 [2] [6]   [4]   [5]     [1] [2,3]
 * 
 * 						^
 * 						|
 * 				LIS [2, 4, 5]
 * 
 * Dosen't account for duplicates...not counted....{2,6,4,4,5,1,3};....output 2, 4, 5
 */
public class Longest_Increasing_Subsequence_DP {
 	public static void main(String[] args) {
       	int[] nums = {2,6,4,5,1,3};
       	printLIS(nums);
 	}
 	//define the key method to print longest increasing subsequence
 	public static void printLIS(int[] nums) {
       	// in order to use DP in this example, we need
       	//1. a size array to keep track of longest LIS ending with current position
       	//2. an accordingly string array to keep track of the path for printing out
       	String[] paths = new String[nums.length];
       	int[] sizes = new int[nums.length];
       	
       	//firstly we assign the initial values to each path/size, by setting size
       	//to 1 and path equals the value (that means initially each path starting/ending
       	//with its current position
       	for(int i=0; i<nums.length; i++) {
            	sizes[i] = 1;
            	paths[i] = nums[i] + " ";//we add a space for separation
       	}
       	
       	//before we start the loop, 
       	//we define a support variable called maxLength to keep track
       	int maxLength = 1;//notice it is 1, but it really does not matter if sets to 0
       	
       	for(int i=1; i<nums.length; i++) { 
       			//notice we start from 2nd postion, 1st position is no point
            	for(int j=0; j<i; j++) { //the inner loop is to check all previous items!
                 	//now it's the key step, 
            		//when do we append our current index to the previous subsequence?
                 	//it has to meet 2 requirements, 
            		//current>previous ending and size is increasing!
                 	if(nums[i]>nums[j] && sizes[i] < sizes[j]+1) { //notice plus one!!
                       	//if so, we need update sizes and path
                       	sizes[i] = sizes[j]+1;
                       	paths[i] = paths[j] + nums[i] + " ";//append current values to end!
                       	//also update the maxLength if necessary
                       	if(maxLength < sizes[i])
                            	maxLength = sizes[i];
                 	}
            	}
       	}
       	
       	//finally go scanning the size array again and print out the path when size matches
       	for(int i=1; i<nums.length; i++) {
            	if(sizes[i] == maxLength)
                 	System.out.println("LIS: "+paths[i]);
       	}
       	//please notice we did not break whenever a max length found, 
       	//because it may not be the only one longest increasing subsequence. 
       	//The only definitive thing is the length of LIS, btw.
 	}
}
