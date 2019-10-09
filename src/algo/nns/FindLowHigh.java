package algo.nns;

/**
 * Given a sorted array of integers, return the low and high index of the given key. 
 * Return -1 if not found. The array length can be in the millions with many duplicates.
 * In the following example, low and high indices would be:
 * Key: 1, Low=0 and High=0
 * Key: 2, Low=1 and High=1
 * Key: 5, Low=2 and High=9
 * key: 20, Low=10 and High=10
 */
import java.util.Arrays;
import java.util.List;

public class FindLowHigh {
	static int find_low_index(List<Integer> arr, int key) {

		int low = 0;
		int high = arr.size() - 1;
		int mid = high / 2;

		while (low <= high) {

			int mid_elem = arr.get(mid);

			if (mid_elem < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

			mid = low + (high - low) / 2;
		}

		if (low < arr.size() && arr.get(low) == key) {
			return low;
		}

		return -1;
	}

	static int find_high_index(List<Integer> arr, int key) {

		int low = 0;
		int high = arr.size() - 1;
		int mid = high / 2;

		while (low <= high) {

			int mid_elem = arr.get(mid);

			if (mid_elem <= key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

			mid = low + (high - low) / 2;
		}

		if (high == -1) {
			return high;
		}

		if (high < arr.size() && arr.get(high) == key) {
			return high;
		}

		return -1;
	}

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
		int key = 5;
		int low = find_low_index(array, key);
		int high = find_high_index(array, key);
		System.out.println("LowIndex of " + key + " : " + low);
		System.out.println("HighIndex of " + key + " : " + high);

		key = -2;
		low = find_low_index(array, key);
		high = find_high_index(array, key);
		System.out.println("LowIndex of " + key + " : " + low);
		System.out.println("HighIndex of " + key + " : " + high);
	}
}
