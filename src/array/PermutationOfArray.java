package array;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

	public <T> List<List<T>> generate(List<T> listOfItems) {

		List<List<T>> result = new ArrayList<List<T>>();

		if (listOfItems == null) {
			return null;
		}

		if (listOfItems.size() == 0) {
			return result;
		}

		if (listOfItems.size() == 1) {
			result.add(listOfItems);
			return result;
		}

		// take out one item from the list
		T pulledOutItem = listOfItems.get(0);

		// get the sub list without that "pulled out item"
		List<T> subList = listOfItems.subList(1, listOfItems.size());

		// this method will return the permutations for the remaining items
		List<List<T>> generatedListOfListOfItems = generate(subList);

		// for each permutation of items
		for (List<T> items : generatedListOfListOfItems) {
			// clone that items permutation and put the "pulled out item" at
			// each index location in the cloned permutation
			for (int i = 0; i <= items.size(); i++) {
				List<T> clonedItems = clone(items);
				clonedItems.add(i, pulledOutItem);
				result.add(clonedItems);
			}
		}

		return result;
	}

	public static void main(String... args) {
		List<Integer> listOfItems = new ArrayList<Integer>();
		listOfItems.add(1);
		listOfItems.add(2);
		listOfItems.add(3);
		List<List<Integer>> listOfListOfItems = new PermutationOfArray().generate(listOfItems);
		for (List<Integer> items : listOfListOfItems) {
			for (Integer item : items) {
				System.out.print(item + ",");
			}
			System.out.println("--");
		}
	}

	public <T> List<T> clone(List<T> list) {
		List<T> newList = new ArrayList<T>();
		newList.addAll(list);
		return newList;
	}
}