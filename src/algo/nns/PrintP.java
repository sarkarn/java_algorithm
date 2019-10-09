package algo.nns;

import java.util.ArrayList;
import java.util.List;

public class PrintP {

	public static void main(String args[]) {

		List<String> aa = new ArrayList();
		printP(5, 5, "", aa);

		aa.forEach(System.out::println);
	}

	public static void printP(int leftCount, int rightCount, String tempStr, List<String> pList) {
		if (leftCount < 0 || rightCount < leftCount) {
			return;
		}

		if (leftCount == 0 && rightCount == 0) {
			pList.add(tempStr);
		}
		
		if (leftCount > 0) {
			tempStr = tempStr + "(";
			printP(leftCount - 1, rightCount, tempStr, pList);
		}

		if (rightCount > leftCount) {
			tempStr = tempStr + ")";
			printP(leftCount, rightCount - 1, tempStr, pList);
		}

	}

}
