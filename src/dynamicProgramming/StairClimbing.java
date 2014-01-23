package dynamicProgramming;

/*
 * Recursive way
 * --At any time with N steps left, you can choose
 * 		1. One step and finish the remaining N-1 steps
 * 		2. Two Steps and finish N-2 steps
 * 		3. Three steps and finish N-3 steps
 * 
 * Optimization (iteration way)
 * -- Recursion works, but inefficient
 * 		-- Tow-down recursion recalculates smaller steps
 * -- Using iteration to solve the problem from bottom up
 * 		-- Remember the necessary stpes for a fixed number of steps
 */
class StairClimbing 
{
	//now we create a test case
	public static void main(String[] args)
	{
		//now let's see the performance difference using larger case and count time used
		long startTime = System.currentTimeMillis();
		System.out.println("Ways of 35-steps: (recursive) "+ways(35));
		System.out.println("Time used (recursive)"+(System.currentTimeMillis()-startTime));

		startTime = System.currentTimeMillis();//update time for start of iterative method
		System.out.println("Ways of 35-steps: (interation) "+waysInteration(35));
		System.out.println("Time used (iterative)"+(System.currentTimeMillis()-startTime));

		//same result, but the optimized method has much better performance
		//this is one of the simplest example to show the power of dynamic programming (DP)
	}

	//firstly we implement the recursive way without optimization
	//this method process the problrm in a top-down manner
	public static int ways(int n)
	{
		//firstly check if n<=3 because they are basic cases
		if(n==1) return 1;//climb 1 step
		if(n==2) return 2;//(1+1) or (2)
		if(n==3) return 4;//1+1+1, 1+2, 2+1, 3
		return ways(n-1)+ways(n-2)+ways(n-3);//this is the key, and this is why I say this is similar to fibonacci problem
	}

	//all right the second method is the same idea but from a bottom-up manner
	public static int waysInteration(int n)
	{
		//similary we check if it meets basic cases
		if(n==1) return 1;//climb 1 step
		if(n==2) return 2;//(1+1) or (2)
		if(n==3) return 4;//1+1+1, 1+2, 2+1, 3
		//now we process the problem by using additional memory to remember the steps for stairs less than n
		//we only need to remember the most recent 3 cases for most space efficiency
		int[] prev = {1,2,4};//these are the basic cases
		int current = 3;//we only come here when n>3
		while(current<n)
		{
			//we need update the previous three steps!
			int preTotal = prev[0] + prev[1] + prev[2];
			//and we update prev[0] with original prev[1] and further
			prev[0] = prev[1];
			prev[1] = prev[2];
			prev[2] = preTotal;//we need update the most recent with the total sum of previous three
			//we forgot the update current
			++current;
		}
		//after the loop, current equal n and the last value in the memory array is what we want!
		return prev[2];
	}
}

