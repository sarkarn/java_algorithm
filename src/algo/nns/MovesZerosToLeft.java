package algo.nns;

public class MovesZerosToLeft {
	static void move_zeros_to_left_in_array(int[] A) {
		int read_index = A.length - 1;
		int write_index = A.length - 1;

		while (read_index >= 0) {
			if (A[read_index] != 0) {
				A[write_index] = A[read_index];
				write_index--;
			}
			read_index--;
		}

		while (write_index >= 0) {
			A[write_index] = 0;
			write_index--;
		}
	}
}