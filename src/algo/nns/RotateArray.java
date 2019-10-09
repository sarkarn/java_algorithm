package algo.nns;

/**
 * Given an array of integers, rotate the array by N elements where N is an integer.
 */

import java.util.List;

public class RotateArray {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		rotate_array(arr, 2);
	}

	static void rotate_array(int[] array, int n) {
		// TODO: Write - Your - Code

		while (n > 0) {
			
			int tmp = array[array.length - 1];
			
			for (int i = array.length - 1; i > 0 ; i--) {
				array[i] = array[i-1];
			}
			array[0] = tmp;
			n = n -1;
		}
		for (int a : array) {
			System.out.println(a);
		}
	}
}
