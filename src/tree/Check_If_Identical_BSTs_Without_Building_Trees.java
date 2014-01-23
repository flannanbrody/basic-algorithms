package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * According to BST property, elements of left subtree must be smaller and
 * elements of right subtree must be greater than root. 
 * 
 * Two arrays represent same BST if for every element x, the elements in left and right subtrees
 * of x appear after it in both arrays. And same is true for roots of left
 * and right subtrees. The idea is to check if next smaller and greater
 * elements are same in both arrays. Same properties are recursively checked
 * for left and right subtrees. The idea looks simple, but implementation
 * requires checking all conditions for all elements. Following is an
 * interesting recursive implementation of the idea.
 * 
	 Example 1:
		a[] = {2, 4, 1, 3} will construct following tree.
		   2
		 /  \
		1    4
		    /
		   3
		b[] = {2, 4, 3, 1} will also also construct the same tree.
		   2
		 /  \
		1    4
		    /
		   3 
		So the output is "True"
		
		Example 2:
		a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13}
		b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13}
		
		They both construct the same following BST, so output is "True"
		           15
		         /    \
		       5       19
		     /  \        \
		    1    11        27
		        /   \     /
		       7     13  25 
		       
 */
public class Check_If_Identical_BSTs_Without_Building_Trees {

	public static void main(String[] args) {
		Integer a[] = { 15, 5, 11, 1, 7, 13, 19, 27, 25 };
		Integer b[] = { 15, 19, 27, 5, 11, 7, 1, 13, 25 };

		/*
		 * 1. We traverse the array and find all possible children of each index
		 * 2. Were going to iterate thro a[0...N]...and create a list of all possible children at that index...a[index]
		 *     -- inner loop....from current index + 1 too end and check if its a child...isChild(inputArray, possibleFather, possibleChild, index)
		 *     -- isChild method....goes thro a loop...starting at root...and checks is possibleFather and possibleChild....if yes..then adds them too list.
		 *     
		 */
		//firstChildList = [[5, 11, 1, 7, 13, 19, 27, 25], [11, 1, 7, 13], [7, 13], [], [], [], [27, 25], [25], []]
		//secondChildList =	[[19, 27, 5, 11, 7, 1, 13, 25], [27, 25], [25], [11, 7, 1, 13], [7, 13], [], [], [], []]
		List<List<Integer>> firstChildList = getChildrenOfArray(a);
		List<List<Integer>> secondChildList = getChildrenOfArray(b);

		System.out.println(firstChildList + "\n" + secondChildList);

		// Now compare children of one array element
		for (int i = 0; i < a.length; i++) {
			List<Integer> childrenInArray1 = firstChildList.get(i);
			List<Integer> childrenInArray2 = secondChildList.get(indexOf(a[i], b));

			if (firstChildList.size() == secondChildList.size()) {
				Iterator<Integer> iter = childrenInArray1.iterator();

				while (iter.hasNext()) {
					if (!childrenInArray2.contains(iter.next())) {
						System.out.println("not same bst");
						return;
					}
				}

			} else {
				System.out.println("not same bst");
				return;
			}

		}

		System.out.println(" same bst");
	}

	public static List<List<Integer>> getChildrenOfArray(Integer[] inputArray) {
		List<List<Integer>> childList = new ArrayList<>();

		// we traverse the array and find all possible children of each index

		for (int i = 0; i < inputArray.length; i++) {
			List<Integer> child = getChildrensOfAnIndex(inputArray, i);
			childList.add(child);
		}
		return childList;
	}

	/**
	 * Finding the children of specific index. For this we need to traverse from
	 * index+1 to the end of the inputArray. And checking at each index whether
	 * the given element can be child or not.
	 * 
	 * @param inputArray
	 * @param index
	 * @return
	 */
	private static List<Integer> getChildrensOfAnIndex(Integer[] inputArray, int index) {
		List<Integer> child = new ArrayList<Integer>();
		int possibleFather = inputArray[index];

		for (int startIndex = index + 1; startIndex < inputArray.length; startIndex++) {
			int possibleChild = inputArray[startIndex];

			if (isChild(inputArray, possibleFather, possibleChild, index)) {
				child.add(inputArray[startIndex]);
			}
		}
		return child;
	}

	/**
	 * An element will be child if it is on the same side(i.e either
	 * greater/less ) while traversing from the root i.e is index 0.
	 * 
	 * @param originalArray
	 * @param possibleFather
	 * @param possibleChild
	 * @return
	 */

	private static boolean isChild(Integer[] originalArray, int possibleFather, int possibleChild, int fatherIndex) {

		//We traverse from root and see are they on the same side
		for (int startIndex = 0; startIndex < fatherIndex; startIndex++) {

			if (originalArray[startIndex] > possibleChild && originalArray[startIndex] > possibleFather) {
				// both child and its father should be either less then ie. on left side.
			} else if (originalArray[startIndex] < possibleChild && originalArray[startIndex] < possibleFather) {
				// both child and its father should be either greater then ie. on right side.
			} else {
				return false;
			}
		}
		return true;
	}

	private static int indexOf(Integer element, Integer[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].equals(element)) {
				return i;
			}
		}
		return 0;
	}

}
