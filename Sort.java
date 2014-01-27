package sorting;

/*
 * Variety of sorting Algorithms
 */

public class Sort {
	
	/*
	 * Bubble Sort : we compare adjacent elements, and swap if neccessary.
	 * Each pass through the list we make n-1 comparisons
	 * On the first pass, the largest element moves to the end of the list
	 * since it would be swapped with every element it was compared against
	 * On ith pass, the ith largest element is put in its position. 
	 * After n passes, we are sorted
	 * O(n^2)
	 */
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	/*
	 * Same as regular bubble sort, except if any pass through
	 * the entire array results in no swaps, we exit the function.
	 */
	public static int[] modBubbleSort(int[] arr) {
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					flag = true;
				}
			}
		}
		return arr;
	}
	
	/*
	 * MergeSort: recursively sorts the list. Breaks the list down into sublists
	 * and sorts each sublist. Then, merges the two sorted sublists together.
	 * O(nlogn), since there are logn + 1 levels of recursion (2^logn = n), 
	 * and n instructions at each level.
	 */
	public static int[] mergeSort(int[] arr) {
		if(arr.length < 2)
			return arr;
		int length = arr.length;
		int[] left = new int[length/2];
		int[] right;
		if(length % 2 != 0)
			right = new int[length/2 + 1];
		else
			right = new int[length/2];
		for(int i = 0; i < length; i++) {
			if(i < length/2)
				left[i] = arr[i];
			else
				right[i - length/2] = arr[i];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		arr = merge(left,right);
		
		return arr;
	}
	
	/*
	 * Auxilary function to merge two sorted lists
	 */
	
	private static int[] merge(int[] left, int[] right) {
		int length = left.length + right.length;
		int[] result = new int[length];
		int l_index = 0;
		int l_max = left.length;
		int r_index = 0;
		int r_max = right.length;
		for(int i = 0; i < length; i++) {
			if(l_index == l_max){
				result[i] = right[r_index];
				r_index++;
				continue;
			}
			if(r_index == r_max) {
				result[i] = left[l_index];
				l_index++;
				continue;
			}
			if(left[l_index] < right[r_index]) {
				result[i] = left[l_index];
				l_index++;
			}
			else {
				result[i] = right[r_index];
				r_index++;
			}
		}
		return result;
	}
}
