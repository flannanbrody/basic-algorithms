package linkedList;

import static java.util.Arrays.asList;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a linked list where in addition to the next pointer, each node has a child pointer, which may or may not point to a separate list. 
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in below 
 * figure.You are given the head of the first level of the list. Flatten the list so that all the nodes appear in a single-level linked 
 * list. You need to flatten the list in way that all nodes at first level should come first, then nodes of second level, and so on.
 * 
 * origional:[[1], 2, [[3, 4], 5], [[[]]], [[[6]]], 7, 8, []]
 * flatten: [1, 2, 3, 4, 5, 6, 7, 8]
 */
public final class Flatten_Multi_Level_SinglyLinkedList {

	public static void main(String[] args) {
		List<Object> treeList = list(list(1), 2, list(list(3, 4), 5), list(list(list())), list(list(list(6))), 7, 8, list()); //[[1], 2, [[3, 4], 5], [[[]]], [[[6]]], 7, 8, []]
		List<Object> flatList = flatten(treeList);
		System.out.println(treeList);
		System.out.println("flatten: " + flatList);
	}

	//var-args
	private static List<Object> list(Object... item) {
		return asList(item);
	}

	public static List<Object> flatten(List<?> list) {
		List<Object> retVal = new LinkedList<Object>();
		flatten(list, retVal);
		return retVal;
	}

	public static void flatten(List<?> fromTreeList, List<Object> toFlatList) {
		for (Object item : fromTreeList) {
			if (item instanceof List<?>) {
				flatten((List<?>) item, toFlatList);
			} else {
				toFlatList.add(item);
			}
		}
	}
}
