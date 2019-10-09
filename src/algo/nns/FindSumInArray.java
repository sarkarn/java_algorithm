package algo.nns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSumInArray {
	
	static List<int[]> find_sum_of_two_2(int[] A, int val) {

		List<int[]> abc = new ArrayList();
		int i =0;
		int j = A.length -1;
		while(i < j) {
			int sum = A[i] + A[j];
			if (sum == val) {
				abc.add(new int[]{A[i],A[j]});
			}

			if (sum < val) {
				++i;
			} else {
				--j;
			}
		}

		return abc;
	}

	static void test(int[] v, int val) {
		Arrays.sort(v);
		List<int[]> abc = find_sum_of_two_2(v, val);
		
		for(int[] arr: abc) {
			System.out.println(arr[0]+ " " + arr[1]);
		}

	}

	public static void main(String[] args) {
		int[] v = new int[] { 2, 1, 8, 4, 7, 3 };
		test(v, 3);
		test(v, 20);
		test(v, 1);
		test(v, 2);
		test(v, 7);
	}
}