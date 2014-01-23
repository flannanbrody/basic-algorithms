package dynamicProgramming;

import java.util.*;

/*
 * What is the difference between the solution for n = Sand the solution for n = 2?Let's look at this more deeply:
	P(2) - {}, {aj, {a2}, {aaJ a2}
	P(3) = {}, (aj, {aj, {a3}, {aa, a2}, {a^ a3}, {a2, a3},
	{aj, a2, a3}
	The difference between these solutions is that P(2) is missing all the subsets containing ar
	P(3) -P(2)={aj,{3lJ a,},{a2J a3},{a,,a2,a3}
	How can we use P ( 2 ) to create P( 3)? We can simply clone the subsets in P ( 2 ) and add a3 to them:
 */
public class Return_All_Subsets_Of_A_Set {

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); 
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());
		
		ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
		System.out.println(subsets2.toString());		
	}

}
